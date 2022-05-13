CREATE TABLE member(
id VARCHAR2(20) primary key,
pw NUMBER,
name VARCHAR2(15),
birthday NUMBER,
phonenumber NUMBER,
email VARCHAR2(100)
)

 ALTER TABLE member MODIFY (pw VARCHAR2(30));

ALTER TABLE member MODIFY (phonenumber VARCHAR2(15) UNIQUE);
ALTER TABLE member MODIFY (email VARCHAR2(100) UNIQUE);

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
CONSTRAINT fk_board_id foreign key(id) references member(id) ON DELETE CASCADE
)



SELECT id
,REGEXP_REPLACE(id, '[가-힣]','') FROM tbl_board





CREATE SEQUENCE seq_board_num
DROP SEQUENCE seq_board_num

SELECT * FROM member;