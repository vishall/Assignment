package base;

import builders.WFBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;
import java.time.Duration;
import java.util.List;

//this class should have all the methods which can be used frequently
public class Base extends Driver {


    public void loadPage(String url) {
        setDriver();
        driver.get(url);
    }

    public void clickInsert(By locator, String message, WFBuilder build) {
        clickInsert(locator, message, WFBuilder.options().scrollTo(true).build());
    }

    public boolean isPresent(By locators) {

        if (driver.findElement(locators).isDisplayed())
            return true;
        else
            return false;
    }

    private JavascriptExecutor javascript() {
        return (JavascriptExecutor) driver;
    }

    private void scrollToElement(WebElement element, boolean scrollTo, int scrollToOffset) {
        if (scrollTo) {
            javascript().executeScript("arguments[0].scrollIntoView(true);", element);

            javascript().executeScript("window.scrollBy(0, " + scrollToOffset + ")", "");
        }
    }

    public String getTextById(String elementId) {
        String text = (String) javascript().executeScript("return document.getElementById('" + elementId + "').value;");

        return text;
    }

    public WebElement verifyElement(By locator) {
        return waitFor(locator, WFBuilder.options().failOnNotFound(false).build());
    }

    public WebElement waitFor(By locator, WFBuilder options) {
        WebElement element = null;
        Exception exception = null;
        try {
            switch (options.conditions) {
                case CLICKABLE:
                    element = new WebDriverWait(driver, Duration.ofSeconds(1000)).until(ExpectedConditions.elementToBeClickable(
                            (locator)));
                    break;
                case PRESENT:
                    element = new WebDriverWait(driver, Duration.ofSeconds(1000)).until(ExpectedConditions
                            .presenceOfElementLocated((locator)));
                    break;
            }

        } catch (Exception e) {
            exception = e;
        }

        // If element cannot be found the check if test should fail
        if (element == null) {
            try {
                if (options.failOnNotFound) {
                    throw new Exception(exception);
                } else {
                    element = null;
                }
            } catch (Exception ex) {
                ex.initCause(ex);
            }
        } else {
            scrollToElement(element, options.scrollTo, options.scrollToOffset);
        }

        return element;
    }

    public List<WebElement> getListOfElements(By locator) {
        return getListOfElements(locator, WFBuilder.options().build());
    }

    public List<WebElement> getListOfElements(By locator, WFBuilder options) {
        List<WebElement> elementList = null;
        Exception exception = null;
        try {
            elementList = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

        } catch (Exception e) {
            exception = e;
        }

        if (elementList != null) {
            return elementList;
        } else {
            try {
                if (options.failOnNotFound) {
                    throw new Exception(exception);
                }

            } catch (Exception e) {
                e.initCause(e);
            }
        }

        return null;
    }

    private Select selectElement(By locator) {
        return new Select(waitFor(locator, WFBuilder.options().build()));
    }

    public void selectByValue(By locator, String value) {
        Select select = selectElement(locator);
        select.selectByValue(value);
    }

    public void selectByIndex(By locator, Integer index) {
        Select select = selectElement(locator);
        select.selectByIndex(index);
    }

    public void selectByVisibleText(By locator, String value) {
        Select select = selectElement(locator);
        select.selectByVisibleText(value);
    }

    public WebElement selectByFirstSelectedOption(By locator) {
        Select select = selectElement(locator);
        return select.getFirstSelectedOption();
    }


}
