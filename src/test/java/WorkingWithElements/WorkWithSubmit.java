package WorkingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkWithSubmit {
    ChromeDriver driver;
    WebElement txtsearch;
    @BeforeTest
    public void openUrl()
    {
        String chromePath= System.getProperty("user.dir")+"\\sources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver=new ChromeDriver();
        driver.navigate().to("https://www.google.com");
    }
    @Test
    public void test_search_submit()
    {
        txtsearch =driver.findElement(By.name("q"));
        txtsearch.clear();
        txtsearch.sendKeys("Egybest");
        txtsearch.submit();
        txtsearch =driver.findElement(By.name("q"));
        txtsearch.clear();
        txtsearch.sendKeys("books");
        txtsearch.submit();
    }
    @AfterTest
    public void closeUrl()
    {
        driver.quit();
    }
}
