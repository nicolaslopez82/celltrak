package celltrak.challenge.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created by nicolaslopez82.
 */

public class Retry implements IRetryAnalyzer {

    private int count = 0;
    private static int maxTry = 1;

    /**
     *
     * @param iTestResult
     * @return
     */
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (count < maxTry) {
                count++;

                return true;
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }

    /**
     * I've commented this method the due to on this Celltrack Challenger I'm not using a webDriver to Testing API.
     * However, this method is useful for screenshots when a test has failed.
     *
     * nicolaslopez82
     */
    /*
    public void extendReportsFailOperations (ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BASE64);
        ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",
                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }
    */
}
