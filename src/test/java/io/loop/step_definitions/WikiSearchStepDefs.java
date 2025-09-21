package io.loop.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loop.pages.POM;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class WikiSearchStepDefs {
    POM pages = new POM(); // Page Object Manager to access page classes
    private static final Logger LOG = LogManager.getLogger();// Logger for reporting steps


    @Given("user is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org/");
        LOG.info("User is on Wiki page");
    }
    @When("user types {string} in the google search box and clicks wiki search button")
    public void user_types_in_the_google_search_box_and_clicks_wiki_search_button(String full_name) {

        pages.getWikiSearchPage().searchBox.sendKeys(full_name);
        pages.getWikiSearchPage().searchButton.click();
        LOG.info("User searched for: " + full_name);
    }
    @Then("user should be able to see {string} in the {string}")
    public void user_should_be_able_to_see_in_the(String full_name, String variation) {
     switch (variation.toLowerCase()) {
         case "wiki title":
             String actualTitle = Driver.getDriver().getTitle();
             assertEquals("Actual title does not match expected: " + actualTitle, full_name + " - Wikipedia", actualTitle);
             LOG.info("Verified Wiki title : " + full_name + " - Wikipedia");
             break;

         case "main header":
             String actualHeader = pages.getWikiSearchPage().mainHeader.getText();
             assertEquals("Actual title does not match expected: " + actualHeader, full_name, actualHeader);
             LOG.info("Verified main header: " + full_name);
             break;

         case "image header":
             String actualImageHeader = pages.getWikiSearchPage().imageHeader.getText();
             assertEquals("Actual title does not match expected: " + actualImageHeader, full_name, actualImageHeader);
             LOG.info("Verified image header: " + full_name);
             break;

     }
    }
}
