package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainProjectsPage extends BasePage {

    private static String ENDPOINT = "/admin/projects/overview";
    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//a[@onclick='this.blur(); App.Admin.addExampleProject(); return false;']");
    private By successfullyAddProjectMessage_Selector = By.xpath("//*[text() = 'Successfully added the new project.']");
    private By addProjectButton_Selector = By.xpath("//*[contains(text(),'Add Project')]");



    public MainProjectsPage(WebDriver driver) {
        super(driver);
    }

    public MainProjectsPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    public WebElement getSuccessfullyMessageAboutAddingProject() {
        return driver.findElement(successfullyAddProjectMessage_Selector);}

    public WebElement findAnyProjectInDashboard(String nameProject) {
        return driver.findElement(By.xpath(String.format("//a[contains(@href,'index.php?/admin/projects/') and text()='%s']", nameProject)));
    }
}
