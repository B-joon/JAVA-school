package com.answer.biz;

import java.util.List;

import com.answer.dao.AnswerDao;
import com.answer.dao.AnswerDaoImpl;
import com.answer.dto.AnswerDto;

public class AnswerBizImpl implements AnswerBiz {

	AnswerDao dao = new AnswerDaoImpl();
	
	@Override
	public List<AnswerDto> selectList() {
		return dao.selectList();
	}

	@Override
	public AnswerDto selectOne(int boardno) {
		return dao.selectOne(boardno);
	}

	@Override
	public int boardInsert(AnswerDto dto) {
		return dao.answerInsert(dto);
	}

	@Override
	public int boardUpdate(AnswerDto dto) {
		return dao.boardUpdate(dto);
	}

	@Override
	public int boardDelete(int boardno) {
		return 0;
	}

	@Override
	public int answerProc(AnswerDto dto) {
		
		int update = dao.answerUpdate(dto.getBoardno());
		int insert = dao.answerInsert(dto);
		
		return update + insert;
	}

}
