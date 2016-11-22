/* Script SQL para criação e povoamento de tabelas
Grupo:
	Gabriel		(gvmgs)
	Jailson		(jcd2)
	Leonardo	(las3)
	Marcos		(msb5)
	Matheus		(mlrbc)
	Moabe		(mrov)
	Thomas 		(tafm)
	Vinicius	(vrm)
*/
/*ESBOÇO DAS ASSINATURAS DOS TIPOS NÃO É UMA VERSÃO FINAL*/

-- 2 - CRIAÇÃO DOS TIPOS

-- TELEFONE
CREATE OR REPLACE TYPE tp_fone AS OBJECT(
  telefone varchar2(50)
)NOT FINAL;
/

-- VARRAY TELEFONES
CREATE OR REPLACE TYPE varray_fones AS VARRAY(5) OF tp_fone;
/

--ENDERECO
CREATE OR REPLACE TYPE  tp_endereco AS OBJECT(
  cep varchar2(30),
  cidade varchar2(30),
  bairro varchar2(50),
  rua varchar2(50),
  numero varchar2(20)
)NOT FINAL;
/


-- PESSOA
CREATE OR REPLACE TYPE tp_pessoa AS OBJECT(
  cpf varchar2(15),
  nome varchar2(50),
  datanascimento date,
  sexo char(1),
  fones varray_fones,
  endereco tp_endereco,

  MEMBER PROCEDURE exibir_detalhes (SELF tp_pessoa)
)NOT FINAL;
/

CREATE OR REPLACE TYPE BODY tp_pessoa AS
	MEMBER PROCEDURE exibir_detalhes (SELF tp_pessoa) IS
	n INTEGER;
	i INTEGER;
	BEGIN
		DBMS_OUTPUT.PUT_LINE('Informações pessoais');
		DBMS_OUTPUT.PUT_LINE('CPF:' || cpf);
		DBMS_OUTPUT.PUT_LINE('NOME:' || nome);
		DBMS_OUTPUT.PUT_LINE('DATA DE NASCIMENTO:' || TO_CHAR(datanascimento));
		DBMS_OUTPUT.PUT_LINE('SEXO:' || sexo);

		n := fones.count;
		DBMS_OUTPUT.PUT_LINE('Telefone(s):');
		IF n > 0 THEN
			FOR i in 1..n LOOP
				DBMS_OUTPUT.PUT_LINE(i || ')' || fones(i).telefone);
			END LOOP;
		ELSE
			DBMS_OUTPUT.PUT_LINE('SEM REGISTRO DE TELEFONES');
		END IF;

		DBMS_OUTPUT.PUT_LINE('Endereço:');
		DBMS_OUTPUT.PUT_LINE('CEP:' || endereco.cep);
		DBMS_OUTPUT.PUT_LINE('Cidade:' || endereco.cidade);
		DBMS_OUTPUT.PUT_LINE('Bairro:' || endereco.bairro);
		DBMS_OUTPUT.PUT_LINE('Rua:' || endereco.rua);
		DBMS_OUTPUT.PUT_LINE('Número:' || endereco.numero);
	END;
END;
/


-- PLANO
CREATE OR REPLACE TYPE tp_plano AS OBJECT(
	descricao varchar2(50),
	preco number(5,2)
)NOT FINAL;
/

-- ASSINANTE
CREATE OR REPLACE TYPE tp_assinante UNDER tp_pessoa(
  plano REF tp_plano,
	dataAssinatura date
)NOT FINAL;
/


-- FUNCIONARIO
CREATE OR REPLACE TYPE tp_funcionario UNDER tp_pessoa(
	salario number(10,2),
	dataAdmissao date
)NOT FINAL;
/


-- TITULACAO
CREATE OR REPLACE TYPE tp_titulacao AS OBJECT(
  data date,
	instituicao varchar2(50),
	grau varchar2(30)
)NOT FINAL;
/

-- JORNALISTA
CREATE OR REPLACE TYPE tp_jornalista UNDER tp_funcionario(
  mtb varchar2(20),
  supervisor REF tp_jornalista,
  titulacao tp_titulacao
)NOT FINAL;
/

-- EDICAO
CREATE OR REPLACE TYPE tp_edicao AS OBJECT(
  numero integer,
	chefe REF tp_jornalista,
	data date
)NOT FINAL;
/

--SECAO
CREATE OR REPLACE TYPE tp_secao AS OBJECT(
  nome varchar2(30),
	coordenador REF tp_jornalista
)NOT FINAL;
/

--MATERIA
CREATE OR REPLACE TYPE tp_materia AS OBJECT(
  id integer,
	secao REF tp_secao,
	edicao REF tp_edicao,
	titulo varchar2(255),
	conteudo CLOB,
	anexos CLOB
)NOT FINAL;
/

--JORNTRABMATERIA
CREATE OR REPLACE TYPE tp_jorntrabmateria AS OBJECT(
	jornalista REF tp_jornalista,
	materia REF tp_materia
)NOT FINAL;
/

