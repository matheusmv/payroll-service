FROM amazoncorretto:11-alpine-jdk

VOLUME /tmp

COPY ./hr-user /hr-user

WORKDIR /hr-user

RUN ./mvnw clean package -DskipTests

ENTRYPOINT ["java", "-jar", "/hr-user/target/hr-user-0.0.1.jar"]