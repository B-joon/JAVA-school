package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MTest02 {

	// DEPT 테이블에 있는 모든 값을 출려해보자
	public static void main(String[] args) {
		
		try {
			selectlist();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void selectlist() throws ClassNotFoundException, SQLException {
		
		// 1. driver 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		// 3. query 준비
		String sql = " SELECT DEPTNO, DNAME, LOC " 
		+ " FROM DEPT ";
		Statement stmt = con.createStatement();
		
		// 4. query 결과 리턴
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
//			System.out.printf("%3d %15s %14s", rs.getInt(1), rs.getString(2), rs.getString(3));
		}
		
		// 5. db 종료
		rs.close();
		stmt.close();
		con.close();
		
	}
	
}
