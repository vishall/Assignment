package tests;

import Locators.Locators;
import base.Base;
import org.junit.Assert;
import org.junit.Test;
import utils.PropertyLoader;

// this is a test class which has all the tests
public class homeTest extends Base {


    @Test
    public void accessHomePage() {

        loadPage(PropertyLoader.loadProperty("url"));
        Assert.assertTrue(isPresent(Locators.logo));

    }

    @Test
    public void verifyTopBreadcrum() {
        loadPage(PropertyLoader.loadProperty("url"));
        Assert.assertTrue(isPresent(Locators.breadcrum_container));

    }


}
