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
* Run `mvn package` to prepare proper war file with whole dependencies

#### To run:
* Put already built `Supermarket.war` file in `<TOMCAT>\webapps` directory
* Go to `<TOMCAT>\bin` and run `catalina.bat run` to deploy and run the project

* Alternatively you can run `Supermarket` in your IDE like IntelliJ or Eclipse using local instance of Tomcat.

## Model structure
### Raw Data
Raw data will be get from `MOCK_DATA_<items>.json` files

### Canonical Data
Raw data will be transfered onto DAO/DTO patterns model. 

## WorkLog
#### 09.08.2017:

[3 H] Setup Simple project based on Maven & Spring

[2 H] Add simple initial GUI based on Bootstrap 

[0,5 H] Prepare mock data

[0,5 H] Setup frontend libraries 

[1 H] Implementing model layer

#### 10.08.2017:

[0,5 H] Update documentation, merge feature/GUI branch into develop

[2,5 H] Add missing dependency, implementing DTOs with tests

[1 H] Add Json converter for mocking sample data

[1 H] Implementing DAOs and domain objects with test

[0,5 H] Push sample data from Json to view layer for tests.

#### 12.08.2017:

[5 H] Small refactors, add and implement services

#### 13.08.2017:

[3 H] Refactor domain model, due to lack of design

[2 H] Update existing services

## Bugs and Issues

Have you seen a bug or an issue in my page? [Open a new issue](https://github.com/pawellinkshell/supermarket/issues) here on GitHub

## Authors

* **Jan Koszela** - *Initial work* - known also as [Pawel Linkshell](https://github.com/pawellinkshell)

See also the list of [contributors](https://github.com/pawellinkshell/supermarket/contributors) who participated in this project.

## Copyright and License

Copyright 2017 Jan Koszela. Code released under the [MIT](https://github.com/pawellinkshell/Supermarket/blob/master/LICENSE) license.

## Acknowledgments
Sample mock data was generated thanks to: 
* [mockaroo](https://www.mockaroo.com/)

GUI is based on:
* [jQuery CDN](http://code.jquery.com/)           - core library
* [Bootstrap CDN](https://www.bootstrapcdn.com/)  - library
* [BootSnipp](https://bootsnipp.com)              - quick snippets
* [{less}](http://lesscss.org/)                   - precompiler for stylesheets