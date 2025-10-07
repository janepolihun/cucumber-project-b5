package io.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoopUtils {
    /**
     *
     * @param driver
     * @param fullName
     * @param field
     * @return
     * @throws InterruptedException
     */
    public static String returnAnyFieldFromTableLOOP(WebDriver driver, String fullName, String field ) throws InterruptedException {
        WebElement element = null;
        String xpath = "";
        //tr[td[2][normalize-space()='John Doe']]/td[2]
        switch (field.toLowerCase()){
            case "pizza type":
                xpath = "//tr[td[normalize-space()='" + fullName + "']]/td[3]";
                element = driver.findElement(By.xpath(xpath));
                break;
            //td[2][text()='alex.de.souza@gmail.com']/following-sibling:td[1]
            case "amount":
                xpath = "//tr[td[normalize-space()='" + fullName + "']]/td[4]";
                element = driver.findElement(By.xpath(xpath));
                break;

            case "date":
                xpath = "//tr[td[normalize-space()='" + fullName + "']]/td[5]";
                element = driver.findElement(By.xpath(xpath));
                break;

            case "street":
                xpath = "//tr[td[normalize-space()='" + fullName + "']]/td[6]";

                element = driver.findElement(By.xpath(xpath));
                break;

            case "city":
                xpath = "//tr[td[normalize-space()='" + fullName + "']]/td[7]";

                element = driver.findElement(By.xpath(xpath));
                break;

            case "state":
                xpath = "//tr[td[normalize-space()='" + fullName + "']]/td[8]";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "zip":
                xpath = "//tr[td[normalize-space()='" + fullName + "']]/td[9]";
                element = driver.findElement(By.xpath(xpath));
                break;

            case "card":
                xpath = "//tr[td[normalize-space()='" + fullName + "']]/td[10]";
                element = driver.findElement(By.xpath(xpath));
                break;

            case "card number":
                xpath = "//tr[td[normalize-space()='" + fullName + "']]/td[11]";
                element = driver.findElement(By.xpath(xpath));
                break;

            case "exp":
                xpath = "//tr[td[normalize-space()='" + fullName + "']]/td[12]";
                element = driver.findElement(By.xpath(xpath));
                break;

            default: throw new InterruptedException( "ERROR.There is not such a field: " + field);

        }
        return element.getText().trim();
    }


}
