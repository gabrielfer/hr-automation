package automationUI.steps;

import automationUI.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {

    private HeaderObject headerObject;
    private LoginPageObject loginPage;
    private EmployeeListPageObject employeeListPage;
    private DashboardPageObject dashboardPage;
    private AddEmployeePageObject addEmployeePageObject;
    private PersonalDetailsPageObject personalDetailsPageObject;

    public StepDefinitions() {
        headerObject = new HeaderObject();
        loginPage = new LoginPageObject();
        employeeListPage = new EmployeeListPageObject();
        dashboardPage = new DashboardPageObject();
        addEmployeePageObject = new AddEmployeePageObject();
        personalDetailsPageObject = new PersonalDetailsPageObject();
    }

    @Given("^User is accessing HR Website System Login Page$")
    public void accessHrWebsiteSystemLoginPage() {
        loginPage.accessLoginPage();
    }

    @And("^Login panel is displayed$")
    public void verifyLoginPage() {
        loginPage.verifyLoginPanel();
    }

    @When("^User enters UserName \"([^\"]*)\" and Password \"([^\"]*)\"$")
    public void login(String userName, String password) {
        loginPage.fillUserNameField(userName);
        loginPage.fillUserPassword(password);
        loginPage.clickLoginButton();
    }

    @Then("^Dashboard page is displayed$")
    public void verifyDashboardPage() {
        dashboardPage.verifyDashboardPage();
    }

    @And("^Welcome link is displayed$")
    public void verifyWelcomeLink() {
        headerObject.verifyWelcomeLink();
    }

    @Given("^I'm on Add Employee page$")
    public void navigateToAddEmployeePage() {
        headerObject.navigateToPimModule();
        headerObject.clickAddEmployeePage();
    }

    @And("^Add Employee page is displayed$")
    public void verifyAddEmployeePage() {
        addEmployeePageObject.verifyAddEmployeePage();
    }

    @When("^I fill first name field with \"([^\"]*)\" and last name field with \"([^\"]*)\" and employee Id with \"([^\"]*)\"$")
    public void setFirstAndLastName(String firstName, String lastName, String employeeId) {
        addEmployeePageObject.fillFirstNameField(firstName);
        addEmployeePageObject.fillLastNameField(lastName);
        addEmployeePageObject.fillEmployeeId(employeeId);
    }

    @And("^I click on Save button$")
    public void clickSaveButton() {
        addEmployeePageObject.clickSaveButton();
    }

    @Then("^Persona Details page is displayed$")
    public void verifyPersonalDetailsPage() {
        personalDetailsPageObject.verifyPersonalDetailsPage();
    }

    @Then("^The employee \"([^\"]*)\" is created$")
    public void verifyEmployeeCreated(String employeeName) {
        personalDetailsPageObject.verifyEmployeeName(employeeName);
    }

    @Given("^I'm on Employee List page$")
    public void navigateToEmployeeListPage() {
        headerObject.navigateToPimModule();
        headerObject.clickEmployeeListPage();
        employeeListPage.verifyEmployeeListPage();
    }

    @Given("^I search for employee \"([^\"]*)\" with employee Id \"([^\"]*)\"$")
    public void employeeSearch(String employeeName, String employeeId) throws InterruptedException {
        employeeListPage.fillEmployeeNameField(employeeName);
        employeeListPage.fillEmployeeIdField(employeeId);
        employeeListPage.clickSearchButton();

    }

    @Given("^\"([^\"]*)\" with employee id \"([^\"]*)\" is displayed$")
    public void verifyEmployeeSearched(String expectedEmployeeName, String employeeId) {
        employeeListPage.verifyEmployeeSearched(expectedEmployeeName, employeeId);
    }

    @When("^I select the checkbox for the searched employee$")
    public void clickEmployeeCheckbox() {
        employeeListPage.selectSearchedEmployeeCheckbox();
    }

    @And("^I click on Delete button$")
    public void clickDeleteButton() {
        employeeListPage.clickDeleteButton();
    }

    @Then("^Delete Confirmation popup is displayed$")
    public void verifyDeleteConfirmationPopup() {
        employeeListPage.verifyDeleteConfirmationModal();
    }

    @And("^I click on Ok button$")
    public void clickOkButton() {
        employeeListPage.clickOkButton();
    }

    @Then("^Successfully delete message is displayed$")
    public void verifySuccessfullyDeleteMessage() {
        employeeListPage.verifySuccessfullyDeleteMessage();
    }
}
