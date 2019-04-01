# contract-testing-example

Contract testing example with spring-cloud-contract

## Quickstart

Add location of your local nexus to `build.gradle` in producer and consumer

### Producer

- Build and publish contract with `./gradlew clean build publish`

### Consumer

- Build and test with `./gradlew clean test`

### Local Nexus Docker

- Image used `https://hub.docker.com/r/sonatype/nexus3`
- Start the image the replace references in both `build.gradle` in producer and consumer
