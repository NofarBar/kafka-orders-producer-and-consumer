FROM maven:3.8.2-jdk-8

VOLUME /tmp
WORKDIR /build
Copy . .
RUN mvn clean install

CMD mvn spring-boot:run