--PREMIACAO
CREATE OR REPLACE TYPE tp_premiacao AS OBJECT(
  id integer,
  evento varchar2(50),
  data date,
  categoria varchar2(50)
)NOT FINAL;
/

--(JORNALISTA <ESCREVE> MATERIA) <GANHA> PREMIACAO (GANHA) (DISCUTIR DEPOIS)
CREATE OR REPLACE TYPE tp_ganha AS OBJECT(
  id integer,
  premiacao REF tp_premiacao,
  materia REF tp_jorntrabmateria
)NOT FINAL;
/

-- FOTOS
CREATE OR REPLACE TYPE tp_fotos AS OBJECT(
  id integer,
	materia REF tp_materia,
	foto BLOB
)NOT FINAL;
/

CREATE OR REPLACE TYPE tp_nt_fotos AS TABLE OF tp_fotos;
/

-- FOTOGRAFO
CREATE OR REPLACE TYPE tp_fotografo UNDER tp_funcionario(
  certificado BLOB,
  fotos tp_nt_fotos
)NOT FINAL;
/

-- 3 - Sequences

CREATE SEQUENCE ID_GANHA
    minvalue 1
    maxvalue 9999999999
    start with 1
    increment by 1
    nocache
    cycle
;


CREATE SEQUENCE ID_EDICAO
	minvalue 1
	maxvalue 9999999999
	start with 1
	increment by 1
	nocache
	cycle
;

CREATE SEQUENCE ID_MATERIA
	minvalue 1
	maxvalue 9999999999
	start with 1
	increment by 1
	nocache
	cycle
;

CREATE SEQUENCE ID_PREMIACAO
	minvalue 1
	maxvalue 9999999999
	start with 1
	increment by 1
	nocache
	cycle
;

CREATE SEQUENCE ID_FOTO
	minvalue 1
	maxvalue 9999999999
	start with 1
	increment by 1
	nocache
	cycle
;




/* LEMBRAR DE USAR WITH ROWID REFERENCES NA CRIAÇÃO DAS TABELAS PARA AS CHAVES ESTRANGEIRAS*/

-- 3 - Criação das tabelas dos tipos definidos acima.

-- CREATE TABLE tb_fone of tp_fone;

-- CREATE TABLE tb_endereco of tp_endereco(cep NOT NULL, cidade NOT NULL, bairro NOT NULL, rua NOT NULL, numero NOT NULL);

-- CREATE TABLE tb_pessoa of tp_pessoa(cpf PRIMARY KEY, nome NOT NULL,datanascimento NOT NULL, sexo NOT NULL,endereco NOT NULL);

CREATE TABLE tb_plano of tp_plano(descricao PRIMARY KEY, preco NOT NULL);

CREATE TABLE tb_assinante of tp_assinante(cpf PRIMARY KEY, nome NOT NULL,datanascimento NOT NULL, sexo NOT NULL,endereco NOT NULL, plano WITH ROWID REFERENCES tb_plano NOT NULL, dataAssinatura NOT NULL);

-- CREATE TABLE tb_funcionario of tp_funcionario(cpf PRIMARY KEY, nome NOT NULL,datanascimento NOT NULL, sexo NOT NULL,endereco NOT NULL,salario NOT NULL, dataAdmissao NOT NULL);

-- talvez fotos seja uma nested table em fotografo, pensar nisso depois
-- CREATE TABLE tb_fotos of tp_fotos(id PRIMARY KEY, fotografo WITH ROWID REFERENCES tp_fotografo,materia WITH ROWID REFERENCES tp_materia);


CREATE TABLE tb_fotografo of tp_fotografo(cpf PRIMARY KEY, nome NOT NULL,datanascimento NOT NULL, sexo NOT NULL,endereco NOT NULL,salario NOT NULL, dataAdmissao NOT NULL)NESTED TABLE fotos STORE AS Portifolio;

-- CREATE TABLE tb_titulacao of tp_titulacao(data NOT NULL, instituicao NOT NULL, grau NOT NULL);

CREATE TABLE tb_jornalista of tp_jornalista(cpf PRIMARY KEY, nome NOT NULL,datanascimento NOT NULL, sexo NOT NULL,endereco NOT NULL,salario NOT NULL, dataAdmissao NOT NULL,mtb NOT NULL,supervisor WITH ROWID REFERENCES tb_jornalista);

CREATE TABLE tb_edicao of tp_edicao(numero PRIMARY KEY, chefe WITH ROWID REFERENCES tb_jornalista NOT NULL,data NOT NULL);

CREATE TABLE tb_secao of tp_secao(nome NOT NULL, coordenador WITH ROWID REFERENCES tb_jornalista);

CREATE TABLE tb_materia of tp_materia(id PRIMARY KEY, secao WITH ROWID REFERENCES tb_secao, edicao WITH ROWID REFERENCES tb_edicao,titulo NOT NULL);

