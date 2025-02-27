package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testBase.BaseClass;
import utilities.ExcelUtil;
import java.time.Duration;

public class ExcelDDTest extends BaseClass {

    @DataProvider(name = "UserDetails")
    public Object[][] getUserDetail() {
        // Reads the data from Excel
        return ExcelUtil.getTestData("UserDetails");
    }

    @Test(dataProvider = "UserDetails")
    public void testLoginAndCheckout(String username, String password, String firstname, String lastname, String postalcode) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step 1: Login with multiple credentials
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='user-name']"))).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        // Step 2: Verify successful login
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title']")));
        Assert.assertTrue(title.getText().contains("Product"), "Login failed!");

        // Step 3: Add the product to cart
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"))).click();

        // Step 4: Go to cart
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='shopping_cart_link']"))).click();

        // Step 5: Proceed to checkout
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='checkout']"))).click();

        // Step 6: Enter user details
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='first-name']"))).sendKeys(firstname);
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(lastname);
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(postalcode);

        // Step 7: Continue and complete the checkout
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='finish']"))).click();

        // Step 8: Verify order confirmation
        WebElement confirmationText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='complete-header']")));
        Assert.assertEquals(confirmationText.getText(), "Thank you for your order!", "Order confirmation failed");

        // Step 9: Logout after completion
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='react-burger-menu-btn']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='logout_sidebar_link']"))).click();
    }
}
