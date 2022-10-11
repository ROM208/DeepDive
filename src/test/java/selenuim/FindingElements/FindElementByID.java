package selenuim.FindingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByID {
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
    public void find_element_by_id()
     {
         WebElement usernameText=driver.findElement(By.id("username"));
         WebElement passwordText=driver.findElement(By.id("password"));
         System.out.println(usernameText.getTagName());
         System.out.println(passwordText.getSize());
     }
     @AfterTest
    public void closeUrl()
     {
         driver.quit();
     }
}
