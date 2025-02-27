package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cartaddpage extends BasePage{

    public Cartaddpage(WebDriver driver){
        super(driver);
    }


    By item1 =(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
    By item2 = (By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']"));
    By cart = (By.xpath("//a[@class='shopping_cart_link']"));
    By removecart = (By.xpath("//button[@id='remove-sauce-labs-bike-light']"));
    By Checkout = (By.xpath("//button[@id='checkout']"));

    public void addtem1(){
        driver.findElement(item1).click();
    }

    public void  additem2(){
        driver.findElement(item2).click();
    }

    public void  setCart(){
        driver.findElement(cart).click();
    }

    public void setRemovecart(){
        driver.findElement(removecart).click();
    }

    public void setCheckout(){
        driver.findElement(Checkout).click();
    }



}
