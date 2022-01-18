package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsTest_HW extends BaseTest {

    @Test
    public void actionsTest() {
        driver.get("http://the-internet.herokuapp.com/login");

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.className("radius"));

        Actions actions = new Actions(driver);
        actions
                .sendKeys(username, " tomsmith")
                .sendKeys(password, "SuperSecretPassword!")
                .click(loginButton)
                .build()
                .perform();

        WebElement youLogged = driver.findElement(By.id("flash"));
        Assert.assertTrue(youLogged.isDisplayed());
    }
}
