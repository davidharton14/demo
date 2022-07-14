FROM openjdk:11
LABEL maintainer="javaguides.net"
ADD target/demo-0.0.1-SNAPSHOT.jar demo.jar
CMD ["java","-jar","demo.jar"]
