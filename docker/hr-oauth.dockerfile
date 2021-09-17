FROM amazoncorretto:11-alpine-jdk

VOLUME /tmp

COPY ./hr-oauth /hr-oauth

WORKDIR /hr-oauth

RUN ./mvnw clean package -DskipTests

ENTRYPOINT ["java", "-jar", "/hr-oauth/target/hr-oauth-0.0.1.jar"]