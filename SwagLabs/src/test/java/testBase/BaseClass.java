package testBase;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utilities.ScreenshotUtil;

import java.io.IOException;

public class BaseClass {
    //public WebDriver driver;

    //if you want excuete in parallel execution use the below
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    protected  WebDriver driver;


    
    @BeforeClass
    public void setup() throws InterruptedException {

        //use the this for parallel exceution
          driverThreadLocal.set(new ChromeDriver());
          driver = driverThreadLocal.get();


        //driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }

    //this method will added in case if the test fails during the exceution auto screenshot will be captured
    public void captureScreenshotOnFailure(ITestResult result) throws IOException {
        if(ITestResult.FAILURE == result.getStatus()) {
            ScreenshotUtil.captureScreenshot(driver, result.getName() + ".png");
            System.out.println("screenshots saved successfully");
        }
    }

    @AfterClass
    public void tear_down() {

        if (driver != null) {
            driver.quit();

            //use this for parallel excuetion
            driverThreadLocal.remove();
        }


    }
}