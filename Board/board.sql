CREATE table tbl_board(
	bno NUMBER,
	title VARCHAR2(60) NOT NULL,
	content VARCHAR2(3000) NOT NULL,
	writer VARCHAR2(15) NOT NULL,
	regDay DATE DEFAULT SYSDATE,
	updateDay DATE DEFAULT SYSDATE,
	readCnt NUMBER DEFAULT 0,
	CONSTRAINT pk_board_bno PRIMARY KEY(bno)
)

CREATE SEQUENCE seq_board_bno;

SELECT * FROM tbl_board where writer like '%새로이%';