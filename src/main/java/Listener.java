import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener{

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("=========");
        System.out.println("Screenshot has been captured");
        System.out.println("=========");
    }

}
