package com.muldel.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.muldel.db.SqlMapConfig;
import com.muldel.dto.MDBoardDto;

public class MDBoardDaoImpl extends SqlMapConfig implements MDBoardDao {

	private String namespace = "com.muldel.mapper.";
	
	@Override
	public List<MDBoardDto> selectList() {
		
		
		
		return list;
	}

	@Override
	public MDBoardDto selectOne(int seq) {

		return dto;
	}

	@Override
	public int insert(MDBoardDto dto) {

		return res;
	}

	@Override
	public int update(MDBoardDto dto) {

		return res;
	}

	@Override
	public int delete(int seq) {

		return res;
	}

	@Override
	public int multiDelete(String[] seqs) {

		return count;
	}

}
