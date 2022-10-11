package selenuim.FindingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.event.ListDataEvent;
import java.util.List;

public class FindElementsByTagname {
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
    public void find_element_by_tagName()
    {
        WebElement loginBtn=driver.findElement(By.tagName("button"));
        loginBtn.click();
    }
    @AfterTest
    public void closeUrl()
    {
        //driver.quit();
    }
}
