Before running tests, set the following environment variables:
EPAM_NAME_SURNAME (name and surname in your EPAM account in the following format: "name_surname")
MOBITRU_TOKEN (your Mobitru token)

Also, it is necessary to replace "udid" Desired Capability in .xml files located in src/test/resources 
with the actual value of a launched device

To run the test for the Android Native app, run the following Maven command: mvn clean test -P androidNative
To run the test for the iOS Native app, run the following Maven command: mvn clean test -P iosNative
(Note: before launching tests for the native app, please, install the app to the selected device. Both files for 
Android and iOS are located in the following directory: src/main/resources)

To run the test for the Android Web app, run the following Maven command: mvn clean test -P androidWeb
To run the test for the iOS Web app, run the following Maven command: mvn clean test -P iosWeb
(NB! Currently, the test for iOS Web app fails after inputting search data (not possible to run search query,
I'm looking for dealing with this issue))

For the Native app, before the test run, set the following environmental variables:
"email"
"userName"
"password"

Note: password length must be at least 8 characters
