# language: pt
# enconding: utf-8

Funcionalidade: Acessar Conta

	Cenario: Acessar corretamente a conta dentro do automation practice
		Dado que eu esteja na pagina de home  	
		Quando eu tento acessar minha conta
		E tenha os dados validos 
		| fewonas288@64ge.com | Saudade@@ |
		Entao eu me logo na minha conta

	Cenario: Não conseguir acessar a conta dentro do olx
		Dado que eu esteja na pagina de home
		Quando eu tento acessar minha conta
		E possuo dados invalidos
		| fewonas288@64ge.com | SenhaErrada |
		Entao eu nao consigo me logar
		E uma mensagem de erro aparece
		|Authentication failed.|
