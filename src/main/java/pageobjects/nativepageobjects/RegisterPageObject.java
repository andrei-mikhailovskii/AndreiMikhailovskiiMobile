package pageobjects.nativepageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import setup.BaseTest;

public class RegisterPageObject extends BaseTest {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Registration']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Registration']")
    public static WebElement registrationHeader;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    WebElement registrationEmail;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='TimApple']")
    WebElement registrationUsername;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    WebElement registrationPassword;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Repeat please']")
    WebElement confirmPassword;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Register new account']")
    WebElement registerNewUserButton;

    public RegisterPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public void fillEmail(String email) {
        registrationEmail.sendKeys(email);
    }

    public void fillUsername(String username) {
        registrationUsername.sendKeys(username);
    }

    public void fillPassword(String password) {
        registrationPassword.sendKeys(password);
    }

    public void fillPasswordConfirm(String password) {
        confirmPassword.sendKeys(password);
    }

    public void clickRegisterButton() {

        String platformName = (String) getDriver().getCapabilities().getCapability("platformName");

        registerNewUserButton.click();

        // possible bug in the iOS app - it is needed to tap 'Register new account' button twice
        if (platformName.equals("iOS")) {
            registerNewUserButton.click();
        }

    }

}
