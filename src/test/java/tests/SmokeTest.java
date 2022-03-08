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
    public void loginTest() {
        /*LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage.successLogin(ReadProperties.getUsername(),
                ReadProperties.getPassword());  Внизу тоже самое, но лаконичнее!!!
         */
        Assert.assertTrue(new LoginPage(driver)
                .successLogin(ReadProperties.getUsername(),ReadProperties.getPassword())
                .getAddProjectButton().isDisplayed());
    }

    @Test (retryAnalyzer = Retry.class)
    public void flakyLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.getEmailField().sendKeys(ReadProperties.getUsername());
        loginPage.getPasswordField().sendKeys(ReadProperties.getPassword());
        loginPage.getLoginButton().click();

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }
}
