package WorkingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkWithCanvasHtml5 {
    ChromeDriver driver;
    @BeforeTest
    public void openUrl()
    {
        String chromePath= System.getProperty("user.dir")+"\\sources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver=new ChromeDriver();
        driver.navigate().to("http://cookbook.seleniumacademy.com/html5canvasdraw.html");
    }
    @Test
    public void test_canvas()
    {
        WebElement tool= driver.findElement(By.id("dtool"));
        WebElement canvas= driver.findElement(By.id(("imageTemp")));
        Select option=new Select(tool);
        option.selectByVisibleText("Pencil");
        Actions act=new Actions(driver);
        act.clickAndHold(canvas).moveByOffset(10,50).moveByOffset(50,10).release().perform();

    }
    @AfterTest
    public void closeUrl()
    {
        //  driver.quit();
    }

}
