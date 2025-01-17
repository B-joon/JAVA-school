package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MTest04 {

	// DEPT 테이블에 값 저장
	public static void main(String[] args) {
		
//		insert();
		insetForPrepared();

	}
	
	public static void insetForPrepared() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("부서번호 입력 : ");
		int deptno = sc.nextInt();
		System.out.println("부서이름 입력 : ");
		String dname = sc.next();
		System.out.println("지역 입력 : ");
		String loc = sc.next();
		
		//1.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//2.
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3.
		String sql = " INSERT INTO DEPT "
				+ " VALUES (?, ?, ?) ";
		PreparedStatement pstm = null;
		
		try {
			//3.
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, deptno);
			pstm.setString(2, dname);
			pstm.setString(3, loc);
			
			//4.
			int res = pstm.executeUpdate();
			if (res > 0) {
				System.out.println("입력 성공");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//5.
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void insert() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("부서번호 입력 : ");
		int deptno = sc.nextInt();
		System.out.println("부서이름 입력 : ");
		String dname = sc.next();
		System.out.println("지역 입력 : ");
		String loc = sc.next();
		
		// 1.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 2.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
//			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql = " INSERT INTO DEPT "
				+ " VALUES ( " + deptno + ", '" + dname + "', '" + loc + "') ";
		
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 3. 
			stmt = con.createStatement();
			
			// 4.
			// row
			int res = stmt.executeUpdate(sql);
			if (res > 0) {
				System.out.println("입력 성공");
			} else {
				System.out.println("입력 실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		
		// 4.
		
		
		// 5.
		
	}

}
