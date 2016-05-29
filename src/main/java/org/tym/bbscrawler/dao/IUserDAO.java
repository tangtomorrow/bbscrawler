package org.tym.bbscrawler.dao;

import java.util.List;

import org.tym.bbscrawler.model.User;

public interface IUserDAO {
	// 插入user
	public boolean insertUser(User user);
	
	// 根据id查找User
	public User findUserById(int id);
	
	// 根据userid查找User
	public User findUserByUserid(String userid);
	
	// 根据userid更新其他字段
	public boolean updateUser(User user);
	
	// 获取当前已保存的用户数
	public int getUserNum();
	
	// 分页查找
	//public List<User> queryUsersLimit(int startIndex, int count);
	
	// 查找所有用户
	public List<User> queryAllUsers();
}
