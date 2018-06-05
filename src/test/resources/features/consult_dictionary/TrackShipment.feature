Feature: Track Shipment functionality
  I would like to be able to track shipment

  #Positive path
  Scenario Outline: Track shipment
    Given user is on track shipment page
    And click on gdpr agree button
    When user enters valid data
      | shipment number   | expected result   |
      | <shipment number> | <expected result> |

    Then an "№<expected result>" is displayed
    Examples:
      | shipment number      | expected result |
      | 222222               | 222222          |
      | 22222                | 22222           |

  #Negative path frontend validation
  Scenario Outline: Track shipment
    Given user is on track shipment page
    And click on gdpr agree button
    When user enters invalid data
      | shipment number   | expected result   |
      | <shipment number> | <expected result> |

    Then an error message "<expected result>" is displayed
    Examples:
      | shipment number | expected result                                                                                                                 |
      | sadasd          | Моля, въведете номер на пратка само с цифри. Ако имате повече от една, ги разделете със запетая или поставете всяка на нов ред. |
      | 1               | Моля, въведете номер на пратка само с цифри. Ако имате повече от една, ги разделете със запетая или поставете всяка на нов ред. |

  #Multiply shipments
  Scenario Outline: Track shipment
    Given user is on track shipment page
    And click on gdpr agree button
    When user enters valid data
      | shipment number   | expected result   |
      | <shipment number> | <expected result> |

    Then an "<expected result>" for multiply shipments is displayed
    Examples:
      | shipment number      | expected result |
      | 22222, 222222, 00001 | 22222           |