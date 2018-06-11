Feature: Create Shipment functionality
  I would like to be able to create shipment


  #Negative pallets path Step 1
  Scenario Outline: Create Shipment
    Given user is on create shipment page
    When complete create shipment Step One form pallets with incorrect data
      | quantity   | description   | weight   | height   | expected_result_step_1_pallets   |
      | <quantity> | <description> | <weight> | <height> | <expected_result_step_1_pallets> |
    Then "<expected_result_step_1_pallets>" error message must displayed

    Examples: Step 1 Pallets
      | quantity | description                      | weight | height | expected_result_step_1_pallets                 |
      |          | Успешно заявихте куриер на Еконт | 33     | 1      | Моля, въведете броя палети  teeest             |
      | 3        |                                  | 33     | 55     | Моля въведете описание                         |
      | 3        | Успешно заявихте куриер на Еконт |        | 99     | Моля посочете общото тегло на пратката         |
      | 3        | Успешно заявихте куриер на Еконт | 33     |        | Моля посочете общата височина на всички палети |


  #Positive pallets path Step 1
  Scenario Outline: Create Shipment
    Given user is on create shipment page
    When complete create shipment Step One form pallets
      | quantity   | description   | weight   | height   | expected_result_step_1_pallets   |
      | <quantity> | <description> | <weight> | <height> | <expected_result_step_1_pallets> |
    Then "<expected_result_step_1_pallets>" you cah fill data in Step Two

    Examples: Step 1 Pallets
      | quantity | description                      | weight | height | expected_result_step_1_pallets                 |
      | 3        | Успешно заявихте куриер на Еконт | 33     | 212    | true                                           |
      |          | Успешно заявихте куриер на Еконт | 33     | 1      | Моля, въведете броя палети                     |
      | 3        |                                  | 33     | 55     | Моля въведете описание                         |
      | 3        | Успешно заявихте куриер на Еконт |        | 99     | Моля посочете общото тегло на пратката         |
      | 3        | Успешно заявихте куриер на Еконт | 33     |        | Моля посочете общата височина на всички палети |



  #Positive pallets path Step 2
  Scenario Outline: Create Shipment
    Given user is on create shipment page
    When complete create shipment Step One form pallets
      | quantity | description                      | weight | height | expected_result_step_1_pallets |
      | 3        | Успешно заявихте куриер на Еконт | 33     | 99     | true                           |
    And complete create shipment Step Two form for sender
      | Sender Name   | Sender Email   | Sender Phone   | Sender City   | Pickup Address   |
      | <sender name> | <sender email> | <sender phone> | <sender city> | <pickup address> |
    And complete create shipment Step Two form for receiver
      | Receiver Name   | Receiver Email   | Receiver Phone   | Receiver City   | Delivery Location  | expected result step 2   |
      | <receiver name> | <receiver email> | <receiver phone> | <receiver city> | <delivery address> | <expected result step 2> |
    Then "<expected result step 2>" you cah fill data in Step Tree

    Examples: Step 2
      | sender name  | sender email | sender phone  | sender city | pickup address  | receiver name   | receiver email | receiver phone | receiver city  | delivery address     | expected result step 2 |
      | Gosho Goshev | gosho@abv.bg | 0887 78 69 79 | Sofia       | bul. Vitosha 11 | Stoian Stoianov | stuio@abv.bg   | 0887 78 69 79  | [4000] Пловдив | bul. Hristo Botev 21 | true                   |


  #Positive packages path Step 1
  Scenario Outline: Create Shipment
    Given user is on create shipment page
    When complete create shipment Step One form packages
      | quantity   | type   | description   | weight   | expected_result_step_1_packages   |
      | <quantity> | <type> | <description> | <weight> | <expected_result_step_1_packages> |
    Then "<expected_result_step_1_packages>" you cah fill data in Step Two

    Examples: Step 1 Packages
      | quantity | type | description                      | weight | expected_result_step_1_packages |
      | 1        | 2    | Успешно заявихте куриер на Еконт | 3      | true                            |

  #Positive packages path Step 2
  Scenario Outline: Create Shipment
    Given user is on create shipment page
    When complete create shipment Step One form packages
      | quantity | type | description                      | weight | expected_result_step_1_packages |
      | 1        | 2    | Успешно заявихте куриер на Еконт | 3      | true                            |
    And complete create shipment Step Two form for sender
      | Sender Name   | Sender Email   | Sender Phone   | Sender City   | Pickup Address   |
      | <sender name> | <sender email> | <sender phone> | <sender city> | <pickup address> |
    And complete create shipment Step Two form for receiver
      | Receiver Name   | Receiver Email   | Receiver Phone   | Receiver City   | Delivery Location  | expected result step 2   |
      | <receiver name> | <receiver email> | <receiver phone> | <receiver city> | <delivery address> | <expected result step 2> |
    Then "<expected result step 2>" you cah fill data in Step Tree

    Examples: Step 2
      | sender name  | sender email | sender phone  | sender city | pickup address  | receiver name   | receiver email | receiver phone | receiver city  | delivery address     | expected result step 2 |
      | Gosho Goshev | gosho@abv.bg | 0887 78 69 79 | Sofia       | bul. Vitosha 11 | Stoian Stoianov | stuio@abv.bg   | 0887 78 69 79  | [4000] Пловдив | bul. Hristo Botev 21 | true                   |


  #Positive documents path Step 1
  Scenario Outline: Create Shipment
    Given user is on create shipment page
    When complete create shipment Step One form documents
      | Quantity   | Description   | expected result step 1   |
      | <quantity> | <description> | <expected result step 1> |
    Then "<expected result step 1>" you cah fill data in Step Two

    Examples: Step 1 Documents
      | quantity | description                      | expected result step 1 |
      | 3        | Успешно заявихте куриер на Еконт | true                   |

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

