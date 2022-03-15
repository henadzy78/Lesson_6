package tests;

import baseEntities.BaseTest;
import core.ReadProperties;
import models.Project;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.Randomization;
import utils.Retry;

public class LoginTest extends BaseTest {
    Project addProject;
    Project updateProject;

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailField().sendKeys(ReadProperties.getUsername());
        loginPage.getPasswordField().sendKeys(ReadProperties.getPassword());
        loginPage.getLoginButton().click();

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }

    @Test(retryAnalyzer = Retry.class)
    public void flakyLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.getEmailField().sendKeys(ReadProperties.getUsername());
        loginPage.getPasswordField().sendKeys(ReadProperties.getPassword());
        loginPage.getLoginButton().click();

        DashboardPage dashboardPage = new DashboardPage(driver);
        driver.get("https://qa1504.testrail.io/index.php?/admin/overview");

        dashboardPage = new DashboardPage(driver, true);
        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }


    private void setupProjects() {
        addProject = new Project();
        addProject.setName(Randomization.getRandomString(8));
        addProject.setTypeOfProject(Randomization.getRandomType());

        updateProject = new Project();
        updateProject.setName(Randomization.getRandomString(8));
        updateProject.setTypeOfProject(Randomization.getRandomType());
    }

    @Test
    public void chainTest() {
        Assert.assertTrue(new LoginPage(driver).successLogin(ReadProperties.getUsername(),
                        ReadProperties.getPassword())
                .getAddProjectButton().isDisplayed());
    }
}
