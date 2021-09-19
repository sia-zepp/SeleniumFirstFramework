package PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentTest;
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


        Reporter.log("Setting up reports and Test Started", true);
        excel = new ExcelDataProvider();
        config = new ConfigDataProvider();


//        ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/Reports/phpTest_" + Helper.getCurrentDateTime() + ".html"));
//        report = new ExtentReports();
//        report.attachReporter(extent);
//

        extent = new ExtentReports();
        spark = new ExtentSparkReporter(new File(System.getProperty("user.dir") + "/Reports/phpTest_" + Helper.getCurrentDateTime() + ".html"));
        extent.attachReporter(spark);




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

        if (result.getStatus() == ITestResult.FAILURE) {
            Helper.captureScreenshot(driver);

        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            Helper.captureScreenshot(driver);
        }
        else if(result.getStatus() == ITestResult.SKIP) {
            Helper.captureScreenshot(driver);
        }
        extent.flush();
    }


}