CREATE TABLE tb_jorntrabmateria of tp_jorntrabmateria(jornalista WITH ROWID REFERENCES tb_jornalista NOT NULL, materia WITH ROWID REFERENCES tb_materia NOT NULL);

CREATE TABLE tb_premiacao of tp_premiacao(id PRIMARY KEY, evento NOT NULL, data NOT NULL, categoria NOT NULL);

CREATE TABLE tb_ganha of tp_ganha(premiacao WITH ROWID REFERENCES tb_premiacao, materia WITH ROWID REFERENCES tb_jorntrabmateria);

-- 4 - Povoamento (melhor parte, sqn)

-- Plano

INSERT INTO tb_plano VALUES('Básico',   10.00);
INSERT INTO tb_plano VALUES('Combo',    15.00);
INSERT INTO tb_plano VALUES('Ultra',    10.00);

-- Assinante


INSERT INTO tb_assinante VALUES('123456789-45', 'Leonardo Alves', TO_DATE('16/12/1996', 'dd/MM/yyyy'), 'M', varray_fones(tp_fone('081-982661311'), tp_fone('074-9818-9022'),tp_fone('074-999473373')), tp_endereco('44900000', 'Irecê','Bairro','Rua Aquela Mesma','16') ,(Select REF(p) from tb_plano p where p.descricao = 'Combo'),   TO_DATE('05/04/2013', 'dd/MM/yyyy'));

INSERT INTO tb_assinante VALUES('888777666-85', 'Marcos Barreto', TO_DATE('16/08/1996', 'dd/MM/yyyy'), 'M', varray_fones(tp_fone('055-946223584'), tp_fone('081-994687752')), tp_endereco('99212300', 'Irecê',      	'Bairro2',          	'Rua do Beco',      	'188') ,(Select REF(p) from tb_plano p where p.descricao = 'Básico'),   TO_DATE('12/09/2015', 'dd/MM/yyyy'));

INSERT INTO tb_assinante VALUES('456228741-99', 'Afonso Gomes', TO_DATE('09/05/1987', 'dd/MM/yyyy'), 'M', NULL, tp_endereco('05465203', 'São Paulo', 'Liberdade', 'Av.Paulista',  '548') ,(Select REF(p) from tb_plano p where p.descricao = 'Básico'),   TO_DATE('12/09/2015', 'dd/MM/yyyy'));

INSERT INTO tb_assinante VALUES('648752006-56', 'Roberto Andrade', TO_DATE('30/05/1990', 'dd/MM/yyyy'), 'M', NULL, tp_endereco('54862066', 'Rio de Janeiro', 'Leblon', 'Rua 10', '9') ,(Select REF(p) from tb_plano p where p.descricao = 'Ultra'),   TO_DATE('15/06/2012', 'dd/MM/yyyy'));

INSERT INTO tb_assinante VALUES('160742365-48', 'Alice Ayres',TO_DATE('01/01/2000', 'dd/MM/yyyy'), 'F', NULL, tp_endereco('98212340', 'Irecê', 'Recanto',  	'Antonio Cardoso', '61') ,(Select REF(p) from tb_plano p where p.descricao = 'Básico'),   TO_DATE('01/12/2012', 'dd/MM/yyyy'));

INSERT INTO tb_assinante VALUES('283492009-11', 'Ana Maria',TO_DATE('10/05/1997', 'dd/MM/yyyy'), 'F', varray_fones(tp_fone('091-936547785'), tp_fone('081-912003600')), tp_endereco('54896211', 'Brasília',   	'Centro',  'Rua JK',  '7') ,(Select REF(p) from tb_plano p where p.descricao = 'Básico'),   TO_DATE('21/02/2008', 'dd/MM/yyyy'));

INSERT INTO tb_assinante VALUES('945632778-12', 'Ana Alves',TO_DATE('02/02/1987', 'dd/MM/yyyy'), 'F', NULL, tp_endereco('66975233', 'São Paulo', 'Morumbi',  'Av. Santo Antônio',	'400') ,(Select REF(p) from tb_plano p where p.descricao = 'Básico'),   TO_DATE('07/10/2016', 'dd/MM/yyyy'));

INSERT INTO tb_assinante VALUES('549316775-00', 'Bob Jones',TO_DATE('05/06/1988', 'dd/MM/yyyy'), 'M', NULL , tp_endereco('75264977', 'Acre', 'Floresta', 'Árvore',  '7') ,(Select REF(p) from tb_plano p where p.descricao = 'Combo'),   TO_DATE('20/07/2011', 'dd/MM/yyyy'));

INSERT INTO tb_assinante VALUES('654823004-11', 'Amanda Nunes', TO_DATE('06/04/1944', 'dd/MM/yyyy'), 'F', NULL , tp_endereco('65482236', 'Recife', 'CDU', 'Polidoro',         	'344') ,(Select REF(p) from tb_plano p where p.descricao = 'Combo'),   TO_DATE('16/01/2015', 'dd/MM/yyyy'));

