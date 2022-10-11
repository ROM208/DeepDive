package WorkingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkWithCookie {
    ChromeDriver driver;
    @BeforeTest
    public void openUrl()
    {
        String chromePath= System.getProperty("user.dir")+"\\sources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver=new ChromeDriver();
        driver.navigate().to("http://magento-demo.lexiconn.com/");
    }
    @Test
    public void test_cookies()
    {
        WebElement options= driver.findElement(By.id("select-language"));
        Select selectOptions=new Select(options);
        String txt=selectOptions.getFirstSelectedOption().getText();
        Assert.assertEquals(txt,"English");
        // define store cookie and check is empty
        Cookie cookie=driver.manage().getCookieNamed("store");
        Assert.assertEquals(cookie,null);
        // select  any choice
        selectOptions.selectByVisibleText("French");
        //define and check that store cookie stores french value
        cookie=driver.manage().getCookieNamed("store");
        Assert.assertEquals(cookie.getValue(),"french");
    }
    @AfterTest
    public void closeUrl()
    {
        //  driver.quit();
    }
}
