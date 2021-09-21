
package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {

    WebDriver driver;

    public loginPage(WebDriver ldriver)
    {
        this.driver = ldriver;
    }

    @FindBy(name="email") WebElement username;
    @FindBy(name="password") WebElement password;
    @FindBy(xpath="//div[@class='modal-content col align-self-center']//button[contains(@type,'submit')]") WebElement loginBtn;

    public void loginTo(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        loginBtn.click();
    }

}