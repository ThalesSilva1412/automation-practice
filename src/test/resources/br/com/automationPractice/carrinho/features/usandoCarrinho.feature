# language: pt
# encoding: utf-8

Funcionalidade: Uso do carrinho
	Eu como usuario, quero colocar produtos no carrinho, edita-los e remove-los
	
	Cenario: Validar se o carrinho esta recebendo os produtos corretamente
		Dado que eu esteja logado
		| fewonas288@64ge.com | Saudade@@ |
		Quando pesquisar um produto
		|Dress|
		E vizualizo ele
		E coloco ele no carrinho
		Entao o carrinho recebera o produto
		
		Cenario: Validar se o carrinho esta removendo os produtos corretamente
		Dado que eu esteja logado
		| fewonas288@64ge.com | Saudade@@ |
		E com um produto no carrinho
		|Dress|
		Quando eu tento remover o produto
		Entao o carrinho fica vazio
