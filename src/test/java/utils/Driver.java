package utils;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {


    public static long defaultTimeout = 15;
    public WebDriver driver;

    public void setDriver() {


        if (PropertyLoader.loadProperty("browser").equalsIgnoreCase(String.valueOf(Browsers.chrome))) {
            System.setProperty("webdriver.chrome.driver", "Executables/chromedriverMACOS");
            this.driver = new ChromeDriver();

        } else if (PropertyLoader.loadProperty("browser").equalsIgnoreCase(String.valueOf(Browsers.firefox))) {
            System.setProperty("webdriver.gecko.driver", "Executables/geckodriver");
            this.driver = new FirefoxDriver();
        }
    }

    @After
    public void tearDown() {

        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
