package cn.jason.mybatis.service;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.jason.mybatis.dao.UserDao;
import cn.jason.mybatis.impl.UserDaoImpl;

public class UserService {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void before() throws Exception {
		// Mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂,传入Mybatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void test() {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		System.out.println(userDao.findUserById(3));
	}
}
