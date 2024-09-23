package driver;

import browser.BrowserException;
import browser.Chrome;
import browser.Edge;
import browser.Firefox;
import org.openqa.selenium.WebDriver;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver() throws BrowserException {
        if (driver == null) {
            String browser = ConfigurationReader.getConfigProperty("browser");
            switch (browser) {
                case "chrome" -> driver = new Chrome().createInstance();
                case "firefox" ->  driver = new Firefox().createInstance();
                case "edge" -> driver = new Edge().createInstance();
                default -> throw new BrowserException(browser + " is not supported!");
            }

        }
        return driver;
    }
}
