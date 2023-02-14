package setup;

import io.appium.java_client.AppiumDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageobjects.PageObject;

public class BaseTest implements IDriver {

    private static AppiumDriver appiumDriver; // singleton
    protected static final Logger LOGGER = Logger.getGlobal();
    IPageObject po;
    WebDriverWait webDriverWait;

    //capability names
    private static final String PLATFORM_NAME = "platformName";
    private static final String DEVICE_NAME = "deviceName";
    private static final String APP = "app";
    private static final String BROWSER_NAME = "browserName";
    private static final String CHROME_DISABLE_BUILD_CHECK = "chromedriverDisableBuildCheck";

    //capability values
    private String chromeDisableBuildCheckBool = "true";

    @Override
    public AppiumDriver getDriver() {
        return appiumDriver;
    }

    public IPageObject getPo() {
        return po;
    }

    @Parameters({"platformName", "appType", "deviceName", "browserName", "app"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String platformName, String appType, String deviceName,
                      @Optional("") String browserName, @Optional("") String app) throws Exception {
        setAppiumDriver(platformName, deviceName, browserName, app);
        setPageObject(appType, appiumDriver);

    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        try {
            System.out.println("After");
            appiumDriver.closeApp();
        } catch (NullPointerException nullPointerException) {
            LOGGER.log(Level.WARNING, "Appium driver is null", nullPointerException);
        }

    }

    private void setAppiumDriver(String platformName, String deviceName, String browserName, String app) {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        //mandatory Android capabilities
        capabilities.setCapability(PLATFORM_NAME, platformName);
        capabilities.setCapability(DEVICE_NAME, deviceName);

        if (app.endsWith(".apk")) {
            capabilities.setCapability(APP, (new File(app)).getAbsolutePath());
        }

        capabilities.setCapability(BROWSER_NAME, browserName);
        capabilities.setCapability(CHROME_DISABLE_BUILD_CHECK, chromeDisableBuildCheckBool);

        try {
            appiumDriver = new AppiumDriver(new URL(System.getProperty("ts.appium")), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Timeouts tuning
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    private void setPageObject(String appType, AppiumDriver appiumDriver) {
        try {
            po = new PageObject(appType, appiumDriver);
        } catch (Exception exception) {
            LOGGER.log(Level.WARNING, "New page object was not set", exception);
        }

    }

    protected WebDriverWait waitDriver() {
        if (webDriverWait == null) {
            webDriverWait = new WebDriverWait(getDriver(), 10);
        }
        return webDriverWait;
    }

}
