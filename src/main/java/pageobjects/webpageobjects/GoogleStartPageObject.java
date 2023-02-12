package pageobjects.webpageobjects;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BaseTest;

public class GoogleStartPageObject extends BaseTest {

    private final String xpathAcceptCookiesButton = "//button[@id='L2AGLb']";
    @FindBy(xpath = "//input[@name='q']")
    WebElement searchString;
    @FindBy(xpath = xpathAcceptCookiesButton)
    WebElement acceptAllButton;

    public GoogleStartPageObject(AppiumDriver appiumDriver) {

        PageFactory.initElements(appiumDriver, this);

    }

    public void runSearchQuery(String text) {

        String platformName = (String) getDriver().getCapabilities().getCapability("platformName");
        System.out.println("PLATFORM NAME = " + platformName);

        if (platformName.equals("Android")) {

            searchString.sendKeys(text, Keys.ENTER);
            waitUntilPageIsLoaded();

        } else if (platformName.equals("iOS")) {

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            searchString.sendKeys(text);
            getDriver().findElement(By.xpath("//*[@class='gLFyf']")).click();

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            waitUntilPageIsLoaded();

        }

    }

    public void acceptCookies() {

        JavascriptExecutor executor = getDriver();
        executor.executeScript("arguments[0].scrollIntoView()",
                getDriver().findElement(By.xpath(xpathAcceptCookiesButton)));
        waitDriver().until(ExpectedConditions.elementToBeClickable(acceptAllButton));
        acceptAllButton.click();

    }

}
