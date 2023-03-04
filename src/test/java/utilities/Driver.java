package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static AppiumDriver<MobileElement> appiumDriver;


    public static AppiumDriver getAppiumDriver()  {

        URL appiumServerURL = null;

        try {
            appiumServerURL = new URL("http:127.0.0.1:4723/wd/hub");
            //realdevice için url http:0.0.0.0:4723/wd/hub
            //emülatör için url http:127.0.0.1:4723/wd/hub

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        //

        if (appiumDriver == null) {

            DesiredCapabilities caps = new DesiredCapabilities();
            String pathChrome ="C:\\Users\\ahmet\\IdeaProjects\\e2e-mobile\\src\\test\\java\\Driverxx\\chromedriver.exe";
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,ConfigReader.getProperty("automationName"));
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME,ConfigReader.getProperty("platformName"));
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,ConfigReader.getProperty("platformVersion"));
            caps.setCapability(MobileCapabilityType.DEVICE_NAME,ConfigReader.getProperty("deviceName"));
            caps.setCapability(MobileCapabilityType.BROWSER_NAME,ConfigReader.getProperty("browser"));
            caps.setCapability("chromedriverExecutable",pathChrome);
            //caps.setCapability("appPackage",ConfigReader.getProperty("appPackage"));
            //caps.setCapability("appActivity",ConfigReader.getProperty("appActivity"));

            //caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60000");
            //caps.setCapability(MobileCapabilityType.NO_RESET,"true");


            if (ConfigReader.getProperty("platformName").equals("Android")) {

                appiumDriver = new AndroidDriver<>(appiumServerURL,caps);
                appiumDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            }else {

                throw new UnsupportedOperationException("Invalid Platform Name " + ConfigReader.getProperty("platformName"));

            }

        }

        return appiumDriver;
    }


    public static void quitAppiumDriver(){
        if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }
    }
}
