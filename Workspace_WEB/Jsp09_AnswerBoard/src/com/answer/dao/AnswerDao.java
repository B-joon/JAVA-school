package com.answer.dao;

import java.util.List;

import com.answer.dto.AnswerDto;

public interface AnswerDao {

	String SELECT_LIST_SQL = " SELECT BOARDNO, GROUPNO, GROUPSEQ, TITLETAB, TITLE, CONTENT, WRITER, REGDATE"
			+ " FROM ANSWERBOARD "
			+ " ORDER BY GROUPNO DESC, GROUPSEQ ";
	String SELECT_ONE_SQL = " SELECT BOARDNO, GROUPNO, GROUPSEQ, TITLETAB, TITLE, CONTENT, WRITER, REGDATE "
			+ " FROM ANSWERBOARD "
			+ " WHERE BOARDNO = ? ";
	String INSERT_SQL = "";
	String UPDATE_SQL = "";
	String DELETE_SQL = "";
	
	String ANSWER_UPDATE_SQL = " UPDATE ANSWERBOARD "
			+ " SET GROUPSEQ = GROUPSEQ + 1 "
			+ " WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = ?) "
			+ " AND GROUPSEQ > (SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO = ?) ";
	String ANSWER_INSERT_SQL = " INSERT INTO ANSWERBOARD "
			+ " VALUES( "
			+ " BOARDNOSEQ.NEXTVAL, "
			+ " (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = ?), "
			+ " (SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO = ?) + 1, "
			+ "	(SELECT TITLETAB FROM ANSWERBOARD WHERE BOARDNO = ?) + 1, "
			+ " ?, ?, ?, SYSDATE) ";
	
	public List<AnswerDto> selectList();
	public AnswerDto selectOne(int boardno);
	public int boardInsert(AnswerDto dto);
	public int boardUpdate(AnswerDto dto);
	public int boardDelete(int boardno);
	
	public int answerUpdate(int parentBoardNo);
	public int answerInsert(AnswerDto dto);
}
