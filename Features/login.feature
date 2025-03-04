

Feature: Selenium cucumber Assessment for openmrs application login and patient registration

 
Background: Validate the login functionality for openmrs application 
    Given User is on the OpenHRMS page
    When Enter valid credentials
    And Click on login button
    Then User is in inpatient page
   
Scenario: Regsiter a patient 
    Given User is on Inpatient page
    And Selects Register a patient
    When User Provide Demographic, Contact Info, Relationship details in the details page
    And Clicks on the confirm button
    Then Verify that the patient is successfully registered
    
Scenario: Update the patient
    Given User is on Inpatient details page
    And Clicks Find Patient Records
    When User searches for the patient
    And Patient details should be listed
    And Clicks on edit button
    And User edit and save patient name
    Then verify the change is reflected  
    
 

