package baseEntities;

import core.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Locale;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //switch (ReadProperties.getBrowserType().toLowerCase()) {
        //case "chrome":
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--silent");
        //chromeOptions.addArguments("--start-maximized"); // Как вариант можно
        chromeOptions.setHeadless(ReadProperties.getHeadless());

        driver = new ChromeDriver(chromeOptions);

        driver.get(ReadProperties.getUrl());
        //break;
        //case "opera":
        //WebDriverManager.getInstance(DriverManagerType.OPERA).setup();
        //driver = new OperaDriver();
        //break;
        //default:
        //System.out.println("This type of browser is not supported.");
        //break;

    driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}


