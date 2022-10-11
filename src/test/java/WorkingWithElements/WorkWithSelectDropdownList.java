package WorkingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkWithSelectDropdownList {
    ChromeDriver driver;
    @BeforeTest
    public void openUrl()
    {
        String chromePath= System.getProperty("user.dir")+"\\sources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
    }
    @Test
    public void test_select_dropdownList()
    {
        WebElement options= driver.findElement(By.id("dropdown"));
        Select selectOptions=new Select(options);
        Assert.assertFalse(selectOptions.isMultiple()); ////// check that I can select one option
        Assert.assertEquals(selectOptions.getOptions().size(),3); //// check that size of list is 3
        selectOptions.selectByVisibleText("Option 1"); ///// select by txt
        selectOptions.selectByValue("1"); ///// select by value
        selectOptions.selectByIndex(2); //// select by index
    }
    @AfterTest
    public void closeUrl()
    {
      //  driver.quit();
    }
}
