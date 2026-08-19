package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    // Global ExtentReports reference
    private static ExtentReports extent;

    /*
     * This method creates and returns
     * Extent Report instance.
     */
    public static ExtentReports getExtentReport() {

        // Create report only once
        if (extent == null) {

            // Report location
            String reportPath =
                    System.getProperty("user.dir")
                    + "/reports/ExtentReport.html";

            // Spark Reporter setup
            ExtentSparkReporter spark =
                    new ExtentSparkReporter(reportPath);

            // Report customization
            spark.config().setReportName("Automation Test Report");
            spark.config().setDocumentTitle("Selenium Execution Report");

            // Attach reporter
            extent = new ExtentReports();
            extent.attachReporter(spark);

            // System information
            extent.setSystemInfo("Framework", "Selenium + TestNG");
            extent.setSystemInfo("Tester", "Abhishek");
        }

        return extent;
    }

    /*
     * This method captures screenshot
     * and returns screenshot path.
     */
    public static String captureScreenshot(WebDriver driver,
                                           String screenshotName) {

        // Screenshot folder path
        String folderPath =
                System.getProperty("user.dir")
                + "/screenshots/";

        // Create folder if not exists
        File folder = new File(folderPath);

        if (!folder.exists()) {

            folder.mkdirs();
        }

        // Timestamp for unique screenshot name
        String timeStamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());

        // Final screenshot path
        String screenshotPath =
                folderPath
                + screenshotName
                + "_"
                + timeStamp
                + ".png";

        // Capture screenshot
        File srcFile =
                ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        File destFile = new File(screenshotPath);

        try {

            // Copy screenshot to destination
            FileUtils.copyFile(srcFile, destFile);

        } catch (IOException e) {

            e.printStackTrace();
        }

        // Return screenshot location
        return screenshotPath;
    }
}