INSERT INTO tb_assinante VALUES('684997235-01', 'João Silva', TO_DATE('10/07/1980', 'dd/MM/yyyy'), 'M', varray_fones(tp_fone('021-994627756'), tp_fone('021-956317785'),tp_fone('055-976331520')), tp_endereco('95877236', 'Recife',     	'CDU',              	'UFPE',             	'455') ,(Select REF(p) from tb_plano p where p.descricao = 'Ultra'),   TO_DATE('23/05/2014', 'dd/MM/yyyy'));


-- Fotografo

INSERT INTO tb_fotografo VALUES('234908724-88', 'Vitor Pereira',        TO_DATE('15/12/1995', 'dd/MM/yyyy'),    'M',    NULL ,  tp_endereco('23456000', 'Recife',           'Bairro do Caxanga',        'Avenida Caxangá',      '230'), 1500.00,    TO_DATE('13/10/2014', 'dd/MM/yyyy'),    NULL,   NULL);
INSERT INTO tb_fotografo VALUES('171615142-21', 'Amanda Kezia',         TO_DATE('23/10/1994', 'dd/MM/yyyy'),    'F',    NULL ,  tp_endereco('77800000', 'Recife',           'Várzea',                   'João F. Lisboa',       '120'), 1450.00,    TO_DATE('30/11/2015', 'dd/MM/yyyy'),    NULL,   NULL);
INSERT INTO tb_fotografo VALUES('881391402-21', 'Letícia Silva',        TO_DATE('01/11/1980', 'dd/MM/yyyy'),    'F',    NULL ,  tp_endereco('99134817', 'Fortaleza',        'Padre Miguel',             'Marechal Deodoro',     '23'),  1600.00,    TO_DATE('20/02/2014', 'dd/MM/yyyy'),    NULL,   NULL);
INSERT INTO tb_fotografo VALUES('143234503-91', 'Cláudio Roberto',      TO_DATE('09/10/1977', 'dd/MM/yyyy'),    'M',    NULL ,  tp_endereco('88123491', 'Caruaru',          'Centro',                   'Agamenon Magalhães',   '23'),  2000.00,    TO_DATE('29/08/2012', 'dd/MM/yyyy'),    NULL,   NULL);
INSERT INTO tb_fotografo VALUES('144319847-45', 'Antônio Flávio',       TO_DATE('08/03/1990', 'dd/MM/yyyy'),    'M',    NULL ,  tp_endereco('23495302', 'Palmas',           'Floresta',                 'Prefeito Miguel',      '621'), 1400.00,    TO_DATE('06/01/2016', 'dd/MM/yyyy'),    NULL,   NULL);
INSERT INTO tb_fotografo VALUES('238432464-99', 'Priscila Alcântara',   TO_DATE('25/06/1979', 'dd/MM/yyyy'),    'F',    NULL ,  tp_endereco('83475843', 'Florianópolis',    'Mangue',                   'Madre Tereza',         '33'),  1500.00,    TO_DATE('25/10/2012', 'dd/MM/yyyy'),    NULL,   NULL);
INSERT INTO tb_fotografo VALUES('234353455-44', 'Maria Aparecida',      TO_DATE('20/09/1960', 'dd/MM/yyyy'),    'F',    NULL ,  tp_endereco('14124984', 'Porto Alegre',     'Conde Boa Vista',          'Mariano Amaro',        '21'),  1650.00,    TO_DATE('09/03/2012', 'dd/MM/yyyy'),    NULL,   NULL);
INSERT INTO tb_fotografo VALUES('893451348-30', 'Renato Arruda',        TO_DATE('30/03/1990', 'dd/MM/yyyy'),    'M',    NULL ,  tp_endereco('82886234', 'São Paulo',        'Cracolândia',              'Rua da Neblina',       '66'),  1800.00,    TO_DATE('12/05/2013', 'dd/MM/yyyy'),    NULL,   NULL);
INSERT INTO tb_fotografo VALUES('635752445-80', 'Ricardo Junior',       TO_DATE('05/12/1972', 'dd/MM/yyyy'),    'M',    NULL ,  tp_endereco('23476784', 'Rio de Janeiro',   'Nova Morada',              'Teófilo Antônio',      '99'),  1900.00,    TO_DATE('18/12/2013', 'dd/MM/yyyy'),    NULL,   NULL);
INSERT INTO tb_fotografo VALUES('353234979-23', 'Regina Oliveira',      TO_DATE('10/08/1996', 'dd/MM/yyyy'),    'F',    NULL ,  tp_endereco('82346248', 'Santos',           'Litoral',                  'Av. Mascarenhas',      '806'), 1760.00,    TO_DATE('24/07/2014', 'dd/MM/yyyy'),    NULL,   NULL);

-- Jornalista

