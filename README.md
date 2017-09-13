# Spring Boot application in Scala with JWT Authentication

The application in a simple Rest service that manages tasks and use MongoDB as database 

__A running MongoDB server on localhost:27017 is needed.__

The application uses Spring Boot, Spring Security and Spring Data.

Additional dependencies are JacksonModule for scala and the JWT library.

## Usage

* To register a user make a POST request to:

    `localhost:8080/api/users/sign-up`
    
    with the User (see implementation) in the body. You should receive a success message.
    
* To authenticate make a POST request to:

    `localhost:8080/login`
    
    with the User (see implementation) in the body.
    You should receive a blank message with the JWT token in the Authorization header.
    The token is a long string with "Bearer" prefix, something like that:
    
    `Bearer eyJhbGciOiJI........A.LOT.OF.CHARACTERS.......eNRCd_76Q`
    
* To make authenticated requests against the task controller simply put the received token in the Authorization header of all your following requests.



## How to build

You need to install gradle. Then go to the project directory and type:

`$ gradle build`

Now it should compile. The first time it takes a while because gradle have to download all the dependencies.