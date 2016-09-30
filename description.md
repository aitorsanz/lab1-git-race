# HOW TO UPDATE THE WIKI

Since it's not possible to include the changes in the wiki into a pull request, here is a way to update the wiki, while still keeping tight control:

1. Create a new repository on your github account, for example, called *Edited-wiki*.
2. Clone the wiki repo that you want to update to your local machine somewhere: `git clone https://github.com/UNIZAR-30246-WebEngineering/lab1-git-race.wiki.git`
3. Add a new remote to your local directory, for example: `git remote add editWiki https://github.com/YOUR-ACCOUNT-NAME/Edited-wiki`
4. Make your locally changes and then push them to your github account: `git push editWiki master`
5. Submit a issue to the official page (https://github.com/UNIZAR-30246-WebEngineering/lab1-git-race) requesting to the owner of the repo to review your changes and merge them in. Don't forget to include a link to your own repo and describe what you've changed.

# DESCRIPTION ABOUT TECHNOLOGY USED.

In this classes, faculty provides us some classes which try to show us a little demonstration of Spring controllers and some Junit Test for individual method petitions.

## SPRING FRAMEWORK:
*Spring* is a framework for app developing, it's open source for *Java platform*. *Spring* framework its made of some modules which provides a range of services, these modules are grouped into Core Container, Data Access/Integration, Web, AOP (Aspect Oriented Programming), Instrumentation, Messaging, and Test.
	See [this diagram](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/images/spring-overview.png) for more information.

##JUNIT TEST FRAMEWORK:
*JUnit* is a Regression Testing Framework used by developers to implement unit testing in Java, and accelerate programming speed and increase the quality of code. *JUnit* Framework can be easily integrated with either of the following: Eclipse, Ant, Maven. *JUnit* test framework provides the following important features: Fixtures, Test suites, Test runners, JUnit classes. Fixtures is a fixed state of a set of objects used as a baseline for running tests. The purpose of a test fixture is to ensure that there is a well-known and fixed environment in which tests are run so that results are repeatable. It includes: *setUp()* method, which runs before every test invocation, *tearDown()* method, which runs after very test method.

##Heroku
Guidelines about how to deploy the server on a platform like heroku will be given
Heroku offers a service PaaS (Platform as a Service) where you can now deploy applications developed in Ruby, Node.js, Python, Clojure, Scala and Java, which in this case is the language chosen. In Heroku define an application and the source code of the application along with its dependencies.
Heroku deployment is done through Git. The first time, the procedure can be somewhat complex, but once everything is set up, the updates are simply making a push to the Heroku repository `<git push heroku master>`. With this code will be updated in the repository Heroku application and automatically restarts with the new version. Heroku also automatically detects which type of application it is rising.
The requirements are:
- an existing Java app that uses Gradle as a build tool.
- a free Heroku account
- Heroku the CLI
If you are using gradlew, then you must also add your `<gradle/wrapper/gradle-wrapper.jar>` and `<gradle/wrapper/gradle-wrapper.properties>` to your Git repository.

#TRAVIS CI
*Travis CI* is distributed continuous integration service, which supports different languages, used to build and test software projects hosted at GitHub. It allows to connect your GitHub repository and check it after each push. Its main advantage is that we could probe our libraries or applications using several configurations without installing them and that is why it uses different runtimes.60 *Travis CI* could be activated for different repositories. Moreover, it is configured by **travis.yml** file, which is situated on the root directory of each repository. This file includes information about the language, the building and testing environment and other aspects. *Travis CI* supports these languages: C, C++, C#, Clojure, D, Erlang, F#, Go, Groovy, Haskell, Java, JavaScript, Julia, Perl, PHP, Python, R, Ruby, Rust, Scala and Visual Basic.

#INSTALLING GRADLE ON WINDOWS 7
1. Gradle requires a JDK to be installed, version 7 or higher. Visit this [link](http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html#javasejdk) to download and more information.
2. You can now download Gradle binary only distribution [here](https://gradle.org/gradle-download/) and unpack it into a folder on your system.
3. Now, right click on *My Computer* and then select *Properties"->"Advance system settings*.
4. Next, click on *Environment Variables* button, found in *Advanced* tab. Then we want to add 2 new user variable, **GRADLE_HOME** and **PATH**.
    * To add a new variable, click on *New...* button (from user variables frame). For **GRADLE_HOME** variable enter *GRADLE_HOME* into the input field for *Variable name*, and the location of the dowloaded gradle into *Variable value*. For **PATH** variable, enter *PATH* and *%GRADLE_HOME%\bin*. If **PATH** existed before we created, then we have to edit it. For that, click on *Edit...*, and add *;%GRADLE_HOME%\bin* at the end.
5. Now you can use the gradle command in any command prompt. Type `gradle -v` to see if works.
6. For build a project, go to the project's root folder and type `gradle build`. This only works if a **build.gradle** file is well created.

**Common errors:**
- Gradle doesn't find a resource:
    - If this happens, building a project will result in a failure. The most common cause is that Windows system looks an incorrect folder while searching a Java resource. To fix this, a new user variable must be created (like *GRADLE_HOME* one).
    - Name it *JAVA_HOME*, and refers to JDK installation folder (*C:\Program Files\Java\jdk1.8...* is a possible route).
    - Ultimately, edit the variable *PATH* adding *;%JAVA_HOME%\bin* at the end.


# HOW TO RUN THE APPLICATION ON THE LOCAL MACHINE

To build the project, first download it or clone with git (`git clone https://github.com/UNIZAR-30246-WebEngineering/lab1-git-race`). Now, you can see the code and this information. This code is built with gradle. Gradle is an automation system which uses build configuration scripts like build.gradle which is a build configuration script. You just have to follow the wiki of the main repository to configure the tools needed.

After configuring Gradle you can try to compile using the command `gradle check` in the terminal, this will compile and test your code. Other command you can use to build the code is `gradle build` on your terminal. Gradle will compile and check your code and create a JAR file containing your main classes and resources.

Other possibility related to `gradle build` are `gradle assemble` that compiles and jars your code, but does not run the unit tests. After a few seconds, gradle will respond you with "BUILD SUCCESSFUL" that means the build has completed and you are able to run the application.

Once this is done, you can start the application using the command `gradle bootrun`. If everything goes fine, the application will have been compiled and started Spring Framework with the application. Now, you can access from your favourite browser by typing in the address bar: *localhost:8080*.

It can do a testLoggin in the console. This resolves issue #[42](https://github.com/UNIZAR-30246-WebEngineering/lab1-git-race/issues/42).
```
:processResources
:classes
:compileTestJava
:processTestResources UP-TO-DATE
:testClasses
:test

es.unizar.webeng.hello.HelloControllerUnitTest > testMessage STARTED

es.unizar.webeng.hello.HelloControllerUnitTest > testMessage PASSED

es.unizar.webeng.hello.StaticContentUnitTest > testMessage STARTED

es.unizar.webeng.hello.StaticContentUnitTest > testMessage PASSED

es.unizar.webeng.hello.IntegrationTest > testCss STARTED

es.unizar.webeng.hello.IntegrationTest > testCss PASSED

es.unizar.webeng.hello.IntegrationTest > testHome STARTED

es.unizar.webeng.hello.IntegrationTest > testHome PASSED
```

In addition to the commands said before, there are other interesting commands:
- **`gradle help`:** Displays a help message.
- **`gradle war`:** Generates a war archive with all the compiled classes, the web-app content and the libraries.
- **`gradle test`:** Runs the unit tests.
- **`gralde clean`:** Deletes the build directory.
- **`gradle jar`:** Assembles a jar archive containing the main classes.

You can find more tasks if you type the command `gradle tasks` in your terminal.

#USE OF MAVEN AS A JAVA PROJECT BUILDING TOOL

Maven is a tool used for building and managing Java-based projects. The primary goal of Maven is to allow developers to comprehend the complete state of a development effort in the shortest period of time, Maven helps us:
- Making the build process easy.
- Providing a uniform build system.
- Providing quality project information.
- Providing guidelines for best practices development.
- Allowing trasnparent migration to new features.

##MAVEN STANDARD DIRECTORY LAYOUT

Having a common directory layout help users familiar with one Maven project to not get lost in another different Maven project. The directory layout created by Maven have the directories exposed right below and you should try to confort your structure to this one as much as possible:

Path | Description
-----|------------
src/main/java/ | Application/Library sources.
src/main/resources/ | Application/Library resources.
src/main/webapp/ | Web application sources.
src/test/java/ | Test sources.
src/test/resources/ | Test resources.
LICENSE.txt | Project's license.
NOTICE.txt | Notices and attributions required by libraries that the project depends on.
README.txt | Project's readme.

In our case, our project has the next structure:

    |src/
    |---main/
    |------java/
    |---------es/unizar/webeng/hello/
    |------resources/
    |------webapp/
    |---------WEB-INF/
    |------------jsp/
    |------------web.xml
    |---test/
    |------java/
    |---------es/unizar/webeng/hello/
    |README.md
    |description.md
    |build/
    |gradle/
    |other files

As we can see our project follows Mavens directory layout. There are some directories in the layout that aren't present in our project structure but this is because our project source doesn't use anything from those directories since they are generated at building time.

# Bibliography

- [Spring framework in wikipedia](https://en.wikipedia.org/wiki/Spring_Framework)
- [Introduction to the Spring framework](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/overview.html)
- [JUnit Test framework overview](https://www.tutorialspoint.com/junit/junit_test_framework.html)
- [Deploying in Heroku](https://devcenter.heroku.com/articles/deploying-gradle-apps-on-heroku)
- [Travis CI overview](https://en.wikipedia.org/wiki/Travis_CI)
- [How to install gradle on windows 7](https://docs.gradle.org/current/userguide/userguide_single.html)
- [Introduction to the Standard Directory Layout with Maven](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html)
- [Gradle's userguide](https://docs.gradle.org/current/userguide/userguide)
