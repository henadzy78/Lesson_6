package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {

    @Test
    public void infoAlertTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[. = 'Click for JS Alert']")).click();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Alert");
        Thread.sleep(5000);
        alert.accept();


    }


    @Test
    public void confirmAlertTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[. = 'Click for JS Confirm']")).click();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
        Thread.sleep(5000);
        alert.dismiss();
    }

    @Test
    public void promptAlertTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[. = 'Click for JS Prompt']")).click();

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(),"I am a JS prompt");

        alert.sendKeys("Everything is OK!");
        alert.accept();

        Thread.sleep(3000);



    }
}
