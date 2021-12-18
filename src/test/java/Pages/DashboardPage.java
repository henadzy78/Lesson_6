package Pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {

    //Описание элементов страницы
    private By PAGE_OPENED_IDENTIFIER = By.id("navigation-dashboard");

    private By project_Selectors = By.xpath("//*[text() = 'df']");

    //Конструктор страницы
    public DashboardPage(WebDriver driver) { super(driver);}

    public boolean isPageOpened() {
        return super.isPageOpened(PAGE_OPENED_IDENTIFIER);
    }

    // Реализация геттеров элементов
    public WebElement getProjectField(){
        return driver.findElement(project_Selectors);
    }
    //Реализация базовых методов
    public void startProject(){
        getProjectField().click();
    }

}
