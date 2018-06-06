package automationUI.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeeListPageObject extends AbstractPage {

    private static final By LOCATOR_EMPLOYEE_LIST_PAGE_SEARCH_FORM = By.id("search_form");
    private static final By LOCATOR_EMPLOYEE_LIST_PAGE_RESULT_TABLE = By.id("resultTable");
    private static final By LOCATOR_EMPLOYEE_LIST_PAGE_EMPLOYEE_NAME_FIELD = By.id("empsearch_employee_name_empName");
    private static final By LOCATOR_EMPLOYEE_LIST_PAGE_EMPLOYEE_ID_FIELD = By.id("empsearch_id");
    private static final By LOCATOR_EMPLOYEE_LIST_PAGE_SEARCH_BUTTON = By.id("searchBtn");
    private static final By LOCATOR_EMPLOYEE_LIST_PAGE_RESULT_FIRST_NAME_LINK = By.xpath("//*[@id='resultTable']/tbody/tr/td[3]/a");
    private static final By LOCATOR_EMPLOYEE_LIST_PAGE_RESULT_LAST_NAME_LINK = By.xpath("//*[@id='resultTable']/tbody/tr/td[4]/a");
    private static final By LOCATOR_EMPLOYEE_LIST_PAGE_RESULT_EMPLOYEE_ID = By.xpath(("//*[@id='resultTable']/tbody/tr/td[2]/a"));
    private static final By LOCATOR_EMPLOYEE_LIST_PAGE_FIRST_CHECKBOX_TABLE = By.xpath("//*[@name='chkSelectRow[]']");
    private static final By LOCATOR_EMPLOYEE_LIST_PAGE_DELETE_BUTTON = By.id("btnDelete");
    private static final By LOCATOR_EMPLOYEE_LIST_PAGE_DELETE_CONFIRMATION_MODAL = By.id("deleteConfModal");
    private static final By LOCATOR_EMPLOYEE_LIST_PAGE_DELETE_CONFIRMATION_MODAL_OK_BUTTON = By.id("dialogDeleteBtn");


    public void verifyEmployeeListPage() {
        Assert.assertTrue(driver.findElement(LOCATOR_EMPLOYEE_LIST_PAGE_SEARCH_FORM).isDisplayed());
        Assert.assertTrue(driver.findElement(LOCATOR_EMPLOYEE_LIST_PAGE_RESULT_TABLE).isDisplayed());
    }

    public void fillEmployeeNameField(String employeeName) {
        Assert.assertTrue(driver.findElement(LOCATOR_EMPLOYEE_LIST_PAGE_EMPLOYEE_NAME_FIELD).isDisplayed());
        driver.findElement(LOCATOR_EMPLOYEE_LIST_PAGE_EMPLOYEE_NAME_FIELD).sendKeys(employeeName);
    }

    public void fillEmployeeIdField(String employeeId) {
        Assert.assertTrue(driver.findElement(LOCATOR_EMPLOYEE_LIST_PAGE_EMPLOYEE_ID_FIELD).isDisplayed());
        driver.findElement(LOCATOR_EMPLOYEE_LIST_PAGE_EMPLOYEE_ID_FIELD).sendKeys(employeeId);
    }

    public void clickSearchButton() {
        Assert.assertTrue(driver.findElement(LOCATOR_EMPLOYEE_LIST_PAGE_SEARCH_BUTTON).isDisplayed());
        driver.findElement(LOCATOR_EMPLOYEE_LIST_PAGE_SEARCH_BUTTON).click();
    }

    public void verifyEmployeeSearched(String searchedEmployeeName, String searchedEmployeeId) {
        Assert.assertTrue(driver.findElement(LOCATOR_EMPLOYEE_LIST_PAGE_RESULT_FIRST_NAME_LINK).isDisplayed());
        Assert.assertTrue(driver.findElement(LOCATOR_EMPLOYEE_LIST_PAGE_RESULT_LAST_NAME_LINK).isDisplayed());

        String firstName = driver.findElement(LOCATOR_EMPLOYEE_LIST_PAGE_RESULT_FIRST_NAME_LINK).getText();
        String lastName = driver.findElement(LOCATOR_EMPLOYEE_LIST_PAGE_RESULT_LAST_NAME_LINK).getText();
        String employeeId = driver.findElement(LOCATOR_EMPLOYEE_LIST_PAGE_RESULT_EMPLOYEE_ID).getText();

        Assert.assertEquals(searchedEmployeeName, firstName + " " + lastName);
        Assert.assertEquals(searchedEmployeeId, employeeId);

    }

    public void selectSearchedEmployeeCheckbox() {
        Assert.assertTrue(driver.findElement(LOCATOR_EMPLOYEE_LIST_PAGE_FIRST_CHECKBOX_TABLE).isDisplayed());
        driver.findElement(LOCATOR_EMPLOYEE_LIST_PAGE_FIRST_CHECKBOX_TABLE).click();
    }


    public void clickDeleteButton() {
        Assert.assertTrue(driver.findElement(LOCATOR_EMPLOYEE_LIST_PAGE_DELETE_BUTTON).isDisplayed());
        driver.findElement(LOCATOR_EMPLOYEE_LIST_PAGE_DELETE_BUTTON).click();
    }

    public void verifyDeleteConfirmationModal() {
        Assert.assertTrue(driver.findElement(LOCATOR_EMPLOYEE_LIST_PAGE_DELETE_CONFIRMATION_MODAL).isDisplayed());

    }

    public void clickOkButton() {
        Assert.assertTrue(driver.findElement(LOCATOR_EMPLOYEE_LIST_PAGE_DELETE_CONFIRMATION_MODAL_OK_BUTTON).isDisplayed());
        driver.findElement(LOCATOR_EMPLOYEE_LIST_PAGE_DELETE_CONFIRMATION_MODAL_OK_BUTTON).click();
    }

    public void verifySuccessfullyDeleteMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Successfully Deleted')]")));
    }

}
