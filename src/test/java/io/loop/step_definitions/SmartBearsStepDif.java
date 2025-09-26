package io.loop.step_definitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loop.pages.SmartBearsSoftware;
import io.loop.utilities.Driver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SmartBearsStepDif {

    SmartBearsSoftware smartBearsSoftware =  new SmartBearsSoftware();

    @Given("user is on SmartBearsSoftware page")
    public void user_is_on_smart_bears_software_page() {
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @When("user enter username and user enter password and click login button")
    public void user_enter_username_and_user_enter_password_and_click_login_button() {
        smartBearsSoftware.username.sendKeys("Tester");
        smartBearsSoftware.password.sendKeys("test");
        smartBearsSoftware.loginButton.click();
    }

    @Then("user should be able to see Web Orders in the google title")
    public void user_should_be_able_to_see_web_orders_in_the_google_title() throws InterruptedException {
        String actual = Driver.getDriver().getTitle();
        Thread.sleep(3000);
        assertEquals ("Actual Does Not Match", "Web Orders", actual);
    }


    @Then("user should print out count of all the links on landing page")
    public void user_should_print_out_count_of_all_the_links_on_landing_page() {
      List<WebElement> linksOfThePage = smartBearsSoftware.links;
        System.out.println("Number of all links in the landing page is: " + linksOfThePage.size());
    }

    @Then("user should print out each link text on this page")
    public void user_should_print_out_each_link_text_on_this_page() {
        for (WebElement link : smartBearsSoftware.links) {
            String text = link.getText();
            if (text.isEmpty() || text.isBlank()) {
                System.out.println("Link text is Empty");
            } else {
                System.out.println(text);
            }
        }
    }
}







