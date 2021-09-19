package utilities;

import org.apache.commons.exec.ExecuteException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

    Properties pro;

    public ConfigDataProvider() {

        File src = new File("./Configuration/config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Not able to load config file " + e.getMessage());
        }
    }

    public String getDataFromConfig(String ketToSearch){

       return pro.getProperty(ketToSearch);

    }

    public String getBrowser(){

       return pro.getProperty("Browser");

    }

    public String getStagingUrl(){

        return pro.getProperty("qaUrl");

    }


}
