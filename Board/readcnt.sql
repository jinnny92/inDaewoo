CREATE TABLE tbl_readcnt(
	ip VARCHAR2(300),
	bno NUMBER,
	CONSTRAINT pk_readcnt_ipNbno PRIMARY KEY(ip, bno)
)