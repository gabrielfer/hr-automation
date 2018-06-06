package automationUI.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class HeaderObject extends AbstractPage {

    private static final By LOCATOR_PIM_MODULE = By.id("menu_pim_viewPimModule");
    private static final By LOCATOR_PIM_MODULE_EMPLOYEE_LIST_PAGE = By.id("menu_pim_viewEmployeeList");
    private static final By LOCATOR_PIM_MODULE_ADD_EMPLOYEE_PAGE = By.id("menu_pim_addEmployee");
    private static final By LOCATOR_DIRECTORY_MODULE = By.id("menu_directory_viewDirectory");
    private static final By LOCATOR_WELCOME_LINK = By.id("welcome");

    public void navigateToPimModule() {
        Actions builder = new Actions(driver);
        Assert.assertTrue(driver.findElement(LOCATOR_PIM_MODULE).isDisplayed());
        builder.moveToElement(driver.findElement(LOCATOR_PIM_MODULE)).perform();
    }

    public void clickDirectoryPage() {
        Assert.assertTrue(driver.findElement(LOCATOR_DIRECTORY_MODULE).isDisplayed());
        driver.findElement(LOCATOR_DIRECTORY_MODULE).click();
    }

    public void clickEmployeeListPage() {
        navigateToPimModule();
        Assert.assertTrue(driver.findElement(LOCATOR_PIM_MODULE_EMPLOYEE_LIST_PAGE).isDisplayed());
        driver.findElement(LOCATOR_PIM_MODULE_EMPLOYEE_LIST_PAGE).click();
    }

    public void clickAddEmployeePage() {
        navigateToPimModule();
        Assert.assertTrue(driver.findElement(LOCATOR_PIM_MODULE_ADD_EMPLOYEE_PAGE).isDisplayed());
        driver.findElement(LOCATOR_PIM_MODULE_ADD_EMPLOYEE_PAGE).click();
    }

    public void verifyWelcomeLink(){
        Assert.assertTrue(driver.findElement(LOCATOR_WELCOME_LINK).isDisplayed());
        Assert.assertTrue(driver.findElement(LOCATOR_WELCOME_LINK).getText().contains("Welcome"));
    }
}
