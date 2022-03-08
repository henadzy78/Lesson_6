package tests;

import models.User;
import pages.DashboardPage;
import pages.LoginPage;
import baseEntities.BaseTest;
import core.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Retry;

public class SmokeTest extends BaseTest {

    @Test
    public void loginTest() {
        User user = new User()
                .setEmail(ReadProperties.getUsername())
                .setPassword(ReadProperties.getPassword());

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }

    @Test (retryAnalyzer = Retry.class)
    public void flakyLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.getEmailField().sendKeys(ReadProperties.getUsername());
        loginPage.getPasswordField().sendKeys(ReadProperties.getPassword());
        loginPage.getLoginButton().click();

        DashboardPage dashboardPage = new DashboardPage(driver);
        driver.get("https://1511.testrail.io/index.php?/admin/overview");

        dashboardPage = new DashboardPage(driver, true);

        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }
}