INSERT INTO tb_jornalista VALUES('658775462-03', 'Catarina Abreu',       TO_DATE('28/02/1988', 'dd/MM/yyyy'), 'F',varray_fones(tp_fone('081-934003663'), tp_fone('081-965987452'), tp_fone('081-9913584956')),tp_endereco('35741200', 'Fortaleza', 'Meireles', 'Rua Oswaldo Cruz', '1'), 1600.00, TO_DATE('15/08/2014', 'dd/MM/yyyy'),'92425/12/43/SP',NULL,tp_titulacao(TO_DATE('22/04/1979','dd/MM/yyyy') , 'Universidade Federal de Pernambuco', 'Bacharelado'));
INSERT INTO tb_jornalista VALUES('456987415-44', 'Roberta Gomes', TO_DATE('01/01/1944', 'dd/MM/yyyy'), 'F',NULL,tp_endereco('45987455', 'São Luis','Jaracati','Av.Prof.Carlos Cunha', '1000' ), 4650.00, TO_DATE('05/10/2011', 'dd/MM/yyyy'),'09833/53/87/AL',NULL,NULL);
INSERT INTO tb_jornalista VALUES('782662490-13', 'Alberto Maia', TO_DATE('13/12/1977', 'dd/MM/yyyy'), 'M',NULL,tp_endereco('60160230', 'Fortaleza','Aldeota', 'Av.Don Luis', '1200' ), 1000.00, TO_DATE('05/10/2011', 'dd/MM/yyyy'),'23490/01/65/RJ', (SELECT REF(J) FROM tb_jornalista J WHERE J.cpf = '456987415-44'),tp_titulacao(TO_DATE('30/10/1984','dd/MM;yyyy') , 'Universidade Estadual de São Paulo', 'Mestrado'));
INSERT INTO tb_jornalista VALUES('665482660-02','Francisco Cunha',  TO_DATE('02/08/1968', 'dd/MM/yyyy'), 'M',NULL,tp_endereco('96578266', 'Manaus', 'Adrianópolis','Av.Mario Ypiranga','1300'), 1250.00, TO_DATE('05/10/2011', 'dd/MM/yyyy'),'38495/24/45/SP',(SELECT REF(J) FROM tb_jornalista J WHERE J.cpf = '554826331-22'),tp_titulacao(TO_DATE('25/12/2000','dd/MM/yyyy') , 'Universidade Federal do Rio de Janeiro', 'Bacharelado' ));
INSERT INTO tb_jornalista VALUES('554826331-22','Julia Andrade',TO_DATE('03/02/1998', 'dd/MM/yyyy'), 'F',NULL,tp_endereco('56475300', 'Manaus', 'Japiim', 'Rua Santa Luzia', '438'), 3000.00, TO_DATE('05/10/2011', 'dd/MM/yyyy'),'22355/99/23/PE',NULL,tp_titulacao(TO_DATE('07/09/1996','dd/MM/yyyy') , 'Universidade Católica de Pernambuco', 'Bacharelado'));
INSERT INTO tb_jornalista VALUES('785663215-00', 'Roberto Santos', TO_DATE('16/07/1973', 'dd/MM/yyyy'),'M',NULL,tp_endereco('06955712', 'João Pessoa','Tambaú', 'Av.Rui Carneiro','232' ), 1950.00, TO_DATE('05/10/2011', 'dd/MM/yyyy'),'28421/71/42/PE',(SELECT REF(J) FROM tb_jornalista J WHERE J.cpf = '456987415-44'),tp_titulacao(TO_DATE('01/04/1986','dd/MM/yyyy') , 'Pontifícia Universidade Católica de São Paulo' , 'Bacharelado'));
INSERT INTO tb_jornalista VALUES('153664872-66', 'Robin Wood', TO_DATE('06/12/1939', 'dd/MM/yyyy'), 'M',NULL,tp_endereco('32654788', 'Rondonia','Flodoaldo Pinto', 'Av.Rio Madeira', '3288' ), 1550.00, TO_DATE('05/10/2011', 'dd/MM/yyyy'),'20349/12/10/RS',(SELECT REF(J) FROM tb_jornalista J WHERE J.cpf = '554826331-22'),tp_titulacao(TO_DATE('06/10/1991','dd/MM/yyyy') , 'Universidade Federal de Pernambuco', 'Mestrado'  ));
INSERT INTO tb_jornalista VALUES('785441365-99', 'Marcelo Resende', TO_DATE('02/03/1955', 'dd/MM/yyyy'), 'M',NULL,tp_endereco('45699822', 'Porto Alegre', 'Carvalhada','Av.Eduardo Prado', '425'), 1700.00, TO_DATE('05/10/2011', 'dd/MM/yyyy'),'83452/49/23/CE',(SELECT REF(J) FROM tb_jornalista J WHERE J.cpf = '456987415-44'),NULL);
INSERT INTO tb_jornalista VALUES('548662300-11', 'Edinanci Gomes', TO_DATE('22/12/1974', 'dd/MM/yyyy'), 'F', NULL, tp_endereco('45698520', 'Porto Alegre', 'Boa Vista', 'Av.Nilo Peçanha', '2131'), 1900.00, TO_DATE('05/10/2011', 'dd/MM/yyyy'), '35983/36/84/RN', (SELECT REF(J) FROM tb_jornalista J WHERE J.cpf = '554826331-22'), NULL);
INSERT INTO tb_jornalista VALUES('569552330-32', 'Amanda Freitas', TO_DATE('22/12/1974', 'dd/MM/yyyy'), 'F', NULL, tp_endereco('32145874', 'Porto Alegre', 'Praia de Belas', 'Praia de Belas', '1181'), 1650.00, TO_DATE('05/10/2011', 'dd/MM/yyyy'),'05235/25/67/AC', (SELECT REF(J) FROM tb_jornalista J WHERE J.cpf = '456987415-44'), NULL);


