Feature: Create Shipment functionality
  I would like to be able to create shipment

  #Positive documents path Step 1
  Scenario Outline: Create Shipment
    Given user is on create shipment page
    When complete create shipment Step One form documents
      | Quantity   | Description   | expected result step 1   |
      | <quantity> | <description> | <expected result step 1> |
    Then "<expected result step 1>" you cah fill data in Step Two

    Examples: Step 1
      | quantity | description                      | expected result step 1 |
      | 3        | Успешно заявихте куриер на Еконт | true                   |

  @Test
  #Positive documents path Step 2
  Scenario Outline: Create Shipment
    Given user is on create shipment page
    When complete create shipment Step One form documents
      | Quantity | Description                      | expected result step 1 |
      | 3        | Успешно заявихте куриер на Еконт | true                   |
    And complete create shipment Step Two form for sender
      | Sender Name   | Sender Email   | Sender Phone   | Sender City   | Pickup Address   |
      | <sender name> | <sender email> | <sender phone> | <sender city> | <pickup address> |
    And complete create shipment Step Two form for receiver
      | Receiver Name   | Receiver Email   | Receiver Phone   | Receiver City   | Delivery Location  | expected result step 2   |
      | <receiver name> | <receiver email> | <receiver phone> | <receiver city> | <delivery address> | <expected result step 2> |
    Then "<expected result step 2>" you cah fill data in Step Tree

    Examples: Sender Step 2
      | sender name  | sender email | sender phone  | sender city | pickup address  | receiver name   | receiver email | receiver phone | receiver city  | delivery address     | expected result step 2 |
      | Gosho Goshev | gosho@abv.bg | 0887 78 69 79 | Sofia       | bul. Vitosha 11 | Stoian Stoianov | stuio@abv.bg   | 0887 78 69 79  | [4000] Пловдив | bul. Hristo Botev 21 | true                   |

