CREATE TABLE member2(
	id NUMBER,
	name VARCHAR2(15),
	age NUMBER,

	CONSTRAINT pk_member_id PRIMARY KEY(id)
)

CREATE TABLE tbl_board2(
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
CONSTRAINT pk_board2_num PRIMARY KEY(num)

)

alter table tbl_board2 DROP PRIMARY KEY
alter table tbl_board2 add id NUMBER 

alter table tbl_board2 add PRIMARY KEY(num);

CREATE SEQUENCE seq_board_num


SELECT * FROM member2 m2, tbl_board2 b2 WHERE m2.id = b2.id;