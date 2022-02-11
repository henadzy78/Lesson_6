package pages;

import com.codeborne.selenide.SelenideElement;
import models.Milestone;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddMilestonePage {

    private final By name_Milestone_Selector = By.id("name");
    private final By references_Selector = By.id("reference");
    private final By description_Selector = By.id("description_display");
    private final By  isCompleted_Selector = By.id("is_completed");
    private final By  add_Milestone_Button_Selector = By.id("accept");

    public SelenideElement getNameMilestoneField(){return $(name_Milestone_Selector);}
    public SelenideElement getReferencesField(){return $(references_Selector);}
    public SelenideElement getDescriptionField(){return $(description_Selector);}
    public SelenideElement getIsCompletedField(){return $(isCompleted_Selector);}
    public SelenideElement getAddMilestoneButton(){return $(add_Milestone_Button_Selector);}

    public void addMilestone(Milestone milestone){
        getNameMilestoneField().val(milestone.getName());
        getReferencesField().val(milestone.getReferences());
        getDescriptionField().val(milestone.getDescription());
        getAddMilestoneButton().click();
    }

    public void updateMilestone(Milestone updateMilestone){
        getNameMilestoneField().clear();
        getNameMilestoneField().val(updateMilestone.getName());
        getReferencesField().clear();
        getReferencesField().val(updateMilestone.getReferences());
        getDescriptionField().clear();
        getDescriptionField().val(updateMilestone.getDescription());
        getIsCompletedField().click();
        getAddMilestoneButton().click();
    }
}
