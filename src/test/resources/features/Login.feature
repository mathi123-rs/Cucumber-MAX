@login
Feature: verifying omrbranch login module

  Scenario Outline: Login with vaild credentials
    Given user is on the omrbranch page
    When user enters "<userName>" and "<password>"
    And user click the login button
    Then user should verify after login success message

    Examples: 
      | userName               | password  |
      | mathimmrs123@gmail.com | Mathi123@ |

    Examples: 
      | userName          | password  |
      | mathimm@gmail.com | Mathi123@ |

    Examples: 
      | userName             | password  |
      | mathimm123@gmail.com | Mathi123@ |
