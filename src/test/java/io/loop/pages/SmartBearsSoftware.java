package io.loop.pages;

import io.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SmartBearsSoftware {

    public SmartBearsSoftware() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "ctl00_MainContent_username")
    public  WebElement username;

    @FindBy (id = "ctl00_MainContent_password")
    public  WebElement password;

    @FindBy (id = "ctl00_MainContent_login_button")
    public WebElement loginButton;

    @FindBy ( xpath = "//ul[@id = 'ctl00_menu']/li")
    public List <WebElement> links ;
    
}
