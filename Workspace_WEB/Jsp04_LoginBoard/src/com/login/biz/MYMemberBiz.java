package com.login.biz;

import java.util.List;

import com.login.dao.MYMemberDao;
import com.login.dto.MYMemberDto;

public class MYMemberBiz {
	
	MYMemberDao dao;
	
	public MYMemberBiz() {
		dao = new MYMemberDao();
	}

	public List<MYMemberDto> selectAllUser() {
		return dao.selectAllUser();
	}
	public List<MYMemberDto> selectEnabledUser() {
		return dao.selectEnabledUser();
	}
	public int updateRole(int myno, String myrole) {
		return 0;
	}
	
	public MYMemberDto login(String myid, String mypw) {
		return dao.login(myid, mypw);
	}
	public MYMemberDto idCheck(String myid) {
		return null;
	}
	public int insertUser(MYMemberDto dto) {
		return 0;
	}
	public MYMemberDto selectUser(int myno) {
		return null;
	}
	public int updateUser(MYMemberDto dto) {
		return 0;
	}
	public int deleteUser(int myno) {
		return 0;
	}
}
