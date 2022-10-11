package selenuim.FindingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementInTableByTagName {
    ChromeDriver driver;
    @BeforeTest
    public void openUrl()
    {
        String chromePath= System.getProperty("user.dir")+"\\sources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/tables");
    }
    @Test
    public void find_elements_in_table_by_tagName()
    {
        WebElement table= driver.findElement(By.id("table1"));
        List<WebElement> rows=table.findElements(By.tagName("tr"));   ///return many elements
         System.out.println(rows.get(3).getText());                ///return and print specific row
    }
    @AfterTest
    public void closeUrl()
    {
        driver.quit();
    }
}
