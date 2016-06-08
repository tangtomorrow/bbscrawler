package org.tym.bbscrawler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tym.bbscrawler.dao.ILoginInfoDAO;
import org.tym.bbscrawler.dao.IUserDAO;
import org.tym.bbscrawler.model.LoginInfo;
import org.tym.bbscrawler.model.User;
import org.tym.bbscrawler.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	private IUserDAO userDAO;
	private ILoginInfoDAO loginInfoDAO;

	public void insertUser(User user) {
		//return userDAO.insertUser(user);
		userDAO.insertUser(user);
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setUserid(user.getUserid());
		loginInfo.setLoginip(user.getLastLoginIp());
		if (loginInfoDAO.findLoginInfoByUseridLoginip(loginInfo) == -1) {
			loginInfoDAO.insertLoginInfo(loginInfo);
		}
	}

	public User findUserById(int id) {
		return userDAO.findUserById(id);
	}

	public User findUserByUserid(String userid) {
		return userDAO.findUserByUserid(userid);
	}

	public int updateUser(User user) {
		return userDAO.updateUser(user);
	}

	public int getUserNum() {
		return userDAO.getUserNum();
	}

	public List<User> queryAllUsers() {
		return userDAO.queryAllUsers();
	}
	
	public int deleteUserById(int id) {
		return userDAO.deleteUserById(id);
	}
	
	public List<User> qureyModeratorsByBoard(String board) {
		return userDAO.qureyModeratorsByBoard(board);
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}
	
	@Autowired
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public ILoginInfoDAO getLoginInfoDAO() {
		return loginInfoDAO;
	}

	@Autowired
	public void setLoginInfoDAO(ILoginInfoDAO loginInfoDAO) {
		this.loginInfoDAO = loginInfoDAO;
	}
	
}
