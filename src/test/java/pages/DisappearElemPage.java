package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DisappearElemPage extends BasePage {

    //Описание элементов
    private By PAGE_OPENED_IDENTIFIER = By.className("heading");
    private By disappearingElements_Selector = By.xpath("//*[contains(text(), 'Disappearing El')]");

    //Конструктор страницы
    public DisappearElemPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {return super.isPageOpened(PAGE_OPENED_IDENTIFIER);}

    //Реализация геттеров
    public WebElement getDisappearingElementsButton() {return driver.findElement(disappearingElements_Selector);}

    //Реализация базовых методов
    public void openDisappearingElementsPage() {getDisappearingElementsButton().click();}
}
