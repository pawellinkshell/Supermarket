##### [17.08.2017] Current work on branch: Tests
###### Writing tests for application

# Supermarket
Demo of Supermarket with simple checkout mechanism created and designed by Jan Koszela.

### Business requirements:
1. Design and implement supermarket checkout component with readable API that calculates the total unit of a number of items.
2. Checkout mechanism can scan items and return actual unit ( is stateful)
3. Our goods are priced individually. In addition, some items are multipriced: buy n of them, and they’ll cost you y cents
 
  |Item  | Unit Price |  Special Price |
  |:----:|-----------:|---------------:|
  |  A   |  40        | 3 for 70       |
  |  B   |  10        | 2 for 15       | 
  |  C   |  30        |                |
  |  D   |  25        |                |
 
### Non-functional requirements:
1. Clean Code
2. Unit/Integration Tests should be in place
3. Use maven or gradle build system

## Getting Started
* Clone the repo: `git clone https://github.com/pawellinkshell/Supermarket.git`
* Fork the repo

### Prerequisites
To use the source files, you will need to have [Maven](https://maven.apache.org/download.cgi) installed globally. Project is built with 3.3.9 version of Maven.

#### To Start:
First thing to do, is prepare the `*.war` file which should be deployed on Tomcat server.
* Run `mvn clean install` in the root directory

#### To run:
* Put already built `Supermarket.war` file in `<TOMCAT>\webapps` directory
* Go to `<TOMCAT>\bin` and run `catalina.bat run` to deploy and run the project

* Alternatively you can run `Supermarket` in your IDE like IntelliJ or Eclipse using local instance of Tomcat.

## Architectural design 
### Raw Data / Sample data 
Raw data will be get from `MOCK_DATA_<items>.json` files

### Application design
![Model design of Supermarket application][model]

[model]: https://github.com/pawellinkshell/Supermarket/tree/master/src/main/resources/designModel.png "Logo Title Text 2"

## WorkLog
### `develop` branch
#### 09.08.2017:
[3 H] Setup Simple project based on Maven & Spring

[2 H] Add simple initial GUI based on Bootstrap 

[0,5 H] Prepare mock data

[0,5 H] Setup frontend libraries 

### `Model_layer` branch
[1 H] Implementing model layer

#### 10.08.2017:

[0,5 H] Update documentation, merge feature/GUI branch into develop

[2,5 H] Add missing dependency, implementing DTOs with tests

[1 H] Add Json converter for mocking sample data

[1 H] Implementing DAOs and domain objects with test

[0,5 H] Push sample data from Json to view layer for tests.

#### 12.08.2017:

[4 H] Small refactors, add and implement services

[1 H] Documenting

#### 13.08.2017:

[4 H] Refactor domain model, due to lack of design

[4 H] Update existing services

Release working initial draft in version `0.1.0`

### `Service_layer` branch
[4,5 H] Refactoring view files, update cart and order services

Release second draft in version `0.1.1`

### `Redesign` branch
#### 14.08.2017:
[4 H] Redesign into Model, Service, Facade, UI layer

[2 H] Refactor product service

[2 H] Refactor order service

#### 15.08.2017:
[1 H] Refactor cart service

[1 H] Redesign DTO objects

[2 H] Refactor product domain model, update product service

#### 16.08.2017:
[2 H] Writing Product facade

[2 H] Writing Cart facade

[2,5 H] Update model service, order service, update cart facade, add alert messages

#### 17.08.2017
[3 H] Add session scope for cart

[1 H] Documenting

Release third draft in version `0.1.2`

## Bugs and Issues

Have you seen a bug or an issue in my page? [Open a new issue](https://github.com/pawellinkshell/supermarket/issues) here on GitHub

## Authors

* **Jan Koszela** - *Initial work* - known also as [Pawel Linkshell](https://github.com/pawellinkshell)

See also the list of [contributors](https://github.com/pawellinkshell/supermarket/contributors) who participated in this project.

## Copyright and License

Copyright 2017 Jan Koszela. Code released under the [MIT](https://github.com/pawellinkshell/Supermarket/blob/master/LICENSE) license.

## Acknowledgments
Backend was backed by:
* [Spring](https://spring.io/)                       - MVC layer, Dependency Injection
* [Lombok](https://projectlombok.org/)               - Generating boiler plate code
* [Java](https://www.oracle.com/pl/java/index.html)  - Core Java  
* [Maven](https://maven.apache.org/)                 - as a build tool
* [GSON](https://github.com/google/gson)             - to get sample data from JSON

Logged by:
* [SLF4J](https://www.slf4j.org/)                    - as logger facade
* [logback](https://logback.qos.ch/)                 - as main logger for Spring

Tested by:
* [AssertJ](http://joel-costigliola.github.io/assertj/)   - Simplify your life
* [JUnit](http://junit.org/junit4/)                       - Core testing lib
* [Mockito](http://site.mockito.org/)                     - To mock data

Sample mock data was generated thanks to: 
* [mockaroo](https://www.mockaroo.com/)

GUI is based on:
* [jQuery CDN](http://code.jquery.com/)           - core library
* [Bootstrap CDN](https://www.bootstrapcdn.com/)  - library
* [BootSnipp](https://bootsnipp.com)              - quick snippets
* [{less}](http://lesscss.org/)                   - precompiler for stylesheets
* [JSTL](http://www.oracle.com/technetwork/java/index-jsp-135995.html)  - to get objects into view

Belt tool:
* [IntelliJ](https://www.jetbrains.com/idea/)     - as main IDE tool
* [Git](https://git-scm.com/)                     - as version source control
* [Github](https://github.com/)                   - as repository platform
* [SourceTree](https://www.sourcetreeapp.com/)    - as version control platform manager
* [Notepad++](https://notepad-plus-plus.org/)     - as a second IDE tool
* [SemVer](http://semver.org/)                    - for semantic versioning of application