


CREATE TABLE tbl_item(
	iId NUMBER,
	iName VARCHAR2(60) NOT NULL,
	iPrice NUMBER NOT NULL,
	iDc NUMBER DEFAULT 0,
	iCount NUMBER NOT NULL,
	CONSTRAINT pk_item_iId PRIMARY KEY(iId)
)


SELECT * FROM TBL_ITEM

CREATE SEQUENCE seq_item_iId;
원래는  판매자 아이디가 외래기로 들어가야함
