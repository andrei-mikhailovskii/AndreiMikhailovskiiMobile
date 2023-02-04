package scenarios;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.nativePageObjects.BudgetActivityPageObject;
import pageObjects.nativePageObjects.RegisterPageObject;
import pageObjects.nativePageObjects.StartPageObject;
import setup.BaseTest;
import setup.PropertiesExtractor;

public class NativeMobileTests extends BaseTest {

    /*@Test(groups = {"native"}, description = "This simple test just click on the Sign In button")
    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        getPo().getWelement("signInBtn").click();
        System.out.println("Simplest Android native test done");

    }*/

    @Test(groups = {"native"}, description = "This test checks if Budget Activity page is opened")
    public void registerTest() {

        try {
            PropertiesExtractor.getProperties();

            StartPageObject startPageObject = new StartPageObject(getDriver());
            startPageObject.clickRegisterButton();

            RegisterPageObject registerPageObject = new RegisterPageObject(getDriver());
            new WebDriverWait(getDriver(), 5)
                    .until(ExpectedConditions.visibilityOf(RegisterPageObject.registrationHeader));
            registerPageObject.fillEmail(email);
            registerPageObject.fillUsername(userName);
            registerPageObject.fillPassword(password);
            registerPageObject.fillPasswordConfirm(password);
            registerPageObject.clickRegisterButton();

            new WebDriverWait(getDriver(), 5)
                    .until(ExpectedConditions.visibilityOf(StartPageObject.startPageHeader));
            startPageObject.fillEmail(email);
            startPageObject.fillPassword(password);
            startPageObject.clickSignInButton();

            BudgetActivityPageObject budgetActivityPageObject = new BudgetActivityPageObject(getDriver());
            Assert.assertEquals(BudgetActivityPageObject.budgetActivity.isDisplayed(), true);
        } catch (NullPointerException nullPointerException) {
            System.err.println(nullPointerException);
        }

    }
}
