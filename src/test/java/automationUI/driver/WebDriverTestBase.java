package automationUI.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class WebDriverTestBase {

    protected static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        return driver;
    }

}