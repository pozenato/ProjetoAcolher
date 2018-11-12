-- Database: ProjetoAcolher

-- DROP DATABASE "ProjetoAcolher";

CREATE DATABASE "ProjetoAcolher"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
	
	


-- Table: public.adocao

-- DROP TABLE public.adocao;

CREATE TABLE public.adocao
(
    idadocao integer NOT NULL,
    idpessoa integer,
    idanimal integer,
    dataadocao date,
    CONSTRAINT adocao_pkey PRIMARY KEY (idadocao),
    CONSTRAINT fkanimal FOREIGN KEY (idanimal)
        REFERENCES public.animal (idanimal) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkpessoa FOREIGN KEY (idpessoa)
        REFERENCES public.pessoa (idpessoa) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.adocao
    OWNER to postgres;

-- Index: fki_fkanimal

-- DROP INDEX public.fki_fkanimal;

CREATE INDEX fki_fkanimal
    ON public.adocao USING btree
    (idanimal)
    TABLESPACE pg_default;

-- Index: fki_fkpessoa

-- DROP INDEX public.fki_fkpessoa;

CREATE INDEX fki_fkpessoa
    ON public.adocao USING btree
    (idpessoa)
    TABLESPACE pg_default;
	
	


-- Table: public.animal

-- DROP TABLE public.animal;

CREATE TABLE public.animal
(
    idanimal integer NOT NULL,
    nome text COLLATE pg_catalog."default",
    datanasc date,
    tipo numeric,
    status boolean,
    raca text COLLATE pg_catalog."default",
    CONSTRAINT animal_pkey PRIMARY KEY (idanimal)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.animal
    OWNER to postgres;
	
	
	

-- Table: public.pessoa

-- DROP TABLE public.pessoa;

CREATE TABLE public.pessoa
(
    idpessoa integer NOT NULL,
    nome text COLLATE pg_catalog."default",
    datanasc date,
    status boolean,
    datacadastro date,
    telefone text COLLATE pg_catalog."default",
    CONSTRAINT pessoa_pkey PRIMARY KEY (idpessoa)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.pessoa
    OWNER to postgres;
	
	
	
	
	
	
-- SEQUENCE: public.adocao_sequence

-- DROP SEQUENCE public.adocao_sequence;

CREATE SEQUENCE public.adocao_sequence;

ALTER SEQUENCE public.adocao_sequence
    OWNER TO postgres;
	
	
	
-- SEQUENCE: public.animal_sequence

-- DROP SEQUENCE public.animal_sequence;

CREATE SEQUENCE public.animal_sequence;

ALTER SEQUENCE public.animal_sequence
    OWNER TO postgres;
	
	
	
-- SEQUENCE: public.pessoa_sequence

-- DROP SEQUENCE public.pessoa_sequence;

CREATE SEQUENCE public.pessoa_sequence;

ALTER SEQUENCE public.pessoa_sequence
    OWNER TO postgres;