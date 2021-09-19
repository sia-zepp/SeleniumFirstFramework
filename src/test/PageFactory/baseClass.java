package PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.yaml.snakeyaml.representer.Represent;
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
    public ExtentReports report;
    public ExtentTest logger;

    @BeforeSuite
    public void setUpSuite() {


        Reporter.log("Setting up reports and Test Started", true);
        excel = new ExcelDataProvider();
        config = new ConfigDataProvider();


        ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/Reports/phpTest_" + Helper.getCurrentDateTime() + ".html"));
        report = new ExtentReports();
        report.attachReporter(extent);

        Reporter.log("Settings Done - Test can be started", true);

    }

    @BeforeClass

    public void setup() {

        Reporter.log("Trying to start Browser and Getting application ready " + Helper.getCurrentDateTime(), true);
        driver = browserFactory.startBrowser(driver, config.getBrowser(), config.getStagingUrl());
        Reporter.log("Browser and Application is up and running", true);


    }

    @AfterClass
    public void tearDown() {

        browserFactory.quitBrowser(driver);
    }


    @AfterMethod
    public void tearDownMethod(ITestResult result) throws IOException {

        Reporter.log("Test is about to end", true);


        if (result.getStatus() == ITestResult.FAILURE) {
            logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {

            logger.pass("Test passed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
        }
        else if(result.getStatus() == ITestResult.SKIP) {
            logger.skip("Test skipped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
        }
        report.flush();

        Reporter.log("Test completed " + Helper.getCurrentDateTime(), true);

    }


}
