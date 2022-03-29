Feature: Более сложный тест

  Scenario: Использование AND в Given
    Given Открыть браузер
    And страница логина открыта

  Scenario: Прстой тест со всеми ключевыми словами
    Given Открыть браузер
    And страница логина открыта
    Then username field is displayed