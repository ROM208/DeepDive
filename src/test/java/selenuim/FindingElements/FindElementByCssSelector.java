package selenuim.FindingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementByCssSelector {
    ChromeDriver driver;
    @BeforeTest
    public void openUrl()
    {
        String chromePath= System.getProperty("user.dir")+"\\sources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }
    @Test
    public void find_elements_by_cssSelector()
    {
        WebElement loginBtn= driver.findElement(By.cssSelector("button.radius")); ////// tagName.className
        WebElement usernameText=driver.findElement(By.cssSelector("input#username"));///// لما مش بيبقى عندي كلاس بقف على العنصر وبيظهرلي الاسم \\قاعدة عامة
        WebElement loginPage =driver.findElement(By.cssSelector("h2"));
        System.out.println(loginBtn.getText());
        System.out.println(loginPage.getText());
        System.out.println(usernameText.getTagName());
    }
    @AfterTest
    public void closeUrl()
    {
        driver.quit();
    }
}
