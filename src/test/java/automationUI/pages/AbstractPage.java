package automationUI.pages;

import automationUI.driver.WebDriverTestBase;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver driver;

    public AbstractPage() {
        driver = WebDriverTestBase.getDriver();
    }
}
