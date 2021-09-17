FROM amazoncorretto:11-alpine-jdk

VOLUME /tmp

COPY ./hr-payroll /hr-payroll

WORKDIR /hr-payroll

RUN ./mvnw clean package -DskipTests

ENTRYPOINT ["java", "-jar", "/hr-payroll/target/hr-payroll-0.0.1.jar"]