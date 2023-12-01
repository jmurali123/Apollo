package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static WebDriver initializeDriver(String browser) {
        WebDriver driver = null;
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("autofill.profile_enabled",false);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("incognito");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("start-maximized");
                options.addArguments("disable-geolocation");
                options.addArguments("disable-notifications");
                options.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(options);
//
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions option = new FirefoxOptions();
                option.addPreference("dom.webnotifications.enabled", false);
                option.addPreference("app.update.enabled", false);
                option.addPreference("geo.enabled", false);
                driver = new FirefoxDriver(option);
            }
            default -> throw new IllegalStateException("INVALID BROWSER: " + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }
}