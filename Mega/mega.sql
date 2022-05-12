select object_name from user_objects where object_type = 'TABLE'; 

CREATE TABLE member2(
	id VARCHAR2(30),
	pw VARCHAR2(30),
	name VARCHAR2(20),

	CONSTRAINT pk_member2_id PRIMARY KEY(id)
)


SELECT * FROM member2
SELECT * FROM board2

CREATE TABLE board2(
	num NUMBER,
	id VARCHAR2(30),
	title VARCHAR2(100),
	content VARCHAR2(300),
	writeDay DATE DEFAULT SYSDATE,
	updateDay DATE DEFAULT SYSDATE,
	readCnt NUMBER DEFAULT 0,
	repRoot NUMBER,
	repStep NUMBER,
	repIndent NUMBER,

CONSTRAINT pk_board2_num PRIMARY KEY(num),
CONSTRAINT fk_board2_id foreign key(id) references member2(id)
)

CREATE SEQUENCE seq_board2_num

DROP SEQUENCE seq_board2_num