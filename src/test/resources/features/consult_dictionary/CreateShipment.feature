Feature: Create Shipment functionality
  I would like to be able to create shipment


  #Positive documents path
  Scenario Outline: Create Shipment
    Given user is on create shipment page
    When click on gdpr agree button
    And complete create shipment form

      | Quantity   | Description   | Email   | City   | Address   | expected result   |
      | <quantity> | <description> | <email> | <city> | <address> | <expected result> |

    Then an success create shipment message "<expected result>" is displayed
    Examples:
      | quantity | description                      | email        | city  | address               | expected result                  |
      | 3        | Успешно заявихте куриер на Еконт | gosho@abv.bg | Sofia | ул. Ташкови Ливади 11 |                                  |

      | 5        | 0887 78 69 79                    | abv@abv.bg   | Sofia | ул. Ташкови Ливади 2  | Успешно заявихте куриер на Еконт |
