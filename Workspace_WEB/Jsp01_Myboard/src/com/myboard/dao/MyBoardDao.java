package com.myboard.dao;

import static com.myboard.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myboard.dto.MyBoardDto;

public class MyBoardDao {

	public List<MyBoardDto> selectList() {
		
		Connection con = getConnection();
		
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE "
				+ " FROM MYBOARD "
				+ " ORDER BY SEQ DESC ";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<MyBoardDto> list = new ArrayList<MyBoardDto>();
		
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				MyBoardDto dto = new MyBoardDto();
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getNString(4));
				dto.setDate(rs.getDate(5));
				
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
	public MyBoardDto selectOne(int seq) {
		
		Connection con = getConnection();
		
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE "
				+ " FROM MYBOARD "
				+ " WHERE SEQ = ? ";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MyBoardDto dto = new MyBoardDto();
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);
			
			rs = pstm.executeQuery();
			while (rs.next()) {
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setDate(rs.getDate(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}
		
		return dto;
	}
	public int insert(MyBoardDto dto) {
		
		Connection con = getConnection();
		
		String sql = " INSERT INTO MYBOARD "
				+ " VALUSE(MYBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";
		
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			
			res = pstm.executeUpdate();
			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return res;
	}
	public int update(MyBoardDto dto) {
		
		Connection con = getConnection();
		
		String sql = " UPDATE MYBOARD "
				+ " SET TITLE = ?, CONTENT = ? "
				+ " WHERE WRITER = ? ";
		
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setString(3, dto.getWriter());
			
			res = pstm.executeUpdate();
			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return res;
	}
	public int delete(int seq) {
		
		Connection con = getConnection();
		
		String sql = " DELETE FROM MYBOARD "
				+ " WHERE SEQ = ? ";
		
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);
			
			res = pstm.executeUpdate();
			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return res;
		
	}
}
