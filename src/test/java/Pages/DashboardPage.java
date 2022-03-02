package Pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage{

    private By PAGE_OPENED_IDENTIFIER = By.id("navigation-dashboard");

    private By addProject_Selector = By.id("sidebar-projects-add");

    public DashboardPage(WebDriver driver) {super(driver);}

    public boolean isPageOpened() {
        return super.isPageOpened(PAGE_OPENED_IDENTIFIER);
    }

    public WebElement getAddProjectButton(){ return driver.findElement(addProject_Selector);}

    public void startProject(){getAddProjectButton().click();}
}
