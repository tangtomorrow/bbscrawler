package org.tym.bbscrawler.dao;

import org.tym.bbscrawler.model.User;

public interface IUserDAO {
	// 插入user
	public boolean insertUser(User user);
	
	// 根据userid查找User
	public User findUserByUserid(String userid);
	
	// 根据userid更新其他字段
	public boolean updateUser(User user);
}
