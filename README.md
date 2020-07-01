# Api Compasso UOL

Essa API tem como finalidade fornecer serviço para as entidades Cliente e Cidade atendendo os seguintes requisitos:
1. Cadastrar cidade
2. Cadastrar cliente
3. Consultar cidade pelo nome
4. Consultar cidade pelo estado
5. Consultar cliente pelo nome
6. Consultar cliente pelo Id
7. Remover cliente
8. Alterar o nome do cliente
# Considere o cadastro com dados básicos:
	1. Cidades: nome e estado
	2. Cliente: nome completo, sexo, data de nascimento, idade e cidade onde mora.

# Script do BD

1. Caso deseje após a instalação do banco de dados postgres efetue os seguites comandos:
CREATE TABLE CLIENTE (
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR(100),
    SEXO VARCHAR(1),
    DATA_NASCIMENTO DATE,    
    IDATE INTEGER,
    CIDADE VARCHAR(60)
);

CREATE TABLE CIDADE (
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR(60),
    UF VARCHAR(2)
);	

## Instalação
1. É necessário o Postgres instalado versão 9.xxx ou superior!
2. O sistema ira criar as tabelas na sua inicialização! 
3. Esta sendo usado o database "compassodb" é necessário criar esse database no BD
4. Esta sendo usado o schema "public" sendo desnecessário criar esse schema no BD
5. A documentação da API pode ser vista na URL [SWAGGER - Spring Boot Compasso UOL]: http://localhost:8787/swagger-ui.html#

## Configuração para Desenvolvimento

Descreva como instalar todas as dependências para desenvolvimento e como rodar um test-suite automatizado de algum tipo. Se necessário, faça isso para múltiplas plataformas.

## Meta

Marcelo Mauricio Souza da Silva – [@marcelomauricioss](https://github.com/mmss07/apicompasso) – marcelomauricio@hotmail.com

Distribuído sob a licença  de MMSS S.A. Veja `LICENSE` para mais informações.

[https://github.com/mmss07/apicompasso]

## Contributing

1. Faça o _fork_ do projeto (<https://github.com/mmss07/apicompasso)>)
2. Crie uma _branch_ para sua modificação (`git checkout -b feature/fooBar`)
3. Faça o _commit_ (`git commit -am 'Add some fooBar'`)
4. _Push_ (`git push origin feature/fooBar`)
5. Crie um novo _Pull Request_

## EndPoints da aplicação

[SWAGGER - Spring Boot Compasso UOL]: http://localhost:8787/swagger-ui.html#
[Cadastrar cidade]: POST -  http://localhost:8787/api/cidades
[Cadastrar cliente]: POST - http://localhost:8787/api/clientes
[Consultar cidade pelo nome]: GET - http://localhost:8787/api/clientes/nome/{nome}
[Consultar cidade pelo estado]: GET - http://localhost:8787/api/cidades/uf/{uf}
[Consultar cliente pelo nome]: GET - http://localhost:8787/api/clientes/nome/Maranhao
[Consultar cliente pelo Id]: GET - http://localhost:8787/api/clientes/{id}
[Remover cliente]: DELETE - http://localhost:8787/api/clientes/{id}
[Alterar o nome do cliente]: PUT - http://localhost:8787/api/clientes/{id}

