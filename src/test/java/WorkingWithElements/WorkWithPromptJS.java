package WorkingWithElements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkWithPromptJS {
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
    public void test_prompt_alerts_javascript()
    {
       WebElement promptBtn= driver.findElement(By.id("prompt"));
       promptBtn.click();
       Alert alert=driver.switchTo().alert();
       alert.sendKeys("ROM");
       alert.accept();
       WebElement alerttxt= driver.findElement(By.id("prompt_demo"));
       String prompttxt=alerttxt.getText();
       Assert.assertEquals(prompttxt,"Hello ROM! How are you today?");

    }
    @AfterTest
    public void closeUrl()
    {
        // driver.quit();
    }
}
