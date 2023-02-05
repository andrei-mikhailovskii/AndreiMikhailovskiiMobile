package pageObjects;

import io.appium.java_client.AppiumDriver;
import java.lang.reflect.Field;
import org.openqa.selenium.WebElement;
import pageObjects.nativePageObjects.StartPageObject;
import pageObjects.webPageObjects.GoogleStartPageObject;
import setup.IPageObject;

public class PageObject implements IPageObject {

    Object somePageObject; // it should be set of web page or EPAM Test App WebElements

    public PageObject(String appType, AppiumDriver appiumDriver) throws Exception {

        System.out.println("Current app type: " + appType);

        switch(appType) {
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
    public WebElement getWelement(String weName) {
        // use reflection technique
        try {
            Field field = somePageObject.getClass().getDeclaredField(weName);
            field.setAccessible(true);
            return (WebElement) field.get(somePageObject);
        } catch (NoSuchFieldException | IllegalAccessException exception) {
            System.err.println(exception);
        }
        return null;
    }
}
