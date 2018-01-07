package cn.jason.mybatis.dao;

import cn.jason.mybatis.entity.User;

public interface UserDao {

	/**
	 * 根据ID查找User记录
	 * 
	 * @param id user的ID
	 * @return user对象
	 */
	public User findUserById(Integer id);
}
