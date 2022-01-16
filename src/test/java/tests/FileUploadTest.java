package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Waits;

public class FileUploadTest extends BaseTest {

    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/upload");

        Waits waits = new Waits(driver);

        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        WebElement uploadFile = driver.findElement(By.id("file-submit"));
        //chooseFile.click();
        chooseFile.sendKeys("C:\\Users\\Геннадий\\Desktop\\Scania\\Пульт.jpg");
        uploadFile.click();

        //Thread.sleep(10000);

        WebElement header = waits.waitForVisibility(By.xpath("//h3[. = 'File Uploaded!']"));
        WebElement fileName = waits.waitForVisibility(By.id("uploaded-files"));

        Assert.assertTrue(header.isDisplayed()); //Наиболее корректная проверка. Элемент отображается!

        //Assert.assertTrue(header != null); //Как вариант можно. Эта проверка показывает ТОЛЬКО что элемент есть
                                             // в дом-модели, но не ОБЯЗАТЕЛЬНО отображается!
        Assert.assertEquals(fileName.getText(), "Пульт.jpg");
    }
}
