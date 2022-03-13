package pages;

import baseEntities.BasePage;
import enums.ProjectType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {
    private static String ENDPOINT = "/admin/projects/add/1";
    private static final By PAGE_OPENED_IDENTIFIER = By.id("accept");
    private static String typeRadioButtonSelector = "//*[@name = 'suite_mode' and @value='replace']";
    private By nameProject_Selector = By.id("name");
    private By announcement_Selector = By.id("announcement");
    private By showAnnouncement_Selector = By.id("show_announcement");
    private By addProjectButton_Selector = By.id("accept");
    private By successfullyAddedMessage_Selector = By.cssSelector(".message-success");

    public AddProjectPage(WebDriver driver) {super(driver);
    }

    public AddProjectPage(WebDriver driver, boolean openPageByUrl) {super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    public WebElement getNameField(){return driver.findElement(nameProject_Selector);}

    public WebElement getAnnouncementField(){ return driver.findElement(announcement_Selector);}

    public WebElement getCheckboxShowAnnouncement(){return driver.findElement(showAnnouncement_Selector);}

    public WebElement getAddProjectButton(){return driver.findElement(addProjectButton_Selector);}

    public WebElement findAnyProjectInProjects(String nameProject) {return driver.findElement(By.xpath("//a[contains(@href, 'index.php?/admin/projects/edit/') and text()='\" + nameProject + \"']"));}

    public WebElement getSuccessfullyMessage(){return driver.findElement(successfullyAddedMessage_Selector);
    }
    public void setType(ProjectType type) {
        driver.findElement(By.xpath(typeRadioButtonSelector.replace("replace", String.valueOf(type))));
    }
    public void createProject(String name, String announcement){
        driver.findElement(nameProject_Selector).sendKeys(name);
        driver.findElement(announcement_Selector).sendKeys(announcement);
        driver.findElement(showAnnouncement_Selector).click();
        driver.findElement(addProjectButton_Selector).click();
    }

    public void createProjectBase(String name, String announcement){
        getNameField().sendKeys(name);
        getAnnouncementField().sendKeys(announcement);
        getCheckboxShowAnnouncement().click();
        getAddProjectButton().click();
    }
}
