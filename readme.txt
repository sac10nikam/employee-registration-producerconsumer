POC: Publish message to RabbitMQ  And Consume the same

Prerequisites:
Have RabbitMQ installed / use docker image of RabbitMQ. Start RabbitMQ/its image
Should have download rights for your dependencies

Import employee-registration-producerconsumer project as a Maven project under IDE like STS/Eclipse/Intellij
Main Class: EmployeeRegistrationApplication.java
Run this class as a Java application. This will start your Tomcat container. Before that please start your RabbitMQ

Access RabbitMQ exchanges and queues using below given link

http://localhost:15672/#/exchanges


It has both producer and consumer
Used Spring cloud stream instead of Spring RabbitMQ
Simple Spring Boot service
Not yet used design patterns and best practices
Fault Tolerance/Exception handling is in progress

Lombok:
Install lombok plugin in Eclipse/STS/Intellij
https://www.baeldung.com/lombok-ide