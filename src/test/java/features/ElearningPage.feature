Feature: Elearning Automation Evaluation

  Scenario Outline: Elearning Signup and Messaging
    Given User navigates to Elearning Portal
    When User clicks on Signup
    And User fills up the registration form with "<FirstName>","<LastName>","<Email>","<UserName>","<Pass>","<ConfirmPassword>"
    And User clicks on Register
    Then User validates the registration message
    And User Clicks on Next button
    And User clicks on username and selects profile option
    And User clicks on messages link
    And User clicks on compose message link
    Then User fills up the compose message details
      | Test Message | Test Email |
    And User clicks on Send Message

    Examples: 
      | FirstName | LastName  | Email                      | UserName  | Pass      | ConfirmPassword |
      | Swati     | Mohapatra | swati.mohapatra@in.ibm.com | SwatiM123 | Ibm@12345 | Ibm@12345       |