-- Edicao

INSERT INTO tb_edicao VALUES(ID_EDICAO.Nextval,(SELECT REF(J) FROM tb_jornalista J where j.cpf = '554826331-22'), TO_DATE('01/07/2010', 'dd/MM/yyyy'));
INSERT INTO tb_edicao VALUES(ID_EDICAO.Nextval,(SELECT REF(J) FROM tb_jornalista J where j.cpf = '456987415-44'), TO_DATE('02/03/2001', 'dd/MM/yyyy'));
INSERT INTO tb_edicao VALUES(ID_EDICAO.Nextval,(SELECT REF(J) FROM tb_jornalista J where j.cpf = '782662490-13'), TO_DATE('03/01/2003', 'dd/MM/yyyy'));
INSERT INTO tb_edicao VALUES(ID_EDICAO.Nextval,(SELECT REF(J) FROM tb_jornalista J where j.cpf = '456987415-44'), TO_DATE('04/02/2008', 'dd/MM/yyyy'));
INSERT INTO tb_edicao VALUES(ID_EDICAO.Nextval,(SELECT REF(J) FROM tb_jornalista J where j.cpf = '554826331-22'), TO_DATE('05/09/2011', 'dd/MM/yyyy'));
INSERT INTO tb_edicao VALUES(ID_EDICAO.Nextval,(SELECT REF(J) FROM tb_jornalista J where j.cpf = '782662490-13'), TO_DATE('06/02/2014', 'dd/MM/yyyy'));
INSERT INTO tb_edicao VALUES(ID_EDICAO.Nextval,(SELECT REF(J) FROM tb_jornalista J where j.cpf = '554826331-22'), TO_DATE('07/04/1998', 'dd/MM/yyyy'));
INSERT INTO tb_edicao VALUES(ID_EDICAO.Nextval,(SELECT REF(J) FROM tb_jornalista J where j.cpf = '554826331-22'), TO_DATE('08/08/2005', 'dd/MM/yyyy'));
INSERT INTO tb_edicao VALUES(ID_EDICAO.Nextval,(SELECT REF(J) FROM tb_jornalista J where j.cpf = '782662490-13'), TO_DATE('09/08/2013', 'dd/MM/yyyy'));
INSERT INTO tb_edicao VALUES(ID_EDICAO.Nextval,(SELECT REF(J) FROM tb_jornalista J where j.cpf = '456987415-44'), TO_DATE('10/09/2013', 'dd/MM/yyyy'));



-- Secao

INSERT INTO tb_secao VALUES('Esportes', 	(Select REF(J) FROM tb_jornalista J where j.cpf = '782662490-13'));
INSERT INTO tb_secao VALUES('Policial', 	(Select REF(J) FROM tb_jornalista J where j.cpf = '554826331-22'));
INSERT INTO tb_secao VALUES('Cultura', 	(Select REF(J) FROM tb_jornalista J where j.cpf = '153664872-66'));
INSERT INTO tb_secao VALUES('Política', 	(Select REF(J) FROM tb_jornalista J where j.cpf = '785441365-99'));
INSERT INTO tb_secao VALUES('Famosos', 	(Select REF(J) FROM tb_jornalista J where j.cpf = '569552330-32'));
INSERT INTO tb_secao VALUES('Economia', 	(Select REF(J) FROM tb_jornalista J where j.cpf = '569552330-32'));

-- Materia

