import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcSumTest extends BaseTest {

    Calculator calc = new Calculator("CalcSumTest");

    @Test (enabled = true, priority = 2)
    public void testSum (){
        Assert.assertEquals(calc.sum(3,4),7);
    }

    @Test (description = "Test Sum", priority = 2)
    public void testSum1 (){
        Assert.assertEquals(calc.sum(6,9),15);
    }

    @Test (priority = 1)
    public void testSum2 (){
        Assert.assertEquals(calc.sum(2,6),8);
    }




}
