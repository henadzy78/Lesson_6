package pages;

import baseEntities.BasePage;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private static String ENDPOINT = "/auth/login";
    // Описание элементов страницы
    private static final By PAGE_OPENED_IDENTIFIER = By.id("button_primary");

    protected By email_Selector = By.id("name");
    protected By password_Selector = By.id("password");
    protected By login_Selector = By.id("button_primary");

    // Конструктор страницы
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    // Реализация гетерров элементов
    public WebElement getEmailField() {
        return driver.findElement(email_Selector);
    }

    public WebElement getPasswordField() {
        return driver.findElement(password_Selector);
    }

    public WebElement getLoginButton() {
        return driver.findElement(login_Selector);
    }

    // Реализаци базовых методов
    public void populateFields(String email, String psw) {
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(psw);
        getLoginButton().click();
    }

    public void login(String email, String psw){
        populateFields(email, psw);
        getLoginButton().click();
    }

    public void loginWithValue(User user){
        getEmailField().sendKeys(user.getEmail());
        getPasswordField().sendKeys(user.getPassword());
        getLoginButton().click();
    }

    public DashboardPage successLogin(String email, String psw){
        populateFields(email, psw);
        getLoginButton().click();
        return new DashboardPage(driver);
    }

    public LoginPage incorrectLogin(String email, String psw){
        populateFields(email, psw);
        getLoginButton().click();
        return new LoginPage(driver);
    }
}
