package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DisappearElemPage;
import pages.DropdownPage;
import pages.InputsPage;

public class SmokeTest extends BaseTest {

    @Test
    public void inputsTest() {
        InputsPage inputsPage = new InputsPage(driver);

        inputsPage.isPageOpened();
        inputsPage.startInputsFunction();

        String expectedInputs = "15";
        WebElement resultInputs = driver.findElement(By.cssSelector("input[type='number']"));
        String actualInputs = resultInputs.getAttribute("value");
        Assert.assertEquals(actualInputs, expectedInputs, "Values are not equal");
    }

    @Test (priority = 1)
    public void dropDownTest() {
        DropdownPage dropdownPage = new DropdownPage(driver);

        dropdownPage.isPageOpened();
        dropdownPage.optionSelection();

        String expectedOption = "Option 2";
        WebElement resultOption = driver.findElement(By.xpath("//*[. = 'Option 2']"));
        String actualOption = resultOption.getAttribute("innerText");
        Assert.assertEquals(actualOption, expectedOption, "Values are not equal");
    }

    @Test (priority = 2)
    public void disappearElemTest(){
        DisappearElemPage dep = new DisappearElemPage(driver);

        dep.isPageOpened();
        dep.openDisappearElemPage();
        dep.visibilityGalleryTest();
    }
}
