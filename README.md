Before running tests, set the following environment variables:
EPAM_NAME_SURNAME (name and surname in your EPAM account in the following format: "name_surname")
MOBITRU_TOKEN (your Mobitry token)

To run the test for the Android Web app, run the following Maven command: mvn clean test -P androidweb
To run the test for the iOS Web app, run the following Maven command: mvn clean test -P iosweb
To run the test for the Native app, run the following Maven command: mvn clean test -P native

For the Native app, before the test run, set the following environmental values:
"email"
"userName"
"password"

Note: password length must be at least 8 characters

Note #2: if you are located in the EU, before running the test for the web app, please, do the following steps before:
1 - clear history, cache and cookies
2 - turn off the emulator
3 - enable vpn choosing any non-EU and non-US region
4 - start the emulator
5 - open google.com in Chrome browser and/or run autotests
