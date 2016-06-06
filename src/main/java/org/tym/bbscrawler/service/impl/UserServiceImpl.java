package org.tym.bbscrawler.service.impl;

import java.util.List;

import org.tym.bbscrawler.dao.IUserDAO;
import org.tym.bbscrawler.model.User;
import org.tym.bbscrawler.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDAO userDAO;
	
	@Override
	public int insertUser(User user) {
		return userDAO.insertUser(user);
	}

	@Override
	public User findUserById(int id) {
		return userDAO.findUserById(id);
	}

	@Override
	public User findUserByUserid(String userid) {
		return userDAO.findUserByUserid(userid);
	}

	@Override
	public boolean updateUser(User user) {
		return userDAO.updateUser(user);
	}

	@Override
	public int getUserNum() {
		return userDAO.getUserNum();
	}

	@Override
	public List<User> queryAllUsers() {
		return userDAO.queryAllUsers();
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
