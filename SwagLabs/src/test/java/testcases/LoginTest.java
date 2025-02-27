package testcases;

import org.testng.annotations.Test;
import pageobjects.LoginPage;
import testBase.BaseClass;
import utilities.ScreenshotUtil;

import java.io.IOException;

public class LoginTest extends BaseClass {

    @Test
    public void verfiy_login() throws IOException {
        LoginPage lp = new LoginPage(driver);
        lp.setemail("standard_user");
        lp.setpwd("secret_sauce");
        lp.clicklogin();
        ScreenshotUtil.captureScreenshot(driver, "Checkout1.png");



    }
}
