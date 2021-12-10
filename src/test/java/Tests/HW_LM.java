package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW_LM {
    static String URL = "https://calc.by/building-calculators/laminate.html";

    @Test
    public void LmTest(){
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
        //inputLength.sendKeys(Keys.BACK_SPACE);
        //inputLength.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        inputLength.clear();
        inputLength.sendKeys(length);





        //driver.quit();




    }
}
