package scenarios;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.DriverSetup;

public class BaseTest extends DriverSetup {

    String signInBtn = "platkovsky.alexey.epamtestapp:id/email_sign_in_button";

    @Test
    public void clickButtonTest() {
        androidDriver.findElement(By.id(signInBtn)).click();
        System.out.println("Clicked!");
    }

}
