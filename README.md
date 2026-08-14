# paymenthub-ee-e2e-tests

The test tooling for Payment Hub: the end-to-end suite you run against a deployed stack, and the
mock payment scheme those tests (and the Gazelle demo flows) transact against.

[![License](https://img.shields.io/badge/License-MPL--2.0-blue.svg)](LICENSE)

## Modules

| Module | What it is | Ships |
|---|---|---|
| [`integration-test/`](integration-test) | The end-to-end suite. Cucumber features driven by a JUnit runner, with WireMock standing in for the services it needs to fake. **Not a service** — you run it against a stack that is already deployed. | a runner image you exec into |
| [`mock-payment-schema/`](mock-payment-schema) | A stand-in payment scheme. A Spring Boot service on port 5000 that answers the calls a real scheme would, so the flows can complete without one. | a Docker image |

`mock-payment-schema` lives here rather than with the product connectors because it is test tooling:
it mocks a scheme, it does not integrate with one.

These two were separate repositories before (`ph-ee-integration-test`,
`ph-ee-connector-mock-payment-schema`).

## Building

One Gradle build for the whole repository. Java 21 is required.

```bash
./gradlew build
```

Per module:

```bash
./gradlew :mock-payment-schema:bootJar
```

Library versions come from the `org.mifos:paymenthub-ee-bom` platform, published by
[paymenthub-ee-core](https://github.com/openMF/paymenthub-ee-core). Do not pin managed versions in
a module's `build.gradle`.

Both Dockerfiles take the **repository root** as the build context — the `COPY` paths are
module-qualified:

```bash
./gradlew :mock-payment-schema:bootJar
docker build -f mock-payment-schema/Dockerfile -t paymenthub-ee-mock-payment-schema .
```

```bash
docker build -f integration-test/Dockerfile -t paymenthub-ee-integration-test .
```

## Running the suite

The suite needs a deployed stack to talk to. Every host it calls is read from
[`integration-test/src/main/resources/application.yaml`](integration-test/src/main/resources/application.yaml)
and can be overridden with an environment variable; the defaults are the in-cluster service names.

```bash
./gradlew :integration-test:test
```

One group of scenarios at a time, by Cucumber tag:

```bash
./gradlew :integration-test:test -Dcucumber.filter.tags=@common
```

## Branches

- `dev` is the active development branch — all PRs should target `dev`.
- `main` holds released versions.

## Contributing

See [contributing.md](contributing.md), our [Code of Conduct](CODE_OF_CONDUCT.md) and the [security policy](security.md).
