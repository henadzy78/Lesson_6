import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcMultiplyTest {

    Calculator calc = new Calculator("CalcMultiplyTest");

    @Test (dependsOnMethods = "multiplyTest1")
    public void multiplyTest(){
        Assert.assertEquals(calc.multiplication(4, 3),12);
        Assert.fail();
    }

    @Test
    public void multiplyTest1(){
        Assert.assertEquals(calc.multiplication(5, 12),60);
    }

    @Test (dependsOnMethods = "multiplyTest", alwaysRun = true)
    public void multiplyTest2(){
        Assert.assertEquals(calc.multiplication(7, 9),63);
    }
}
