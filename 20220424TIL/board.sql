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