# Simple Order Manager Service

A hands-on way to dive into the Spring Boot Framework by building a basic Order Manager from scratch.

This service allows to create and retrieve orders while simulating sending them to an external API. It also showcases best practices and pattern designs like Factory or Observer.

## 🎯 Main goals

* Build a RESTful API for managing orders
* Follow clean codeEntity principles and best practices as well as design patterns:
  * Layer architecture (Controller → Service → Repository)
  * Design Patterns:
    * Factory Pattern for centralized exception creation
    * Observer Pattern to simulate async behaviours 
* Practice key Spring Boot concepts and logging:
  * Exception Handling
  * Caching
  * Aspects (AOP)
  * Async
  * Actuator
  * Interceptors
  * Filters
  * Custom configuration
  * Logging with log4j2

## 🛠️ Tech Stack

* Spring Boot 3.4.3
* Java 23
* Maven
* Log4j2
* H2 in memory DB