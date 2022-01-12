package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTests extends BaseTest {

    @Test
    public void frameTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");

        //driver.switchTo().frame(driver.findElement(By.id("mce_0"_ifr)));
        driver.switchTo().frame(0);
        Assert.assertTrue(driver.findElement(By.id("tinymce")).isDisplayed());

        driver.switchTo().parentFrame();
        Assert.assertTrue(driver.findElement(By.className("tox-editor-container")).isDisplayed());


    }
}
