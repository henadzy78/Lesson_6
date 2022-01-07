package baseEntities;

import core.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--silent");
        chromeOptions.setHeadless(ReadProperties.getHeadless());

        driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }




}
