
package PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utilities.ConfigDataProvider;
import utilities.ExcelDataProvider;
import utilities.Helper;
import utilities.browserFactory;

import java.io.File;
import java.io.IOException;

public class baseClass {

    public WebDriver driver;
    public ExcelDataProvider excel;
    public ConfigDataProvider config;
    public ExtentReports extent;
    public ExtentSparkReporter spark;

    @BeforeSuite
    public void setUpSuite() {


        excel = new ExcelDataProvider();
        config = new ConfigDataProvider();

        extent = new ExtentReports();
        spark = new ExtentSparkReporter(new File(System.getProperty("user.dir") + "/Reports/phpTest_" + Helper.getCurrentDateTime() + ".html"));
        extent.attachReporter(spark);

    }

    @BeforeClass

    public void setup() {
        driver = browserFactory.startBrowser(driver, config.getBrowser(), config.getStagingUrl());
    }

    @AfterClass
    public void tearDown() {

        browserFactory.quitBrowser(driver);
    }


    @AfterMethod
    public void tearDownMethod(ITestResult result) throws IOException {

        ExtentTest test;

        if (result.getStatus() == ITestResult.FAILURE) {
            test = extent.createTest(result.getName());
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
//            Helper.captureScreenshot(driver);

        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test = extent.createTest(result.getName());
            test.pass(MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
//            Helper.captureScreenshot(driver);
        }
        else if(result.getStatus() == ITestResult.SKIP) {
            test = extent.createTest(result.getName());
            test.pass(MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
//            Helper.captureScreenshot(driver);
        }
        extent.flush();
    }


}