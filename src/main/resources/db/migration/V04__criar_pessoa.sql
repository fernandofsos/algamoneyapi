
CREATE SEQUENCE s_pessoa
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE s_pessoa OWNER TO postgres;

CREATE TABLE t_pessoa
(
  id_pessoa BIGINT NOT NULL,
  nome character varying(50),
  CONSTRAINT pk_pessoa PRIMARY KEY (id_pessoa)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE t_pessoa OWNER TO postgres;

ALTER TABLE public.t_pessoa ADD COLUMN flg_ativo boolean NOT NULL DEFAULT true;
ALTER TABLE public.t_pessoa ADD COLUMN logradouro varchar(50) NOT NULL;
ALTER TABLE public.t_pessoa ADD COLUMN numero integer NOT NULL;
ALTER TABLE public.t_pessoa ADD COLUMN complemento varchar(50) NOT NULL;
ALTER TABLE public.t_pessoa ADD COLUMN bairro varchar(50) NOT NULL;
ALTER TABLE public.t_pessoa ADD COLUMN cep varchar(8) NOT NULL;
ALTER TABLE public.t_pessoa ADD COLUMN cidade varchar(50) NOT NULL;
ALTER TABLE public.t_pessoa ADD COLUMN estado varchar(8) NOT NULL;    

insert into t_pessoa  values (nextval('s_pessoa'), 'SERGIO', true, 'rua dos cachorros', 1010,'teste', 'maraponga','60811120', 'fortaleza','ceara');
