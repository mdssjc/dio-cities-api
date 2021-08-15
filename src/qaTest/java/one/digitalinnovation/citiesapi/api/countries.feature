Feature: Gerencia os países

  Background:
    * url 'http://localhost:8080'

  Scenario: lista todos os países

    Given path 'api/v1/countries'
    When method GET
    Then status 200
    And match responseType == 'json'
    And match $response contains {id: 1, name: 'Brazil', portugueseName: 'Brasil', code: 'BR', bacen: 1058}
