package utils;

import core.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class Waits {
    private WebDriver driver;
    private WebDriverWait wait;

    public Waits(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, ReadProperties.)
    }

    public void waitForVisibility() {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
