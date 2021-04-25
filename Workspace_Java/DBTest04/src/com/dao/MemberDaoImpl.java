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
// DB서버에서 가져온 값을 전달
// Data Access Object : DB와 접근
public class MemberDaoImpl implements MemberDao {

	// DB서버에 있는 값을 다른 레이어에 전달하기 위한 객체
	@Override
	public List<MemberDto> selectList() {
		
		// DB연결 객체
		Connection con = getConnection();
		
		// DB와 연결되어 있는 connection 객체를 통해 sql문을 db에 전달하여 실행하고
		// 결과를 리턴받아 주는 객체
		Statement stmt = null;
		
		ResultSet rs = null;
		// dto는 한줄만 저장하기 때문에 많이 받으려고 리스트에 담음
		List<MemberDto> list = new ArrayList<MemberDto>();
		
		try {
			stmt = con.createStatement();
			// table 전체를 가져온다.
			rs = stmt.executeQuery(SELECT_LIST_SQL);
			while (rs.next()) {
				// 가져온 table의 row를 하나씩 전달
				MemberDto temp = new MemberDto();
				temp.setM_no(rs.getInt("M_NO"));
				temp.setM_name(rs.getString("M_NAME"));
				temp.setM_age(rs.getInt("M_AGE"));
				temp.setM_gender(rs.getString("M_GENDER"));
				temp.setM_location(rs.getString("M_LOCATION"));
				temp.setM_job(rs.getString("M_JOB"));
				temp.setM_tel(rs.getString("M_TEL"));
				temp.setM_email(rs.getString("M_EMAIL"));
				// dto로 전달했던 값을 받아와 리스트에 저장
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
		
		// statement를 상속받았기 때문에 거의 비슷하지만 sql문을 컴파일 할 때
		// ?를 사용하여 preCompile하여 미리 준비해놓고 실행하여 리턴받는다.
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
