package WorkingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkWithJavaScript {
    ChromeDriver driver;
    @BeforeTest
    public void openUrl()
    {
        String chromePath= System.getProperty("user.dir")+"\\sources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver=new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
    }
    @Test
    public void test_js()
    {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        String title= (String) js.executeScript("return document.title");
        System.out.println(title);
       long links= (long) js.executeScript("var links=document.getElementsByTagName('A'); return links.length");
       System.out.println(links);
    }
    @AfterTest
    public void closeUrl()
    {
        driver.quit();
    }
}
