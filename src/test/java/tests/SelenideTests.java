package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import tests.pages.LoginPage;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

//@Listeners({SoftAsserts.class})
public class SelenideTests {
    String url = "https://qa1505.testrail.io";
    String username = "atrostyanko+0401@gmail.com";
    String password = "QqtRK9elseEfAk6ilYcJ";

    @BeforeSuite
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        // or for fine-tuning:
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );
    }

    @Test
    public void userCanLogin() {
        //Настройка slf4j
        org.apache.log4j.BasicConfigurator.configure();

        //Настройка Selenide
        Configuration.baseUrl = url;
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;
        Configuration.headless = false;
        //Configuration.assertionMode = SOFT;

        // Начинаем писать тест
        open("/");

        $(By.id("name")).setValue(username);
        $("#password").val(password);
        $("#button_primary").click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));

        open("/index.php?/admin/projects/overview");
        $$(By.className("hoverSensitive"))
                .shouldHaveSize(629)
                .find(text("Henadzy_Project"))
                .find(By.tagName("a"))
                .click();

        $(By.id("announcement"))
                .should(exist)
                .shouldBe(visible)
                .shouldHave(exactText("OK!!!"));
    }

    @Test
    public void userCanLogin1() {

        // Начинаем писать тест
        open("/");

        LoginPage loginPage = new LoginPage();
        loginPage.getUsernameField().setValue(username);

        $("#password").val(password);
        $("#button_primary").click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));

        open("/index.php?/admin/projects/overview");
        $$(By.className("hoverSensitive"))
                .shouldHaveSize(388)
                .find(text("123456"))
                .find(By.tagName("a"))
                .click();

        $("#announcement")
                .should(exist)
                .shouldBe(visible)
                .shouldHave(exactText("This is the description for the project1"));
    }

    /*
    @Test
    public void test1() {
        //Настройка slf4j
        org.apache.log4j.BasicConfigurator.configure();

        //Настройка Selenide
        Configuration.baseUrl = url;
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;
        Configuration.headless = false;
        //Configuration.assertionMode = SOFT;

        // Начинаем писать тест
        open("/");

        $(By.id("name")).setValue(username);
        $("#password").val(password);
        $("#button_primary").click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));

        $$(".chart-legend-name")
                .filter(visible)
                .shouldHave(CollectionCondition.texts("aaa"));
    }
     */
    @Test
    public void test2() throws FileNotFoundException {
        //Настройка slf4j
        org.apache.log4j.BasicConfigurator.configure();

        //Настройка Selenide
        Configuration.baseUrl = url;
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;
        Configuration.headless = false;
        //Configuration.assertionMode = SOFT;

        // Начинаем писать тест
        open("/");

        $(By.id("name")).setValue(username);
        $("#password").val(password);
        $("#button_primary").click();

        $(byText("Henadzy_Project")).shouldBe(visible);
        $(withText("dzy")).shouldBe(visible);

        SelenideElement parent = $(byText("Henadzy_Project")).parent();
        System.out.println(parent.getTagName());

        $(byText("Henadzy_Project")).innerText();
        $(byText("Henadzy_Project")).innerHtml();
        $(byText("Henadzy_Project")).scrollTo();
        $(byText("Henadzy_Project")).closest("tr");
        $(byText("Henadzy_Project")).find(By.xpath(""));
        $(byText("Henadzy_Project")).doubleClick();
        $(byText("Henadzy_Project")).contextClick();
        $(byText("Henadzy_Project")).hover();

        $(byText("Henadzy_Project")).uploadFile(new File(""));
        $(byText("Henadzy_Project")).download();

        sleep(3000);


    }
}
