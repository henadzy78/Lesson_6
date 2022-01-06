import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcDivisionTest extends BaseTest {

    Calculator calc = new Calculator("CalcDivisionTest");

    @Test (expectedExceptions = ArithmeticException.class)
    public void testException(){
        Assert.assertEquals(calc.division(8,0),0);
    }

    @Test (timeOut = 1000)
    public void timeOutTest() throws InterruptedException {
        Assert.assertEquals(calc.division(8,2),4);
        Thread.sleep(1015);
    }

    @Test (invocationCount = 4, invocationTimeOut = 1000)
    public void invocationCountTest() throws InterruptedException {
        Thread.sleep(200);
        Assert.assertEquals(calc.division(10,5),2);
    }

    @Test (invocationCount = 8, threadPoolSize = 4)
    public void threadPoolSizeTest() throws InterruptedException {
        Assert.assertEquals(calc.division(14,2),7);
    }
}
