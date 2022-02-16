package tests.gui;

import baseEntity.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.pages.DashboardPage;
import tests.pages.LoginPage;

public class SmokeTest extends BaseTest {
    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);

        DashboardPage dashboardPage = new DashboardPage(driver, false);
        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }
}
