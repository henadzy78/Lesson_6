package Pages;

import baseEntities.BasePage;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AddProjectPage extends BasePage {

    //Описание элементов страницы
    private By PAGE_OPENED_IDENTIFIER = By.id("sidebar-projects-add");

    private By addProject_Selector = By.id("sidebar-projects-add");
    private By name_Selector = By.id("name");
    private By announcement_Selector = By.id("announcement");
    private By radiobutton_Selector = By.id("suite_mode_multi");
    private By addProjectButton_Selector = By.id("accept");

    //Конструктор страницы
    public AddProjectPage(WebDriver driver) {
        super(driver);
    }
    public boolean isPageOpened() {
        return super.isPageOpened(PAGE_OPENED_IDENTIFIER);
    }

    //Реализация геттеров элементов
    public WebElement getAddProjectField(){return driver.findElement(addProject_Selector);}
    public WebElement getNameField(){return driver.findElement(name_Selector);}
    public WebElement getAnnouncementField(){return driver.findElement(announcement_Selector);}
    public WebElement getRadiobuttonField(){return driver.findElement(radiobutton_Selector);}
    public WebElement getAddProjectButton(){return driver.findElement(addProjectButton_Selector);}

    //Реализация базовых методов
    public void startAddProject(){getAddProjectField().click();}
    public void createProject(String name, String announcement){
        getNameField().sendKeys(ReadProperties.getName());
        getAnnouncementField().sendKeys(ReadProperties.getAnnouncement());
        getRadiobuttonField().click();
        getAddProjectButton().click();
    }

}
