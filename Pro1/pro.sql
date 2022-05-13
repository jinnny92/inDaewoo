CREATE TABLE tbl_m(
	id VARCHAR2 (10),
	name VARCHAR2 (15) NOT NULL,
	age NUMBER  NOT NULL,

	CONSTRAINT pk_m_id PRIMARY KEY(id)
)

SELECT id
,REGEXP_REPLACE(id, '[가-힣]','') FROM tbl_board


CREATE TABLE tbl_b(
num NUMBER,
id VARCHAR2 (10),
title VARCHAR2 (60) NOT NULL,
content VARCHAR2 (3000),
CONSTRAINT pk_b_num PRIMARY KEY(num),
CONSTRAINT fk_b_id FOREIGN KEY(id) REFERENCES tbl_m(id)
)

SELECT * FROM tbl_b, tbl_m


SELECT m.id,  b.id FROM tbl_m m, tbl_b b WHERE m.id  = b.id;

CREATE SEQUENCE seq_b_num

DROP TABLE member;

DROP TABLE tbl_board;


CREATE TABLE member(
id VARCHAR2(20) primary key,
pw NUMBER,
name VARCHAR2(15),
birthday NUMBER,
phonenumber NUMBER,
email VARCHAR2(100)
)

ALTER TABLE member DROP PRIMARY KEY;



CREATE TABLE tbl_board(

num NUMBER,
writer VARCHAR2(15),
title VARCHAR2(60) NOT NULL,
content VARCHAR2(3000),
writeDay DATE DEFAULT SYSDATE,
updateDay DATE DEFAULT SYSDATE,
readcnt NUMBER DEFAULT 0,
repRoot NUMBER,
repStep NUMBER,
repIndent NUMBER,
id VARCHAR2(20),
CONSTRAINT pk_board_num PRIMARY KEY(num),
CONSTRAINT fk_board_id foreign key(id) references member(id)
)

SELECT * FROM member;

SELECT * FROM tbl_board;

