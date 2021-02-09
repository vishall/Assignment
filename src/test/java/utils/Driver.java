package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {


    public WebDriver driver;
    public static long defaultTimeout = 15;


    public void setDriver(WebDriver driver) {



        if(PropertyLoader.loadProperty("browser").equalsIgnoreCase(String.valueOf(Browsers.chrome))){
           System.setProperty("webdriver.chrome.driver","Executables/chromedriverMACOS");
            this.driver = new ChromeDriver();

        }
        else if(PropertyLoader.loadProperty("browser").equalsIgnoreCase(String.valueOf(Browsers.firefox))){
            System.setProperty("webdriver.gecko.driver","Executables/geckodriver");
            this.driver = new FirefoxDriver();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
