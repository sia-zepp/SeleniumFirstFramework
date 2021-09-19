package utilities;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.io.FileHandler;

public class Helper {


    //Screenshots, alerts, frmase, multiple windows, Sync issues, javascript executor

    public static String captureScreenshot(WebDriver driver) {

      File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      String screenshotPath = System.getProperty("user.dir") + "/Screenshots/phpTest_" + getCurrentDateTime() +".png";

        try {
            FileHandler.copy(src, new File(screenshotPath));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to capture screenshot" + e.getMessage());
        }
            return screenshotPath;
    }

    public static String getCurrentDateTime() {

        DateFormat customFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");

        Date currentDate = new Date();

        return customFormat.format(currentDate);
    }
    
    public static String getCurrentTime() {

        SimpleDateFormat time = new SimpleDateFormat("HH_mm_ss");
        Date currentTime = new Date();
        return time.format(currentTime);

    }

}
