FROM amazoncorretto:11-alpine-jdk

VOLUME /tmp

COPY ./hr-worker /hr-worker

WORKDIR /hr-worker

RUN ./mvnw clean package -DskipTests

ENTRYPOINT ["java", "-jar", "/hr-worker/target/hr-worker-0.0.1.jar"]