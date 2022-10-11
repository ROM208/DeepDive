package selenuim.FindingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBrowserCommands {
    ChromeDriver driver;
    @BeforeTest
    public void openUrl()
    {
        String chromePath= System.getProperty("user.dir")+"\\sources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }
    @Test
    public void test_commands()
    {
       WebElement txtusername =driver.findElement(By.id("username"));
        WebElement txtpassword =driver.findElement(By.id("password"));
        WebElement loginbtn =driver.findElement(By.className("radius"));
        txtusername.clear();
        txtusername.sendKeys("tomsmith");
        txtpassword.clear();
        txtpassword.sendKeys("SuperSecretPassword!");
        loginbtn.click();
        String currenturl = driver.getCurrentUrl();
        Assert.assertEquals(currenturl,"https://the-internet.herokuapp.com/secure");
    }
    @AfterTest
    public void closeUrl()
    {
        driver.quit();
    }
}
