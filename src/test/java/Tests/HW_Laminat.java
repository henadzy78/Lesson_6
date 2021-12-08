package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HW_Laminat {
    static String URL = "https://masterskayapola.ru/kalkulyator/laminata.html";

    @Test
    public void laminatValidationTest() throws InterruptedException {

        String length = "8";
        String width = "4";
        String lengthLam = "1300";
        String widthLam = "192";
        String pack = "12";
        String price = "500";
        String rows = "300";
        String indent = "10";

        String expectedSquare = "31.76";
        String expectedNumber = "132";
        String expectedNumbPack = "11";
        String expectedPrice = "16473";
        String expectedLeftovers = "0";
        String expectedSegments = "6";

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        //1. Открыть браузер и перейти на тестируемую страницу
        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);

        //2.Ввести Длина помещения
        WebElement lengthRoom = driver.findElement(By.name("calc_roomwidth"));
        lengthRoom.sendKeys(Keys.DELETE, lengthLam);

        //3. Ввести Ширина помещения
        WebElement widthRoom = driver.findElement(By.name("calc_roomheight"));
        widthRoom.sendKeys("4");

        //4. Ввести Длина ламината
        WebElement lengthLm = driver.findElement(By.name("calc_lamwidth"));
        lengthLm.sendKeys("1300");

        //5. Ввести Ширина ламината
        WebElement widthLm = driver.findElement(By.name("calc_lamheight"));
        widthLm.sendKeys("192");

        //6. Ввести В упаковке
        WebElement packLm = driver.findElement(By.name("calc_inpack"));
        packLm.sendKeys("12");

        //7. Ввести Цена
        WebElement priceLm = driver.findElement(By.name("calc_price"));
        priceLm.sendKeys("500");

        //8. Выбрать направление укладки
        WebElement direction = driver.findElement(By.name("calc_direct"));
        Select directionDropDown = new Select(direction);
        directionDropDown.selectByValue("toh");

        //9. Выбрать Смещение рядов
        WebElement rowsLm = driver.findElement(By.name("calc_bias"));
        rowsLm.sendKeys("300");

        //10. Выбрать Отстут от стены
        WebElement indentLm = driver.findElement(By.name("calc_walldist"));
        indentLm.sendKeys("10");

        //11. Нажать кнопку Расчитать
        WebElement calculate = driver.findElement(By.cssSelector("input[type = 'button']"));
        calculate.click();








        Thread.sleep(10000);








        //driver.quit();








    }

}
