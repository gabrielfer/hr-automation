package automationUI.pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class AddEmployeePageObject extends AbstractPage {

    private static final By LOCATOR_ADD_EMPLOYEE_TABLE = By.id("addEmployeeTbl");
    private static final By LOCATOR_FIRST_NAME_FIELD = By.id("firstName");
    private static final By LOCATOR_LAST_NAME_FIELD = By.id("lastName");
    private static final By LOCATOR_SAVE_BUTTON = By.id("btnSave");
    private static final By LOCATOR_EMPLOYEE_ID_FIELD = By.id("employeeId");

    public void verifyAddEmployeePage() {
        Assert.assertTrue(driver.findElement(LOCATOR_ADD_EMPLOYEE_TABLE).isDisplayed());
    }

    public void fillFirstNameField(String firstName) {
        Assert.assertTrue(driver.findElement(LOCATOR_FIRST_NAME_FIELD).isDisplayed());
        driver.findElement(LOCATOR_FIRST_NAME_FIELD).sendKeys(firstName);
    }

    public void fillLastNameField(String lastName) {
        Assert.assertTrue(driver.findElement(LOCATOR_LAST_NAME_FIELD).isDisplayed());
        driver.findElement(LOCATOR_LAST_NAME_FIELD).sendKeys(lastName);
    }

    public void fillEmployeeId(String employeeId) {
        Assert.assertTrue(driver.findElement(LOCATOR_EMPLOYEE_ID_FIELD).isDisplayed());
        driver.findElement(LOCATOR_EMPLOYEE_ID_FIELD).clear();
        driver.findElement(LOCATOR_EMPLOYEE_ID_FIELD).sendKeys(employeeId);
    }

    public void clickSaveButton() {
        Assert.assertTrue(driver.findElement(LOCATOR_SAVE_BUTTON).isDisplayed());
        driver.findElement(LOCATOR_SAVE_BUTTON).click();
    }

}
