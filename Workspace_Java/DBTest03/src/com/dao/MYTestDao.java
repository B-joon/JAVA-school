package com.dao;

import static com.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dto.MYTestDto;

// Data Access Object : DB와 접근하는 객체.
// import static : class.method 하고 호출 할 때, class 생략
public class MYTestDao {
	
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
	
}
