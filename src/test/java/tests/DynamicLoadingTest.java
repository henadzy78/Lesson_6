package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Waits;

public class DynamicLoadingTest extends BaseTest {

    @Test
    public void waitsTest(){
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement button = driver.findElement(By.xpath("//*[. = 'Start']"));
        button.click();

        WebElement loading = driver.findElement(By.xpath("//*[. = 'Loading... ']"));
        Assert.assertTrue(loading.isDisplayed());

        Waits waits = new Waits(driver);

        Assert.assertTrue(waits.waitForInvisibility(loading,10));

        WebElement helloWorld = driver.findElement(By.xpath("//*[. = 'Hello World!']"));
        Assert.assertTrue(helloWorld.isDisplayed());
    }
}
