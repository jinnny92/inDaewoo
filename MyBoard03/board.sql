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

SELECT * FROM tbl_board

DROP TABLE  tbl_board;

DROP SEQUENCE seq_board_num;

SELECT COUNT(num) FROM tbl_board

SELECT * FROM tbl_board order by repRoot desc, repStep asc /*정렬된 목록 전체가 나옴*/



/*select문 자체가 하나의 테이블*/

select rownum rnum, num, title, writer, updateday, readcnt, repIndent 
from (SELECT * FROM tbl_board order by repRoot desc, repStep asc) /*이만큼이 또 하나의 테이블*/

select * from 
(select 
rownum rnum, num, title, writer, updateday, readcnt, repIndent 
from (select * from tbl_board order by repRoot desc, repStep asc)) 
where rnum between 11 and 20 /*11~20번까지 하나의 테이블*/

