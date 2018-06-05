Feature: Econt Partners functionality
  I would like to be able to apply for econt partnership program

  #Positive path
  Scenario Outline: Apply for econt partnership program
    Given user is on partnership program page
    When user read and accept terms
    And complete application form partnership program
      | Name   | Phone   | Email   | Town   | Area   | expected result   |
      | <name> | <phone> | <email> | <town> | <area> | <expected result> |

    Then an agree message "<expected result>" is displayed
    Examples:
      | name            | phone         | email        | town         | area       | expected result                               |
      | Ivan Ivan       | 0887 78 69 79 | gosho@abv.bg | [1000] София | Banishora  | Кандидатствахте успешно за откриване на офис. |
      | Stoian Stoianov | 0887 78 69 79 | abv@abv.bg   | [1000] София | Ivan Vazov | Кандидатствахте успешно за откриване на офис. |




  #Negative path
  Scenario Outline: Apply for econt partnership program
    Given user is on partnership program page
    When user read and accept terms
    And fill application form partnership program with invalid data
      | Name   | Phone   | Email   | Town   | Area   | expected result   |
      | <name> | <phone> | <email> | <town> | <area> | <expected result> |

    Then an error message "<expected result>" should displayed
    Examples:
      | name            | phone         | email        | town         | area       | expected result                                                                         |
      | I               | 0887 78 69 79 | gosho@abv.bg | [1000] София | Banishora  | Моля, попълнете две имена с дължина миниум 5 символа.                                   |
      | Stoian Stoianov | 8             | abv@abv.bg   | [1000] София | Ivan Vazov | Моля, попълнете валиден телефонен номер само с цифри. За код на държава използвайте 00. |
      | New User        | 0887 78 69 79 | a            | [1000] София | Mladost    | Моля, попълнете валиден имейл адрес. Например: ivan.ivanov@site.com                     |
      | New User        | 0887 78 69 79 | abv@abv.bg   |              | Mladost    | Моля, попълнете град.                                                                   |
      | New User        | 0887 78 69 79 | abv@abv.bg   | [1000] София |            | Моля, попълнете полето.                                                                 |

