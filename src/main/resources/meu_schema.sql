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
