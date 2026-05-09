When I push code to main on ResumeMaster, GitHub receives the push and detects a workflow file living at .github/workflows/ci-cd.yml. GitHub spins up a fresh virtual machine called a runner, in my case ubuntu-latest. That runner has nothing installed so the workflow first sets up Java and Maven, then checks out my code.

The workflow has two jobs. The first job runs my 43 tests using JUnit 5, Mockito, and MockMvc. If any test fails, the job is marked failed and the pipeline stops. Nothing deploys.

The second job has needs: test at the top. That single keyword makes it dependent on the first job. It only runs if the test job completed successfully. This is the exact mechanism that prevents bad code from reaching production.

If tests pass, the deploy job SSHs into my EC2 instance using three secrets I configured in GitHub: EC2_HOST for the server address, EC2_USER for the username, and EC2_SSH_KEY for the private key. GitHub never sees those values in plain text, they are injected at runtime. Once inside the server, it changes directory into the ResumeMaster folder, runs git pull to get the latest code, runs mvn package -DskipTests to build the jar (skipping tests because they already passed in the CI job), then runs docker-compose up --build -d to rebuild the containers and bring them back up with zero downtime.

The result: every push to main either passes all tests and deploys automatically, or fails tests and never touches the server.