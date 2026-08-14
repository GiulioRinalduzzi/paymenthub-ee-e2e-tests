# mock-payment-schema

A stand-in payment scheme for payment transfers. A Spring Boot service on port 5000 that answers the
calls a real scheme would, so the test flows and the Gazelle demo flows can complete without one.

This is a module of [paymenthub-ee-e2e-tests](../README.md), so run every command from the
**repository root** with the module prefix.

## Build

```shell
./gradlew :mock-payment-schema:bootJar
```

The jar comes out as `build/libs/app.jar`. The image is built with the repository root as the build
context, because the `COPY` path in the Dockerfile is module-qualified:

```shell
docker build -f mock-payment-schema/Dockerfile -t paymenthub-ee-mock-payment-schema .
```

## Checkstyle
Use below command to execute the checkstyle test.
```shell
./gradlew :mock-payment-schema:checkstyleMain
```

## Spotless
Use below command to execute the spotless apply.
```shell
./gradlew :mock-payment-schema:spotlessApply
```
