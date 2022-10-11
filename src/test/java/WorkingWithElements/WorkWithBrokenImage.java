package WorkingWithElements;


import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.List;

public class WorkWithBrokenImage {
    ChromeDriver driver;
    private int invalidImageCount;
    @BeforeTest
    public void openUrl()
    {
        String chromePath= System.getProperty("user.dir")+"\\sources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/broken_images");
    }
    @Test
    public void test_brokenImages()
    {
       List<WebElement> imagelist=driver.findElements(By.tagName("img"));
       for(WebElement image: imagelist)
       {
           if(image != null)
           {
               check_invalidImages(image);
           }
       }
     System.out.println("Number of invalid images = "+invalidImageCount);
    }
    public void check_invalidImages(WebElement image)
    {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(image.getAttribute("src"));
        try
        {
            HttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() != 200)
            {
                invalidImageCount++ ;
            }
        }
        catch (ClientProtocolException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    @AfterTest
    public void closeUrl()
    {
        driver.quit();
    }
}
