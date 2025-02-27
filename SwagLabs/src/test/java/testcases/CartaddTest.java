package testcases;

import org.testng.annotations.Test;
import pageobjects.Cartaddpage;
import pageobjects.LoginPage;
import testBase.BaseClass;
import utilities.ScreenshotUtil;

import java.io.IOException;

public class CartaddTest extends BaseClass {
    @Test
    public void verify_cartadd() throws InterruptedException, IOException {
        LoginPage lp = new LoginPage(driver);
        lp.setemail("standard_user");
        lp.setpwd("secret_sauce");
        lp.clicklogin();
        ScreenshotUtil.captureScreenshot(driver, "CartaddTest1.png");

        Cartaddpage Ct = new Cartaddpage(driver);
        Ct.addtem1();
        Thread.sleep(2000);
        Ct.additem2();
        Thread.sleep(2000);
        Ct.setCart();

        //System.out.println("Product is added succesfully");

        Thread.sleep(3000);
        ScreenshotUtil.captureScreenshot(driver, "CartaddTest2.png");


        Ct.setRemovecart();
        Ct.setCheckout();
        ScreenshotUtil.captureScreenshot(driver, "CartaddTest3.png");

        //System.out.println("Product is removed from the cart");

    }
}
