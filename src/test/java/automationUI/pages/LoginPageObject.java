package automationUI.pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPageObject extends AbstractPage {

    private static final By LOCATOR_LOGIN_FORM = By.id("frmLogin");
    private static final By LOCATOR_USER_NAME_FIELD = By.id("txtUsername");
    private static final By LOCATOR_USER_PASSWORD_FIELD = By.id("txtPassword");
    private static final By LOCATOR_LOGIN_BUTTON = By.id("btnLogin");

    public void accessLoginPage() {
        driver.get("http://opensource.demo.orangehrmlive.com/index.php/auth/login");
    }

    public void verifyLoginPanel() {
        Assert.assertTrue("Login Panel is displayed", driver.findElement(LOCATOR_LOGIN_FORM).isDisplayed());
    }

    public void fillUserNameField(String userName) {
        Assert.assertTrue(driver.findElement(LOCATOR_USER_NAME_FIELD).isDisplayed());
        driver.findElement(LOCATOR_USER_NAME_FIELD).sendKeys(userName);
    }

    public void fillUserPassword(String userPassword) {
        Assert.assertTrue(driver.findElement(LOCATOR_USER_PASSWORD_FIELD).isDisplayed());
        driver.findElement(LOCATOR_USER_PASSWORD_FIELD).sendKeys(userPassword);
    }

    public void clickLoginButton() {
        Assert.assertTrue(driver.findElement(LOCATOR_LOGIN_BUTTON).isDisplayed());
        driver.findElement(LOCATOR_LOGIN_BUTTON).click();
    }


}


