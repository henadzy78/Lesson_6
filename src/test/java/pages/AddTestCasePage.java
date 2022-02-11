package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import models.TestCase;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@Data
public class AddTestCasePage {
    private final By title_TestCase_Selector = By.id("title");
    private final By preconditions_Selector = By.id("custom_preconds_display");
    private final By steps_Selector = By.id("custom_steps_display");
    private final By add_TestCase_Button = By.id("accept");

    public SelenideElement getTitleTestCaseField(){return $(title_TestCase_Selector);}
    public SelenideElement getPreconditionsField(){return $(preconditions_Selector);}
    public SelenideElement getStepsField(){return $(steps_Selector);}
    public SelenideElement getAddTestCaseButton(){return $(add_TestCase_Button);}

    public void addTestCase(TestCase testCase){
        getTitleTestCaseField().val(testCase.getTitle());
        getPreconditionsField().val(testCase.getPreconditions());
        getStepsField().val(testCase.getSteps());
        getAddTestCaseButton().click();
    }
    public void updateTestCase(TestCase updateTestCase){
        getTitleTestCaseField().clear();
        getTitleTestCaseField().val(updateTestCase.getTitle());
        getPreconditionsField().clear();
        getPreconditionsField().val(updateTestCase.getPreconditions());
        getStepsField().clear();
        getStepsField().val(updateTestCase.getSteps());
        getAddTestCaseButton().click();
    }
}
