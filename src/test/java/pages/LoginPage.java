package pages;

import baseEntities.BasePage;
import core.ReadProperties;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private static String ENDPOINT = "/auth/login";
    // Описание элементов страницы
    private static final By PAGE_OPENED_IDENTIFIER = By.id("button_primary");

    private By email_Selector = By.id("name");
    private By password_Selector = By.id("password");
    private By login_Selector = By.id("button_primary");

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
    public void login(User user) {
        getEmailField().sendKeys(user.getEmail());
        getPasswordField().sendKeys(user.getPassword());
        getLoginButton().click();
    }
}
