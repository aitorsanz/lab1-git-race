HOW TO UPDATE THE WIKI

Since it's not possible to include the changes in the wiki into a pull request, here is a way to update the wiki, while still keeping tight control.
1- Create a new repository on your github account, for example, called "Edited-wiki".
2- Clone the wiki repo that you want to update to your local machine somewhere: 'git clone [https://github.com/UNIZAR-30246-WebEngineering/lab1-git-race.wiki.git]'
3- Add a new remote to your local directory, for example: 'git remote add editWiki [https://github.com/YOUR-ACCOUNT-NAME/Edited-wiki]'
4- Make your locally changes and then push them to your github account: 'git push editWiki master'
5-  Submit a issue to the official page (https://github.com/UNIZAR-30246-WebEngineering/lab1-git-race) requesting to the owner of the repo to review your changes and merge them in. Don't forget to include a link to your own repo and describe what you've changed.

In this classes, faculty provides us some classes which try to show us a little demonstration of Spring controllers and some Junit Test for individual method petitions.

SPRING FRAMEWORK:
	Spring is a framework for app developing, it's open source for Java platform.
	Spring framework its made of some modules which provides a range of services, these modules are grouped into Core Container, Data Access/Integration, Web, AOP (Aspect Oriented Programming), Instrumentation, Messaging, and Test.
	(See this diagram for more information: http://docs.spring.io/spring/docs/current/spring-framework-reference/html/images/spring-overview.png).
BIBLIOGRAPHY: https://es.wikipedia.org/wiki/Spring_Framework#M.C3.B3dulos - http://docs.spring.io/spring/docs/current/spring-framework-reference/html/overview.html

JUNIT TEST FRAMEWORK:
	JUnit is a Regression Testing Framework used by developers to implement unit testing in Java, and accelerate programming speed and increase the quality of code. JUnit Framework can be easily integrated with either of the following: Eclipse, Ant, Maven. JUnit test framework provides the following important features: Fixtures, Test suites, Test runners, JUnit classes. Fixtures is a fixed state of a set of objects used as a baseline for running tests. The purpose of a test fixture is to ensure that there is a well-known and fixed environment in which tests are run so that results are repeatable. It includes: setUp() method, which runs before every test invocation, tearDown() method, which runs after very test method.
BIBLIOGRAPHY: https://www.tutorialspoint.com/junit/junit_test_framework.html

HOW TO RUN THE APPLICATION ON THE LOCAL MACHINE

	It's easy to run the application on the local machine. You just have to follow the wiki of the main repository to configure the tools needed. After configure Gradle you can try if compile using the command "gradle check" in the terminal. Once this is well, you can start the application using the command "gradle bootrun". If everything goes fine, the application has been compiled and have started Spring Framework and the application. Now, you can access from your favourite browser by typing in the address bar: "localhost:8080".

SOME OTHER TASKS OF GRADLE 

	In addition to the commands said before, there are other interesting commands:

		- help: Displays a help message.
		- war: Generates a war archive with all the compiled classes, the web-app content and the libraries.
		- test: Runs the unit tests.
		- clean: Deletes the build directory.
		- jar: Assembles a jar archive containing the main classes.

	You can found more tasks if you type the command "gradle tasks" in your terminal.