package WorkingWithElements;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkWithCommands {
    ChromeDriver driver;
    @BeforeTest
    public void openUrl()
    {
        String chromePath= System.getProperty("user.dir")+"\\sources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();  /////////////make window in max option
    }
    @Test
    public void login_screen()
    {
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.navigate().back();   //////// <-----
        driver.navigate().forward();//////// ------>
        driver.navigate().refresh(); ///// refresh window
    }
    @AfterTest
    public void closeUrl()
    {
        driver.quit();
    }
}
