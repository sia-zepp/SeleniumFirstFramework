package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import PageFactory.baseClass;
import PageFactory.loginPage;


public class firstTestCase extends baseClass {


    @Test
    public void login() {


        test = report.createTest("loginToPhp");

        loginPage loginPage = PageFactory.initElements(driver, loginPage.class);

        loginPage.loginTo(excel.getStringData("Login", 1, 0), excel.getStringData("Login", 1, 1));

    }

}
