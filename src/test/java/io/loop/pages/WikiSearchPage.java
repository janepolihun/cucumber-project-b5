package io.loop.pages;

import io.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiSearchPage {

   public  WikiSearchPage() {
      PageFactory.initElements(Driver.getDriver(), this); // create constructor
   }

   @FindBy(xpath = "//input[@id='searchInput']")
    public WebElement searchBox;

   @FindBy(xpath= "//button[@class='pure-button pure-button-primary-progressive']")
    public WebElement searchButton;

   @FindBy(xpath = "//h1[@id='firstHeading']")
    public WebElement mainHeader;

   @FindBy(xpath= "//div[@class='fn']")
    public WebElement imageHeader;

}
