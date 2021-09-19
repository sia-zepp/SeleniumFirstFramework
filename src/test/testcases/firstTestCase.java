package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import PageFactory.baseClass;
import PageFactory.loginPage;


public class firstTestCase extends baseClass {


    @Test
    public void login() {


        logger = report.createTest("loginToPhp");

        loginPage loginPage = PageFactory.initElements(driver, loginPage.class);

        logger.info("Starting App");

        loginPage.loginTo(excel.getStringData("Login", 1, 0), excel.getStringData("Login", 1, 1));

        logger.pass("Login done");

        System.out.println("Test Three");

    }

    @Test(priority = 2)
    public void login2() {


        logger = report.createTest("Logout");


        logger.fail("Login done");


    }

}
