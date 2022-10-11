package WorkingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class WorkWithTables {
    ChromeDriver driver;
    private int c=0;
    @BeforeTest
    public void openUrl()
    {
        String chromePath= System.getProperty("user.dir")+"\\sources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/tables");
    }
    @Test
    public void test_tables()
    {
       WebElement table= driver.findElement(By.id("table1"));
       List<WebElement> rows=table.findElements(By.tagName("tr"));
       for(WebElement row:rows)
       {
          List<WebElement> cells=row.findElements(By.tagName("td"));
          for(WebElement cell:cells)
          {
              System.out.println(cell.getText());
          }
          if(c < rows.size()-1) {
              c++;
              System.out.println("Row : " + c);
          }
       }
    }
    @AfterTest
    public void closeUrl()
    {
        driver.quit();
    }
}
