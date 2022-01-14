package tests;


//import Pages.*;
import org.testng.Assert;
import pages.DashboardPage;
import baseEntities.BaseTest;
import core.ReadProperties;
import org.testng.annotations.Test;
import utils.Retry;

public class SmokeTest extends BaseTest {

    @Test
    public void loginTest() {
        pages.LoginPage loginPage = new pages.LoginPage(driver);

        loginPage.emailField.sendKeys(ReadProperties.getUsername());
        loginPage.passwordField.sendKeys(ReadProperties.getPassword());
        loginPage.loginButton.click();

           DashboardPage dashboardPage = new DashboardPage(driver);
           driver.get("https://qa1504.testrail.io/index.php?/admin/overview");

           dashboardPage = new DashboardPage(driver, true);
        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }

    @Test (retryAnalyzer = Retry.class)
    public void flakyLoginTest() {
        pages.LoginPage loginPage = new pages.LoginPage(driver);

        loginPage.emailField.sendKeys(ReadProperties.getUsername());
        loginPage.passwordField.sendKeys(ReadProperties.getPassword());
        loginPage.loginButton.click();

        DashboardPage dashboardPage = new DashboardPage(driver);
        driver.get("https://qa1504.testrail.io/index.php?/admin/overview");

        dashboardPage = new DashboardPage(driver, true);
        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }

}
