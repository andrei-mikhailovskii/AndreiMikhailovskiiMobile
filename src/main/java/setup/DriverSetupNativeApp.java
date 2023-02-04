package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetupNativeApp extends PropertiesExtractor implements IDriver {

    private AppiumDriver appiumDriver;

    @BeforeClass
    public void driverSetup() throws MalformedURLException {

        File app = new File("src/main/resources/EPAMTestApp.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("app", app.getAbsolutePath());

        this.appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @Override
    public AppiumDriver getDriver() {
        return appiumDriver;
    }
}
