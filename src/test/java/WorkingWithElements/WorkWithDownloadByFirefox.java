package WorkingWithElements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkWithDownloadByFirefox {

    FirefoxDriver driver;
    public static String downloadpath=System.getProperty("user.dir")+"\\downloads";
    public static FirefoxOptions firefoxoption()
    {
      FirefoxOptions option=new FirefoxOptions();
      option.addPreference("browser.download.folderList",2);
      option.addPreference("browser.download.dir",downloadpath);
      option.addPreference("browser.helperApps.neverAsk.saveToDisk","application/octet-stream");
      option.addPreference("browser.download.manager.showWhenString",false);
      return option;
    }
    @BeforeTest
    public void openUrl()
    {
        String firefoxPath= System.getProperty("user.dir")+"\\sources\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver",firefoxPath);
        driver=new FirefoxDriver(firefoxoption());
        driver.navigate().to("https://the-internet.herokuapp.com/download");
    }
    @Test
    public void test_download_with_firefox()
    {
        WebElement download= driver.findElement(By.linkText("webdriverIO.png"));
        download.click();
    }
    @AfterTest
    public void closeUrl()
    {
          driver.quit();
    }
}
