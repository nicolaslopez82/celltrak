package celltrak.challenge.extentreport;

import com.relevantcodes.extentreports.ExtentReports;

/**
 * Created by nicolaslopez82.
 */

public class ExtentManager {

    private static ExtentReports extent;

    /**
     * Setting *.HTML reporting file location
     * @return
     */
    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir + "\\ExtentReports\\ExtentReportsResults.html", true);
        }
        return extent;
    }
}
