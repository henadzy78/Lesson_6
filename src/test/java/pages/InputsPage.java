package pages;

import baseEntities.BasePage;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputsPage extends BasePage {

    //Описание элементов страницы
    private By PAGE_OPENED_IDENTIFIER = By.xpath("//*[. = 'Inputs']");
    private By inputs_Selector = By.xpath("//*[contains(text(), 'Inp')]");
    private By number_Selector = By.cssSelector("input[type='number']");

    //Конструктор страницы
    public InputsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {return super.isPageOpened(PAGE_OPENED_IDENTIFIER);}

    //Реализация геттеров элементов
    public WebElement getInputsButton() {return driver.findElement(inputs_Selector);}
    public WebElement getInputsField() {return driver.findElement(number_Selector);};

    //Реализация базовых методов
    public void startInputsFunction() {
        getInputsButton().click();
        getInputsField().sendKeys(ReadProperties.getNumber());
    }
}

