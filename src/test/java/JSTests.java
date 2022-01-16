import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSTests extends BaseTest {

    @Test
    public void jsTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/jqueryui/menu#");

        WebElement webElement = driver.findElement(By.xpath("//*[. = 'Enabled']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", webElement);

        Thread.sleep(10000);
    }
}



