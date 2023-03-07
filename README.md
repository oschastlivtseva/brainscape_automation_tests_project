# Automation tests' examples for the "Brainscape" platform

![](https://theme.zdassets.com/theme_assets/2092825/5f93252045a23abd2bb2929b16bb400d58ed0787.png)
> <a target="_blank" href="https://www.brainscape.com/">Website link</a>

## Table of contents
+ [Description](#Description)
+ [UI Tests](#ui-tests)
+ [Tools](#Tools)
+ [List of checks](#list-of-checks)
+ [How to run autotests remotely](#how-to-run-autotests-remotely)
+ [How to run autotests locally](#how-to-run-autotests-locally)
+ [Test reports](#test-reports)
+ [Attachments](#Attachments)
+ [TMS integrations](#tms-integrations)
+ [Notifications](#Notifications)

## <a name="Description">Description</a>
This test project was done as a part of the homework of The QA Automation School <a href="https://qa.guru/">QA.GURU</a>. 

## <a name="UI">UI tests</a>

#### <a name="Tools">Tools</a>

| ![Java](/design/icons/Java.png) | ![Gradle](/design/icons/Gradle.png) | ![JUnit5](/design/icons/JUnit5.png) | ![Selenide](/design/icons/Selenide.png) | ![Jenkins](/design/icons/Jenkins.png) | ![Allure_Report](/design/icons/Allure_Report.png) | ![AllureTestOps](/design/icons/AllureTestOps.png) | ![Telegram](/design/icons/Telegram.png) |
| ------ | ------ | ------ | ------ | ------ | ------------ | ------------ | ------ |
| Java | Gradle | JUnit5 | Selenide | Jenkins | Allure Report | Allure TestOps | Telegram |

#### <a name="ListOfChecks">List of checks</a>

<sup>**Login form**
- [x] <sup>Check the visibility of the login form
- [x] <sup>Check successful login via email
- [x] <sup>Check login failed due to an incorrect email
- [x] <sup>Check login failed due to an incorrect password

<sup>**Registration form**
- [x] <sup>Check the visibility of the registration form
- [x] <sup>Check successful registration (_part of the test is disabled to avoid the creation of new test accounts_)
- [x] <sup>Check registration failed due to an existing email

<sup>**Commercial video on the Landing page**
- [x] <sup>Check the visibility of the modal form with the video + check that the video is playable</sup>

#### <a name="how-to-run-autotests-remotely">Run UI tests remotely</a>
Automation tests can be run with the **Jenkins**' job: <a href="https://jenkins.autotests.cloud/job/016-Nusae-brainscape-project-ui-tests/">_here's the link_</a>.

To start a new run, click the button **Build with Parameters**.
![Screen of Jenkins build](/design/icons/Java.png)

After that you can choose a few parameters.

- **Available browsers**: Chrome
- **Available browser's versions**: 100.0, 99.0
- **Available browser's size**: 1920x1080, 1366x768, 1024x768

And then you need to click the **Build** button.
![Screen of Jenkins build 2](/design/icons/Java.png)

#### <a name="how-to-run-autotests-locally">Run UI tests locally</a>
Here's the command to start a new run locally:
```bash
./gradlew clean ui_test
```
:exclamation: If you don't have access to the property file with creds, you might want to replace it with your own test data (e.g., you could create your test user and use its creds).
In this case use this command:
```bash
./gradlew clean test -Denv=local -DtestUserEmail="your_user_email" -DtestUserPassword="your_user_password" -DtestUserNameAndSurname="your_user_name_and_surname"
```

## <a name="api-tests">API tests</a>

#### <a name="Tools">Tools</a>

#### <a name="ListOfChecks">List of checks</a>
<sup>**User profile**
- [x] <sup>Get user's profile info (/api/profile)
- [x] <sup>Get user's profile info (/api/v2)

<sup>**Deck creation**
- [x] <sup>Create a new deck with admin permission
- [x] <sup>Create a new deck without admin permission
- [x] <sup>Create a new deck in non-existent class 
- [x] <sup>Create a new deck by unauthorized user

<sup>**Deck removal**
- [x] <sup>Remove deck with admin permission
- [x] <sup>Remove deck without admin permission
- [x] <sup>Remove a non-existent deck
- [x] <sup>Remove deck by an unauthorized user

#### <a name="how-to-run-autotests-remotely">Run API tests remotely</a>
You can run API automation tests remotely by Jenkins job: <a href="https://jenkins.autotests.cloud/job/016-Nusae-brainscape-project-api-tests/">_link_</a>

#### <a name="how-to-run-autotests-locally">Run API tests locally</a>
If you have access to the hidden property file with user creds, use this:
```bash
./gradlew clean api_test
```
:exclamation: If you don't have access to the property file with creds, you might want to replace it with your own test data (e.g., you could create your test user and use its creds).
In this case use this command:
```bash
./gradlew clean api_test -DuserEmail="your_user_email" -DuserPassword="your_user_password"
```

## <a name="api-tests">Mobile tests</a>

#### <a name="Tools">Tools</a>

#### <a name="ListOfChecks">List of checks</a>
<sup>**Login form**
- [x] <sup>Check the visibility of the login form
- [x] <sup>Check successful login via email
- [x] <sup>Check login failed due to an incorrect credentials

#### <a name="how-to-run-autotests-remotely">Run Mobile tests remotely</a>
You can run Mobile automation tests remotely by Jenkins job: <a href="https://jenkins.autotests.cloud/job/016-Nusae-brainscape-project-mobile-tests/">_link_</a>

#### <a name="how-to-run-autotests-locally">Run Mobile tests locally</a>
If you have access to the hidden property file with user creds, use this:
```bash
./gradlew clean mobile_test -DdeviceHost=emulator
```
or
```bash
./gradlew clean mobile_test -DdeviceHost=real
```
:exclamation: If you don't have access to the property file with creds, you might want to replace it with your own test data (e.g., you could create your test user and use its creds).
In this case use this command:
```bash
./gradlew clean mobile_test -DdeviceHost=emulator -DuserEmail="your_user_email" -DuserPassword="your_user_password" -DuserName="your_user_firstname"
```


## <a name="test-reports">Test reports</a>
**For remote runs**:
A test report will be automatically generated after an autotests run's completion. You can check an **Allure report** in the **Jenkins** interface:
![Screen where to find Allure report](/design/icons/Java.png)
![Screen with Allure report](/design/icons/Java.png)

**For local runs**:
Run the task "allureServe"
![Screen allureServe](/design/icons/Java.png)

## <a name="Attachments">Attachments</a>
Each test result in **Allure reports** includes attachments, such as screenshot, page source, video, and browser console logs.
![Screen of attaches](/design/icons/Java.png)

Example of the video with record of the test execution:
![Gif of video](/design/icons/Java.png)

## <a name="TMS">TMS integrations</a>
Test run results will also be available in the test management system **Allure TestOps**.
![Screen where to find Allure TetsOps](/design/icons/Java.png)
![Screen with testcases in Allure TetsOps](/design/icons/Java.png)

## <a name="Notifications">Notifications</a>
The **telegram bot** will send a message to the **telegram group** about the completion of a test run. The text of the bot's message includes a link to the **Allure test report** in the **Jenkins**.
![Telegram message](/design/icons/Java.png)
