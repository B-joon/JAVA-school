package com.biz;

import java.util.List;

public interface ScoreBiz {

	public List<ScoreDto> selectList();
	public ScoreDto selectOne(int m_no);
	
	
	
}
