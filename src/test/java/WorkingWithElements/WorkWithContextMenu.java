package WorkingWithElements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkWithContextMenu {
    ChromeDriver driver;
    @BeforeTest
    public void openUrl()
    {
        String chromePath= System.getProperty("user.dir")+"\\sources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver=new ChromeDriver();
        driver.navigate().to("https://swisnl.github.io/jQuery-contextMenu/demo.html");
    }
    @Test
    public void test_contextMenu()
    {
        WebElement contextMenu= driver.findElement(By.cssSelector("span.context-menu-one.btn.btn-neutral"));
        WebElement copy= driver.findElement(By.cssSelector("li.context-menu-item.context-menu-icon.context-menu-icon-copy"));
        Actions act=new Actions(driver);
        act.contextClick(contextMenu).moveToElement(copy).click().perform();
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"clicked: copy");
        alert.accept();
    }
    @AfterTest
    public void closeUrl()
    {
        //driver.quit();
    }
}
