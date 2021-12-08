package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW {
    static String URL = "https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx";

    @Test
    public void kermiTest(){

        String widthValue = "4";
        String lengthValue = "6";
        String heatLossesValue = "40";

        String expectedFCP = "42";
        String expectedSFCP = "2";

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        //1. Открыть браузер и перейти на тестируемую страницу
        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);

        //2. Ввести ширину
        WebElement width = driver.findElement(By.id("el_f_width"));
        width.sendKeys(widthValue);

        //3. Ввести длину
        WebElement length = driver.findElement(By.id("el_f_lenght"));
        length.sendKeys(lengthValue);

        //4. Выбрать помещение
        WebElement room = driver.findElement(By.id("room_type"));
        Select roomDropDown = new Select(room);

        roomDropDown.selectByValue("2");

        //5. Выбрать обогрев
        WebElement heat = driver.findElement(By.id("heating_type"));
        Select heatDropDown = new Select(heat);

        heatDropDown.selectByValue("2");

        //6. Ввести теплопотери
        WebElement heatLosses = driver.findElement(By.id("el_f_losses"));
        heatLosses.sendKeys(heatLossesValue);

        //7. Нажать на кнопку "рассчитать"
        WebElement calculate = driver.findElement(By.cssSelector("input[type = 'button']"));
        calculate.click();

        //8. Проверить результаты
        WebElement resultFCP = driver.findElement(By.id("floor_cable_power"));
        String actualFCP = resultFCP.getAttribute("value");
        WebElement resultSFCP = driver.findElement(By.id("spec_floor_cable_power"));
        String actualSFCP = resultSFCP.getAttribute("value");

        Assert.assertEquals(actualFCP, expectedFCP, "Данные различные");
        Assert.assertEquals(actualSFCP, expectedSFCP, "Данные различные");


        driver.quit();



    }
}
