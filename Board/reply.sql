CREATE table tbl_reply(
	 rno NUMBER,
	 bno NUMBER,
	 replyer VARCHAR2(15) NOT NULL,
	 replyText VARCHAR2(300) NOT NULL,
	 regDay DATE DEFAULT SYSDATE,
	 updateDay DATE DEFAULT SYSDATE, 
	
	CONSTRAINT pk_reply_rno PRIMARY KEY(rno),
	CONSTRAINT fk_reply_bno FOREIGN KEY(bno) REFERENCES tbl_board(bno)
	
)	

CREATE SEQUENCE seq_reply_rno

SELECT * FROM TBL_REPLY