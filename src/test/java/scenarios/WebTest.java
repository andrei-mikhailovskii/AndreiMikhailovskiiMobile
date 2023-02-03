package scenarios;

import org.testng.annotations.Test;
import setup.DriverSetupWebApp;

public class WebTest extends DriverSetupWebApp {

    String url = "https://www.google.com/";
    String searchQuery = "EPAM";


    @Test
    public void webCheck() throws InterruptedException {
        androidDriver.get(url);
        Thread.sleep(2000);
        System.out.println("Website is opened!");
    }

}
