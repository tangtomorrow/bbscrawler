package org.tym.bbscrawler.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.tym.bbscrawler.dao.IUserDAO;
import org.tym.bbscrawler.model.User;

public class UserDAOImpl extends SqlSessionDaoSupport implements IUserDAO {

	public int insertUser(User user) {
		return this.getSqlSession().insert("org.tym.bbscrawler.dao.IUserDAO.insertUser", user);
	}

	public User findUserById(int id) {
		return this.getSqlSession().selectOne("org.tym.bbscrawler.dao.IUserDAO.findUserById", id);
	}

	public User findUserByUserid(String userid) {
		return this.getSqlSession().selectOne("org.tym.bbscrawler.dao.IUserDAO.findUserByUserid", userid);
	}

	public int updateUser(User user) {
		return this.getSqlSession().update("org.tym.bbscrawler.dao.IUserDAO.updateUser", user);
	}

	public int getUserNum() {
		return this.getSqlSession().selectOne("org.tym.bbscrawler.dao.IUserDAO.getUserNum");
	}

	public List<User> queryAllUsers() {
		return this.getSqlSession().selectList("org.tym.bbscrawler.dao.IUserDAO.queryAllUsers");
	}

	public int deleteUserById(int id) {
		return this.getSqlSession().delete("org.tym.bbscrawler.dao.IUserDAO.deleteUserById", id);
	}

}
