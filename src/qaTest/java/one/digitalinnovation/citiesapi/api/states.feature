Feature: Gerencia os estados

  Background:
    * url 'http://localhost:8080'

  Scenario: lista todos os estados

    Given path 'api/v1/states'
    When method GET
    Then status 200
    And match responseType == 'json'
    And match $response contains {id: 26, name: 'São Paulo', uf: 'SP', ibge: 35, country: {id: 1, name: 'Brazil', portugueseName: 'Brasil', code: 'BR', bacen: 1058}, ddd: [11,12,13,14,15,16,17,18,19]}
