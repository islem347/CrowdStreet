Feature: Create a new account

  @wip
  Scenario: As a new user, I should be able to create a new user account

    Given user on the landing page
    When user clicks on create an account link
    Then user should see "Sign up with Google or Linkedin" is displayed
    And the title contains "Create Account | CrowdStreet"
    When user enters all valid credentials
    And user check the captcha checkbox
    And user click on sign up button
    Then user should be able to click on Complete My Profile Button
    And user should access his profile successfully and title contains "Profile"



