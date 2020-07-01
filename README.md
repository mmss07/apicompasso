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
