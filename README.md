# StudInClass-Back-End
Necessário configurar o server WildFly para a utilização.
Por falta de tempo para o desenvolvimento, o usuário e senha ficam cadastrados no banco.

O BD foi criado com Postgres, o script de criação das 3 tabelas está descrito a seguir:

CREATE TABLE public.pessoa
(
    id integer NOT NULL DEFAULT nextval('pessoa_id_seq'::regclass),
    nome character varying(100) COLLATE pg_catalog."default",
    turma character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT pessoa_pkey PRIMARY KEY (id)
)

CREATE TABLE public.turma
(
    id integer NOT NULL DEFAULT nextval('turma_id_seq'::regclass),
    nome character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT turma_pkey PRIMARY KEY (id)
)

CREATE TABLE public.usuario
(
    id integer NOT NULL DEFAULT nextval('usuario_id_seq'::regclass),
    nome character varying(100) COLLATE pg_catalog."default",
    senha character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT usuario_pkey PRIMARY KEY (id)
)
