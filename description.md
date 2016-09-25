# HOW TO UPDATE THE WIKI

Since it's not possible to include the changes in the wiki into a pull request, here is a way to update the wiki, while still keeping tight control:

1. Create a new repository on your github account, for example, called *Edited-wiki*.
2. Clone the wiki repo that you want to update to your local machine somewhere: `git clone https://github.com/UNIZAR-30246-WebEngineering/lab1-git-race.wiki.git`
3. Add a new remote to your local directory, for example: `git remote add editWiki https://github.com/YOUR-ACCOUNT-NAME/Edited-wiki`
4. Make your locally changes and then push them to your github account: `git push editWiki master`
5. Submit a issue to the official page (https://github.com/UNIZAR-30246-WebEngineering/lab1-git-race) requesting to the owner of the repo to review your changes and merge them in. Don't forget to include a link to your own repo and describe what you've changed.

# DESCRIPTION ABOUT TECHNOLOGY USED

In this classes, faculty provides us some classes which try to show us a little demonstration of Spring controllers and some Junit Test for individual method petitions.

## SPRING FRAMEWORK:
*Spring* is a framework for app developing, it's open source for *Java platform*. *Spring* framework its made of some modules which provides a range of services, these modules are grouped into Core Container, Data Access/Integration, Web, AOP (Aspect Oriented Programming), Instrumentation, Messaging, and Test.
	(See [this diagram](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/images/spring-overview.png) for more information).

**BIBLIOGRAPHY:**
- https://es.wikipedia.org/wiki/Spring_Framework#M.C3.B3dulos 
- http://docs.spring.io/spring/docs/current/spring-framework-reference/html/overview.html

##JUNIT TEST FRAMEWORK:
*JUnit* is a Regression Testing Framework used by developers to implement unit testing in Java, and accelerate programming speed and increase the quality of code. *JUnit* Framework can be easily integrated with either of the following: Eclipse, Ant, Maven. *JUnit* test framework provides the following important features: Fixtures, Test suites, Test runners, JUnit classes. Fixtures is a fixed state of a set of objects used as a baseline for running tests. The purpose of a test fixture is to ensure that there is a well-known and fixed environment in which tests are run so that results are repeatable. It includes: *setUp()* method, which runs before every test invocation, *tearDown()* method, which runs after very test method.

**BIBLIOGRAPHY:** 
- https://www.tutorialspoint.com/junit/junit_test_framework.html

#TRAVIS CI
*Travis CI* is distributed continuous integration service, which supports different languages, used to build and test software projects hosted at GitHub. It allows to connect your GitHub repository and check it after each push. Its main advantage is that we could probe our libraries or applications using several configurations without installing them and that is why it uses different runtimes.60 *Travis CI* could be activated for different repositories. Moreover, it is configured by **travis.yml** file, which is situated on the root directory of each repository. This file includes information about the language, the building and testing environment and other aspects. *Travis CI* supports these languages: C, C++, C#, Clojure, D, Erlang, F#, Go, Groovy, Haskell, Java, JavaScript, Julia, Perl, PHP, Python, R, Ruby, Rust, Scala and Visual Basic.

**BIBLIOGRAPHY:** 
- https://en.wikipedia.org/wiki/Travis_CI	

#INSTALLING GRADLE ON WINDOWS 7
1. Gradle requires a JDK to be installed, version 7 or higher. Visit this [link](http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html#javasejdk) to download and more information.
2. You can now download Gradle binary only distribution [here](https://gradle.org/gradle-download/) and unpack it into a folder on your system.
3. Now, right click on *My Computer* and then select *Properties"->"Advance system settings*.
4. Next, click on *Environment Variables* button, found in *Advanced* tab. Then we want to add 2 new user variable, **GRADLE_HOME** and **PATH**.
    * To add a new variable, click on *New...* button (from user variables frame). For **GRADLE_HOME** variable enter *GRADLE_HOME* into the input field for *Variable name*, and the location of the dowloaded gradle into *Variable value*. For **PATH** variable, enter *PATH* and *%GRADLE_HOME%\bin*. If **PATH** existed before we created, then we have to edit it. For that, click on *Edit...*, and add *;%GRADLE_HOME%\bin* at the end.
5. Now you can use the gradle command in any command prompt. Type `gradle -v` to see if works.
6. For build a project, go to the project's root folder and type `gradle build`. This only works if a **build.gradle** file is well created.

Here is the [User Guide](https://docs.gradle.org/current/userguide/userguide_single.html).
		
**Common errors:**
- Gradle doesn't find a resource:
    - If this happens, building a project will result in a failure. The most common cause is that Windows system looks an incorrect folder while searching a Java resource. To fix this, a new user variable must be created (like *GRADLE_HOME* one).
    - Name it *JAVA_HOME*, and refers to JDK installation folder (*C:\Program Files\Java\jdk1.8...* is a possible route).
    - Ultimately, edit the variable *PATH* adding *;%JAVA_HOME%\bin* at the end.

# HOW TO RUN THE APPLICATION ON THE LOCAL MACHINE

It's easy to run the application on the local machine. You just have to follow the wiki of the main repository to configure the tools needed. After configuiring Gradle you can try to compile using the command `gradle check` in the terminal. Once this is done, you can start the application using the command `gradle bootrun`. If everything goes fine, the application will have been compiled and started Spring Framework with the application. Now, you can access from your favourite browser by typing in the address bar: *localhost:8080*.

## SOME OTHER TASKS OF GRADLE 

In addition to the commands said before, there are other interesting commands:
- **help:** Displays a help message.
- **war:** Generates a war archive with all the compiled classes, the web-app content and the libraries.
- **test:** Runs the unit tests.
- **clean:** Deletes the build directory.
- **jar:** Assembles a jar archive containing the main classes.

You can find more tasks if you type the command `gradle tasks` in your terminal.
