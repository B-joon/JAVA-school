DROP TABLE MYBOARD;
DROP SEQUENCE MYBOARDSEQ;

CREATE SEQUENCE MYBOARDSEQ;

CREATE TABLE MYBOARD(
	MYNO NUMBER PRIMARY KEY,
	MYNAME VARCHAR2(100) NOT NULL,
	MYTITLE VARCHAR2(1000) NOT NULL,
	MYCONTENT VARCHAR2(4000) NOT NULL,
	MYDATE DATE NOT NULL
);

INSERT INTO MYBOARD
VALUES(MYBOARDSEQ.NEXTVAL, '관리자', '게시판 테스트', '테스트 글 입니다. 123456789', SYSDATE);

SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE
FROM MYBOARD
ORDER BY MYNO DESC;