package cn.jason.mybatis.service;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import cn.jason.mybatis.mapper.UserMapper;

public class UserService {
	@Test
	public void test() throws IOException {
		// Mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂,传入Mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 创建会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 创建实现类对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		System.out.println(userMapper.findUserById(3));
	}
}
