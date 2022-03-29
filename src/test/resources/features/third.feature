Feature: Более сложный тест

  Background:
    Given Открыть браузер
    And страница логина открыта

  Scenario: Использование AND в Given
    Given user logged in


  Scenario: Прстой тест со всеми ключевыми словами
    Then username field is displayed