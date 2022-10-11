package WorkingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkWithFrames {
    ChromeDriver driver;
    @BeforeTest
    public void openUrl()
    {
        String chromePath= System.getProperty("user.dir")+"\\sources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver=new ChromeDriver();
        driver.navigate().to("http://cookbook.seleniumacademy.com/Frames.html");
    }
    @Test
    public void test_frames()
    {
        //make driver switch to the frame I want
       driver.switchTo().frame("left");
        WebElement msgLeft= driver.findElement(By.tagName("p"));
        String txt=msgLeft.getText();
        Assert.assertEquals(txt,"This is Left Frame");
        // back to original mode of driver
        driver.switchTo().defaultContent();
        // make driver switch to another frame I want
        driver.switchTo().frame("right");
        WebElement msgRight= driver.findElement(By.tagName("p"));
        String txt2=msgRight.getText();
        Assert.assertEquals(txt2,"This is Right Frame");
        // back to original mode of driver
        driver.switchTo().defaultContent();
        // make driver switch to another frame I want
        driver.switchTo().frame(1);                // index is 0 1 2 ...by order
        WebElement msgMiddle= driver.findElement(By.tagName("p"));
        String txt3=msgMiddle.getText();
        Assert.assertEquals(txt3,"This Frame doesn't have id or name");
        // back to original mode of driver
        driver.switchTo().defaultContent();
    }
    @AfterTest
    public void closeUrl()
    {
        driver.quit();
    }
}
