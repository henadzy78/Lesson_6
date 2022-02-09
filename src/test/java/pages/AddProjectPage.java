package pages;

import com.codeborne.selenide.SelenideElement;
import models.Project;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddProjectPage {

    private final By name_Project_Selector = By.id("name");
    private final By announcement_Selector = By.id("announcement");
    private final By isShowAnnouncement_Selector = By.id("show_announcement");
    private final By typeOfProject_Selector = By.id("suite_mode_single_baseline");
    private final By isCompletedSelector = By.id("is_completed");                           ///!!!!
    private final By addProject_Button_Selector = By.id("accept");

    public SelenideElement getNameProjectField(){return $(name_Project_Selector);}
    public SelenideElement getAnnouncementField(){return $(announcement_Selector);}
    public SelenideElement getIsShowAnnouncementField(){return $(isShowAnnouncement_Selector);}
    public SelenideElement getTypeOfProjectField(){return $(typeOfProject_Selector);}
    public SelenideElement getIsCompletedField(){return $(isCompletedSelector);}
    public SelenideElement getAddProjectButton(){return $(addProject_Button_Selector);}

    public void addProject(Project project){
        getNameProjectField().val(project.getName());
        getAnnouncementField().val(project.getAnnouncement());
        getIsShowAnnouncementField().click();
        getTypeOfProjectField().val(project.getTypeOfProject());
        getAddProjectButton().click();
    }
}







