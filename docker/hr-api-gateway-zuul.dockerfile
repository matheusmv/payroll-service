FROM amazoncorretto:11-alpine-jdk

VOLUME /tmp

COPY ./hr-api-gateway-zuul /hr-api-gateway-zuul

WORKDIR /hr-api-gateway-zuul

RUN ./mvnw clean package -DskipTests

ENTRYPOINT ["java", "-jar", "/hr-api-gateway-zuul/target/hr-api-gateway-zuul-0.0.1.jar"]