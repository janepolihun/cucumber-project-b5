package io.loop.utilities;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;


public class BrowserUtils {

    public static Scenario myScenario;

    /**
     * takes screenshot
     * @author jp
     */
    public static void takeScreenshot(){
        try{
            myScenario.log("Current url is: " + Driver.getDriver().getCurrentUrl());
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            myScenario.attach(screenshot, "image/png", myScenario.getName());
        } catch (WebDriverException | ClassCastException wbd){
            wbd.getMessage();
        }
    }




    /**
     * validate if the driver switch to the expected url or title
     *
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @author jp
     * implements assertion
     */
    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle) {
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();

        // get all window handles, switch one by one each time check if the url matches exp to stop
        // var windowHandles
        Set<String> windowHandle = driver.getWindowHandles();
        for (String each : windowHandle) {
            driver.switchTo().window(each);
            if (driver.getCurrentUrl().toLowerCase().contains(expectedUrl)) {
                break;
            }
        }
        // after stopping on expected url, validate the title
        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }

    /**
     * @param driver
     * @param targetTitle
     * @author jp
     */
    public static void switchToWindow(WebDriver driver, String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);

    }

    /**
     * clicks any link from loop practice
     *
     * @param nameOfPage
     * @author jp
     */
    public static void loopLinkClick(String nameOfPage) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='" + nameOfPage + "']"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(DocuportConstants.LARGE));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * waits for the provided element to be clickable
     *
     * @param element
     * @param timeout
     * @return element
     * @author jp
     */
    public static WebElement waitForClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * waits for provided element to be invisible on the page
     * @param element
     * @param timeaout
     * @author jp
     */
    public static void waitForInvisibility(WebElement element, int timeaout){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeaout));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * waits for provided element to be visible on the page
     * @param element
     * @param timeaout
     * @author jp
     */
    public static WebElement waitForVisibility(WebElement element, int timeaout){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeaout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickable2(WebElement element, int timeout){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        try {
            System.out.println("try");
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (StaleElementReferenceException se){
            System.out.println("catch");
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        }
    }

    public static void uploadFileWindows (String filePath) throws AWTException {
       // copy file path WINDOWS
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        // simulate keyboard paste and enter
        Robot robot = new Robot();
        robot.delay(1000);

        // press ctrl + v
        robot.keyPress(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        //press enter

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    public static void  uploadFileForMac(String filePath) throws AWTException {
        Robot robot = new Robot();

        //copy the file path
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        robot.delay(1000);

        // press ⌘ + Shift + G to open go to finder
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_META);

        // Paste file path (⌘ + V)
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);

        robot.delay(1000);

        // press enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.delay(1000);

        // Press Enter again to confirm file selection
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }
    public static void uploadFileUsingAppleScript(String filePath) throws Exception {
        String posixPath = filePath.replace("\\", "\\\\").replace("\"", "\\\"");
        String script = "tell application \"System Events\"\n"
                + "delay 1\n"
                + "keystroke \"G\" using {command down, shift down}\n"
                + "delay 1\n"
                + "keystroke \"" + filePath + "\"\n"
                + "keystroke return\n"
                + "delay 1\n"
                + "keystroke return\n"
                + "end tell";

        String[] command = { "osascript", "-e", script };
        Runtime.getRuntime().exec(command);
    }

    /**
     * Moves the mouse to given element
     * @param element to hover over
     * @author jp
     */
    public static void  hover (WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    /**
     * Scrolls down to element with JavaScript
     * @param element
     * @author jp
     */

    public static void scrollToElement(WebElement element){
        ((JavascriptExecutor)  Driver.getDriver()).executeAsyncScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Clicks on element using javaScript
     * @param element
     * @author jp
     */
    public static void clickWithJS(WebElement element){
        try {
            new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(DocuportConstants.LARGE));
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
        } catch (StaleElementReferenceException se) {
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
        }
    }


    /**
     * perform a pause
     * @param milliSeconds
     * author jp
     */

    public static void justWait(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException i) {
            i.printStackTrace();
        }
    }


    public static List <String> getElements (List <WebElement> elements){
        List <String> elementsText = new ArrayList<>();
        for (WebElement element : elements) {
            elementsText.add(element.getText());
        }
        return elementsText;
    }

    public static List <String> getElementsTextWithStream (List <WebElement> elements){
        return elements.stream()
                .map(x->x.getText())
                .collect(Collectors.toList());
    }

    public static List <String> getElementsTextWithStream2 (List <WebElement> elements){
        return elements.stream()
                .map(WebElement :: getText)
                .collect(Collectors.toList());
    }


}