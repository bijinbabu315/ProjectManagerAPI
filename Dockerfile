From openjdk:8
EXPOSE 8090
ADD target/ProjectManagerAPI-0.0.1-SNAPSHOT.jar ProjectManagerAPI-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","ProjectManagerAPI-0.0.1-SNAPSHOT.jar"]