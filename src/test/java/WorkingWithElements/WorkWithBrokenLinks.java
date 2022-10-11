package WorkingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class WorkWithBrokenLinks {
    ChromeDriver driver;
    private int c=1;
    @BeforeTest
    public void openUrl()
    {
        String chromePath= System.getProperty("user.dir")+"\\sources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/");
    }
    @Test
    public void test_brokenLinks() throws IOException {
        List<WebElement> links=driver.findElements(By.tagName("a"));
        System.out.println("Total links are : "+links.size());
        for(WebElement link:links)
        {
            String url=link.getAttribute("href");
            verifyLink(url);
        }
    }
    public void verifyLink(String url) throws IOException {
        URL link = new URL(url);
            // create connection using URL object
            HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
            httpConn.setConnectTimeout(2000);
            httpConn.connect();
            // use getResponseCode() to get the response code
            if(httpConn.getResponseCode() == 200)
            {
                System.out.println(c+" : "+url+" - "+httpConn.getResponseMessage());
                c++;
            }
            if (httpConn.getResponseCode() == 404) {
                System.out.println(c+" : "+url+" - "+httpConn.getResponseMessage());
                c++;
            }
    }
    @AfterTest
    public void closeUrl()
    {
        driver.quit();
    }
}
