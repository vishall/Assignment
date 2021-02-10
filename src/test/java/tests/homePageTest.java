package tests;

import Locators.Locators;
import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.Test;
import utils.PropertyLoader;


// this is a step definations class which has all the definations of methods
public class homePageTest extends Base {


    @Given("I load the policy expert website")
    public void i_load_the_policy_expert_website() {

        loadPage(PropertyLoader.loadProperty("url"));

    }

    @And("I am on the home page")
    public void i_am_on_the_home_page() {

        Assert.assertTrue(isPresent(Locators.logo));
    }

    @Then("I should be able to see the breadcrum at the top of the page")
    public void i_should_be_able_to_see_the_breadcrum_at_the_top_of_the_page() {

        Assert.assertTrue(isPresent(Locators.breadcrum_container));
        tearDown();

    }

}
