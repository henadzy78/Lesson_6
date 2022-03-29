Feature: Начальный тест для изучения Cucumber

  Scenario: Простой тест без тела

  Scenario: Прстой тест с Given
    Given Открыть браузер

  Scenario: Прстой тест с Given и When
    Given Открыть браузер
    When страница логина открыта

  Scenario: Прстой тест со всеми ключевыми словами
    Given Открыть браузер
    When страница логина открыта
    Then username field is displayed


