import data.StaticProvider;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners (Listener.class)

public class CalcDifferenceTest extends BaseTest {

    Calculator calc = new Calculator("CalcDifferenceTest");

    @Test (dataProvider = "dataForDiff", dataProviderClass = StaticProvider.class)
    public void dataProviderTest(int a, int b, int expectedResult){
        Assert.assertEquals(calc.dif(a,b), expectedResult);
    }

    private int attempt = 1;

    @Test (retryAnalyzer = Retry.class)
    public void flakyTest(){
        if(attempt == 7){
            Assert.assertEquals(calc.dif(14,5), 9);
        }
        else{
            attempt++;
            System.out.println("attempt once again");
            throw new NullPointerException();
        }
    }

    @Test
    public void listenerTest(){
        Assert.assertEquals(calc.dif(9,3),2);
    }
}
