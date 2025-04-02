package projectEvri.uiAutomation.utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import projectEvri.uiAutomation.pages.PageInitializer;

import java.io.File;
import java.time.Duration;
import java.util.UUID;

public class Driver {


    public static WebDriver driver;
    public static Actions actions;

    public static WebDriver getDriver() {
        String browser = ConfigurationReader.get("browser");

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new");
//        options.addArguments("--remote-allow-origins=*");



        switch (browser) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--user-data-dir=/tmp/chrome_profile_" + UUID.randomUUID());
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                driver = new ChromeDriver(options);
                //driver = new ChromeDriver();
                break;
            case "chrome-headless":
                driver = new ChromeDriver(new ChromeOptions().addArguments("--headless"));
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "firefox-headless":
                driver = new FirefoxDriver(new FirefoxOptions().addArguments("--headless"));
                break;
            // Internet Explorer only works on Windows operating systems.
            case "ie":
                if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                    throw new WebDriverException("Your OS doesn't support Internet Explorer");
                driver = new InternetExplorerDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            // Safari WebDriver only works on macOS operating systems.
            case "safari":
                if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                    throw new WebDriverException("Your OS doesn't support Safari");
                driver = new SafariDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        PageInitializer.initialize();
        actions = new Actions(driver);
        return driver;
    }
    /*
     * This method quits the browser
     */
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

}