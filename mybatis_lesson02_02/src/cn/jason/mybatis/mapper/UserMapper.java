package cn.jason.mybatis.mapper;

import cn.jason.mybatis.entity.User;

public interface UserMapper {

	/**
	 * 根据ID查找User记录
	 * 注意四原则：接口名、方法名、参数类型、返回值类型
	 * @param id user的ID
	 * @return user对象
	 */
	public User findUserById(Integer id);
}
