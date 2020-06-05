# Validate-HTTP-Request-Body
REST API with Spring Boot - Validate HTTP Request Body with Hibernate Bean Validator
- Test the Bean Validation
-  create a custom constraint when the built-in constraints are inadequate for your specific needs
- Validating Path Variables

Open H2 data base on Browser:
http://localhost:9091/h2 
required password from properties file.

# How to create Jar
First install gradle from this command: #apt get install gradle

Now you can run this command: #./gradlew build 

If JAVA_HOME path is not set
use this command: export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/

Then #export PATH=$JAVA_HOME/bin:$PATH

 


# How to create Docker image
First install docker in your system
- Goto the terminal run - #docker build .

Push docker image to docker hub
- Create docker hub account and create repository with name
- tag name version with docker hub repository | <repostory_name> like <praveenvermatech/spring-validator>
    - From this command: #docker tag praveenvermatech/spring-validator:1.0-SNAPSHOT praveenvermatech/spring-validator:1.0-SNAPSHOT
- Show docker images 
    - command: #docker images
- Push image on docker hub
    - command: #docker login
    - command: #docker push praveenvermatech/spring-validator:1.0-SNAPSHOT

Now push the docker image on Docker hub. you can pull image any time and run it.

# How to Pull Docker image from Docker Hub and how to run it?
follow this step:
- command: #docker pull <repository_name:target> like : #docker pull praveenvermatech/validatorpoc:1.0 
- command: #docker images
     - show the IMAGE ID in images list
- Now you can run this image
     - command: #docker run -p 8081:9091 <IMAGE ID> 
     like: #docker run -p 8081:9091 2a72aad0c54e
                       