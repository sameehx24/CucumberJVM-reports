Feature: To validate the login functionality of Adactin hotel

  # Background:
  # Given User has to launch the browser and url..
  @sanity
  Scenario: Verify that user can login by valid credentials
    Given User has to launch the browser and url
    When User has to enter the valid username and valid password
      # one dimensional
      | Sameeh24    |
      | Niyas       |
      | Ashkar      |
      | Sameeh2438@ |
      | Niyas4h567  |
      | Ashkar123   |
    And User has to click the login button
    Then Validate user reached the home page and close the browser

  @smoke
  Scenario: Verify that user can login by valid credentials
    Given User has to launch the browser and url
    When User has to enter any  valid username and any valid password
      # two  dimensional
      | Sameeh24 | 2KC4K3    |
      | Niyas    | Niyas234  |
      | Ashkar   | Askhar345 |
    And User has to click the login button
    Then Validate user reached the home page and close the browser

  @unit
  Scenario: Verify that user can login by valid credentials
    Given User has to launch the browser and url
    When User has to enter any  vvalid username and any vvalid password
      # one   dimensional map
      | username | Sameeh              |
      | password | Sameeh2438@         |
      | mailid   | sameehx24@gmail.com |
    And User has to click the login button
    Then Validate user reached the home page and close the browser

  @integration
  Scenario: Verify that user can login by valid credentials
    Given User has to launch the browser and url
    When User has to enter any  vvalid uusername and any vvalid ppassword
      # two   dimensional map
      | username | password | mailid             |
      | messi    | messi123 | messi@gmail.com    |
      | cr       | cr7      | cr7@gmai.com       |
      | neymar   | neymar24 | neymar38@gmail.com |
    And User has to click the login button
    Then Validate user reached the home page and close the browser

  @regression
  Scenario Outline: verify multiple user can login by valid credentials
    Given User has to launch the browser and url
    When User has to  enter the valid "<user>" and valid "<pass>"
    And User has to click the login button
    Then Validate user reached the home page and close the browser

    Examples:
      | user       | pass   |
      | Ahamed0001 | SI6W4Y |
      | Sameeh24   | 3TB795 |
      | Mani       | Muthu  |
      | STALIN     | DMK    |
