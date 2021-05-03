package com.mvc.update.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mvc.update.model.dto.JDBCDto;

@Repository
public class JDBCDaoImpl implements JDBCDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<JDBCDto> selectList() {
		
		List<JDBCDto> list = new ArrayList<JDBCDto>();
		
		list = jdbcTemplate.query(SELECT_LIST_SQL, null, null, new RowMapper<JDBCDto>() {
		
				public JDBCDto mapRow(ResultSet rs, int rowNum) throws SQLException {
					return new JDBCDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
				}
			
		});
		
		return list;
	}

	@Override
	public JDBCDto selectOne(int seq) {
		return null;
	}

	@Override
	public int insert(JDBCDto dto) {
		return 0;
	}

	@Override
	public int update(JDBCDto dto) {
		return 0;
	}

	@Override
	public int delete(int seq) {
		return 0;
	}

}
