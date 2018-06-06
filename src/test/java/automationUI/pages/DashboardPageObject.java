package automationUI.pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class DashboardPageObject extends AbstractPage {

    private static final By LOCATOR_QUICK_LAUNCH_PANEL = By.id("panel_resizable_0_0");
    private static final By LOCATOR_EMPLOYEE_DISTRIBUTION_PANEL = By.id("panel_resizable_1_0");
    private static final By LOCATOR_LEGEND_PANEL = By.id("panel_resizable_1_1");
    private static final By LOCATOR_PENDING_LEAVE_REQUESTS_PANEL = By.id("panel_resizable_1_2");

    public void verifyDashboardPage() {
        Assert.assertTrue(driver.findElement(LOCATOR_QUICK_LAUNCH_PANEL).isDisplayed());
        Assert.assertTrue(driver.findElement(LOCATOR_EMPLOYEE_DISTRIBUTION_PANEL).isDisplayed());
        Assert.assertTrue(driver.findElement(LOCATOR_LEGEND_PANEL).isDisplayed());
        Assert.assertTrue(driver.findElement(LOCATOR_PENDING_LEAVE_REQUESTS_PANEL).isDisplayed());
    }
}
