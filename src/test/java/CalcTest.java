import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTest extends BaseTest {

    Calculator calc = new Calculator("CalcTest");

    //@Test (invocationCount = 3, invocationTimeOut = 1000)
    @Test (invocationCount = 6, threadPoolSize = 3)
    public void invocationTest() throws InterruptedException {
        Thread.sleep(200);
        Assert.assertEquals(calc.sum(2,3),5);

    }



    @Test (enabled = false)
    public void testSum(){
        System.out.println("CalcTest -> testSum");
    }
}
