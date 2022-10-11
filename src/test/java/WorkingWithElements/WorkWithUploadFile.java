package WorkingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class WorkWithUploadFile {
    ChromeDriver driver;
    @BeforeTest
    public void openUrl()
    {
        String chromePath= System.getProperty("user.dir")+"\\sources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
    }
    @Test
    public void test_uploadFile()
    {
        WebElement file= driver.findElement(By.id("file-upload"));
        WebElement upload= driver.findElement(By.id("file-submit"));
        String path=System.getProperty("user.dir")+"/uploads/page.png";
        file.sendKeys(path);
        upload.click();
        WebElement uploaded= driver.findElement(By.id("uploaded-files"));
        Assert.assertEquals(uploaded.getText(),"page.png");
    }
    @AfterTest
    public void closeUrl()
    {
      //  driver.quit();
    }





}
