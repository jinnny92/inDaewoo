create table tbl_member_202005(
	m_no char(1) not null,
	m_name varchar2(20),
	p_code char(2),
	p_school char(1),
	m_jumin char(13),
	m_city varchar2(20),
	
constraint pk_member_no primary key(m_no),
constraint fk_member_code foreign key(p_code) references tbl_party_202005(p_code)
)

select * from tbl_member_202005

insert into tbl_member_202005 values ('1', '김후보', 'P1', '1', '6603011999991', '수선화동');
insert into tbl_member_202005 values ('2', '이후보', 'P2', '3', '5503011999992', '민들레동');
insert into tbl_member_202005 values ('3', '박후보', 'P3', '2', '7703011999993', '나팔꽃동');
insert into tbl_member_202005 values ('4', '조후보', 'P4', '2', '8803011999994', '진달래동');
insert into tbl_member_202005 values ('5', '최후보', 'P5', '3', '9903011999995', '개나리동');



