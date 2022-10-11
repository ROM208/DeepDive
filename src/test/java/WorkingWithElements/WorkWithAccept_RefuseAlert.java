package WorkingWithElements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkWithAccept_RefuseAlert {
    ChromeDriver driver;
    @BeforeTest
    public void openUrl()
    {
        String chromePath= System.getProperty("user.dir")+"\\sources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver=new ChromeDriver();
        driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");
    }
    @Test(priority = 1)
    public void test_accept_alert()
    {
       WebElement alertbtn= driver.findElement(By.id("confirm"));
       alertbtn.click();
       Alert alert=driver.switchTo().alert();
       alert.accept();
       WebElement alerttxt= driver.findElement(By.id("demo"));
       String txt=alerttxt.getText();
       Assert.assertEquals(txt,"You Accepted Alert!");
    }
    @Test(priority = 2)
    public void test_dismiss_alert()
    {
        WebElement alertbtn= driver.findElement(By.id("confirm"));
        alertbtn.click();
        Alert alert=driver.switchTo().alert();
        alert.dismiss();
        WebElement alerttxt= driver.findElement(By.id("demo"));
        String txt=alerttxt.getText();
        Assert.assertEquals(txt,"You Dismissed Alert!");
    }
    @AfterTest
    public void closeUrl()
    {
        // driver.quit();
    }
}
