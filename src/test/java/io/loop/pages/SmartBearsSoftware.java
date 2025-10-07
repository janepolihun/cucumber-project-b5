package io.loop.pages;

import io.loop.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SmartBearsSoftware {

    public SmartBearsSoftware() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    private static final Logger LOG = LogManager.getLogger();

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement username;

    @FindBy(id = "ctl00_MainContent_password")
    public WebElement password;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement loginButton;

    @FindBy(xpath = "//ul[@id = 'ctl00_menu']/li")
    public List<WebElement> links;

    @FindBy(xpath = "//a[.='Order']")
    public WebElement order;

    @FindBy(xpath = "//select [@id = 'ctl00_MainContent_fmwOrder_ddlProduct']")
    public WebElement productTypeDropdown;

    @FindBy(xpath = "//input[@id = 'ctl00_MainContent_fmwOrder_txtQuantity']")
    public WebElement quantityInput;

    @FindBy(xpath = "//input[@id = 'ctl00_MainContent_fmwOrder_txtName']")
    public WebElement customerNameInput;

    @FindBy(xpath = "//input[@id = 'ctl00_MainContent_fmwOrder_TextBox2']")
    public WebElement streetInput;

    @FindBy(xpath = "//input[@id = 'ctl00_MainContent_fmwOrder_TextBox3']")
    public WebElement cityInput;

    @FindBy(xpath = "//input[@id = 'ctl00_MainContent_fmwOrder_TextBox4']")
    public WebElement stateInput;

    @FindBy(xpath = "//input[@id = 'ctl00_MainContent_fmwOrder_TextBox5']")
    public WebElement zipInput;

    @FindBy(xpath = "//input[@id = 'ctl00_MainContent_fmwOrder_cardList_2']")
    public WebElement creditCardType;

    @FindBy(xpath = "//input[@id = 'ctl00_MainContent_fmwOrder_TextBox6']")
    public WebElement creditCardNumberInput;

    @FindBy(xpath = "//input[@id = 'ctl00_MainContent_fmwOrder_TextBox1']")
    public WebElement expirationDateInput;

    @FindBy(xpath = "//a[@id = 'ctl00_MainContent_fmwOrder_InsertButton']")
    public WebElement processButton;

    @FindBy(xpath = "//a[.='View all orders']")
    public WebElement viewAllOrders;

    public void validationName(String name) {

        WebElement actualName = Driver.getDriver().findElement(By.xpath("//td[normalize-space(text())='" + name + "']"));
        Assert.assertEquals("Actual does not match expected",actualName.getText(), name);
        LOG.info("Actual {} is match expected {}. Validation done. ",  actualName.getText(), name);

    }

    public void selectProduct(String product) {
        Select select = new Select(productTypeDropdown);
        select.selectByVisibleText(product);
    }


}
