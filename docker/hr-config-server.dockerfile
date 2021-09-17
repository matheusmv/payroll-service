FROM amazoncorretto:11-alpine-jdk

VOLUME /tmp

COPY ./hr-config-server /hr-config-server

WORKDIR /hr-config-server

RUN ./mvnw clean package -DskipTests

ENTRYPOINT ["java", "-jar", "/hr-config-server/target/hr-config-server-0.0.1.jar"]

EXPOSE 8888