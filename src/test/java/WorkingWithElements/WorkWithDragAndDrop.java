package WorkingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkWithDragAndDrop {
    ChromeDriver driver;
    @BeforeTest
    public void openUrl()
    {
        String chromePath= System.getProperty("user.dir")+"\\sources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver=new ChromeDriver();
        driver.navigate().to("http://cookbook.seleniumacademy.com/DragDropDemo.html");
    }
    @Test
    public void test_drag_drop()
    {
        WebElement source= driver.findElement(By.id("draggable"));
        WebElement target= driver.findElement(By.id("droppable"));
        Actions act =new Actions(driver);
        act.dragAndDrop(source,target).perform();
        Assert.assertEquals(target.getText(),"Dropped!");
    }
    @AfterTest
    public void closeUrl()
    {
        driver.quit();
    }
}
