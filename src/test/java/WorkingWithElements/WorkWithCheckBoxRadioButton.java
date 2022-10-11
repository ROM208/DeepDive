package WorkingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkWithCheckBoxRadioButton {
    ChromeDriver driver;
    @BeforeTest
    public void openUrl()
    {
        String chromePath= System.getProperty("user.dir")+"\\sources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
    }
    @Test
    public void test_checkbox()
    {
         WebElement check1= driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        WebElement check2= driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
         check1.click();
         if(!check2.isSelected())
         {
             check2.click();
         }
    }
    @AfterTest
    public void closeUrl()
    {
      //  driver.quit();
    }
}
