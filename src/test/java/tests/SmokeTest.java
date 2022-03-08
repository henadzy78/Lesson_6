package tests;

import pages.DashboardPage;
import pages.LoginPage;
import baseEntities.BaseTest;
import core.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Retry;

public class SmokeTest extends BaseTest {

    @Test
    public void loginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.emailField.sendKeys(ReadProperties.getUsername());
        loginPage.passwordField.sendKeys(ReadProperties.getPassword());
        loginPage.loginButton.click();

        DashboardPage dashboardPage = new DashboardPage(driver);
        driver.get("https://1511.testrail.io/index.php?/admin/overview");

        dashboardPage = new DashboardPage(driver, true);
        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
        //Thread.sleep(5000);
    }

    @Test (retryAnalyzer = Retry.class)
    public void flakyLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.emailField.sendKeys(ReadProperties.getUsername());
        loginPage.passwordField.sendKeys(ReadProperties.getPassword());
        loginPage.loginButton.click();

        DashboardPage dashboardPage = new DashboardPage(driver);
        driver.get("https://1511.testrail.io/index.php?/admin/overview");

        dashboardPage = new DashboardPage(driver, true);

        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }
}
