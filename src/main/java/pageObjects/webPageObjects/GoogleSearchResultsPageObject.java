package pageObjects.webPageObjects;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResultsPageObject {

    @FindBy(xpath = "//div[@class='MjjYud']")
    List<WebElement> searchResults;

    public GoogleSearchResultsPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }

    public int findValidSearchResult() {
        int count = 0;
        for (WebElement element : searchResults) {
            if (element.getText().contains("EPAM")) {
                count++;
                break;
            }
        }
        return count;
    }

}
