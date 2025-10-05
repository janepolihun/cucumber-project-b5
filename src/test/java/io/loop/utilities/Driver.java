package io.loop.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Driver {

    /*
    Creating a private constructor, so we are closing access to the object of this class from outside the class
     */

    private Driver(){

    }

    /*
    Making our driver instance private, so it is not reachable from outside the class
    We make it static because we want it to run before everything else, and we will use it in a static method
     */

    // private static WebDriver driver;
    // implement threadLocal to achieve multi thread locally
    private static InheritableThreadLocal <WebDriver> driverPool = new InheritableThreadLocal<>();

    /*
    Creating a reusable method that will return the same driver instance every time when we call it
     */

    /**
     * Singleton pattern
     * @return
     */
    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            ChromeOptions options = new ChromeOptions();


            // --- Keep Incognito if you want it ---
            options.addArguments("--incognito");

            // --- Turn off HTTPS-First / upgrades that cause the block page ---
            options.addArguments("--disable-features=HttpsFirstMode,HttpsFirstModeV2,HttpsUpgrades");

            // --- Accept insecure stuff just in case (harmless here) ---
            options.setAcceptInsecureCerts(true);
            options.addArguments("--allow-running-insecure-content");

             // --- Kill Chrome Password Manager popups ---
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("--disable-features=PasswordManagerOnboarding,PasswordLeakDetection");
            options.addArguments("--disable-save-password-bubble");

            // (Optional) Treat this origin as secure to silence some warnings
            options.addArguments("--unsafely-treat-insecure-origin-as-secure=http://secure.smartbearsoftware.com");

            // Create driver
            WebDriver driver = new ChromeDriver(options);




            String browserType = ConfigurationReader.getProperties("browser");
           // ChromeOptions options = new ChromeOptions();
            switch (browserType.toLowerCase()) {
                case "chrome" -> {
                    options.addArguments("--disable-blink-features=AutomationControlled");
                    driverPool.set(new ChromeDriver(options));
                }
                case "firefox" -> driverPool.set(new FirefoxDriver());
                case "safari" -> driverPool.set(new SafariDriver());
                case "headless" -> {
                    options.addArguments("--headless");
                    driverPool.set(new ChromeDriver(options));
                }
            }
            driverPool.get().manage().window().maximize();
            //driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperties("timeouts"))));
            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(DocuportConstants.LARGE));
        }
        return driverPool.get();
    }

    /**
     * Closing the driver
     * @author nsh
     */
    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
