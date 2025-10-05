package io.loop.pages;

import io.loop.utilities.BrowserUtils;
import io.loop.utilities.DocuportConstants;
import io.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LeftNavigatePageDay14 {

public LeftNavigatePageDay14(){
    PageFactory.initElements(Driver.getDriver(),this);

}


    @FindBy (xpath = "//span[contains (text(), 'Home')]")
    public WebElement homeButton;

    @FindBy(xpath = "//span[contains(text(),'Upload')]")
    public WebElement uploadButton;

    @FindBy(xpath = "//span[contains(text(),'Received')]")
    public WebElement receivedDocsButton;

    @FindBy(xpath = "//span[contains(text(),'My uploads')]")
    public WebElement myUploads;

    @FindBy(xpath = "//span[contains(text(),'Invitations')]")
    public WebElement invitationsButton;

    @FindBy(xpath = "//a[contains(text(),'Terms')]")
    public WebElement termsAndConditionsButton;

    @FindBy(xpath = "//a[contains(text(),'Clients')]")
    public WebElement clientsButton;

    @FindBy(xpath = "//a[contains(text(),'Users')]")
    public WebElement usersButton;

    @FindBy(xpath = "//a[contains(text(),'Leads')]")
    public WebElement leadsButton;

    @FindBy(xpath = "//a[contains(text(),'Bookkeeping')]")
    public WebElement bookkeepingButton;

    @FindBy(xpath = "//a[contains(text(),'Form')]")
    public WebElement formButton;

    @FindBy(xpath = "//a[contains(text(),'Reconciliations')]")
    public WebElement reconciliations;

    public void clickButton(String role, String expected){
       switch (expected.toLowerCase().trim()){
           case "home" -> BrowserUtils.waitForClickable(homeButton, DocuportConstants.LARGE).click();
           case "received" -> BrowserUtils.waitForClickable(receivedDocsButton, DocuportConstants.LARGE).click();
           case "my uploads" -> BrowserUtils.waitForClickable(myUploads, DocuportConstants.LARGE).click();
           case "clients" -> BrowserUtils.waitForClickable(clientsButton, DocuportConstants.LARGE).click();
           case "users" -> BrowserUtils.waitForClickable(usersButton, DocuportConstants.LARGE).click();
           case "bookkeeping" -> BrowserUtils.waitForClickable(bookkeepingButton, DocuportConstants.LARGE).click();
           case "form" -> BrowserUtils.waitForClickable(formButton, DocuportConstants.LARGE).click();
           case "reconciliations" -> BrowserUtils.waitForClickable(reconciliations, DocuportConstants.LARGE).click();


           }



       }
    public List<String> getLeftNavItemsText() {
        List<String> navTexts = new ArrayList<>();

        try { navTexts.add(homeButton.getText().trim()); } catch (Exception ignored) {}
        try { navTexts.add(uploadButton.getText().trim()); } catch (Exception ignored) {}
        try { navTexts.add(receivedDocsButton.getText().trim()); } catch (Exception ignored) {}
        try { navTexts.add(myUploads.getText().trim()); } catch (Exception ignored) {}
        try { navTexts.add(invitationsButton.getText().trim()); } catch (Exception ignored) {}
        try { navTexts.add(termsAndConditionsButton.getText().trim()); } catch (Exception ignored) {}
        try { navTexts.add(clientsButton.getText().trim()); } catch (Exception ignored) {}
        try { navTexts.add(usersButton.getText().trim()); } catch (Exception ignored) {}
        try { navTexts.add(leadsButton.getText().trim()); } catch (Exception ignored) {}
        try { navTexts.add(bookkeepingButton.getText().trim()); } catch (Exception ignored) {}
        try { navTexts.add(formButton.getText().trim()); } catch (Exception ignored) {}
        try { navTexts.add(reconciliations.getText().trim()); } catch (Exception ignored) {}

        return navTexts;
    }


    }



