# Spring Security Deep Dive — ResumeMaster

## Full Request Flow

### Step 1 — Nginx (SSL Termination)
Request arrives HTTPS encrypted. Nginx is a reverse proxy that terminates SSL, decrypting the request and forwarding plain HTTP to Spring Boot on port 8080.

### Step 2 — Spring Security Filter Chain
Before the request reaches any controller, Spring Security intercepts it through a chain of filters. Every request must pass through each checkpoint in order.

### Step 3 — CorsFilter
Checks the Origin header on the request. Verifies whether the calling domain is in the allowed origins list. For example resumemaster.dev is allowed to call api.resumemaster.dev but an unknown domain like attacker.com is not. If the domain is not allowed returns 403 immediately and the request goes no further.

### Step 4 — JwtAuthFilter (custom filter)
Reads the Authorization header looking for a Bearer token. Two outcomes:
- No token or invalid token — returns 401 Unauthorized, request ends
- Valid token — validates signature, checks expiration, verifies it was signed with the correct secret key. If valid, extracts the userId from the token payload and stores it in the SecurityContext for controllers to access later.

### Step 5 — SecurityFilterChain Configuration
Defines which endpoints are public and which require authentication:
- /api/auth/** is public (permitAll) — users need to register and login without a token
- Everything else requires a valid JWT token (authenticated)

### Step 6 — Controller
Request finally reaches the controller. User identity is available from the SecurityContext.

## Key Terms

| Term | Definition |
|---|---|
| Filter Chain | Series of security checkpoints every request passes through in order |
| SecurityContext | Stores the authenticated user identity throughout the request lifecycle |
| 401 | Not authenticated — no token or invalid token |
| 403 | Not authorized — valid token but no permission, or CORS rejection |
| Stateless authentication | No session stored on server, every request carries its own JWT proof of identity |
| Bearer token | The JWT sent in the Authorization header: Authorization: Bearer <token> |
| CORS | Cross-Origin Resource Sharing — controls which domains can call your API |

## The One Sentence Summary
Spring Security sits between Nginx and your controllers as a filter chain — CORS verifies the calling domain is allowed, JwtAuthFilter validates the token and extracts user identity, and SecurityFilterChain defines which endpoints are public vs protected.