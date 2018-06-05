Feature: Order Courier functionality
  I would like to be able to order courier
#Negative path
  Scenario Outline: Order Courier
    Given user is on order courier page
    When click on gdpr agree button
    And complete order courier form
      | Name   | Phone   | Email   | City   | Address   | expected result   |
      | <name> | <phone> | <email> | <city> | <address> | <expected result> |

    Then an success order courier message "<expected result>" is displayed
    Examples:
      | name            | phone         | email        | city  | address               | expected result                  |
      | Ivan Ivanov     | 0887 78 69 79 | gosho@abv.bg | Sofia | ул. Ташкови Ливади 11 | Успешно заявихте куриер на Еконт |
      | Stoian Stoianov | 0887 78 69 79 | abv@abv.bg   | Sofia | ул. Ташкови Ливади 2  | Успешно заявихте куриер на Еконт |


  #Negative path
  Scenario Outline: Order Courier
    Given user is on order courier page
    When click on gdpr agree button
    And complete order courier form with invalid data
      | Name   | Phone   | Email   | City   | Address   | expected result   |
      | <name> | <phone> | <email> | <city> | <address> | <expected result> |

    Then an error message for order courier "<expected result>" should displayed
    Examples:
      | name            | phone         | email        | city  | address               | expected result                                                                         |
      | Iv              | 0887 78 69 79 | gosho@abv.bg | Sofia | ул. Ташкови Ливади 11 | Моля, попълнете две имена с дължина миниум 5 символа.                                   |
      |                 | 0887 78 69 79 | gosho@abv.bg | Sofia | ул. Ташкови Ливади 11 | Моля, попълнете вашите имена.                                                           |
      | Stoian Stoianov |               | abv@abv.bg   | Sofia | ул. Ташкови Ливади 2  | Моля, попълнете телефонен номер.                                                        |
      | Stoian Stoianov | 33223         | abv@abv.bg   | Sofia | ул. Ташкови Ливади 2  | Моля, попълнете валиден телефонен номер само с цифри. За код на държава използвайте 00. |
      | Stoian Stoianov | 0887 78 69 79 | abv@abv.bg   |       | ул. Ташкови Ливади 2  | Моля, попълнете град.                                                                   |
      | Stoian Stoianov | 0887 78 69 79 |              | Sofia | ул. Ташкови Ливади 2  | Моля, попълнете имейл адрес.                                                            |
      | Stoian Stoianov | 0887 78 69 79 | ss@ss        | Sofia | ул. Ташкови Ливади 2  | Моля, попълнете валиден имейл адрес. Например: ivan.ivanov@site.com                     |
      | Stoian Stoianov | 0887 78 69 79 | abv@asd.bg   | Sofia |                       | Моля, попълнете адрес.                                                                  |