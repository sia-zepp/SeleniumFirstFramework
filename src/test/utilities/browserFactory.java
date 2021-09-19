package utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class browserFactory {

    public static WebDriver startBrowser(WebDriver driver, String browserName, String url) {

        if(browserName.equals("Chrome"))
        {
            System.setProperty("WebDriver.chrome.driver", "./drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browserName.equals("Firefox"))
        {
            System.setProperty("WebDriver.gecko.driver", "./drivers/chromedriver.exe");
            driver = new FirefoxDriver();
        }
        else
        {
            System.out.println("Browser is not supported");
        }

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        return driver;
    }

    public static void quitBrowser(WebDriver driver) {

        driver.quit();

    }

}
