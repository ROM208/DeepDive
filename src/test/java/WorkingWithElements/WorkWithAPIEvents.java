package WorkingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class WorkWithAPIEvents {
    ChromeDriver driver;
    @BeforeTest
    public void openUrl()
    {
        String chromePath= System.getProperty("user.dir")+"\\sources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver=new ChromeDriver();
        driver.navigate().to("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");
    }
    @Test
    public void test_doubleClick()
    {
        WebElement message =driver.findElement(By.id("message"));
        String color1=message.getCssValue("background-color");
      // System.out.println(color1);
        Assert.assertEquals(color1,"rgba(0, 0, 255, 1)"); /// check first color of box
        Actions act=new Actions(driver);
        act.doubleClick(message).perform();  ////مش هتشتغل من غير perform
       String color2=message.getCssValue("background-color");
       // System.out.println(color2);
       Assert.assertEquals(color2,"rgba(255, 255, 0, 1)"); /// check second color of box
    }
    @AfterTest
    public void closeUrl()
    {
        driver.quit();
    }
}
