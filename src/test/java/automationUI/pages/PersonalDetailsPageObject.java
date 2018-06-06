package automationUI.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PersonalDetailsPageObject extends AbstractPage {

    private static final By LOCATOR_PERSONAL_DETAILS_FRAME = By.id("frmEmpPersonalDetails");
    private static final By LOCATOR_PERSONAL_DETAILS_EMPLOYEE_NAME_CARD = By.xpath("//*[@id='profile-pic']/h1");

    public void verifyPersonalDetailsPage() {
        try {
            Assert.assertTrue(driver.findElement(LOCATOR_PERSONAL_DETAILS_FRAME).isDisplayed());
        } catch (Exception e) {
            System.out.println("Error, element " + LOCATOR_PERSONAL_DETAILS_FRAME + " not found. " + e);
        }
    }

    public String getCardEmployeeName() {
        String employeeName = driver.findElement(LOCATOR_PERSONAL_DETAILS_EMPLOYEE_NAME_CARD).getText();
        return employeeName;
    }

    public void verifyEmployeeName(String expectedEmployeeName) {
        String employeeNameDisplayed = getCardEmployeeName();
        Assert.assertEquals(employeeNameDisplayed, expectedEmployeeName);
    }
}
