package tests;

import baseEntities.BaseTest;
import core.ReadProperties;
import enums.ProjectType;
import models.Project;
import models.User;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainProjectsPage;
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
        loginSteps.loginGeneralUsers(user);
        driver.get("https://1511.testrail.io/index.php?/admin/projects/add/1");
        projectSteps.addProject(project);
        MainProjectsPage mainProjectsPage = new MainProjectsPage(driver);
        Assert.assertTrue(mainProjectsPage.getSuccessfullyMessageAboutAddingProject().isDisplayed());
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",
                mainProjectsPage.findAnyProjectInDashboard(project.getName()));
        Assert.assertTrue(waits.waitForVisibility(mainProjectsPage.findAnyProjectInDashboard(project.getName())),
                "Project not listed");
    }

    @Test(dependsOnMethods = "addProject")
    public void updateProject(){
        currentProject = project;
        updateProject = new Project.BuilderProject.Builder()
                .withName(Randomization.getRandomString(8))
                .withAnnouncement(Randomization.getRandomString(12))
                .withTypeOfProject(Randomization.getRandomType())
                .build();
        loginSteps.loginGeneralUsers(user);
        driver.get("https://1511.testrail.io/index.php?/admin/projects/overview");
        MainProjectsPage mainProjectsPage = new MainProjectsPage(driver);
        projectSteps.updateProject(currentProject, updateProject);
        Assert.assertTrue(mainProjectsPage.findAnyProjectInProject(updateProject.getName()).isDisplayed());
    }

    @Test(dependsOnMethods = "updateProject")
    public void deleteProject(){
        loginSteps.loginGeneralUsers(user);
        driver.get("https://1511.testrail.io/index.php?/admin/projects/overview");
        MainProjectsPage mainProjectsPage = new MainProjectsPage(driver);
        projectSteps.deleteProject(updateProject);
        Assert.assertTrue(mainProjectsPage.getSuccessfullyMessageAboutDeleteProject().isDisplayed());
    }
}
