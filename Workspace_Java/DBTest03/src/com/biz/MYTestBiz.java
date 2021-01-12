package com.biz;

import java.util.List;

import com.dao.MYTestDao;
import com.dto.MYTestDto;

// Biz : business Logic -> 연산 / 처리
public class MYTestBiz {

	private MYTestDao dao = new MYTestDao();

	public List<MYTestDto> selectList()
	{
		return dao.selectList();
	}
	
	public  MYTestDto selectOne(int mno) {
		return dao.selectOne(mno);
	}
	
	public int insert(MYTestDto dto) {
		return dao.insert(dto);
	}
	
	public int update(MYTestDto dto) {
		return dao.update(dto);
	}
	
	public int delete(int mno) {
		return dao.delete(mno);
	}	
}
