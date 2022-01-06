package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    //Описание элементов страницы
    private By PAGE_OPENED_IDENTIFIER = By.className("heading");

    WebDriver driver;

    //Конструктор страницы
    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    //Реализация геттеров элементов


}
