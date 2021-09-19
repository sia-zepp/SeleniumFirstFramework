package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import PageFactory.baseClass;
import PageFactory.loginPage;
import PageFactory.dashBoard;


public class firstTestCase extends baseClass {


    @Test
    public void login() {

        loginPage loginPage = PageFactory.initElements(driver, loginPage.class);

        loginPage.loginTo(excel.getStringData("Login", 1, 0), excel.getStringData("Login", 1, 1));

    }

    @Test
    public void bookings() {

        dashBoard dashBoard = PageFactory.initElements(driver, dashBoard.class);

        dashBoard.goToMyBookings();

    }

}
