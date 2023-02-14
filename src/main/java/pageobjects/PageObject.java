package pageobjects;

import io.appium.java_client.AppiumDriver;
import java.lang.reflect.Field;
import java.util.logging.Logger;
import org.openqa.selenium.WebElement;
import pageobjects.nativepageobjects.StartPageObject;
import pageobjects.webpageobjects.GoogleStartPageObject;
import setup.IPageObject;

public class PageObject implements IPageObject {

    Object somePageObject; // it should be set of web page or EPAM Test App WebElements
    private static final Logger LOGGER = Logger.getLogger(PageObject.class.getName());

    public PageObject(String appType, AppiumDriver appiumDriver) throws Exception {

        switch (appType) {
            case "web":
                somePageObject = new GoogleStartPageObject(appiumDriver);
                break;
            case "native":
                somePageObject = new StartPageObject(appiumDriver);
                break;
            default: throw new Exception("Can't create a page object for " + appType);
        }

    }


    @Override
    public WebElement getWelement(String weName) throws NoSuchFieldException, IllegalAccessException {

        // use reflection technique
        Field field = somePageObject.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (WebElement) field.get(somePageObject);

    }
}
