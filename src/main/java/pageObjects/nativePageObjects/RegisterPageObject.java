package pageObjects.nativePageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Registration']")
    public static WebElement registrationHeader;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    WebElement registrationEmail;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    WebElement registrationUsername;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    WebElement registrationPassword;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    WebElement confirmPassword;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
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
        registerNewUserButton.click();
    }

}
