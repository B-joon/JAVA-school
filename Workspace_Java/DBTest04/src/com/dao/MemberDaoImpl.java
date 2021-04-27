package com.dao;

import static com.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dto.MemberDto;

public class MemberDaoImpl implements MemberDao {

	@Override
	public List<MemberDto> selectList() {
		
		Connection con = getConnection();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		List<MemberDto> list = new ArrayList<MemberDto>();
		
		try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(SELECT_LIST_SQL);
			while (rs.next()) {
				MemberDto temp = new MemberDto();
				temp.setM_no(rs.getInt("M_NO"));
				temp.setM_name(rs.getString("M_NAME"));
				temp.setM_age(rs.getInt("M_AGE"));
				temp.setM_gender(rs.getString("M_GENDER"));
				temp.setM_location(rs.getString("M_LOCATION"));
				temp.setM_job(rs.getString("M_JOB"));
				temp.setM_tel(rs.getString("M_TEL"));
				temp.setM_email(rs.getString("M_EMAIL"));
				
				list.add(temp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(con);
		}
		
		return list;
	}

	@Override
	public MemberDto selectOne(int m_no) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MemberDto temp = new MemberDto();
		
		try {
			pstm = con.prepareStatement(SELECT_ONE_SQL);
			pstm.setInt(1, m_no);
			
			rs = pstm.executeQuery();
			while (rs.next()) {
				temp.setM_no(rs.getInt("M_NO"));
				temp.setM_name(rs.getString("M_NAME"));
				temp.setM_age(rs.getInt("M_AGE"));
				temp.setM_gender(rs.getString("M_GENDER"));
				temp.setM_location(rs.getString("M_LOCATION"));
				temp.setM_job(rs.getString("M_JOB"));
				temp.setM_tel(rs.getString("M_TEL"));
				temp.setM_email(rs.getString("M_EMAIL"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}
		
		
		return temp;
	}

	@Override
	public int insert(MemberDto dto) {
		Connection con = getConnection();

		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(INSERT_SQL);
			pstm.setInt(1, dto.getM_no());
			pstm.setString(2, dto.getM_name());
			pstm.setInt(3, dto.getM_age());
			pstm.setString(4, dto.getM_gender());
			pstm.setString(5, dto.getM_location());
			pstm.setString(6, dto.getM_job());
			pstm.setString(7, dto.getM_tel());
			pstm.setString(8, dto.getM_email());
			
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

	@Override
	public int update(MemberDto dto) {
		
		Connection con = getConnection();
		
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(UPDATE_SQL);
			pstm.setString(1, dto.getM_name());
			pstm.setInt(2, dto.getM_age());
			pstm.setString(3, dto.getM_gender());
			pstm.setString(4, dto.getM_location());
			pstm.setString(5, dto.getM_job());
			pstm.setString(6, dto.getM_tel());
			pstm.setString(7, dto.getM_email());
			pstm.setInt(8, dto.getM_no());
			
			res = pstm.executeUpdate();
			if (res > 0) {
				commit(con);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
		}
		
		return res;
	}

	@Override
	public int delete(int m_no) {
		
		Connection con = getConnection();
		
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(DELETE_SQL);
			pstm.setInt(1, m_no);
			
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
