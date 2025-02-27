package testcases;

import org.testng.annotations.Test;
import pageobjects.Cartaddpage;
import pageobjects.CheckoutPage;
import pageobjects.LoginPage;
import testBase.BaseClass;
import utilities.ScreenshotUtil;

import java.io.IOException;

public class CheckoutTest extends BaseClass {

    @Test
    public void verify_checkout() throws InterruptedException, IOException {
       LoginPage lp = new LoginPage(driver);
        lp.setemail("standard_user");
        lp.setpwd("secret_sauce");
        lp.clicklogin();

       Cartaddpage Ct = new Cartaddpage(driver);
        Ct.addtem1();
        Thread.sleep(2000);
        Ct.additem2();
        Thread.sleep(2000);
        Ct.setCart();

        //System.out.println("Product is added succesfully");

        Thread.sleep(3000);
        ScreenshotUtil.captureScreenshot(driver, "Checkout1.png");


        Ct.setRemovecart();
        Ct.setCheckout();

        CheckoutPage CP = new CheckoutPage(driver);
        Thread.sleep(3000);
        CP.setEntername("Sanjana");
        CP.setEnterlastname("manish");
        CP.setEnterpostcode("576537777");
        Thread.sleep(3000);
        CP.setBtncontinue();
        Thread.sleep(2000);
        CP.setBtnfinish();

        ScreenshotUtil.captureScreenshot(driver, "checkout2.png");


    }
}
