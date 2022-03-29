Feature: Параметризированные тесты

  Scenario: Параметризация
    Given Открыть браузер
    And страница логина открыта
    When user "atrostyanko+StandardUser@gmail.com" with password "1234567" logged in
    Then add project button is displayed
    And username is "Alex Tros"
    And project id is 23

  Scenario Outline: Таблицы
    Given открыт браузер
    * страница логина открыта
    When user "<username>" with password "<password>" logged in
    Then username is "<visibleText>"
    Examples:
      | username                           | password             | visibleText                        |
      | atrostyanko+0401@gmail.com         | QqtRK9elseEfAk6ilYcJ | Alex Tros                          |
      | atrostyanko+StandardUser@gmail.com | 1234567              | atrostyanko+StandardUser@gmail.com |