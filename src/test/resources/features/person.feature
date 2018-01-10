#language: pt
Funcionalidade: CRUD pessoa  
    
Cenario: Consultando pessoa pelo id
	Dado que existe um cliente cadastrado com o primeiro nome "Edivilson", segundo nome "Dalacosta" e idade de 25 
	Quando o cliente consulta pelo id
	Entao o cliente recebe o status code 200
	E o cliente recebe o primeiro "Edivilson", segundo nome "Dalacosta" e idade de 25