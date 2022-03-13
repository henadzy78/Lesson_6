package tests;

import baseEntities.BaseTest;
import core.ReadProperties;
import enums.ProjectType;
import models.Project;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainProjectsPage;
import steps.LoginSteps;
import utils.Randomization;

public class AddProjectTest extends BaseTest {
    Project project;
    Project currentProject;
    Project updateProject;
    User user;

    @Test
    public void addProject(){
        user = new User.BuilderUser.Builder()
                .withEmail(ReadProperties.getUsername())
                .withPassword(ReadProperties.getPassword())
                .build();
        project = new Project.BuilderProject.Builder()
                .withName(Randomization.getRandomString(6))
                .withAnnouncement(Randomization.getRandomString(12))
                .withIsShowAnnouncement(true)
                .withTypeOfProject(ProjectType.SINGLE)
                .build();
        loginSteps.lo
        driver.get("https://1511.testrail.io/index.php?/admin/projects/add/1");
        projectSteps.addProject(project);
        MainProjectsPage mainProjectsPage = new MainProjectsPage(driver);
        Assert.assertTrue(mainProjectsPage.getSuccessfullyMessageAboutAddingProject().isDisplayed());
    }
}
