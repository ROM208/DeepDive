package WorkingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;


public class WorkWithDownloadByChrome {
    ChromeDriver driver;
    public static String downloadpath=System.getProperty("user.dir")+"\\downloads";
    public static ChromeOptions chromeoption()
    {
         ChromeOptions option = new ChromeOptions();
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default.content_settings.popups", 0);
            chromePrefs.put("download.default_directory", downloadpath);
            option.setExperimentalOption("prefs", chromePrefs);
           // option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
           option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        return option;
    }
    @BeforeTest
    public void openUrl()
    {
        String chromePath= System.getProperty("user.dir")+"\\sources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver=new ChromeDriver(chromeoption());
        driver.navigate().to("https://the-internet.herokuapp.com/download");
    }
    @Test
    public void test_download_with_chrome()
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
