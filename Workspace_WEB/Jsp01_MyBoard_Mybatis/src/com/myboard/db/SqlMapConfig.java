package com.myboard.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public SqlSessionFactory getSqlSessionFactory() {
		
		// xml을 가지고와서   /  경로일때는 /를 사용한다.
		String resource = "com/myboard/db/mybatis-config.xml";

		try {
			// 가지고온 xml을 읽고
			InputStream inputStream = Resources.getResourceAsStream(resource);
			// 빌더가 만들어 지고 팩토리가 만들어 진다
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sqlSessionFactory;
	}
}
