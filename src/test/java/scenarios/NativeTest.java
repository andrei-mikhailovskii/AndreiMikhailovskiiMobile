package scenarios;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.nativePageObjects.BudgetActivityPageObject;
import pageObjects.nativePageObjects.RegisterPageObject;
import pageObjects.nativePageObjects.StartPageObject;
import setup.DriverSetupNativeApp;
import setup.PropertiesExtractor;

public class NativeTest extends DriverSetupNativeApp {

    @Test(description = "This test checks if Budget Activity page is opened")
    public void registerTest() throws InterruptedException {

        PropertiesExtractor.getProperties();

        StartPageObject startPageObject = new StartPageObject(getDriver());
        startPageObject.clickRegisterButton();
        Thread.sleep(1000);
        RegisterPageObject registerPageObject = new RegisterPageObject(getDriver());
        registerPageObject.fillEmail(email);
        registerPageObject.fillUsername(userName);
        registerPageObject.fillPassword(password);
        registerPageObject.fillPasswordConfirm(password);
        registerPageObject.clickRegisterButton();
        Thread.sleep(1000);
        startPageObject.fillEmail(email);
        startPageObject.fillPassword(password);
        startPageObject.clickSignInButton();
        Thread.sleep(1000);
        BudgetActivityPageObject budgetActivityPageObject = new BudgetActivityPageObject(getDriver());
        Assert.assertEquals(BudgetActivityPageObject.budgetActivity.isDisplayed(), true);
        System.out.println("Finish!");
    }

}
