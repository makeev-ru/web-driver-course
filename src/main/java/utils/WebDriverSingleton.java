package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {
    private static WebDriver driver;


    private static final String SAUCE_USERNAME = System.getenv("SAUCE_USERNAME");
    private static final String SAUCE_ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
    private static final String SAUCE_DC = "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    private WebDriverSingleton() {
    }

    public static WebDriver getWebDriver() {

        if (null == driver) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();

//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setBrowserName("chrome");
//            capabilities.setVersion("83");
//            capabilities.setPlatform(Platform.WIN10);
//            capabilities.setCapability("screenResolution", "1280x1024");
//
//            try {
//                driver = new RemoteWebDriver(new URL("https://" + SAUCE_USERNAME + ":" + SAUCE_ACCESS_KEY + SAUCE_DC), capabilities);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;

    }
}
