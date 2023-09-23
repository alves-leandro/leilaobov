# BovWallet - API

API desenvolvida utilisando Java Spring Boot, banco de dados psql

### A API foi desenvolvida com o intuito de gerenciar clientes e aquisições de animais.

# EndPoints de Client: 

## POST - localhost:8080/api/clients

### Body Example:

{
	"name": "Abcdário da Silva",
	"cpf": "12345678921",
	"email": "abc@mail.com",
	"type": "STOCK_INVESTOR"
}

## GET - localhost:8080/api/clients

### Body Example:

NO BODY CONTENT

## GET BY ID - localhost:8080/api/clients/:ID

### Body Example:

NO BODY CONTENT

## PUT - localhost:8080/api/clients/:ID

### Body Example:

{
	"name": "Abcdário da Costa",
	"cpf": "12345678921",
	"email": "abc@mail.com",
	"type": "STOCK_INVESTOR"
}


## DELETE - localhost:8080/api/clients/:ID

### Body Example:

NO BODY CONTENT

# EndPoints de Cards:
Faz adição de animais para a carteira do Cliente

## POST - localhost:8080/card-info/1

### Body Example:

{
    "race": "Raça do Card",
    "age": 6,
    "price": 25.99,
    "urlImage": "https://example.com/imagem.png"
}

## PUT - localhost:8080/card-info/:ID

### Body Example:

{
    "race": "Nova Raça do Card",
    "age": 4,
    "price": 29.99,
    "urlImage": "https://example.com/nova-imagem.png"
}


## DELETE - localhost:8080/api/card-info/:ID

### Body Example:

NO BODY CONTENT

## Desenvolvedor:

### *Leandro Vasconcelos Alves* ##
* LinkedIn: https://www.linkedin.com/in/leandro-alves85/
* Github: https://github.com/alves-leandro
* E-mail: l.alves85@live.com
* Portifólio: https://leandro-portifolio.vercel.app/
