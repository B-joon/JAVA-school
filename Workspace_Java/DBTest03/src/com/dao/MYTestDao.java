package com.dao;

import static com.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dto.MYTestDto;

// Data Access Object : DB와 접근하는 객체.
// import static : class.method 하고 호출 할 때, class 생략
public class MYTestDao {
	
	static Scanner sc = new Scanner(System.in);
	
	// 전체출력
	public List<MYTestDto> selectList() {
		// 1. 2.
		// Connection con = JDBCTemplate.getConnection(); // -> import static com.common.JDBCTemplate.*;
		Connection con = getConnection();
		String sql = " SELECT MNO, MNAME, NICKNAME "
				+ " FROM MYTEST ";
		Statement stmt = null;
		ResultSet rs = null;
		List<MYTestDto> list = new ArrayList<MYTestDto>();
		
		try {
			// 3.
			stmt = con.createStatement();
			
			// 4.
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				MYTestDto temp = new MYTestDto();
				temp.setMno(rs.getInt("MNO"));
				temp.setMname(rs.getString("MNAME"));
				temp.setNickname(rs.getString("NICKNAME"));
				
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
	
	public MYTestDto selectOne(int mno) {

		MYTestDto temp = new MYTestDto();
		
		Connection con = getConnection();

		String sql = " SELECT MNO, MNAME, NICKNAME "
				+ " FROM MYTEST "
				+ " WHERE MNO = ? ";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, mno);
			
			rs = pstm.executeQuery();
			while (rs.next()) {
				
				temp.setMno(rs.getInt(1));
				temp.setMname(rs.getString(2));
				temp.setNickname(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}
		
		
		return temp;
	}
	
	public int insert(MYTestDto dto) {
		
		Connection con = getConnection();
		
		String sql = " INSERT INTO MYTEST "
				+ " VALUES (?, ?, ?) ";
		
		PreparedStatement pstm = null;
		int res = 0;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, dto.getMno());
			pstm.setString(2, dto.getMname());
			pstm.setString(3, dto.getNickname());
			
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
	
	public int update(MYTestDto dto) {
		
		Connection con = getConnection();
		
		String sql = " UPDATE MYTEST "
				+ " SET MNAME = ? , NICKNAME = ?"
				+ " WHERE MNO = ? ";
		
		PreparedStatement pstm = null;
		int res = 0;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMname());
			pstm.setString(2, dto.getNickname());
			pstm.setInt(3, dto.getMno());
			
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
	
	public int delete(int mno) {
		
		Connection con = getConnection();
		
		String sql = " DELETE FROM MYTEST "
				+ " WHERE MNO = ? ";
		
		PreparedStatement pstm = null;
		int res = 0;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, mno);
			
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
