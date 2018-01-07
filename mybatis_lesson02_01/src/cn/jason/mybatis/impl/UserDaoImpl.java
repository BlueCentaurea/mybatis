package cn.jason.mybatis.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.jason.mybatis.dao.UserDao;
import cn.jason.mybatis.entity.User;

public class UserDaoImpl implements UserDao {
	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(Integer id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("test.findUserById", id);
	}
}
