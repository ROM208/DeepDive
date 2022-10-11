package WorkingWithElements;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class WorkWithScreenShot {
    ChromeDriver driver;
    @BeforeTest
    public void openUrl()
    {
        String chromePath= System.getProperty("user.dir")+"\\sources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver=new ChromeDriver();
        driver.navigate().to("https://www.amazon.com/");
    }
    @Test
    public void test_screenshot()
    {
       WebElement search= driver.findElement(By.id("twotabsearchtextbox"));
       search.sendKeys("selenium book");
       search.submit();
        Assert.assertTrue(driver.getTitle().contains("cook"));
    }
    @AfterMethod
    public void takeScreenShot(ITestResult result) throws IOException {
        if(ITestResult.FAILURE == result.getStatus())
        {
            TakesScreenshot sc=(TakesScreenshot) driver;
            File photo=sc.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(photo,new File("./screenshots/"+result.getName()+".png"));
        }
    }
    @AfterTest
    public void closeUrl()
    {
        driver.quit();
    }
}
