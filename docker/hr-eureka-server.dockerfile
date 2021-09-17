FROM amazoncorretto:11-alpine-jdk

VOLUME /tmp

COPY ./hr-eureka-server /hr-eureka-server

WORKDIR /hr-eureka-server

RUN ./mvnw clean package -DskipTests

ENTRYPOINT ["java", "-jar", "/hr-eureka-server/target/hr-eureka-server-0.0.1.jar"]

EXPOSE 8761