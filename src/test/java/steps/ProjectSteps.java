package steps;

import baseEntities.BaseStep;
import models.Project;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.AddProjectPage;
import pages.DeletePage;
import pages.MainProjectsPage;

public class ProjectSteps extends BaseStep {

    private AddProjectPage addProjectPage;
    private MainProjectsPage mainProjectsPage;
    private DeletePage confirmationDeletePage;

    public ProjectSteps(WebDriver driver) {
        super(driver);
    }

    public void addProject(Project project){
        addProjectPage = new AddProjectPage(driver);
        addProjectPage.getNameField().sendKeys(project.getName());
        addProjectPage.getAnnouncementField().sendKeys(project.getAnnouncement());
        addProjectPage.getCheckboxShowAnnouncement().click();
        addProjectPage.setType(project.getTypeOfProject());
        addProjectPage.getAddProjectButton().click();
    }

    public void updateProject(Project currentProject, Project newProject){
        mainProjectsPage = new MainProjectsPage(driver);
        mainProjectsPage.findAnyProjectInProject(currentProject.getName()).click();
        addProjectPage = new AddProjectPage(driver);
        addProjectPage.getNameField().clear();
        addProjectPage.getNameField().sendKeys(newProject.getName());
        addProjectPage.getAnnouncementField().sendKeys(newProject.getAnnouncement());
        addProjectPage.getCheckboxShowAnnouncement().click();
        addProjectPage.setType(newProject.getTypeOfProject());
        addProjectPage.getSaveProjectButton().click();
        mainProjectsPage = new MainProjectsPage(driver);
    }

    public void deleteProject(Project project){
        mainProjectsPage = new MainProjectsPage(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",
                mainProjectsPage.findAnyProjectInDashboard(project.getName()));
        mainProjectsPage.getDeleteButtonAnyProject(project.getName()).click();
        confirmationDeletePage = new DeletePage(driver);
        confirmationDeletePage.getCheckBoxForConfirmationDelete().click();
        confirmationDeletePage.getButtonOk().click();
    }
}
