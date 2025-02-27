package testcases;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.LogoutPage;
import testBase.BaseClass;
import utilities.ScreenshotUtil;

import java.io.IOException;
import java.time.Duration;

public class LogoutTest extends BaseClass {


    @Test
    public void verify_logout() throws InterruptedException, IOException {
        LoginPage lp = new LoginPage(driver);
        lp.setemail("standard_user");
        lp.setpwd("secret_sauce");
        lp.clicklogin();

        LogoutPage lt = new LogoutPage(driver);
        lt.clickmenu();

        Thread.sleep(2000);
        lt.clicklogout();
        System.out.println("Logges out successfully");

        ScreenshotUtil.captureScreenshot(driver, "logout.png");









    }
}
