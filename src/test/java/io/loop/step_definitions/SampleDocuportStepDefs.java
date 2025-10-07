package io.loop.step_definitions;

import io.cucumber.java.en.*;
import io.loop.pages.POM;
import io.loop.utilities.BrowserUtils;
import io.loop.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class SampleDocuportStepDefs {

    private static final Logger LOG = LogManager.getLogger();
    POM pages = new POM();

    @When("user insert {string} to {string} field on {string} page")
    public void user_insert_to_field_on_page(String input, String field, String page) {

        switch (page.toLowerCase().trim()) {
            case "login" -> {
                pages.getLoginPage().insertField(field, input);
                LOG.info(input + " - was successfully sent to - " + field);
            }
            case "received doc" -> {
                pages.getReceivedDocPage().insertField(field, input);
                LOG.info(input + " - was successfully sent to - " + field);
            }
            default -> throw new IllegalArgumentException("No such a page: " + page);
        }
    }


    @When("user clicks {string} button on {string} page")
    public void user_clicks_button_on_page(String button, String page) throws InterruptedException {
        switch (page.toLowerCase().trim()) {
            case "login", "choose account" -> {
                pages.getLoginPage().clickButton(button);
                LOG.info(button + " - was successfully clicked");
            }
            case "left navigate" -> {
                pages.getLeftNavigatePage().clickButton(button);
                LOG.info(button + " - was successfully clicked");
            }
            case "received doc" -> {
                pages.getReceivedDocPage().clickButton(button);
                LOG.info(button + " - was successfully clicked");
            }

            case "my uploads" -> {
                pages.getMyUploadsPage().clickButton(button);
                LOG.info(button + " - was successfully clicked");
            }
            default -> throw new IllegalArgumentException("No such a page: " + page);
        }
    }

    @Then("user uploads a document")
    public void user_uploads_a_document() throws Exception {

        WebElement element = Driver.getDriver().findElement(By.xpath("//input[@type='file']"));

       element.sendKeys("/Users/janepoligyn/Desktop/test");
//          BrowserUtils.uploadFileForMac("/Users/janepoligyn/Desktop/test");
//        BrowserUtils.uploadFileUsingAppleScript("/Users/janepoligyn/Desktop/test");
    }


}
