package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW_Laminat {
    static String URL = "https://masterskayapola.ru/kalkulyator/laminata.html";

    @Test
    public void laminatValidationTest() throws InterruptedException {

        String length = "8";
        String width = "4";
        String lengthLam = "1500";
        String widthLam = "200";
        String pack = "15";
        String price = "700";
        String rows = "400";
        String indent = "15";

        String expectedSquare = "31.64 м2.";
        String expectedNumber = "110 шт.";
        String expectedNumbPack = "8 шт.";
        String expectedPrice = "25200 руб.";
        String expectedLeftovers = "10 шт.";
        String expectedSegments = "10 шт.";

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        //1. Открыть браузер и перейти на тестируемую страницу
        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);

        //2.Ввести Длина помещения
        WebElement lengthRoom = driver.findElement(By.name("calc_roomwidth"));
        lengthRoom.sendKeys(Keys.DELETE, length);

        //3. Ввести Ширина помещения
        WebElement widthRoom = driver.findElement(By.name("calc_roomheight"));
        widthRoom.sendKeys(Keys.DELETE, width);

        //4. Ввести Длина ламината
        WebElement lengthLm = driver.findElement(By.name("calc_lamwidth"));
        lengthLm.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        lengthLm.sendKeys(lengthLam);

        //5. Ввести Ширина ламината
        WebElement widthLm = driver.findElement(By.name("calc_lamheight"));
        widthLm.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        widthLm.sendKeys(widthLam);

        //6. Ввести В упаковке
        WebElement packLm = driver.findElement(By.name("calc_inpack"));
        packLm.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        packLm.sendKeys(pack);

        //7. Ввести Цена
        WebElement priceLm = driver.findElement(By.name("calc_price"));
        priceLm.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        priceLm.sendKeys(price);

        //8. Выбрать направление укладки
        WebElement direction = driver.findElement(By.name("calc_direct"));
        Select directionDropDown = new Select(direction);
        directionDropDown.selectByValue("toh");

        //9. Выбрать Смещение рядов
        WebElement rowsLm = driver.findElement(By.name("calc_bias"));
        rowsLm.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        rowsLm.sendKeys(rows);

        //10. Выбрать Отступ от стены
        WebElement indentLm = driver.findElement(By.name("calc_walldist"));
        indentLm.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        indentLm.sendKeys(indent);

        //11. Нажать кнопку Расчитать
        WebElement calculate = driver.findElement(By.cssSelector("input[type = 'button']"));
        calculate.click();

        //12. Проверить результаты
        WebElement resultSquare = driver.findElement(By.id("s_lam"));
        String actualSquare = resultSquare.getAttribute("innerText");

        WebElement resultNumber = driver.findElement(By.id("l_count"));
        String actualNumber = resultNumber.getAttribute("innerText");

        WebElement resultNumbPack = driver.findElement(By.id("l_packs"));
        String actualNumbPack = resultNumbPack.getAttribute("innerText");

        WebElement resultPrice = driver.findElement(By.id("l_price"));
        String actualPrice = resultPrice.getAttribute("innerText");

        WebElement resultLeftovers = driver.findElement(By.id("l_over"));
        String actualLeftovers = resultLeftovers.getAttribute("innerText");

        WebElement resultSegments = driver.findElement(By.id("l_trash"));
        String actualSegments = resultSegments.getAttribute("innerText");


        Assert.assertEquals(actualSquare, expectedSquare, "Данные различны");
        Assert.assertEquals(actualNumber, expectedNumber,"Данные различны");
        Assert.assertEquals(actualNumbPack, expectedNumbPack, "Данные различны");
        Assert.assertEquals(actualPrice, expectedPrice,"Данные различны");
        Assert.assertEquals(actualLeftovers, expectedLeftovers,"Данные различны");
        Assert.assertEquals(actualSegments,expectedSegments,"Данные различны");

        Thread.sleep(5000);

        driver.quit();

    }

}
