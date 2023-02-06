How to run scenarios, after running Appium Server GUI and connecting the emulator:

To run the test for the Native app, run the following Maven command: mvn clean test -P native
To run the test for the Web app, run the following Maven command: mvn clean test

For the Native app, before the test run, open src/main/resources/config.properties file and add values for the following keys:
"email" = {any valid email}
"userName" = {string username}
"password" = {string with the length at least 8 characters}