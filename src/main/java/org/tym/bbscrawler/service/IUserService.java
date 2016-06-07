package org.tym.bbscrawler.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.tym.bbscrawler.model.User;

@Transactional
public interface IUserService {
	// 插入user
	public int insertUser(User user);
	
	// 根据id查找User
	public User findUserById(int id);
	
	// 根据userid查找User
	public User findUserByUserid(String userid);
	
	// 根据userid更新其他字段
	public int updateUser(User user);
	
	// 获取当前已保存的用户数
	public int getUserNum();
	
	// 查找所有用户
	public List<User> queryAllUsers();
	
	// 根据id删除用户
	public int deleteUserById(int id);
}
