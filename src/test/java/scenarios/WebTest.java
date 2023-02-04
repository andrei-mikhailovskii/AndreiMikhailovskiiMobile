package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import setup.DriverSetupWebApp;

import java.util.List;

public class WebTest extends DriverSetupWebApp {

    String url = "https://www.google.com/";
    String searchQuery = "EPAM";

    String searchString = "//input[@class='gLFyf']";
    String googleSearchButton = "//div[@class='FPdoLc lJ9FBc']//input[@class='gNO89b']";

    String searchResultsTag = "//div[@class='MjjYud']";

    @Test
    public void webCheck() throws InterruptedException {
        androidDriver.get(url);
        androidDriver.findElement(By.xpath(searchString)).sendKeys(searchQuery, Keys.ENTER);
        Thread.sleep(1000);

        List<WebElement> searchResults = androidDriver.findElements(By.xpath(searchResultsTag));
        System.out.println("Search results size = " + searchResults.size());

        int count = 0;
        for (WebElement element : searchResults) {
            if (element.getText().contains("EPAM")) {
                count++;
                break;
            }
        }

        System.out.println("Count value = " + count);

        Assert.assertEquals(count, 1);
        System.out.println("Test passed!");
    }

    @AfterClass
    public void teardown() {
        androidDriver.quit();
    }

}
