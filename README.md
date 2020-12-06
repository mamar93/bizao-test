# Table of contents
 - General info
 - Technologies
 - Setup
 - Example of use

# General info
This API provides the cheapest quote on flights from one origin to one destination on a specific date.
It retrieves the data from the travelpayouts and skycanner apis and makes the comparison to propose the best quote

# Technologies
 - Jakarta EE 8
 - Spring Boot 2.2. 1
 - maven for dependency management
 - Travis & Docker for CI/CD process
 - Swagger for documentation
 
 # Setup
 ```
$ cd path/to/project
$ mvn clean install
$ cd target
$ java -jar test-0.0.1-SNAPSHOT.jar
```

# Example of use

- URL to get the cheapest quote :  GET /flight-data-api/v1/quote/cheapest?country=US&currency=USD&local=en-US&origin=LED&destination=MOW&outbounddate=2020-12-07

 *URL Params : country, currency, local, origin, destination, outbounddate*

- URL for documentation /flight-data-api/v1/swagger-ui.html

response :  ```{
  "status": 200,
  "message": "Success",
  "data": {
    "minPrice": 15,
    "origin": "LED",
    "destination": "MOW",
    "currency": "USD",
    "departure_at": "2020-12-07"
  }
} ```
