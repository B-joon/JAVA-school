package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MTest01 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		
		System.out.println("메뉴 선택");
		System.out.println("1: 전체선택 2: 특정 부서 선택 3: 부서추가 4: 부서 수정 5: 부서 삭제 6 : 종료");
		int select = sc.nextInt();

		switch (select) {
		case 1:
			selectList();
			break;
		case 2:
			selectOne();
			break;
		case 3:
			insert();
			break;
		case 4:
			update();
			break;
		case 5:
			delete();
			break;
		default:
			System.out.println("종료");
			
		}
		
//		selectList();
//		selectOne();
//		insert();
//		update();
//		delete();

	}
	
	public static void selectList() throws ClassNotFoundException, SQLException {
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
	
	public static void selectOne() {
		
		// DEPTNO를 입력 받아서, 부서테이블의 해당 부서 모든 정보 출력
		// SELECT DEPTNO, DNAME, LOC
		// FROM DEPT
		// WHERE DEPTNO = ??
		
		System.out.println("부서 번호를 입력하세요 : ");
		int deptno = sc.nextInt();
		
		// 1. driver 연결
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2. 계정 연결
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
		
		// 3. query 준비
		String sql = " SELECT DEPTNO, DNAME, LOC "
				+ " FROM DEPT "
				+ " WHERE DEPTNO = " + deptno;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.createStatement();
			// 4. query 결과 리턴
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				System.out.printf("%3d %15s %14s", rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				// 5. db 종료
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void insert() throws ClassNotFoundException {
		
		System.out.println("부서 번호 입력 : ");
		int deptno = sc.nextInt();
		System.out.println("부서 명 입력 : ");
		String dname = sc.next();
		System.out.println("지역 명 입력 : ");
		String loc = sc.next();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql = " INSERT INTO DEPT "
				+ " VALUES (?, ?, ?) ";
		
		PreparedStatement pstm = null;
		
		try {
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, deptno);
			pstm.setString(2, dname);
			pstm.setString(3, loc);
			
			int res = pstm.executeUpdate();
			if (res > 0) {
				System.out.println("입력 성공");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void update() {
		
		System.out.println("수정할 부서번호를 입력 : ");
		int deptno = sc.nextInt();
		System.out.println("변경할 지역명을 입력 : ");
		String loc = sc.next();
		System.out.println("변경할 부서이름을 입력 : ");
		String dname = sc.next();

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql = " UPDATE DEPT "
				+ " SET DNAME = ?, loc = ? " 
				+ " WHERE DEPTNO = ? ";
		
		PreparedStatement pstm = null;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dname);
			pstm.setString(2, loc);
			pstm.setInt(3, deptno);
			
			int res = pstm.executeUpdate();
			if (res > 0) {
				System.out.println("수정 완료");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void delete() {
		
		System.out.println("삭제할 부서명을 입력 : ");
		String dname = sc.next();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql = " DELETE FROM DEPT "
				+ " WHERE DEPTNO = ? ";
		
		PreparedStatement pstm = null;
		
		try {
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dname);
			
			int res = pstm.executeUpdate();
			if (res > 0) {
				System.out.println("입력 완료");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
