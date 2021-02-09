package Locators;

import org.openqa.selenium.By;

//this class should have all the locators we need while interacting with elements or webelements
public class Locators {

    public static By logo = By.cssSelector("div:nth-child(1) > div > div:nth-child(1) > div.panel-heading");
    public static By breadcrum_container = By.cssSelector("div[data-testid=breadcrumbs-container]");
}
