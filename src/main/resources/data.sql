INSERT INTO TIPO_LOCALIDADE (DESCRICAO) VALUES ('Terminal de Integração');
INSERT INTO TIPO_LOCALIDADE (DESCRICAO) VALUES ('Rua');
INSERT INTO TIPO_LOCALIDADE (DESCRICAO) VALUES ('Avenida');

INSERT INTO PREFIXO (SIGLA, DESCRICAO) VALUES ( 'A', 'Alimentador' );
INSERT INTO PREFIXO (SIGLA, DESCRICAO) VALUES ( 'T', 'Troncal' );
INSERT INTO PREFIXO (SIGLA, DESCRICAO) VALUES ( 'C', 'Circular' );

INSERT INTO LOCALIDADE (SENTIDO, DESCRICAO, TIPO_LOCALIDADE_ID) VALUES ('Bairro', 'Terminal de Integração Cohama/Vinhais', 1);
INSERT INTO LOCALIDADE (SENTIDO, DESCRICAO, TIPO_LOCALIDADE_ID) VALUES ('Centro', 'Terminal de Integração Cohama/Vinhais', 1);
INSERT INTO LOCALIDADE (SENTIDO, DESCRICAO, TIPO_LOCALIDADE_ID) VALUES ('Bairro', 'Rua Jaú', 2);
INSERT INTO LOCALIDADE (SENTIDO, DESCRICAO, TIPO_LOCALIDADE_ID) VALUES ('Centro', 'Av. Mato Grosso', 3);
