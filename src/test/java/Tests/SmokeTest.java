package Tests;

import Pages.AddProjectPage;
import Pages.DashboardPage;
import Pages.LoginPage;
import baseEntities.BaseTest;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void loginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ReadProperties.getUsername(), ReadProperties.getPassword());
    }
    @Test
    public void projectTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ReadProperties.getUsername(), ReadProperties.getPassword());

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.startProject();
    }
    @Test
    public void addProjectTest(){
        String expectedMsg = "Successfully added the new project.";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ReadProperties.getUsername(), ReadProperties.getPassword());

        AddProjectPage addProjectPage = new AddProjectPage(driver);
        addProjectPage.createProject(ReadProperties.getName(), ReadProperties.getAnnouncement());
        WebElement resultMsg = driver.findElement(By.cssSelector("div[class='message message-success']"));
        String actualMsg = resultMsg.getText();
        Assert.assertEquals(actualMsg, expectedMsg);
    }
}
