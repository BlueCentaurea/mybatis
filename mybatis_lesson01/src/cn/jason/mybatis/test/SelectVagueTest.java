package cn.jason.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.jason.mybatis.entity.User;

public class SelectVagueTest {
	// 根据id查询用户信息，得到一条记录结果
	@Test
	public void findUserByIdTest() throws IOException {
		// Mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂,传入Mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过工厂得到SQLSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 通过SQLSession操作数据库
		// 第一个参数：映射文件select的id，等于namespace+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配的paramenterType类型的参数
		// SQLSession.selectOne结果是映射文件中所匹配的ResultType类型的对象

		List<User> list = sqlSession.selectList("test.findUserList", "八");
		for (User u : list) {
			System.out.println(u);
		}

		// 释放资源
		sqlSession.close();
	}
}
