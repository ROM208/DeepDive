package WorkingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkWithScrollJS {
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
    public void test_scroll_using_javascript()
    {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
    }
    @AfterTest
    public void closeUrl()
    {
        //driver.quit();
    }
}
