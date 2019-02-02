package celltrak.challenge.extentreport;

import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
            Date date = new Date();
            extent = new ExtentReports(workingDir + "\\ExtentReports\\ExtentReportsResults-" + dateFormat.format(date) + ".html", true);
            extent.loadConfig(new File(workingDir + "\\src\\resources\\extent-config.xml"));
        }
        return extent;
    }
}
