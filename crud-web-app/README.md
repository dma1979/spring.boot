# Getting Started

* To Access h2 in-memory database use the link [localhost:port/h2-console](http://localhost:port/h2-console) with JDB URL `jdbc:h2:mem:testdb`

* API is available via [link](http://localhost:port/swagger-ui.html#)

### Creating entities include following steps:
- [X] Add test for creating new entities(Card, User)
- [X] Add the endpoint for creating new entities(Card, User)
- [X] Add business logic for creating new entities(Card, User)
- [X] Manually verify endpoints with Postman

### Reading entities include following steps:
- [X] Add test for reading entities
- [X] Add the endpoint for reading one and all entities
- [X] Add business logic for both endpoints
- [X] Manually verify endpoints with Postman

### Updating entities include following steps:
- [X] Add test for updating entities
- [X] Add the endpoint for updating the existing entities
- [X] Add business logic for updating the existing entities
- [X] Manually verify endpoints with Postman

### Deleting entities include following steps:
- [X] Add test for deleting entities
- [X] Add the endpoint for deleting the existing entities
- [X] Add business logic for deleting the existing entities
- [X] Manually verify endpoints with Postman

### Integration test
- [X] IT for Card REST service
- [X] IT for User REST service

### Hibernate steps
- [X] Many2Many - DB tables
  * [X] table User
    * [X] table User
  * [X] table Card
  * [X] table Card2user
  * [X] fill table data
- [ ] Many2Many - mapping entities
- [ ] Many2Many - test in Demo app

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
