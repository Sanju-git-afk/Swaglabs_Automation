package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    public CheckoutPage (WebDriver driver)
    {
        super(driver);
    }





     By entername=   (By.xpath("//input[@id='first-name']"));
     By enterlastname=    (By.xpath("//input[@id='last-name']"));
     By enterpostcode =    (By.xpath("//input[@id='postal-code']"));
     By  btncontinue=  (By.xpath("//input[@id='continue']"));
       By btnfinish = (By.xpath("//button[@id='finish']"));




       public void setEntername(String name){
           driver.findElement(entername).sendKeys(name);
       }

       public void setEnterlastname(String lastname){
           driver.findElement(enterlastname).sendKeys(lastname);
       }

       public void setEnterpostcode(String Post){
           driver.findElement(enterpostcode).sendKeys(Post);
       }

       public void setBtncontinue(){
           driver.findElement(btncontinue).click();
       }

       public  void setBtnfinish(){
           driver.findElement(btnfinish).click();
       }

}
