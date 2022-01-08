package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropdownPage extends BasePage {

    //Описание элементов страницы
    private By PAGE_OPENED_IDENTIFIER = By.xpath("//*[. = 'Dropdown List']");
    private By dropDown_Selector = By.xpath("//*[contains(text(), 'Dropd')]");
    private By dropDownField_Selector = By.cssSelector("select[id='dropdown']");
    private By optionField_Selector = By.xpath("//*[. = 'Option 2']");

    //Конструктор страницы
    public DropdownPage (WebDriver driver) {super(driver);}

    public boolean isPageOpened() {return super.isPageOpened(PAGE_OPENED_IDENTIFIER);}

    //Реализация геттеров элементов
    public WebElement getDropDownButton() {return driver.findElement(dropDown_Selector);}
    public WebElement getDropDownField() {return driver.findElement(dropDownField_Selector);}
    public WebElement getOptionField() {return driver.findElement(optionField_Selector);}

    //Реализация базовых методов
    public void optionSelection() {
        getDropDownButton().click();
        getDropDownField().click();
        getOptionField().click();
    }
}
