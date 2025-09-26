package io.loop.step_definitions;

import io.cucumber.java.en.*;
import io.loop.pages.POM;
import io.loop.utilities.BrowserUtils;
import io.loop.utilities.DocuportConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class Day_14StepDefs {
    POM pages = new POM();
    private static final Logger LOG = LogManager.getLogger();


    @When("user insert {string} and {string} for {string}")
    public void user_insert_and_for(String username, String password, String role) throws InterruptedException {

        pages.getLoginPage().login(username, password);
        LOG.info("User as: {} - was successfully logged in.", role);

    }

    @Then("user should be able to see the home page for {string}")
    public void user_should_be_able_to_see_the_home_page_for(String role) {

       BrowserUtils.waitForVisibility(pages.getHomePage().logo, DocuportConstants.LARGE);
       //Assert.assertTrue(pages.getHomePage().logo.isDisplayed());
        Assert.assertTrue("Home page is not visible for role: " + role, (pages.getHomePage().logo.isDisplayed()));
        LOG.info("Home page is displayed.");
    }



    @Then("the left navigation for {string} should be {string}")
    public void the_left_navigation_for_should_be(String role, String expectedCsv) {
        List <String> expected = Arrays.stream(expectedCsv.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();

        List<String> actual = pages.getLeftNavigatePageDay14().getLeftNavItemsText().stream()
                .map(String::trim)
                .toList();

        LOG.info("Expected left nav: " + expected);
        LOG.info("Actual left nav:   " + actual);

        assertEquals(expected, actual);

    }

    }

