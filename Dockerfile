FROM openjdk:8
COPY "./target/proyecto-0.0.1-SNAPSHOT.jar" "app0.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app0.jar"]