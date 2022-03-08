package pages;

import baseEntities.BasePage;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private static String ENDPOINT = "/auth/login";
    // Описание элементов страницы
    private By PAGE_OPENED_IDENTIFIER = By.className("logo-loginpage");

    @FindBy (id = "name")
    public WebElement emailField;

    @FindBy (id = "password")
    public WebElement passwordField;

    @FindBy (id = "button_primary")
    public WebElement loginButton;

    // Конструктор страницы
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    public boolean isPageOpened() {
        return super.isPageOpened(PAGE_OPENED_IDENTIFIER);
    }

    // Реализаци базовых методов
    public void login(String username, String password) {
     emailField.sendKeys(ReadProperties.getUsername());
    passwordField.sendKeys(ReadProperties.getPassword());
    loginButton.click();
    }


}
