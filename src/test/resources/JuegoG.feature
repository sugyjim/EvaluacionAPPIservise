@Jugoslav
Feature: validar el status de la plataforma
  Background: la URL del servicio es " https://www.freetogame.com/api/games"

  @1
  Scenario : validacion del servicio
    Given valido que el servicio responde 200
    When  entro a la pagina
    Then Accedo a la lista de juegos


  @test2
  Scenario:caso de error
    Given que tengo una consulta fallida
    When se ingresa un id
    Then  muestra un codigo de error 404
