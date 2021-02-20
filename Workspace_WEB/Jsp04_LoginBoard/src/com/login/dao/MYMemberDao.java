package com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static com.login.db.JDBCTemplate.*;
import com.login.dto.MYMemberDto;

public class MYMemberDao {

	/*
	 * 관리자(ADMIN) 기능
	 * 1. 회원 전체 정보 확인 (탈퇴한 회원도 포함)
	 * 2. 회원 전체 정보 확인 (MYENABLED='y'인 -> 탈퇴안한 회원들의정보
	 * 3. 회원 등겁 조정 (ADMIN<->USER)
	 */
	// 1. 전체 정보
	public List<MYMemberDto> selectAllUser() {
		
		Connection con = getConnection();
		
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE "
				+ " FROM MYMEMBER "
				+ " ORDER BY MYNO DESC ";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MYMemberDto> list = new ArrayList<MYMemberDto>();
		
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				MYMemberDto dto = new MYMemberDto();
				dto.setMyno(rs.getInt(1));
				dto.setMyid(rs.getString(2));
				dto.setMypw(rs.getString(3));
				dto.setMyname(rs.getString(4));
				dto.setMyaddr(rs.getString(5));
				dto.setMyphone(rs.getString(6));
				dto.setMyemail(rs.getString(7));
				dto.setMyenable(rs.getString(8));
				dto.setMyrole(rs.getString(9));
				
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
	// 2. 전체정보(탈퇴안한)
	public List<MYMemberDto> selectEnabledUser() {
		
		Connection con = getConnection();
		
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE "
				+ " FROM MYMEMBER "
				+ " WHERE MYENABLED = 'Y' "
				+ " ORDER BY MYNO DESC ";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MYMemberDto> list = new ArrayList<MYMemberDto>();
		
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				MYMemberDto dto = new MYMemberDto();
				dto.setMyno(rs.getInt(1));
				dto.setMyid(rs.getString(2));
				dto.setMypw(rs.getString(3));
				dto.setMyname(rs.getString(4));
				dto.setMyaddr(rs.getString(5));
				dto.setMyphone(rs.getString(6));
				dto.setMyemail(rs.getString(7));
				dto.setMyenable(rs.getString(8));
				dto.setMyrole(rs.getString(9));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs, pstm, con);
		}
		
		return list;
	}
	// 3. 회원 등급 조정
	public int updateRole(int myno, String myrole) {
		return 0;
	}
	
	/*
	 * 	사용자 (USER) 기능
	 * 1. 로그인
	 * 3. 회원가입 <- 2. 아이디 중복체크
	 * 4. 내 정보 조회
	 * 5. 내 정보 수정
	 * 6. 회원 탈퇴 (delete 안써!!! update : myenabled를 n으로 바꾸자.
	 */
	
	// 1. 로그인
	public MYMemberDto login(String myid, String mypw) {
		
		Connection con = getConnection();
		
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE "
				+ " FROM MYMEMBER "
				+ " WHERE MYID = ? "
				+ " AND MYPW = ? ";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		// side effect
		
		MYMemberDto dto = null;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, myid);
			pstm.setString(2, mypw);
			
			rs = pstm.executeQuery();
			while (rs.next()) {
				dto = new MYMemberDto();
				dto.setMyno(rs.getInt(1));
				dto.setMyid(rs.getString(2));
				dto.setMypw(rs.getString(3));
				dto.setMyname(rs.getString(4));
				dto.setMyaddr(rs.getString(5));
				dto.setMyphone(rs.getString(6));
				dto.setMyemail(rs.getString(7));
				dto.setMyenable(rs.getString(8));
				dto.setMyrole(rs.getString(9));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs, pstm, con);
		}
		
		return dto;
	}
	// 2. 중복체크
	public MYMemberDto idCheck(String myid) {
		return null;
	}
	// 3. 회원가입
	public int insertUser(MYMemberDto dto) {
		return 0;
	}
	// 4. 정보 조회
	public MYMemberDto selectUser(int myno) {
		return null;
	}
	// 5. 정보 수정
	public int updateUser(MYMemberDto dto) {
		return 0;
	}
	// 6. 회원 탈퇴
	public int deleteUser(int myno) {
		return 0;
	}
}
