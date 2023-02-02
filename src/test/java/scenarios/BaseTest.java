package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.DriverSetup;

public class BaseTest extends DriverSetup {

    //user info
    String email = "email@testemail.com";
    String userName = "testUser";
    String password = "testPassword";

    //start screen
    String emailField = "platkovsky.alexey.epamtestapp:id/login_email";
    String passwordField = "platkovsky.alexey.epamtestapp:id/login_pwd";
    String registerButton = "platkovsky.alexey.epamtestapp:id/register_button";
    String signInBtn = "platkovsky.alexey.epamtestapp:id/email_sign_in_button";

    //register screen
    String registrationEmail = "platkovsky.alexey.epamtestapp:id/registration_email";
    String registrationUsername = "platkovsky.alexey.epamtestapp:id/registration_username";
    String registrationPassword = "platkovsky.alexey.epamtestapp:id/registration_password";
    String confirmPassword = "platkovsky.alexey.epamtestapp:id/registration_confirm_password";
    String registerNewUserButton = "platkovsky.alexey.epamtestapp:id/register_new_account_button";
    String budgetActivity = "//android.widget.TextView[@text='BudgetActivity']";

    @Test
    public void registerTest() throws InterruptedException {
        androidDriver.findElement(By.id(registerButton)).click();
        Thread.sleep(1000);
        androidDriver.findElement(By.id(registrationEmail)).sendKeys(email);
        androidDriver.findElement(By.id(registrationUsername)).sendKeys(userName);
        androidDriver.findElement(By.id(registrationPassword)).sendKeys(password);
        androidDriver.findElement(By.id(confirmPassword)).sendKeys(password);
        androidDriver.findElement(By.id(registerNewUserButton)).click();
        Thread.sleep(1000);
        androidDriver.findElement(By.id(emailField)).sendKeys(email);
        androidDriver.findElement(By.id(passwordField)).sendKeys(password);
        androidDriver.findElement(By.id(signInBtn)).click();
        Assert.assertEquals(true, androidDriver.findElement(By.xpath(budgetActivity)).isDisplayed());
        System.out.println("Finish!");
    }

}
