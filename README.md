# Mower Challenge

## Description

The following code challenge is about the need to cut the grass of a given rectangular area, for now on the plateau.. For that purpose there is a bunch of mowers to accomplish this task sequentially.

## Assumptions

Some assumptions have been taken into account to setup the rules of this application:

- It is assumed that all the mowers are initially inside the plateau or on the borders. The operators are really competent in their jobs.
- The mowers cannot cross the borders of the plateau, so every movement that causes that action will not be done. The mowers are smart enough due to a pair of sensors to avoid crashes and move out of bounds . In that case every mower will wait for the next valid movement (rotation or straight move for one position).
- It is considered that all the mowers are deployed at the same time. So, when a mower is about to get moved to an occupied position, it will be stopped and will wait for the next movement. The mowers are so expensive, so we do not want them to crash and get the job undone. They move sequentially, but it is possible that they try to occupy a position by stopped mowers.
- The movements will be considered only for a single position given the current mower's direction.
- For the rotations it is considered a conversion for North, South, East and West clockwise as follows: 

![This is an image](http://www.rasmus.is/sp/imagenes/primaria1/gradosyangulos/gradosyangulos003.jpg)

* Turn left means +270 degrees.
* Turn right means +90 degrees given the current direction.
* The modulus operator will be executed for each rotation, keeping the direction in the range 0-360 degrees.
  

## Output

A controller will be invoked to perform all the movements given a list of mowers. The output will be a report with the final positions for all the mowers.

## Technologies

* JDK 18
* Spring Boot 2.7
* Maven 3

## How to install

1. Clone the current repository with Git

2. Install the project with Maven

```
mvn clean install
```

## How to run 


1. Run the Spring Boot application

```
mvn spring-boot:run
```

2. Test the controller with curl command line or use Postman for this purpose.

```

 curl --location --request POST 'http://localhost:8080/mowerchallenge/mowers/' --header 'Content-Type: text/plain' --data-raw '5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM'

```

---

## 

