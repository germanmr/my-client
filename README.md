# my-client
It Knows everything about:"The Client"
It's a part of the "My Store" Project

( This project is a Spring boot app for Demo purposes
The idea is to expose a Restful API )

The service is dockerized and consumes a PostgreSql database
It shares the same docker network as my-store Project


## Getting Started

### Prerequisites
* Git
* JDK 8 or later
* Maven 3.0 or later

### Clone
To get started you can simply clone this repository using git:
```
git clone https://github.com/germanmr/my-client.git
cd my-client
```

### Configuration

The configuration is located in `src/resources/application.properties`.

### Build an executable WAR
You can run the application from the command line using:
```
mvn spring-boot:run -Dspring.profiles.active=local
```
or add this: "-Dspring.profiles.active=local" local profile on VMoptions

Or you can build a single executable WAR file that contains all the necessary dependencies, classes, and resources with:
```
mvn clean package
```
Then you can run the JAR file with:
```
java -jar target/*.jar
```
*Instead of `mvn` you can also use the maven-wrapper `./mvnw` to ensure you have everything necessary to run the Maven build.*

### Deploy to Docker Containers
Build image:
```
docker image build -t my-client .
```
Run image:
```
docker container run -p 8080:8080 -d my-client
```
this returns then id:

Logs
```
docker container logs [id]
```
Stop
```
docker container stop [id]
```

Remove
```
docker image rm my-client
```

```
docker container rm  [containerId]
```
