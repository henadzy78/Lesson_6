package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW_LM {
    static String URL = "https://calc.by/building-calculators/laminate.html";

    @Test
    public void LmTest() throws InterruptedException {
        String length = "500";
        String width = "400";
        String lengthLm = "2000";
        String widthLm = "200";

        String expectedNumbBoard = "53";
        String expectedNumbPack = "7";

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        //1. Открыть браузер и перейти на тестируемую страницу
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(URL);

        //2. Ввести Длина комнаты
        WebElement inputLength = driver.findElement(By.id("ln_room_id"));
        inputLength.clear();
        inputLength.sendKeys(length);

        //3. Ввести Ширина комнаты
        WebElement inputWidth = driver.findElement(By.id("wd_room_id"));
        inputWidth.clear();
        inputWidth.sendKeys(width);

        //4. Ввести Длина панели ламината
        WebElement inputLengthLm = driver.findElement(By.id("ln_lam_id"));
        inputLengthLm.clear();
        inputLengthLm.sendKeys(lengthLm);

        //5. Ввести Ширина панели ламината
        WebElement inputWidthLm = driver.findElement(By.id("wd_lam_id"));
        inputWidthLm.clear();
        inputWidthLm.sendKeys(widthLm);

        //6. Ввести Способ укладки ламината
        WebElement stylingMethod = driver.findElement(By.id("laying_method_laminate"));
        Select stylingDropDown = new Select(stylingMethod);
        stylingDropDown.selectByValue("2");

        //7. Выбрать Направление укладки ламината
        WebElement layingDirection = driver.findElement(By.id("direction-laminate-id1"));
        layingDirection.click();

        //8. Нажать кнопку Рассчитать
        WebElement calculate = driver.findElement(By.className("calc-btn"));
        calculate.click();

        //9. Проверить результаты
        WebElement resultNumbBoard = driver.findElement(By.cssSelector("span[style='padding:5px 0;font-size:22px; color:#C80303; font-weight:bold;']"));
        String actualNumbBoard = resultNumbBoard.getAttribute("innerText");

        WebElement resultNumbPack = driver.findElement(By.cssSelector("span[style='padding:5px 0;font-size:18px; color:#0E8C19; font-weight:bold;']"));
        String actualNumbPack = resultNumbPack.getAttribute("innerText");

        Assert.assertEquals(actualNumbBoard, expectedNumbBoard,"Данные различны");
        Assert.assertEquals(actualNumbPack,expectedNumbPack,"Данные различны");


        Thread.sleep(10000);

        driver.quit();


    }
}
