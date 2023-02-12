package setup;

import io.appium.java_client.AppiumDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageobjects.PageObject;

public class BaseTest implements IDriver {

    private static AppiumDriver appiumDriver; // singleton
    IPageObject po;
    WebDriverWait webDriverWait;

    //capability names
    private static final String PLATFORM_NAME = "platformName";
    private static final String DEVICE_NAME = "deviceName";
    private static final String UDID = "udid";
    private static final String APP = "app";
    private static final String BROWSER_NAME = "browserName";
    private static final String CHROME_DISABLE_BUILD_CHECK = "chromedriverDisableBuildCheck";
    private static final String APP_PACKAGE = "appPackage";
    private static final String APP_ACTIVITY = "appActivity";
    private static final String BUNDLE_ID = "bundleId";
    private static final String URL = String.format("https://%s:%s@app.mobitru.com/wd/hub",
            System.getenv("EPAM_NAME_SURNAME"), URLEncoder.encode(System.getenv("MOBITRU_TOKEN")));

    //capability values
    private String chromeDisableBuildCheckBool = "true";

    @Override
    public AppiumDriver getDriver() {
        return appiumDriver;
    }

    public IPageObject getPo() {
        return po;
    }

    @Parameters({"platformName", "appType", "deviceName", "udid", "browserName",
                    "app", "appPackage", "appActivity", "bundleId"})
    @BeforeClass(alwaysRun = true)
    public void setUp(String platformName,
                      String appType,
                      @Optional("") String deviceName,
                      @Optional("") String udid,
                      @Optional("") String browserName,
                      @Optional("") String app,
                      @Optional("") String appPackage,
                      @Optional("") String appActivity,
                      @Optional("") String bundleId
    ) throws Exception {
        System.out.println("Before: app type - " + appType);
        setAppiumDriver(platformName, deviceName, udid, browserName, app, appPackage, appActivity, bundleId);
        setPageObject(appType, appiumDriver);

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        try {
            System.out.println("After");
            appiumDriver.closeApp();
        } catch (NullPointerException nullPointerException) {
            System.err.println("Appium driver is null: " + nullPointerException);
        }

    }

    private void setAppiumDriver(String platformName, String deviceName, String udid, String browserName,
                                 String app, String appPackage, String appActivity, String bundleId) {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        // mandatory Android capabilities
        capabilities.setCapability(PLATFORM_NAME, platformName);
        capabilities.setCapability(DEVICE_NAME, deviceName);
        capabilities.setCapability(UDID, udid);

        if (app.endsWith(".apk")) {
            capabilities.setCapability(APP, (new File(app)).getAbsolutePath());
        }

        capabilities.setCapability(BROWSER_NAME, browserName);
        capabilities.setCapability(CHROME_DISABLE_BUILD_CHECK, chromeDisableBuildCheckBool);

        // capabilities for test of Android native app
        capabilities.setCapability(APP_PACKAGE, appPackage);
        capabilities.setCapability(APP_ACTIVITY, appActivity);

        // capabilities for test of iOS native app
        capabilities.setCapability(BUNDLE_ID, bundleId);

        try {
            appiumDriver = new AppiumDriver(new URL(URL), capabilities);
            //"http://127.0.0.1:4723/wd/hub"
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
            System.err.println(exception);
        }

    }

    protected WebDriverWait waitDriver() {
        if (webDriverWait == null) {
            webDriverWait = new WebDriverWait(getDriver(), 10);
        }
        return webDriverWait;
    }

    protected void waitUntilPageIsLoaded() {
        waitDriver().until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

}
