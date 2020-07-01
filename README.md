# apicompasso
Este documento tem como finalidade auxiliar na instalação e uso do sistema de cadastro de pessoas.

========= Os Projetos ===========================================
Serviço REST = apicompasso
 https://github.com/mmss07/apicompasso.git 
O serviço esta hospedado em: https://dashboard.heroku.com/apps/mmss20200712

================================================================================== Banco de dados usado PostgreeSQL usuario = postgres senha = root

usuario para login no sistema login = basic senha = basic

======INICIO DOS END POINT DO SERVIÇO==============

GET - Consulta de Pessoas Remoto = https://mmss20200712.herokuapp.com/pessoas GET - Consulta de pessoas local = http://localhost:8090/pessoas GET - Pesquisa Pessoas Local Cpf = http://localhost:8090/pessoas/cpf/88200442420 GET - Pesquisa Pessoas Remoto Cpf = https://mmss20200712.herokuapp.com/pessoas/cpf/88200442420 POST - Inserir Pessoa Local = http://localhost:8090/pessoas POST - Inserir Pessoa Remoto = https://mmss20200712.herokuapp.com/pessoas PUT - Alterar Pessoa Local = http://localhost:8090/pessoas/8 PUT - Alterar Pessoa Remoto = https://mmss20200712.herokuapp.com/pessoas DELETE - Delete Pessoa Local = http://localhost:8090/3 DELETE - Delete Pessoa Remote = https://mmss20200712.herokuapp.com/pessoas/2

======FIM DOS END POINT DO SERVIÇO===================

Instale o banco de dados postgres e com o mesmo aberto efetue os seguites comandos:
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


==============================================FIM DO CRIPT DE BANCO ======================================
--Pronto banco instalado

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

#Script do BD
Instale o banco de dados postgres e com o mesmo aberto efetue os seguites comandos:
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

