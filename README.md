# Automation tests' examples for the "Brainscape" platform

![](https://theme.zdassets.com/theme_assets/2092825/5f93252045a23abd2bb2929b16bb400d58ed0787.png)
> <a target="_blank" href="https://www.brainscape.com/">Website link</a>

## Table of contents
- [Description](#Description)
- [UI Tests](#ui-tests)
  - [Tools](#tools)
  - [List of checks](#list-of-checks)
  - [How to run autotests remotely](#run-ui-tests-remotely)
  - [How to run autotests locally](#run-ui-tests-locally)
- [API Tests](#api-tests)
  - [Tools](#tools-1)
  - [List of checks](#list-of-checks-1)
  - [How to run autotests remotely](#run-api-tests-remotely)
  - [How to run autotests locally](#run-api-tests-locally)
- [Mobile Tests](#mobile-tests)
  - [Tools](#tools-2)
  - [List of checks](#list-of-checks-2)
  - [How to run autotests remotely](#run-mobile-tests-remotely)
  - [How to run autotests locally](#run-mobile-tests-locally)
- [Test reports](#test-reports)
- [Attachments](#Attachments)
- [TMS integrations](#tms-integrations)
- [Notifications](#Notifications)

## <a name="Description">Description</a>
This test project was done as a part of the homework of The QA Automation School <a href="https://qa.guru/">QA.GURU</a>. 

## <a name="UI">UI tests</a>

#### <a name="Tools">Tools</a>
<p align="center">
<img title="Java" src="readme-content/logos/Java.png">
<img title="Gradle" src="/readme-content/logos//Gradle.png">
<img title="Selenide" src="/readme-content/logos/Selenide.png">
<img title="Jenkins" src="/readme-content/logos/Jenkins.png">
<img title="Allure_Report" src="/readme-content/logos/Allure_Report.png">
<img title="AllureTestOps" src="/readme-content/logos/AllureTestOps.png">
<img title="Telegram" src="/readme-content/logos/Telegram.png"></p>

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

After that you can choose a few parameters.

- **Available browsers**: Chrome
- **Available browser's versions**: 100.0, 99.0
- **Available browser's size**: 1920x1080, 1366x768, 1024x768

And then you need to click the **Build** button.
![Screen of Jenkins build 2](/readme-content/images/Build.png)

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
<p align="center">
<img title="Java" src="readme-content/logos/Java.png">
<img title="Gradle" src="/readme-content/logos//Gradle.png">
<img title="Rest Assured" src="/readme-content/logos/Rest_Assured.png">
<img title="Jenkins" src="/readme-content/logos/Jenkins.png">
<img title="Allure_Report" src="/readme-content/logos/Allure_Report.png">
<img title="AllureTestOps" src="/readme-content/logos/AllureTestOps.png">
<img title="Telegram" src="/readme-content/logos/Telegram.png"></p>

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
<p align="center">
<img title="Java" src="readme-content/logos/Java.png">
<img title="Gradle" src="/readme-content/logos//Gradle.png">
<img title="Selenide" src="/readme-content/logos/Selenide.png">
<img width="4%" title="Appium" src="/readme-content/logos/Appium.svg">
<img width="4%" title="Browserstack" src="/readme-content/logos/Browserstack.svg">
<img title="Jenkins" src="/readme-content/logos/Jenkins.png">
<img title="Allure_Report" src="/readme-content/logos/Allure_Report.png">
<img title="AllureTestOps" src="/readme-content/logos/AllureTestOps.png">
<img title="Telegram" src="/readme-content/logos/Telegram.png"></p>

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
![Screen where to find Allure report](/readme-content/images/Allure.png)
![Screen with Allure report](/readme-content/images/Allure%20Report.png)

**For local runs**:
Run the task "allureServe"
![Screen allureServe](/readme-content/images/allureServe.png)

## <a name="Attachments">Attachments</a>
Each test result in **Allure reports** includes attachments, such as screenshot, page source, video, and browser console logs.
![Screen of attaches](/readme-content/images/Attachments.png)

Example of the video with record of the test execution:
![Gif of video](/readme-content/images/Video%20from%20test%20run.gif)

## <a name="TMS">TMS integrations</a>
Test run results will also be available in the test management system **Allure TestOps**.
![Screen where to find Allure TetsOps](/readme-content/images/Allure%20TestOps.png)
![Screen with testcases in Allure TetsOps](/readme-content/images/Allure%20TestOps%20Report.png)

## <a name="Notifications">Notifications</a>
The **telegram bot** will send a message to the **telegram group** about the completion of a test run. The text of the bot's message includes a link to the **Allure test report** in the **Jenkins**.

![Telegram message](/readme-content/images/Telegram%20message.png)
