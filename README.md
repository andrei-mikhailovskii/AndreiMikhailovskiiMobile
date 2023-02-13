Before running tests, set the following environment variables:
EPAM_NAME_SURNAME (name and surname in your EPAM account in the following format: "name_surname")
MOBITRU_TOKEN (your Mobitru token)

To run the test for the Android Web app, run the following Maven command: mvn clean test -P androidWeb
To run the test for the iOS Web app, run the following Maven command: mvn clean test -P iosWeb
To run the test for the Android Native app, run the following Maven command: mvn clean test -P androidNative
To run the test for the iOS Native app, run the following Maven command: mvn clean test -P iosNative

For the Native app, before the test run, set the following environmental values:
"email"
"userName"
"password"

Note: password length must be at least 8 characters

Note #2: before launching tests for the native app, please, install the app to the selected device
