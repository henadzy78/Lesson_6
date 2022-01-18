package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Waits;

public class WaitsTest_HW extends BaseTest {

    @Test
    public void waitTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");

        Waits waits = new Waits(driver, 10);

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();
        Assert.assertTrue(waits.waitForVisibility(By.id("loading")).isDisplayed());
        Assert.assertTrue(waits.waitForVisibility(By.xpath("//*[. = 'Hello World!']")).isDisplayed());
    }
}
