DROP SEQUENCE CALBOARDSEQ;
DROP TABLE CALBOARD;

CREATE SEQUENCE CALBOARDSEQ;

CREATE TABLE CALBOARD(
	SEQ NUMBER PRIMARY KEY,
	ID VARCHAR2(500) NOT NULL,
	TITLE VARCHAR2(1000) NOT NULL,
	CONTENT VARCHAR2(4000) NOT NULL,
	MDATE VARCHAR2(12) NOT NULL,
	REGDATE DATE NOT NULL
);

SELECT SEQ, ID, TITLE, CONTENT, MDATE, REGDATE
FROM CALBOARD;

-- row_number() over(partition by @ order by)
-- @로 group by를 해서, 그룹별 rownum을 사용하고 싶을 때
SELECT * 
FROM 
	(
		SELECT (ROW_NUMBER() OVER(PARTITION BY SUBSTR(MDATE, 1, 8) ORDER BY MDATE))RN, SEQ, ID, TITLE, CONTENT, MDATE, REGDATE
		FROM CALBOARD
		WHERE ID = 'kh'
		AND SUBSTR(MDATE, 1, 6)='202103'
	)
WHERE RN BETWEEN 1 AND 3;

SELECT COUNT(*)
FROM CALBOARD
WHERE ID = 'kh'
AND SUBSTR(MDATE, 1, 8) = '20210311';