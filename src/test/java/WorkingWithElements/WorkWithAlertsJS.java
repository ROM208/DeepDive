package WorkingWithElements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class WorkWithAlertsJS {
    ChromeDriver driver;
    @BeforeTest
    public void openUrl()
    {
        String chromePath= System.getProperty("user.dir")+"\\sources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver=new ChromeDriver();
        driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");
    }
    @Test
    public void test_alerts_javascript()
    {
       WebElement alertBtn= driver.findElement(By.id("simple"));
       alertBtn.click();
        Alert alert=driver.switchTo().alert();
        String alerttxt= alert.getText();
        Assert.assertEquals(alerttxt,"Hello! I am an alert box!");
        alert.accept();
    }
    @AfterTest
    public void closeUrl()
    {
       // driver.quit();
    }
}
