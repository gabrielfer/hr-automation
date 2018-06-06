Feature: HR Manage Employees

  Scenario: Successful Login on HR Website System
    Given User is accessing HR Website System Login Page
    And Login panel is displayed
    When User enters UserName "Admin" and Password "admin"
    Then Dashboard page is displayed
    And Welcome link is displayed

  Scenario: Creating a new Employee
    Given I'm on Add Employee page
    When I fill first name field with "Tom" and last name field with "Delonge" and employee Id with "Emp123"
    And I click on Save button
    Then Persona Details page is displayed
    And The employee "Tom Delonge" is created

  Scenario: Search and delete an Employee
    Given I'm on Employee List page
    And I search for employee "Tom Delonge" with employee Id "Emp123"
    And "Tom Delonge" with employee id "Emp123" is displayed
    When I select the checkbox for the searched employee
    And I click on Delete button
    And Delete Confirmation popup is displayed
    And I click on Ok button
    Then Successfully delete message is displayed