INSERT INTO tb_materia VALUES(ID_MATERIA.Nextval, (Select REF(g) from tb_secao g where g.nome = 'Esportes'), (SELECT REF(E) FROM tb_edicao E WHERE e.numero = 1), 'Vasco perde e é vice novamente',            	NULL, NULL);
INSERT INTO tb_materia VALUES(ID_MATERIA.Nextval, (Select REF(g) from tb_secao g where g.nome = 'Policia'), (SELECT REF(E) FROM tb_edicao E WHERE e.numero = 1), 'Traficante é encontrado morto',            	NULL, NULL);
INSERT INTO tb_materia VALUES(ID_MATERIA.Nextval, (Select REF(g) from tb_secao g where g.nome = 'Famosos'), (SELECT REF(E) FROM tb_edicao E WHERE e.numero = 2), 'Silvio Santos casa com Elen',            	NULL, NULL);
INSERT INTO tb_materia VALUES(ID_MATERIA.Nextval, (Select REF(g) from tb_secao g where g.nome = 'Cultura'), (SELECT REF(E) FROM tb_edicao E WHERE e.numero = 2), 'Filme Aquarius estreia no cinema',            	NULL, NULL);
INSERT INTO tb_materia VALUES(ID_MATERIA.Nextval, (Select REF(g) from tb_secao g where g.nome = 'Política'), (SELECT REF(E) FROM tb_edicao E WHERE e.numero = 3), 'Cunha disputará segundo turno com Bolsonaro',            	NULL, NULL);
INSERT INTO tb_materia VALUES(ID_MATERIA.Nextval, (Select REF(g) from tb_secao g where g.nome = 'Famosos'), (SELECT REF(E) FROM tb_edicao E WHERE e.numero = 4), 'Ana Maria Braga engordou 0.4 kg',            	NULL, NULL);
INSERT INTO tb_materia VALUES(ID_MATERIA.Nextval, (Select REF(g) from tb_secao g where g.nome = 'Esportes'), (SELECT REF(E) FROM tb_edicao E WHERE e.numero = 5), 'Santa Cruz avança na sulamericana',            	NULL, NULL);
INSERT INTO tb_materia VALUES(ID_MATERIA.Nextval, (Select REF(g) from tb_secao g where g.nome = 'Política'), (SELECT REF(E) FROM tb_edicao E WHERE e.numero = 5), 'Nova capa da Veja trás denúncia contra Lula',            	NULL, NULL);
INSERT INTO tb_materia VALUES(ID_MATERIA.Nextval, (Select REF(g) from tb_secao g where g.nome = 'Economia'), (SELECT REF(E) FROM tb_edicao E WHERE e.numero = 6), 'China lança nova moeda',            	NULL, NULL);
INSERT INTO tb_materia VALUES(ID_MATERIA.Nextval, (Select REF(g) from tb_secao g where g.nome = 'Economia'), (SELECT REF(E) FROM tb_edicao E WHERE e.numero = 7), 'Bitcoin sobe 20% em uma semana',            	NULL, NULL);


-- Jorntrabmateria

INSERT INTO tb_jorntrabmateria VALUES((Select ref(j) from tb_jornalista j where j.cpf = '658775462-03'), (Select ref(m) from tb_materia m where m.id = 1));
INSERT INTO tb_jorntrabmateria VALUES((Select ref(j) from tb_jornalista j where j.cpf = '782662490-13'), (Select ref(m) from tb_materia m where m.id = 1));
INSERT INTO tb_jorntrabmateria VALUES((Select ref(j) from tb_jornalista j where j.cpf = '665482660-02'), (Select ref(m) from tb_materia m where m.id = 2));
INSERT INTO tb_jorntrabmateria VALUES((Select ref(j) from tb_jornalista j where j.cpf = '554826331-22'), (Select ref(m) from tb_materia m where m.id = 3));
INSERT INTO tb_jorntrabmateria VALUES((Select ref(j) from tb_jornalista j where j.cpf = '785663215-00'), (Select ref(m) from tb_materia m where m.id = 4));
INSERT INTO tb_jorntrabmateria VALUES((Select ref(j) from tb_jornalista j where j.cpf = '153664872-66'), (Select ref(m) from tb_materia m where m.id = 5));
INSERT INTO tb_jorntrabmateria VALUES((Select ref(j) from tb_jornalista j where j.cpf = '456987415-44'), (Select ref(m) from tb_materia m where m.id = 5));
INSERT INTO tb_jorntrabmateria VALUES((Select ref(j) from tb_jornalista j where j.cpf = '554826331-22'), (Select ref(m) from tb_materia m where m.id = 6));
INSERT INTO tb_jorntrabmateria VALUES((Select ref(j) from tb_jornalista j where j.cpf = '785441365-99'), (Select ref(m) from tb_materia m where m.id = 6));
INSERT INTO tb_jorntrabmateria VALUES((Select ref(j) from tb_jornalista j where j.cpf = '782662490-13'), (Select ref(m) from tb_materia m where m.id = 7));
INSERT INTO tb_jorntrabmateria VALUES((Select ref(j) from tb_jornalista j where j.cpf = '456987415-44'), (Select ref(m) from tb_materia m where m.id = 8));
INSERT INTO tb_jorntrabmateria VALUES((Select ref(j) from tb_jornalista j where j.cpf = '569552330-32'), (Select ref(m) from tb_materia m where m.id = 9));
INSERT INTO tb_jorntrabmateria VALUES((Select ref(j) from tb_jornalista j where j.cpf = '569552330-32'), (Select ref(m) from tb_materia m where m.id = 10));

-- Premicao

