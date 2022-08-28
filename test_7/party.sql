create table tbl_party_202005(
	p_code char(2) not null,
	p_name varchar2(20),
	p_indate date,
	p_reader varchar2(20),
	p_tel1 char(3),
	p_tel2 char(4),
	p_tel3 char(4),
	
constraint pk_party_code primary key(p_code)
)

select * from tbl_party_202005 natural join tbl_member_202005


insert into tbl_party_202005 values ('P1', 'A정당', '2010-01-01', '위대표', '02', '1111', '0001');
insert into tbl_party_202005 values ('P2', 'B정당', '2010-02-01', '명대표', '02', '1111', '0002');
insert into tbl_party_202005 values ('P3', 'C정당', '2010-03-01', '기대표', '02', '1111', '0003');
insert into tbl_party_202005 values ('P4', 'D정당', '2010-04-01', '옥대표', '02', '1111', '0004');
insert into tbl_party_202005 values ('P5', 'E정당', '2010-05-01', '임대표', '02', '1111', '0005');



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

insert into tbl_vote_202005
values ('89010120010', '강유권', '4', '0930', '제1투표장', 'Y');
insert into tbl_vote_202005
values ('99010110011', '신유권', '5', '0930', '제1투표장', 'Y');
insert into tbl_vote_202005
values ('79010120012', '오유권', '1', '1330', '제1투표장', 'Y');

insert into tbl_vote_202005
values ('69010110013', '현유권', '4', '1330', '제2투표장', 'Y');
insert into tbl_vote_202005
values ('89010110014', '왕유권', '2', '1330', '제2투표장', 'Y');
insert into tbl_vote_202005
values ('99010110015', '유유권', '3', '1330', '제2투표장', 'Y');
insert into tbl_vote_202005
values ('79010110016', '한유권', '2', '1330', '제2투표장', 'Y');
insert into tbl_vote_202005
values ('89010110017', '문유권', '4', '1330', '제2투표장', 'Y');
insert into tbl_vote_202005
values ('99010110018', '양유권', '2', '1330', '제2투표장', 'Y');
insert into tbl_vote_202005
values ('99010110019', '구유권', '4', '1330', '제2투표장', 'Y');
insert into tbl_vote_202005
values ('79010110020', '황유권', '5', '1330', '제2투표장', 'Y');
insert into tbl_vote_202005
values ('69010110021', '배유권', '3', '1330', '제2투표장', 'Y');
insert into tbl_vote_202005
values ('79010110022', '전유권', '3', '1330', '제2투표장', 'Y');
insert into tbl_vote_202005
values ('99010110023', '고유권', '1', '1330', '제2투표장', 'Y');
insert into tbl_vote_202005
values ('59010110024', '권유권', '3', '1330', '제2투표장', 'Y');

select m_no, m_name, count(vote) count from
(select m.m_no as m_no, m.m_name as m_name, v.m_no as vote from TBL_MEMBER_202005 m left outer join TBL_VOTE_202005 v on m.m_no = v.m_no where v.c_confirm = 'Y')
group by(m_no, m_name) order by count desc;

select floor(months_between(sysdate, substr(v_jumin, 1, 6))/12) from tbl_vote_202005