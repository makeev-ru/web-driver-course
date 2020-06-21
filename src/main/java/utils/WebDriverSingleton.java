package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverSingleton {
    private static WebDriver driver;

    private WebDriverSingleton() {
    }

    public static WebDriver getWebDriver() {
        if (null == driver) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            Dimension size = new Dimension(1280, 1024);
            driver.manage().window().setSize(size);
//            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriver getSauceLabsWebDriver() {
        final String SAUCE_USERNAME = System.getenv("SAUCE_USERNAME");
        final String SAUCE_ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
        final String SAUCE_DC = "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

        if (null == driver) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            capabilities.setVersion("83");
            capabilities.setPlatform(Platform.WIN10);
            capabilities.setCapability("screenResolution", "1280x1024");

            try {
                driver = new RemoteWebDriver(new URL("https://" + SAUCE_USERNAME + ":" + SAUCE_ACCESS_KEY + SAUCE_DC), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;

    }
}
