# language: pt
# encoding: utf-8

Funcionalidade: Realizar pesquisas no site da OLX

	Cenario: Realizar pesquisa atraves da aba de busca
		Dado que eu esteja na pagina inicial
		Quando eu coloco infornacoes validas
		|Dress|		
		Entao minha busca e realizada
		
	Esquema do Cenario: Realizar pesquisa com informaçoes errada
		Dado que eu esteja na pagina inicial
		Quando eu coloco a <informacoes> invalidas 
		Entao minha busca nao e realizada e uma mensagem de erro aparece
		|No results were found for your search|
		
		Exemplos:
		|					informacoes				|
		|						"Teste"					|
		|"<script>Alert();</script>"|
		|					"!@#$%&*()"				|
		