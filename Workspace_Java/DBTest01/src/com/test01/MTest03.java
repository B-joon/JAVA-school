package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MTest03 {

	// DEPTNO를 입력 받아서, 부서테이블의 해당 부서 모든 정보 출력
	// SELECT DEPTNO, DNAME, LOC
	// FROM DEPT
	// WHERE DEPTNO = ??
	public static void main(String[] args) {
		
		try {
			selectOne();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void selectOne() throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("부서번호를 입력하세요 : ");
		int deptno = sc.nextInt();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		String sql = " SELECT DEPTNO, DNAME, LOC "
				+ " FROM DEPT "
				+ " WHERE DEPTNO = " + deptno;
		
		Statement stmt = con.createStatement();
		// 결과 테이블
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			System.out.printf("%2d %15s %14s", rs.getInt(1), rs.getString(2), rs.getString(3));
		}
		
		rs.close();
		stmt.close();
		con.close();;
		
	}

}
