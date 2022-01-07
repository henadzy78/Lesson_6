package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    //Описание элементов страницы
    private By PAGE_OPENED_IDENTIFIER = By.className("heading");
    private By dropDown_Selector = By.xpath("//*[.='Dropdown']");

    private WebDriver driver;

    //Конструктор страницы
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened(){
        return super.isPageOpened(PAGE_OPENED_IDENTIFIER);
    }


    //Реализация геттеров элементов
    public WebElement getDropDownButton() {
        return driver.findElement(dropDown_Selector);
    }


}
