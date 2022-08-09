@Netflix
Feature: Apis de Netflix para consumo masivo

  @t1
  Scenario: Operador lista clientes de Netflix
    Given que la aplicación esta operativa
    When obtiene la lista: 2 de clientes suscritos
    Then valida que la respuesta es 200

  @t2
  Scenario: Operador no encuentra cliente en la lista
    Given que la aplicación esta operativa
    When obtiene al cliente: 15 suscrito
    Then valida que la respuesta es 404

  @t3
  Scenario: Operador valida su correo
    Given que la aplicación esta operativa
    When obtiene al cliente: 2 suscrito
    Then valida que el correo es "janet.weaver@reqres.in"

  @t4
  Scenario: Obtener lista como objeto java
    Given que la aplicación esta operativa
    When obtiene la lista: 1 de clientes suscritos como objeto
    Then valida que la respuesta es 200

  @t5
  Scenario Outline: Obtener un cliente especifico y comparar el campo nombre y apellido y finalmente la respuesta obtenida
    Given que la aplicación esta operativa
    When obtiene al cliente: <id> suscrito
    Then valida que el nombre es "Rachel"
    Then valida que el apellido es "Howell"
    Then valida que la respuesta es 200

    Examples:
      | id |
      | 12 |

  @t6
  Scenario: Insertar un cliente en el servicio
    Given que la aplicación esta operativa
    And inicializo request en post
    And agrega la cabecera key: "Content-Type", y valor: "application/json;charset=UTF-8"
    And inserto los valores del cliente con nombre "Alexis" y trabajo "QA"
    And ejecuta la creacion "users"
    Then valida que la respuesta es 201
    And valida el "name" sea "Alexis"
    And valida el "job" sea "QA"
