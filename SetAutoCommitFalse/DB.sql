CREATE TABLE account(
aid NUMBER,
aname VARCHAR2(15),
balance NUMBER DEFAULT 0,

CONSTRAINT pk_account_aid PRIMARY KEY(aid)
)

INSERT INTO account
(aid, aname, balance)
VALUES
(1, '홍길동', 10000)

INSERT INTO account
(aid, aname, balance)
VALUES
(2, '김유신', 0)

COMMIT

SELECT * FROM account

update account set balance = 10000 where aid = 1

SELECT * FROM member
SELECT id FROM member
SELECT id AS 아이디, name 이름 FROM member




SELECT DISTINCT name FROM member, id FROM member ORDER BY id DESC

SELECT * FROM member ORDER BY name ASC, age ASC 


SELECT * FROM member WHERE age > 30

INSERT INTO member (id) VALUES (43)
COMMIT

SELECT * FROM member WHERE name IS null

--name = tt 이고 age = 55인 레코드 조회하기
SELECT * FROM member WHERE name = 'tt', age = 55;

--name = tt 또는 age = 55인 레코드 조회하기

SELECT * FROM member WHERE name = 'tt' OR age = 55;

--age = 13 또는 age = 15인 레코드 조회하기
SELECT * FROM member WHERE age = 13 OR age = 15;

--age = 13 또는 age = 15인 또는 age = 11 또는 age = 22 또는 age = 33인 레코드 조회하기
SELECT * FROM member WHERE age = 13 OR age = 15 OR age = 11 OR age = 22 OR age = 33;

SELECT * FROM member

SELECT * FROM member WHERE age IN(13, 15, 11, 22, 33);
--age != 13 또는 age != 15인 또는 age != 11 또는 age != 22인 레코드 조회하기
SELECT * FROM member WHERE age NOT IN(13, 15, 11, 22);

--33 <= age 그리고 age <= 55인 레크드 조회

SELECT * FROM member WHERE age >= 33 AND age<= 55;

SELECT * FROM member WHERE age BETWEEN 33 AND 55;

33 < age 그리고 age < 55인 레코드 조회 
SELECT * FROM member WHERE age > 33 AND age < 55;

________________________ 언더바 하나가 한 글자
% : 0 ~ N

이란이라는 글자가 들어간 레코드 조회하기
SELECT * FROM member WHERE name LIKE '%이란%';



 a이라는 글자가 들어간 레코드 조회하기
SELECT * FROM member WHERE name LIKE '%A%'; => 데이터가 나오지 않음

SELECT * FROM member WHERE UPPER(name) LIKE UPPER('%A%');
SELECT * FROM member WHERE LOWER(name) LIKE LOWER('%A%');

세 경우의 결과는 같다 
SELECT COUNT(*) AS 회원수 FROM member;
SELECT COUNT(id) AS 회원수 FROM member;
SELECT COUNT(프라이머리키) AS 회원수 FROM member;


--회원중에서 나이가 33살보다 많은 사람은 몇 명일까
SELECT COUNT(id) AS 회원수 FROM member WHERE age > 33;



SELECT MIN(age) 최연소 FROM member;
SELECT MAX(age) 최연장자 FROM member; 

--순위 매기기

SELECT rownum, id, name, age FROM member  --이게 하나의 테이블

SELECT * FROM (SELECT rownum rnum, id, name, age FROM member) WHERE rnum BETWEEN 1 AND 10



SELECT id, name, age FROM member ORDER BY id ASC

SELECT RANK() OVER(ORDER BY id ASC), id, name, age FROM member ORDER BY id ASC

SELECT RANK() OVER(ORDER BY id ASC) 순위, id, name, age FROM member ORDER BY id ASC


SELECT * FROM 
(SELECT RANK() OVER(ORDER BY age ASC) 순위, id, name, age FROM member ORDER BY id ASC) 
WHERE 순위 BETWEEN 1 AND 10

SELECT DENSE_RANK() OVER(ORDER BY id ASC) 연령순, id, name, age FROM member ORDER BY age ASC


SELECT RANK() OVER(ORDER BY age ASC, id ASC) 연령순, id, name, age FROM member ORDER BY age ASC, id ASC

SELECT MAX(ID)+1 FROM member
INSERT INTO member (id) VALUES ((SELECT MAX(ID)+1 FROM member));

DELETE FROM member WHERE id = (SELECT MAX(ID) FROM member)

SELECT * FROM member





