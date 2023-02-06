After running Appium Server GUI and connecting the emulator:

To run the test for the Native app, run the following Maven command: mvn clean test -P native
To run the test for the Web app, run the following Maven command: mvn clean test

For the Native app, before the test run, set the following environmental values:
"email"
"userName"
"password"

Note: password length must be at least 8 characters
