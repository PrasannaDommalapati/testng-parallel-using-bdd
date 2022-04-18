package helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();
    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        reporter.config().setReportName("Testng Parallel Bdd sample Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Blog Name", "ARAIAN Academy");
        extentReports.setSystemInfo("Author", "Prasanna Dommalapati");
        return extentReports;
    }
}