# GreenCityTests
Automation tests for GreenCity project


### Build
Run `mvn test-compile` to download dependencies and build the project.


### Running UI tests
Run `mvn test -Dtestng.xml=*.xml` to execute the automation UI tests via [maven](https://maven.apache.org/).

For example

* `mvn test -Dtestng.xml=econews.xml` to running the UI tests of Eco news page


### Required to install

* Java 8
* Google [Chrome](https://www.google.com/chrome/) Browser
* Mozilla [Firefox](https://www.mozilla.org/en-US/firefox/new/) Browser
* [maven](https://maven.apache.org/)
* [Selenium](https://www.selenium.dev/) ver. 3.141.59


### Where to find back/front-end part of the project

Here is the back-end part of our project: https://github.com/ita-social-projects/GreenCity

Here is the front-end part of our project: https://github.com/ita-social-projects/GreenCityClient

![Diagram](http://jgraph.github.io/drawio-github/diagram.png)

<a href="http://jgraph.github.io/drawio-github/edit-diagram.html?repo=drawio-github&path=GreenCityClasses.png" target="_blank">Edit</a> | <a href="https://app.diagrams.net/#Uhttps%3A%2F%2Fraw.githubusercontent.com%2Fjgraph%2Fdrawio-github%2Fmaster%2FGreenCityClasses.png" target="_blank">Edit As New</a> | <a href="https://app.diagrams.net/#Hjgraph%2Fdrawio-github%2Fmaster%2FGreenCityClasses.png" target="_blank">Edit in diagrams.net</a>

<a href="http://jgraph.github.io/drawio-github/edit-diagram.html" target="_blank">edit-diagram.html</a> does the I/O with GitHub and uses diagrams.net in embed mode for diagram editing. The page supports the following URL parameters: user, pass, repo, path, ref and action=open (the Edit link above is an example). Using action=open, links for immediate diagram editing in GitHub can be created (requires user and pass parameters). You can also use files on GitHub as templates in diagrams.net via the url parameter (see Edit As New above).

Supported file formats: .png, .svg, .html and .xml (default)