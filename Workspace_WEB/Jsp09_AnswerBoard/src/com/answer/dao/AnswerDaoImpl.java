package com.answer.dao;

import static com.answer.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.answer.dto.AnswerDto;

public class AnswerDaoImpl implements AnswerDao {

	@Override
	public List<AnswerDto> selectList() {
		
		Connection con = getConnection();
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<AnswerDto> list = new ArrayList<AnswerDto>();
		
		try {
			pstm = con.prepareStatement(SELECT_LIST_SQL);
			rs = pstm.executeQuery();
			while (rs.next()) {
				AnswerDto dto = new AnswerDto();
				dto.setBoardno(rs.getInt(1));
				dto.setGroupno(rs.getInt(2));
				dto.setGroupseq(rs.getInt(3));
				dto.setTitletab(rs.getInt(4));
				dto.setTitle(rs.getString(5));
				dto.setContent(rs.getString(6));
				dto.setWriter(rs.getString(7));
				dto.setRegdate(rs.getDate(8));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}
		
		return list;
	}

	@Override
	public AnswerDto selectOne(int boardno) {
		return null;
	}

	@Override
	public int boardInsert(AnswerDto dto) {
		return 0;
	}

	@Override
	public int boardUpdate(AnswerDto dto) {
		return 0;
	}

	@Override
	public int boardDelete(int boardno) {
		return 0;
	}

	@Override
	public int answerUpdate(int parentBoardNo) {
		return 0;
	}

	@Override
	public int answerInsert(AnswerDto dto) {
		return 0;
	}

}
