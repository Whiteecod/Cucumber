Feature: DataTable Functionality

Background:

Given Navigate to Campus
When Enter username and password and click login button
Then User should login succesfully

  @Regression
  Scenario: Create Country
    And Click on the element in LeftNav
    | setup |
    | parameters |
    | countries  |
    And Click on the element in Dialog
    | addButton |

    And User sending the keys in Dialog Content
    | nameInput | kubiUlk231 |
    | codeInput | ku23455     |
    And Click on the element in Dialog
    | saveButton |
    And User delete item from Dialog Content
    | kubiUlk231 |
    Then Success message should be displayed

  @Regression
  Scenario: Create Nationality
      And Click on the element in LeftNav
        | setup |
        | parameters |
        | nationalities  |
      And Click on the element in Dialog
        | addButton |
      And User sending the keys in Dialog Content
        | nameInput | kubiUlkk1 |
      And Click on the element in Dialog
        | saveButton |
    And User delete item from Dialog Content
      | kubiUlkk1 |
      Then Success message should be displayed

  Scenario: Fee Functionality
    And Click on the element in LeftNav
      | setup      |
      | parameters |
      | fees       |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog Content
      | nameInput       | kuu123 |
      | codeInput       | 5646     |
      | integrationCode | 56       |
      | priorityCode    | 5885       |

    And Click on the element in Dialog
      | toggleBar  |
      | saveButton |

    Then Success message should be displayed

    And User delete item from Dialog Content
      | kuu123 |

    Then Success message should be displayed
