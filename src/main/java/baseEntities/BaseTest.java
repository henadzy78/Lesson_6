package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    String url = "https://qa1505.testrail.io";
    String username = "atrostyanko+0401@gmail.com";
    String password = "QqtRK9elseEfAk6ilYcJ";

    @BeforeSuite
    public void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        // or for fine-tuning:
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );
        org.apache.log4j.BasicConfigurator.configure();

        //Настройка Selenide
        Configuration.baseUrl = url;
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.fastSetValue = true;
        //Configuration.timeout = 8000;
        //Configuration.headless = false;
        //Configuration.assertionMode = SOFT;
    }

}
