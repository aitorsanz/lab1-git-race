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

#Deploying the project to Heroku

##Previous steps
Before trying to deploy your web page to Heroku you should be aware of a couple of things. First of all, there's something called a "Procfile" that is totally optional, but in our case needs to exist in order to correctly deploy the web page. If this file is missing, Heroku treats as if the file had the default config, which is basically the same as creating a Procfile with the following content: `java -Dserver.port=$PORT $JAVA_OPTS -jar build/libs/*.jar`

For aditional info, the Procfile is best described as: 
> A Procfile is a text file in the root directory of your application, that defines process types and explicitly declares what command should be executed to start your app.

So basically it's a file that must be created in the root of your web project (in this case lab1-git-race), which content should be a series of commands to run your webapp. In our specific case, we'll create a Procfile with the following content: `web: java -Dserver.port=$PORT $JAVA_OPTS -jar build/libs/ingweb.war`

This tells Heroku to run the .war found in build/libs as the web app. Just in case you're wondering, the name of the .war file comes from the build.gradle war property, which name has been defined as "ingweb"

##Actual deployment
1. First of all create a free account on [Heroku](https://signup.heroku.com/login). Here you might want to choose Java as your primary language, although I doubt that this has any implications at all.
2. After having created your account head to your [Dashboard](https://dashboard.heroku.com/apps). Here all your web applications will be displayed. Click on the "New" dropdown and select "Create new app". You can leave the name in blank and it will auto-generate a new one for you. Select "Europe" in this case for the server deployment.
3. Now you'll probably be at your app dashboard. Head to the "deployment" tab if you aren't in there already. In the "deployment method" section sync your Github account. You'll be prompted to search for the repo-name of the repo you're trying to sync with Heroku. For the purpose of this example search and select "lab1-git-race". Click the "connect" button.
4. When you've successfully connected to the repository you want to deploy you'll see that two new sections have appeared: "Automatic deploys" and "Manual deploy". For automatic deploys let's continue on 5i and for manual deploys on 5ii.
5.  1. Automatic deploys are pretty straight-forward, you just select the branch of the repository you want to sync and you can optionally select the option to "Wait for CI to pass before deploy", which in this case we'll select since we have to integrate Travis CI for this assignment anyways. Finally click on "Enable Automatic Deploys". You should be good to go.
    1. Manual deploys are a bit of a pain in the ass in the sense that you have to manually click on "Deploy branch" every time you want to deploy the changes made to your repository. Try it, select the branch from the dropdown and click on "Deploy branch". If everything went well you should see three green check marks.
6. Whether you have manually or automatically deployed your web server, you should be able to access it now. Head to the top of your app dashboard and click on the button labeled "Open app" in the top right corner. A new tab in your web browser should open with your new web page.
7. If something went wrong with the deployment of the app, or you can't access it in spite of it being deployed, head to your app logs and check for any errors on the console. To do this head once again to your app dashboard and at the top click on the "More" dropbdown and select "View logs". You'll be taken to a page with a console output. Check for any errors that might give you a hint to were your problem is.

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

# EditorConfig 
EditorConfig helps developers maintain consistent coding styles between different editors and IDEs. It is a file format for defining coding styles and a collection of text editor plugins that enable editors to read the file format and adhere to defined styles.
You need to create a .editorconfig file in which you define the coding style rules. It is similar to the format accepted by gitignore.

## IDEs supported by EditorConfig
These editors come bundled with native support for EditorConfig. Everything should just work: [BBEdit](http://www.barebones.com/support/technotes/editorconfig.html), [Builder](https://wiki.gnome.org/Apps/Builder/Features#EditorConfig), [CLion](https://github.com/JetBrains/intellij-community/tree/master/plugins/editorconfig), [GitHub](https://github.com/RReverser/github-editorconfig#readme), [Gogs](https://gogs.io/), [IntelliJIDEA](https://github.com/JetBrains/intellij-community/tree/master/plugins/editorconfig), [RubyMine](https://github.com/JetBrains/intellij-community/tree/master/plugins/editorconfig), [SourceLair](https://www.sourcelair.com/features/editorconfig), [TortoiseGit](https://tortoisegit.org/), [WebStorm](https://github.com/JetBrains/intellij-community/tree/master/plugins/editorconfig).

## IDEs not supported by EditorConfig file

To use EditorConfig with one of these editors, you will need to install a plugin: [AppCode](https://plugins.jetbrains.com/plugin/7294), [Atom](https://github.com/sindresorhus/atom-editorconfig#readme), [Brackets](https://github.com/kidwm/brackets-editorconfig/), [Coda](https://panic.com/coda/plugins.php#Plugins), [Code::Blocks](https://github.com/editorconfig/editorconfig-codeblocks#readme), [Eclipse](https://github.com/ncjones/editorconfig-eclipse#readme), [Emacs](https://github.com/editorconfig/editorconfig-emacs#readme), [Geany](https://github.com/editorconfig/editorconfig-geany#readme), [Gedit](https://github.com/editorconfig/editorconfig-gedit#readme), [Jedit](https://github.com/editorconfig/editorconfig-jedit#readme), [Komodo](http://komodoide.com/packages/addons/editorconfig/), [NetBeans](https://github.com/welovecoding/editorconfig-netbeans#readme), [NotePadd++](https://github.com/editorconfig/editorconfig-notepad-plus-plus#readme), [PhpStorm](https://plugins.jetbrains.com/plugin/7294), [PyCharm](https://plugins.jetbrains.com/plugin/7294), [Sublime Text](https://github.com/sindresorhus/editorconfig-sublime#readme), [Textadept](https://github.com/editorconfig/editorconfig-textadept#readme), [textmate](https://github.com/Mr0grog/editorconfig-textmate#readme), [Vim](https://github.com/editorconfig/editorconfig-vim#readme), [Visual Studio](https://github.com/editorconfig/editorconfig-visualstudio#readme), [Visual Studio Code](https://marketplace.visualstudio.com/items?itemName=EditorConfig.EditorConfig), [Xcode](https://github.com/MarcoSero/EditorConfig-Xcode) 



# Bibliography

- [Spring framework in wikipedia](https://en.wikipedia.org/wiki/Spring_Framework)
- [Introduction to the Spring framework](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/overview.html)
- [JUnit Test framework overview](https://www.tutorialspoint.com/junit/junit_test_framework.html)
- [Deploying in Heroku](https://devcenter.heroku.com/articles/deploying-gradle-apps-on-heroku)
- [Travis CI overview](https://en.wikipedia.org/wiki/Travis_CI)
- [How to install gradle on windows 7](https://docs.gradle.org/current/userguide/userguide_single.html)
- [Introduction to the Standard Directory Layout with Maven](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html)
- [Gradle's userguide](https://docs.gradle.org/current/userguide/userguide)
- [About EditorConfig](http://editorconfig.org/)
