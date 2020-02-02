Feature: Testar os triangulos disponiveis
  
Scenario Outline: Testar triangulo
    Given estar na pagina de preenchimento
    When preencher os <lado1> e <lado2> e <lado3>
    Then o sistema verifica o resultado
    
Examples:
|lado1|lado2|lado3|
|1|2|3|
|1|1|1|
|0|1|3|
|1|1|2|