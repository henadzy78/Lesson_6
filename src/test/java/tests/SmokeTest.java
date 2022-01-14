package tests;


//import Pages.*;
import pages.DashboardPage;
import baseEntities.BaseTest;
import core.ReadProperties;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void loginTest() {
        pages.LoginPage loginPage = new pages.LoginPage(driver);

        loginPage.emailField.sendKeys(ReadProperties.getUsername());
        loginPage.passwordField.sendKeys(ReadProperties.getPassword());
        loginPage.loginButton.click();

           DashboardPage dashboardPage = new DashboardPage(driver);
    }

}
