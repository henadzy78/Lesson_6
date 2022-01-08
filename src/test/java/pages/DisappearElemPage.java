package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Waits;

public class DisappearElemPage extends BasePage {

    //Описание элементов
    private By PAGE_OPENED_IDENTIFIER = By.xpath("//*[. = 'Disappearing Elements']");
    private By disappearElem_Selector = By.xpath("//*[contains(text(), 'Disappearing El')]");
    private By gallery_Selector = By.cssSelector("a[href='/gallery/']");

    //Конструктор страницы
    public DisappearElemPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {return super.isPageOpened(PAGE_OPENED_IDENTIFIER);}

    //Реализация геттеров
    public WebElement getDisappearElemButton() {return driver.findElement(disappearElem_Selector);}
    public WebElement getGalleryButton() {return driver.findElement(gallery_Selector);}

    //Реализация базовых методов
    public void openDisappearElemPage() {getDisappearElemButton().click();}

    public void visibilityGalleryTest(){
        Waits waits = new Waits(driver);

        int numberOfElements = driver.findElements(gallery_Selector).size();
        int pageReload = 6;

        for(int i = 0; i < pageReload; i++){
            if(numberOfElements == 5){
                Assert.assertTrue(waits.waitForVisibility(gallery_Selector).isDisplayed());
            }else{
                driver.navigate().refresh();
            }
        }
    }
}
//Тест проходит, но этот метод как-то неправильно работает. Пока не удается рабочий сделать....

