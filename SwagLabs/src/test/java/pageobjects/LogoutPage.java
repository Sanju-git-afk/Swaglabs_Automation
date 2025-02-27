package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage extends BasePage{

    public LogoutPage(WebDriver driver){
        super(driver);
    }


     By menu = (By.xpath("//button[@id='react-burger-menu-btn']"));
     By logout=   (By.xpath("//a[@id='logout_sidebar_link']"));


     public void  clickmenu (){
         driver.findElement(menu).click();
     }

     public void clicklogout(){
         driver.findElement(logout).click();
     }
}
