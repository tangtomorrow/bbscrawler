package org.tym.bbscrawler.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.tym.bbscrawler.dao.IUserDAO;
import org.tym.bbscrawler.model.User;
import org.tym.bbscrawler.utils.DBUtils;

public class UserDAOImpl implements IUserDAO {

	public void insertUser(User user) {

		SqlSession session = DBUtils.getSession();
		try {
			IUserDAO iuserdao = session.getMapper(IUserDAO.class);
			iuserdao.insertUser(user);

			session.commit();

		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
