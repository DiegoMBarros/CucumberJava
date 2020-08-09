# language: pt
#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
# (Comments)
#Sample Feature Definition Template

@tag @unitários
Funcionalidade: Locadora - Alugar filme
  Como um usuário
  Quero cadastrar aluguéis de filmes
  Para controlar preços e datas de entrega

  @tag1
  Cenário: Deve alugar um filme com sucesso
    #Dado um filme com estoque de 2 unidades
    Dado um filme
    | estoque | 2 		|
    | preco		| 3 		|
    | tipo 		| comum |
    #E que o preço do aluguel seja R$ 3
    Quando alugar
    Então o preço do aluguel será R$ 3
    #E a data de entrega será no dia seguinte
    E a data de entrega será em 1 dia
    E o estoque do filme será 1 unidade
    
  @tag2
  Cenário: Não deve alugar um filme sem estoque
    Dado um filme com estoque de 0 unidades
    Quando alugar
    Então não será possível por falta de estoque
    E o estoque do filme será 0 unidade
  
  #Scenario Outline
 	Esquema do Cenário: Deve dar condições conforme tipo do aluguel 
    Dado um filme com estoque de 2 unidades
    E que o preço do aluguel seja R$ <preco>
    E que o tipo do aluguel seja <tipo>
    Quando alugar
    Então o preço do aluguel será R$ <valor>
    E a data de entrega será em <qtdDias> dias
    E a pontuação recebida será de <pontuacao> pontos
  
  #Examples
  Exemplos:  
    | preco | tipo 			| valor | qtdDias | pontuacao |
    | 4     | extendido | 8		  | 3  		  | 2				  |
    | 4		  | comum		  | 4		  | 1			  | 1				  |
    | 10	  | extendido | 20	  | 3  		  | 2				  |
    | 5 	  | semanal   | 15	  | 7  		  | 3				  |
    
  #Cenário: Deve dar condições especiais para categoria extendida
    #Dado um filme com estoque de 2 unidades
    #E que o preço do aluguel seja R$ 4
    #E que o tipo do aluguel seja extendido
    #Quando alugar
    #Então o preço do aluguel será R$ 8
    #E a data de entrega será em 3 dias
    #E a pontuação recebida será de 2 pontos
    #
  #Cenário: Deve alugar para categoria comum
    #Dado um filme com estoque de 2 unidades
    #E que o preço do aluguel seja R$ 4
    #E que o tipo do aluguel seja comum
    #Quando alugar
    #Então o preço do aluguel será R$ 4
    #E a data de entrega será em 1 dia
    #E a pontuação recebida será de 1 ponto