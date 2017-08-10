# Supermarket
Demo of Supermarket with simple checkout mechanism created and designed by Jan Koszela.

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
09.08.2017:

[3 H] Setup Simple project based on Maven & Spring

[2 H] Add simple initial GUI based on Bootstrap 

[0,5 H] Prepare mock data

[0,5 H] Setup frontend libraries 

[1 H] Implementing model layer

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