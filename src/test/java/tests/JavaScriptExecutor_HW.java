package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptExecutor_HW extends BaseTest {

    @Test
    public void javaScriptExecutorTest() {
        driver.get("http://the-internet.herokuapp.com/floating_menu#home");

        WebElement elemSelenium = driver.findElement(By.xpath("//*[. = 'Elemental Selenium']"));

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Assert.assertTrue(elemSelenium.isDisplayed());
    }
}
