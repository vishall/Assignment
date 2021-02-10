package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//this is a setup class for the driver for respective browsers
public class Driver {


    public static long defaultTimeout = 15;
    public static WebDriver driver;

    public void setDriver() {


        if (PropertyLoader.loadProperty("browser").equalsIgnoreCase(String.valueOf(Browsers.chrome))) {
            System.setProperty("webdriver.chrome.driver", "Executables/chromedriverMACOS");
            driver = new ChromeDriver();

        } else if (PropertyLoader.loadProperty("browser").equalsIgnoreCase(String.valueOf(Browsers.firefox))) {
            System.setProperty("webdriver.gecko.driver", "Executables/geckodriver");
            driver = new FirefoxDriver();
        }
    }


    public void tearDown() {

        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
