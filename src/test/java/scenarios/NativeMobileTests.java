package scenarios;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.nativepageobjects.BudgetActivityPageObject;
import pageobjects.nativepageobjects.RegisterPageObject;
import pageobjects.nativepageobjects.StartPageObject;
import setup.BaseTest;

public class NativeMobileTests extends BaseTest {

    private String email = System.getenv("email");
    private String userName = System.getenv("userName");
    private String password = System.getenv("password");

    @Test(groups = {"native"}, description = "This test checks if Budget Activity page is opened")
    public void registerTest() {

        try {
            //click Register New Account button
            StartPageObject startPageObject = new StartPageObject(getDriver());
            startPageObject.clickRegisterButton();

            //Fill the registration form
            RegisterPageObject registerPageObject = new RegisterPageObject(getDriver());
            waitDriver().until(ExpectedConditions.visibilityOf(RegisterPageObject.registrationHeader));
            registerPageObject.fillEmail(email);
            registerPageObject.fillUsername(userName);
            registerPageObject.fillPassword(password);
            registerPageObject.fillPasswordConfirm(password);
            registerPageObject.clickRegisterButton();

            //Log in with the same credential that were used for registration
            waitDriver().until(ExpectedConditions.visibilityOf(StartPageObject.startPageHeader));
            startPageObject.fillEmail(email);
            startPageObject.fillPassword(password);
            startPageObject.clickSignInButton();

            //Verify that Budget Activity page is displayed
            new BudgetActivityPageObject(getDriver());
            Assert.assertTrue(BudgetActivityPageObject.budgetActivity.isDisplayed());
        } catch (NullPointerException nullPointerException) {
            System.err.println(nullPointerException);
        }

    }

}
