package tests;

import Locators.Locators;
import base.Base;
import org.junit.Assert;
import org.junit.Test;
import utils.PropertyLoader;

public class homeTest extends Base {


    @Test
    public void accessHomePage(){

        loadPage(PropertyLoader.loadProperty("url"));
        Assert.assertTrue(isPresent(Locators.logo));
        tearDown();
    }


}
