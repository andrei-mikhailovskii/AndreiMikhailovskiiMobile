package pageObjects.webPageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.BaseTest;

public class GoogleStartPageObject extends BaseTest {

    @FindBy(xpath = "//input[@class='gLFyf']")
    WebElement searchString;

    public GoogleStartPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);

    }

    public void runSearchQuery(String text) {
        searchString.sendKeys(text, Keys.ENTER);
        new WebDriverWait(getDriver(), 5)
                .until(webDriver -> ((JavascriptExecutor) webDriver)
                                .executeScript("return document.readyState").equals("complete"));
    }


}
