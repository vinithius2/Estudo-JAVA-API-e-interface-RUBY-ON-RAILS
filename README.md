### URLS

#### GET - Pega uma lista de pessoas
/java-rest-api/rest/pessoas/list 

#### GET - Traz uma pessoa por ID
/java-rest-api/rest/pessoas/list/{id}/

#### DELETE - Deleta uma pessoa por ID
/java-rest-api/rest/delete/{id}/

#### POST - Adiciona uma pessoa
/java-rest-api/rest/pessoas/add

#### PUT - Edita uma pessoa
/java-rest-api/rest/pessoas/edit/{id}

#### Estrutura JSON
{
	"cnh": "00000000000",
	"cpf": "00000000000",
	"nome": "Teste"
	"id": 0
}

#### Versão do banco usado - PostgreSQL 10.3

#### Script de criação de tabela

CREATE TABLE public."tb_pessoas"
(
    id_pessoa SERIAL NOT NULL,
    cnh varchar(255) NOT NULL UNIQUE,
    cpf varchar(255) NOT NULL UNIQUE,
    nome varchar(255) NOT NULL,
    CONSTRAINT tb_pessoas_pkey PRIMARY KEY (id_pessoa)
)
