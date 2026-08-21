FROM eclipse-temurin:21

# This is not a service. The image is a runner: it carries the suite and its
# Gradle wrapper so you can exec into the pod and drive the tests against an
# already-deployed stack.
#
# Built with the repository root as the context, because the Gradle wrapper and
# settings.gradle live at the root now:
#   docker build -f integration-test/Dockerfile .
#
# The whole repository is copied, and the working directory is the repository
# root, so the module is addressed the Gradle way:
#   ./gradlew :integration-test:test
#   ./gradlew :integration-test:test -Dcucumber.filter.tags=@common
COPY . /integration-test
WORKDIR /integration-test
