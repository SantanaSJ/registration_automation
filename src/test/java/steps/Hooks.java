package steps;

import driver.Driver;
import browser.BrowserException;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private static WebDriver driver;

    @Before
    public static void setup() throws BrowserException {
        driver = Driver.getDriver();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
