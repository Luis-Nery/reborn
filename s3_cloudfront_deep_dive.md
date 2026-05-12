AWS S3 + CloudFront Deep Dive — LocketMap
What Each Service Does
S3 (Simple Storage Service) is object storage. Think of it as a hard drive in the cloud. Files go in, files come out. It is not a CDN — it is just a bucket that holds raw files in a specific AWS region (e.g. us-east-1).

CloudFront is a CDN (Content Delivery Network). It sits in front of S3 and serves your files from the edge location closest to the user. Someone in Tokyo gets the file from an AWS server in Tokyo, not from your S3 bucket in Virginia.

Full Upload Flow (Browser → S3)
Step 1 — User Selects a File
The browser has the raw file in memory. You never send it to your backend — that would waste your server's bandwidth and memory. Instead you get a permission slip first.

Step 2 — Frontend Asks Backend for a Presigned URL
POST /api/media/presign
{ fileName: "photo.jpg", fileType: "image/jpeg" }
This hits your Express controller. The backend does not touch the file. It just calls the AWS SDK and says:

"Generate a URL that gives whoever holds it permission to PUT one file named albums/42/photo.jpg into my bucket for the next 5 minutes."

AWS signs that URL with your secret credentials. The URL looks like:

https://locketmap-media.s3.amazonaws.com/albums/42/photo.jpg
?X-Amz-Algorithm=AWS4-HMAC-SHA256
&X-Amz-Credential=AKIA...
&X-Amz-Expires=300
&X-Amz-Signature=abc123...
Your backend returns this URL to the frontend. Your AWS credentials never leave your server.

Step 3 — Frontend PUTs Directly to S3
PUT https://locketmap-media.s3.amazonaws.com/albums/42/photo.jpg
Content-Type: image/jpeg
[raw binary file bytes]
The browser sends the file directly to S3, bypassing your backend entirely. S3 validates the signature on the URL. If the signature is valid and not expired, it accepts the file. If someone tampers with the URL or it has expired, S3 returns 403.

Your server never touches the file bytes. Your server never has to handle that memory load.

Step 4 — Frontend Tells Backend Where the File Lives
After the PUT succeeds, the frontend calls:

POST /api/media
{ albumId: 42, cloudfrontUrl: "https://d1abc.cloudfront.net/albums/42/photo.jpg" }
Your backend stores the CloudFront URL (not the S3 URL) in the database. This is the URL users will use to view the file forever.

Full Read Flow (User Views a Photo)
Step 1 — Frontend Loads the URL from the Database
The stored URL is a CloudFront URL: https://d1abc.cloudfront.net/albums/42/photo.jpg

Step 2 — Request Hits the Nearest CloudFront Edge
CloudFront has 600+ edge locations worldwide. The user's DNS resolves to the closest one. The edge server checks its cache.

Cache hit — the file was already requested recently. CloudFront serves it instantly from the edge. S3 is never contacted.

Cache miss — first time this file has been requested from this edge location. CloudFront fetches it from S3 (the origin), caches it at the edge, then serves it.

Step 3 — Browser Receives the File
From the user's perspective it is just a fast image URL. They never know S3 exists.

Why Store the CloudFront URL Instead of the S3 URL
S3 URL	CloudFront URL
Speed	Serves from one region	Serves from nearest edge globally
Cost	S3 charges per GET request	CloudFront is cheaper per request at scale
Control	Hard to revoke access	Can invalidate cache, add signed URLs later
Flexibility	If you change bucket you break all URLs	CloudFront is an abstraction layer
The S3 URL is an implementation detail. CloudFront is the public-facing address. If you ever move to a different bucket or storage provider, you only update the CloudFront distribution — all your database URLs stay valid.

CORS on S3
S3 has its own CORS configuration separate from your Express CORS. The browser is making a cross-origin PUT request directly to S3, so S3 must explicitly allow it.

Your S3 bucket has a CORS rule that says:

{
"AllowedOrigins": ["http://localhost:5173", "https://locketmap.com"],
"AllowedMethods": ["PUT"],
"AllowedHeaders": ["Content-Type"]
}
Without this, the browser's preflight OPTIONS request to S3 would get no CORS headers back and the PUT would be blocked before it even happens — even though the presigned URL is valid.

Key Terms
Term	Definition
Presigned URL	A temporary URL with your AWS credentials baked into the signature — gives the holder permission to perform one specific S3 action for a limited time
Origin	The source of truth that CloudFront pulls from — in your case, the S3 bucket
Edge location	One of CloudFront's 600+ servers worldwide that caches and serves files close to users
Cache hit	CloudFront already has the file at this edge — serves instantly, S3 not contacted
Cache miss	First request for this file at this edge — CloudFront fetches from S3, caches it
Distribution	Your CloudFront configuration — maps a d1abc.cloudfront.net domain to your S3 origin
Cache invalidation	Telling CloudFront to throw away cached copies of a file — needed if you overwrite a file in S3 and want CloudFront to serve the new version immediately
Bucket policy	S3's access control rules — your bucket should be private (CloudFront accesses it via OAC, not public internet)
OAC (Origin Access Control)	Grants CloudFront permission to read from a private S3 bucket — so you can block all direct S3 access and only serve through CloudFront
The One Sentence Summary
S3 is the storage vault and CloudFront is the global delivery network in front of it — the browser uploads files directly to S3 using a short-lived presigned URL so your server never handles file bytes, and every file is served back through CloudFront so users worldwide get it from the nearest edge location instead of one S3 region.