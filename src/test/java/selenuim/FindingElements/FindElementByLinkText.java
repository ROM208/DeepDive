package selenuim.FindingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementByLinkText {
    ChromeDriver driver;
    @BeforeTest
    public void openUrl()
    {
        String chromePath= System.getProperty("user.dir")+"\\sources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/");
    }
    @Test
    public void find_element_by_linkText()
    {
        WebElement elementalSelenium= driver.findElement(By.linkText("Elemental Selenium"));
            System.out.println(elementalSelenium.getAttribute("href"));///// return and print link
            System.out.println(elementalSelenium.getText());
    }
    @AfterTest
    public void closeUrl()
    {
        driver.quit();
    }
}
