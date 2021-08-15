Feature: Cálculo entre cidades

  Background:
    * url 'http://localhost:8080'

  Scenario: lista todas as cidades

    Given path 'api/v1/cities'
    When method GET
    Then status 200
    And match responseType == 'json'

  Scenario: calcula a distância entre Ibabe e São Carlos por pontos

    Given path 'api/v1/distances/by-points'
    And params { from: '4929', to: '5254'}
    When method GET
    Then status 200
    And match response == '7.57102293200459'

  Scenario: calcula a distância entre Ibabe e São Carlos por cube

    Given path 'api/v1/distances/by-cube'
    And params { from: '4929', to: '5254'}
    When method GET
    Then status 200
    And match response == '12426.810463465172'

  Scenario: calcula a distância entre Ibabe e São Carlos em metros

    Given path 'api/v1/distances/by-math'
    And params { from: '4929', to: '5254', 'unit': 'METERS'}
    When method GET
    Then status 200
    And match response == '12426.810463465648'

  Scenario: calcula a distância entre Ibabe e São Carlos em quilômetros

    Given path 'api/v1/distances/by-math'
    And params { from: '4929', to: '5254', 'unit': 'METERS'}
    When method GET
    Then status 200
    And match response == '12426.810463465648'

  Scenario: calcula a distância entre Ibabe e São Carlos em milhas

    Given path 'api/v1/distances/by-math'
    And params { from: '4929', to: '5254', 'unit': 'METERS'}
    When method GET
    Then status 200
    And match response == '12426.810463465648'
