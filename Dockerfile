FROM azul/zulu-openjdk-debian:17
COPY target/Bearing-Project-0.0.1-SNAPSHOT.jar /work/app.jar
WORKDIR /work
CMD ["java","-jar","app.jar"]