package org.tym.bbscrawler.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.tym.bbscrawler.dao.IUserDAO;
import org.tym.bbscrawler.model.User;
import org.tym.bbscrawler.utils.DBUtil;

public class UserDAOImpl implements IUserDAO {

	public boolean insertUser(User user) {
		boolean flag = true;

		SqlSession session = DBUtil.getSession();
		try {
			IUserDAO iuserdao = session.getMapper(IUserDAO.class);
			iuserdao.insertUser(user);

			session.commit();

		} catch (Exception e) {
			session.rollback();
			flag = false;
			e.printStackTrace();
		} finally {
			session.close();
		}

		return flag;
	}
	
	@Override
	public User findUserById(int id) {
		User user = null;
		
		SqlSession session = DBUtil.getSession();
		try {
			IUserDAO iuserdao = session.getMapper(IUserDAO.class);

			user = iuserdao.findUserById(id);

			session.commit();

		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return user;
	}

	public User findUserByUserid(String userid) {

		User user = null;

		SqlSession session = DBUtil.getSession();
		try {
			IUserDAO iuserdao = session.getMapper(IUserDAO.class);

			user = iuserdao.findUserByUserid(userid);

			session.commit();

		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return user;
	}

	public boolean updateUser(User user) {
		boolean flag = true;
		SqlSession session = DBUtil.getSession();
		try {
			IUserDAO iuserdao = session.getMapper(IUserDAO.class);

			iuserdao.updateUser(user);

			session.commit();

		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			flag = false;
		} finally {
			session.close();
		}

		return flag;
	}

	public int getUserNum() {
		int count = 0;
		SqlSession session = DBUtil.getSession();
		try {
			IUserDAO iuserdao = session.getMapper(IUserDAO.class);

			count = iuserdao.getUserNum();

			session.commit();

		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return count;
	}

}
