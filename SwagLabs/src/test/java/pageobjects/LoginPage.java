package pageobjects;

import net.bytebuddy.implementation.bind.annotation.Super;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testBase.BaseClass;

public class LoginPage extends BasePage {
    public  LoginPage (WebDriver driver)
    {
        super(driver);

    }


    By enterusername=     (By.xpath("//input[@id='user-name']"));
     By enterpassword=   (By.xpath("//input[@id='password']"));
     By btnlogin = (By.xpath("//input[@id='login-button']"));


     public void setemail (String email) {
         driver.findElement(enterusername).sendKeys(email);
     }

     public void setpwd (String Pass) {
         driver.findElement(enterpassword).sendKeys(Pass);
     }

     public void clicklogin() {
         driver.findElement(btnlogin).click();
    }
}
