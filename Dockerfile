FROM openjdk:8
EXPOSE 9091
ADD build/libs/validatorpoc-1.0-SNAPSHOT.jar validatorpoc-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","validatorpoc-1.0-SNAPSHOT.jar"]

