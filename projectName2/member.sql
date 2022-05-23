CREATE TABLE tbl_member(
	id VARCHAR2(6),
	pw VARCHAR2(600),
	name VARCHAR2(15),
	birth DATE,
	CONSTRAINT pk_member_id PRIMARY KEY(id)
)

SELECT * FROM tbl_member