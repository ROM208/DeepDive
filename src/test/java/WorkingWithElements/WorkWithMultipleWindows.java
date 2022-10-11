package WorkingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkWithMultipleWindows {
    ChromeDriver driver;
    @BeforeTest
    public void openUrl()
    {
        String chromePath= System.getProperty("user.dir")+"\\sources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://cookbook.seleniumacademy.com/Config.html");
    }
    @Test
    public void test_window_using_name()
    {
        String currentWindow= driver.getWindowHandle();
        WebElement helpBtn= driver.findElement(By.id("helpbutton"));
        helpBtn.click();
        driver.switchTo().window("HelpWindow");
        String title= driver.getTitle();
        Assert.assertEquals(title,"Help");
        // code inside Help windows
        driver.close();
        // return to first(parent) window
        driver.switchTo().window(currentWindow);
    }
    @Test
    public void test_window_using_title()
    {
         String currentWindow= driver.getWindowHandle();
         WebElement visitBtn= driver.findElement(By.id("visitbutton"));
         visitBtn.click();
         for(String window: driver.getWindowHandles())
         {
             String title=driver.switchTo().window(window).getTitle();
             if(title.equals("Visit Us"))
             {
                 Assert.assertEquals(driver.getTitle(),"Visit Us");
                 // code inside Visit Us windows
                 System.out.println(driver.getTitle());
                 driver.close();
                 break;
             }
         }
        // return to first(parent) window
        driver.switchTo().window(currentWindow);
    }
    @AfterTest
    public void closeUrl()
    {
        //  driver.quit();
    }
}
