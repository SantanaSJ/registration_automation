package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome implements Browser {
    @Override
    public WebDriver createInstance() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
