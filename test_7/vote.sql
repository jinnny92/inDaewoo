create table tbl_vote_202005(
	v_jumin char(13) not null,
	v_name varchar2(20),
	m_no char(1),
	v_time char(4),
	v_area char(20),
	c_confirm char(1),
	
constraint pk_vote_jumin primary key(v_jumin),
constraint fk_vote_no foreign key(m_no) references tbl_member_202005(m_no)
)

select * from tbl_vote_202005

