# Sumer Login

## Getting Started

The following instructions will allow you to have a copy of the project and run it on your machine.

### Prerequisites

* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring](https://spring.io/) - Development Framework
* [Java 11](https://www.oracle.com/co/java/technologies/javase/jdk11-archive-downloads.html) -  Development Environment 


### Installing

1. Clone the repository

```
https://github.com/juancamilo399/SumerLogin.git
```

2. Compile the projet

```
mvn package
```

3. Executing the program

```
mvn exec:java -D "exec.mainClass"="com.sumer.login.LoginApplication"

Use port 8080
```
### Endpoints

The endpoints of the API are the following:
- POST request:
    - /user/register: Register a new User (User Body)
    - /user/login: User Login (LoginUser Body)

Make the requests to localhost:8080

```
User Body
{ 
    "firstName":"string",
    "lastName":"string",
    "email":"string",
    "password":"string"
}
```

```
LoginUser Body
{ 
    "email":"string",
    "password":"string"
}
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## Author

* **Juan Camilo Angel Hernandez** 


