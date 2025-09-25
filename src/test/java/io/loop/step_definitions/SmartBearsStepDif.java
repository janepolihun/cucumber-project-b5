package io.loop.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loop.pages.POM;
import io.loop.pages.SmartBearsSoftware;
import io.loop.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

import java.time.Duration;
import java.util.List;


import static io.opentelemetry.sdk.internal.Signal.LOG;
import static org.junit.Assert.assertEquals;

public class SmartBearsStepDif {

    POM pages = new POM();
    SmartBearsSoftware smartBearsSoftware =  new SmartBearsSoftware();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    private static final Logger LOG = LogManager.getLogger();


    @Given("user is on SmartBearsSoftware page")
    public void user_is_on_smart_bears_software_page() {
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @When("user enter username and user enter password and click login button")
    public void user_enter_username_and_user_enter_password_and_click_login_button() {
        smartBearsSoftware.username.sendKeys("Tester");
        smartBearsSoftware.password.sendKeys("test");
        smartBearsSoftware.loginButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(pages.getSmartBearsSoftware().order)).click();
        LOG.info("User on the SmartBearsSoftware page");

    }

    @Then("user should be able to see Web Orders in the google title")
    public void user_should_be_able_to_see_web_orders_in_the_google_title() {
        String actual = Driver.getDriver().getTitle();
        assertEquals ("Actual Does Not Match", "Web Orders Login", actual);
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

    @When("user selects product type {string}")
    public void user_selects_product_type(String productType)  {
        pages.getSmartBearsSoftware().order.click();
        pages.getSmartBearsSoftware().selectProduct(productType);
    }

    @When("user enters quantity {string}")
    public void user_enters_quantity(String quantity) throws InterruptedException {
       pages.getSmartBearsSoftware().quantityInput.clear();
       pages.getSmartBearsSoftware().quantityInput.sendKeys(quantity);
    }

    @When("user enters customer name {string}")
    public void user_enters_customer_name(String name) {
        pages.getSmartBearsSoftware().customerNameInput.clear();
        pages.getSmartBearsSoftware().customerNameInput.sendKeys(name);
    }

    @When("user enters street {string}")
    public void user_enters_street(String street) {
        pages.getSmartBearsSoftware().streetInput.clear();
        pages.getSmartBearsSoftware().streetInput.sendKeys(street);
    }

    @When("user enters city {string}")
    public void user_enters_city(String city) {
        pages.getSmartBearsSoftware().cityInput.clear();
        pages.getSmartBearsSoftware().cityInput.sendKeys(city);
    }

    @When("user enters state {string}")
    public void user_enters_state(String state) {
        pages.getSmartBearsSoftware().stateInput.clear();
        pages.getSmartBearsSoftware().stateInput.sendKeys(state);
    }

    @When("user enters zip {string}")
    public void user_enters_zip(String zip) {
        pages.getSmartBearsSoftware().zipInput.clear();
        pages.getSmartBearsSoftware().zipInput.sendKeys(zip);
    }

    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String cardType) {
        pages.getSmartBearsSoftware().creditCardType.click();

    }

    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String cardNumber) {
        pages.getSmartBearsSoftware().creditCardNumberInput.clear();
        pages.getSmartBearsSoftware().creditCardNumberInput.sendKeys(cardNumber);
    }

    @When("user enters expiration date {string}")
    public void user_enters_expiration_date(String expirationDate) {
        pages.getSmartBearsSoftware().expirationDateInput.clear();
        pages.getSmartBearsSoftware().expirationDateInput.sendKeys(expirationDate);
    }

    @When("user clicks process order button")
    public void user_clicks_process_order_button() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(pages.getSmartBearsSoftware().processButton)).click();
        //pages.getSmartBearsSoftware().processButton.click();
    }
    @Then("user should see {string} in the first row of the table")
    public void user_should_see_in_the_first_row_of_the_table(String name) {
        pages.getSmartBearsSoftware().viewAllOrders.click();
        pages.getSmartBearsSoftware().validationName(name);

    }
}