INSERT INTO tb_premiacao VALUES (ID_PREMIACAO.Nextval, 'Pulitzer',	TO_DATE('07/09/2012', 'dd/MM/yyyy'), 'Melhor cobertura eleitoral'           	);
INSERT INTO tb_premiacao VALUES (ID_PREMIACAO.Nextval, 'Pulitzer',	TO_DATE('07/09/2013', 'dd/MM/yyyy'), 'Melhor matéria esportiva'             	);
INSERT INTO tb_premiacao VALUES (ID_PREMIACAO.Nextval, 'Esso',    	TO_DATE('02/01/2015', 'dd/MM/yyyy'), 'Contribuição investigativa'           	);
INSERT INTO tb_premiacao VALUES (ID_PREMIACAO.Nextval, 'Esso',    	TO_DATE('02/01/1999', 'dd/MM/yyyy'), 'Emoção esportiva'                     	);
INSERT INTO tb_premiacao VALUES (ID_PREMIACAO.Nextval, 'Petrobras',   TO_DATE('25/07/1982', 'dd/MM/yyyy'), 'Premio de incentivo ao cinema nacional'   );
INSERT INTO tb_premiacao VALUES (ID_PREMIACAO.Nextval, 'Petrobras',   TO_DATE('25/07/2001', 'dd/MM/yyyy'), 'Premio de imparcialidade política'    	);
INSERT INTO tb_premiacao VALUES (ID_PREMIACAO.Nextval, 'Fapeam',  	TO_DATE('03/11/2003', 'dd/MM/yyyy'), 'Cobertura policial'                   	);
INSERT INTO tb_premiacao VALUES (ID_PREMIACAO.Nextval, 'Fapeam',  	TO_DATE('03/11/2006', 'dd/MM/yyyy'), 'Economia'                             	);
INSERT INTO tb_premiacao VALUES (ID_PREMIACAO.Nextval, 'MPT',     	TO_DATE('15/10/2015', 'dd/MM/yyyy'), 'Melhor análise econômica'             	);
INSERT INTO tb_premiacao VALUES (ID_PREMIACAO.Nextval, 'MPT',     	TO_DATE('15/10/2012', 'dd/MM/yyyy'), 'Matéria mais divertida'               	);

-- Ganha

INSERT INTO tb_ganha VALUES(ID_GANHA.Nextval,(Select ref(p) from tb_premiacao p where p.id = 1), (Select ref(j) from tb_jorntrabmateria j WHERE j.jornalista.cpf = '658775462-03' AND j.materia.id = 1));
INSERT INTO tb_ganha VALUES(ID_GANHA.Nextval,(Select ref(p) from tb_premiacao p where p.id = 2),(Select ref(j) from tb_jorntrabmateria j WHERE j.jornalista.cpf = '782662490-13' AND j.materia.id = 1));
INSERT INTO tb_ganha VALUES(ID_GANHA.Nextval,(Select ref(p) from tb_premiacao p where p.id = 3), (Select ref(j) from tb_jorntrabmateria j WHERE j.jornalista.cpf = '665482660-02' AND j.materia.id = 2));
INSERT INTO tb_ganha VALUES(ID_GANHA.Nextval,(Select ref(p) from tb_premiacao p where p.id = 4),(Select ref(j) from tb_jorntrabmateria j WHERE j.jornalista.cpf = '554826331-22' AND j.materia.id = 3));
INSERT INTO tb_ganha VALUES(ID_GANHA.Nextval,(Select ref(p) from tb_premiacao p where p.id = 5), (Select ref(j) from tb_jorntrabmateria j WHERE j.jornalista.cpf = '569552330-32' AND j.materia.id = 9));
INSERT INTO tb_ganha VALUES(ID_GANHA.Nextval,(Select ref(p) from tb_premiacao p where p.id = 6), (Select ref(j) from tb_jorntrabmateria j WHERE j.jornalista.cpf = '785663215-00' AND j.materia.id = 4));
INSERT INTO tb_ganha VALUES(ID_GANHA.Nextval,(Select ref(p) from tb_premiacao p where p.id = 7), (Select ref(j) from tb_jorntrabmateria j WHERE j.jornalista.cpf = '153664872-66' AND j.materia.id = 5));
INSERT INTO tb_ganha VALUES(ID_GANHA.Nextval,(Select ref(p) from tb_premiacao p where p.id = 8), (Select ref(j) from tb_jorntrabmateria j WHERE j.jornalista.cpf = '554826331-22' AND j.materia.id = 6));
INSERT INTO tb_ganha VALUES(ID_GANHA.Nextval,(Select ref(p) from tb_premiacao p where p.id = 9), (Select ref(j) from tb_jorntrabmateria j WHERE j.jornalista.cpf = '782662490-13' AND j.materia.id = 7));
INSERT INTO tb_ganha VALUES(ID_GANHA.Nextval,(Select ref(p) from tb_premiacao p where p.id = 10), (Select ref(j) from tb_jorntrabmateria j WHERE j.jornalista.cpf = '456987415-44' AND j.materia.id = 8));
