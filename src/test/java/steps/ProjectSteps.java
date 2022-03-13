package steps;

import baseEntities.BaseStep;
import models.Project;
import org.openqa.selenium.WebDriver;
import pages.AddProjectPage;

public class ProjectSteps extends BaseStep {

    private AddProjectPage addProjectPage;

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

    }

    public void deleteProject(Project project){

    }
}
