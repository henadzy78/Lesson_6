import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.internal.TestResult;

import java.sql.SQLOutput;

public class Retry implements IRetryAnalyzer {

    private int attempt = 1;
    private static final int MAX_ATTEMPTS = 7;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (attempt < MAX_ATTEMPTS) {
                attempt++;
                iTestResult.setStatus(TestResult.FAILURE);
                System.out.println("Try one more time");
                return true;
            } else {
                iTestResult.setStatus(TestResult.FAILURE);
            }
        } else {
            iTestResult.setStatus(TestResult.SUCCESS);
        }
        return false;
    }
}
