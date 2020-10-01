
CREATE SEQUENCE s_categoria
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE s_categoria OWNER TO postgres;

CREATE TABLE t_categoria
(
  id_categoria BIGINT NOT NULL,
  nome character varying(40),
  CONSTRAINT pk_grupo PRIMARY KEY (id_categoria)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE t_categoria OWNER TO postgres;

insert into t_categoria values (nextval('s_categoria'), 'LAZER');
insert into t_categoria values (nextval('s_categoria'), 'ALIMENTAÇÃO');
insert into t_categoria values (nextval('s_categoria'), 'SUPERMERCADO');
insert into t_categoria values (nextval('s_categoria'), 'FARMACIA');

