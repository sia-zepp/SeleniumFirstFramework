package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class dashBoard {

    WebDriver driver;

    public dashBoard(WebDriver ldriver) {
        this.driver = ldriver;
    }

    @FindBy(xpath="//ul[@class=\"sidebar-menu list-items\"]//a[@href=\"https://www.phptravels.net/account/bookings\"]") WebElement dashboard;

    public void goToMyBookings() {
        dashboard.click();
    }

}
