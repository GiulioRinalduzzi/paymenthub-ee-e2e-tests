FROM eclipse-temurin:21-jre
EXPOSE 5000

# Built with the repository root as the context, so the path is module-qualified:
# the jar is produced by ./gradlew :mock-payment-schema:bootJar
COPY mock-payment-schema/build/libs/app.jar app.jar
CMD ["java", "-jar", "app.jar"]
