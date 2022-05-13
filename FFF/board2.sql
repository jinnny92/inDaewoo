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
id VARCHAR2(15),
CONSTRAINT pk_board_num PRIMARY KEY(num),
CONSTRAINT fk_board_id foreign key(id) references member(id)
)
CREATE table member(
id VARCHAR2(15),
pw VARCHAR2(15),
name VARCHAR2(15),
birthday VARCHAR2(15),
phonenumber VARCHAR2(15),
email VARCHAR2(100),
constraint pk_member_id primary key(id)


)
drop table member
drop table tbl_board
select*from member
select*from tbl_board
CREATE SEQUENCE seq_board_num



ALTER TABLE tbl_board DROP CONSTRAINT fk_board_id;
ALTER TABLE tbl_board ADD CONSTRAINT fk_board_id FOREIGN KEY (id) REFERENCES member(id) ON DELETE CASCADE;

