CREATE DATABASE pessoaesporte;
USE pessoaesporte;
CREATE TABLE esporte(
    nome_e VARCHAR(30) not null  PRIMARY KEY
);
CREATE TABLE pessoas(
	id_pessoa INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    pessoa_nome VARCHAR(30),
    idade INT,
    sexo VARCHAR(1),
    endereço VARCHAR(30),
    vegetariano BOOLEAN,
    fk_esporte_nome VARCHAR(30) NOT NULL,    
    FOREIGN KEY (fk_esporte_nome) REFERENCES esporte (esporte_nome)
);

DROP DATABASE pessoaesporte; 
select * from pessoas;
 