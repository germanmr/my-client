From openjdk:8
copy ./target/my-client-0.0.1-SNAPSHOT.jar my-client-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","my-client-0.0.1-SNAPSHOT.jar"]