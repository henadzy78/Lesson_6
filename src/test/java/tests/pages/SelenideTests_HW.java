package tests.pages;

import baseEntities.BaseTest;
import models.Milestone;
import models.Project;
import models.TestCase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.AddMilestonePage;
import pages.AddProjectPage;
import pages.AddTestCasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTests_HW extends BaseTest {
    Project addProject;
    Milestone addMilestone;
    Milestone updateMilestone;
    TestCase addTestCase;
    TestCase updateTestCase;

    @Test
    public void loginTest() {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.getUsernameField().setValue(username);

        loginPage.getPasswordField().setValue(password);
        loginPage.getLoginButton().click();

        $(".page_title").shouldBe(visible)
                .shouldHave(text("All Projects"));
    }

    @Test(dependsOnMethods = "loginTest")
    public void addProjectTest() {
        open("/index.php?/admin/projects/add/1");
        addProject = new Project();
        addProject.setName("Selenide_HW_1");
        addProject.setAnnouncement("Selenide_HW_1_Announcement");

        AddProjectPage addProjectPage = new AddProjectPage();
        addProjectPage.addProject(addProject);
        $(By.xpath("//div[@class='message message-success']"))
                .shouldBe(visible)
                .shouldHave(text("Successfully added the new project."));
    }

    @Test(dependsOnMethods = "addProjectTest")
    public void addMilestoneTest() {
        open("/index.php?/dashboard");
        $(By.xpath("//*[text() = 'Selenide_HW_1']")).click();
        $("#sidebar-milestones-add").click();

        addMilestone = new Milestone();
        addMilestone.setName("Selenide_HW_1_Milestone");
        addMilestone.setReferences("Selenide_HW_1_References");
        addMilestone.setDescription("Selenide_HW_1_Description");

        AddMilestonePage addMilestonePage = new AddMilestonePage();
        addMilestonePage.addMilestone(addMilestone);

        $(By.xpath("//div[@class = 'message message-success']"))
                .shouldBe(visible)
                .shouldHave(text("Successfully added the new milestone."));
    }

    @Test(dependsOnMethods = "addMilestoneTest")
    public void updateMilestoneTest() {
        $(byText(addMilestone.getName())).click();
        $(By.xpath("//*[text() = 'Edit']")).click();

        updateMilestone = new Milestone();
        updateMilestone.setName("Update_Selenide_HW_1_Milestone");
        updateMilestone.setReferences("Update_Selenide_HW_1_References");
        updateMilestone.setDescription("Update_Selenide_HW_1_Description");

        AddMilestonePage updateMilestonePage = new AddMilestonePage();
        updateMilestonePage.updateMilestone(updateMilestone);

        $(By.xpath("//div[@class = 'message message-success']"))
                .shouldBe(visible)
                .shouldHave(text("Successfully updated the milestone."));
    }

    @Test(dependsOnMethods = "updateMilestoneTest")
    public void deleteMilestoneTest() {
        $(byText(updateMilestone.getName())).click();
        $(By.xpath("//*[text() = 'Edit']")).click();
        $(By.xpath("//span[@class='button button-negative button-delete']")).click();
        $(By.xpath("//*[text() = 'Yes, delete this milestone (cannot be undone)']")).click();
        $(By.xpath("//div[@id='deleteDialog']//a[@class='button button-ok button-left" +
                " button-positive dialog-action-default']"))
                .click();
        $(By.xpath("//div[@class='message message-success']"))
                .shouldBe(visible)
                .shouldHave(text("Successfully deleted the milestone."));
    }

    @Test(dependsOnMethods = "deleteMilestoneTest")
    public void addTestCaseTest(){
        open("/index.php?/dashboard");
        $(byText(addProject.getName())).click();
        $("#navigation-suites").click();
        $(By.xpath("//*[. = 'Add Test Case']")).click();

        addTestCase = new TestCase();
        addTestCase.setTitle("Selenide_HW_1_Title");
        addTestCase.setPreconditions("Selenide_HW_1_Preconditions");
        addTestCase.setSteps("Selenide_HW_1_Steps");

        AddTestCasePage addTestCasePage = new AddTestCasePage();
        addTestCasePage.addTestCase(addTestCase);

        $(By.xpath("//div[@class='message message-success']"))
                .shouldBe(visible)
                .shouldHave(text("Successfully added the new test case. "));
    }

    @Test(dependsOnMethods = "addTestCaseTest")
    public void updateTestCaseTest(){
        $(By.xpath("//span[@class='button-text']")).click();
        //$(byText("Edit")).click();

        updateTestCase = new TestCase();
        updateTestCase.setTitle("Update_Selenide_HW_1_Title");
        updateTestCase.setPreconditions("Update_Selenide_HW_1_Preconditions");
        updateTestCase.setSteps("Update_Selenide_HW_1_Steps");

        AddTestCasePage updateTestCasePage = new AddTestCasePage();
        updateTestCasePage.updateTestCase(updateTestCase);

        $(By.xpath("//div[@id='content-inner']//div[@class='message message-success']"))
                .shouldBe(visible)
                .shouldHave(text("Successfully updated the test case."));
    }

    @Test(dependsOnMethods = "updateTestCaseTest")
    public void deleteTestCase(){
        $(By.xpath("//span[@class='button-text']")).click();
        $(By.xpath("//*[text() = 'Delete this test case']")).click();
        $(By.xpath("//*[@class='button button-left button-ok button-positive dialog-action-default' " +
                "and @onclick='this.blur(); App.Cases.confirmDeletion(false, false); return false;']"))
                .click();
        $(By.xpath("//div[@class='message message-success']"))
                .shouldBe(visible)
                .shouldHave(text("Successfully flagged the test case as deleted."));
    }
}











