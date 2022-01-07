package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import pages.DropdownPage;
import pages.InputsPage;

public class SmokeTest extends BaseTest {

    @Test
    public void inputNumberTest() {
        InputsPage inputsPage = new InputsPage(driver);

        inputsPage.openInputsPage();
        inputsPage.inputNumber();
    }

    @Test (priority = 1)
    public void dropDownTest() {
        DropdownPage dropdownPage = new DropdownPage(driver);

        dropdownPage.openDropDownPage();
        dropdownPage.optionSelection();
    }
}
