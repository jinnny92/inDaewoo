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
CONSTRAINT pk_board_num PRIMARY KEY(num)

)


CREATE SEQUENCE seq_board_num



SELECT * FROM 
(SELECT 
rownum rnum, num, title, writer, updateday, readcnt, repIndent 
from (SELECT * FROM tbl_board order by repRoot desc, repStep asc)) 
where rnum between ? and ?

SELECT * FROM tbl_board order by repRoot desc, repStep asc




SELECT COUNT(num) FROM tbl_board