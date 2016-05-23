package org.tym.bbscrawler.dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.tym.bbscrawler.dao.impl.UserDAOImpl;
import org.tym.bbscrawler.model.User;
import org.tym.bbscrawler.utils.StringUtil;

public class IUserDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		User user = new User();
		user.setUserid("Opus");
		user.setUsername("xxx");
		user.setLoginTimes(1822);
		user.setPostArticles(289);
		user.setTitle(null);
		user.setConstellation("狮子座");
		user.setLastLoginTime(StringUtil.formatDate("Sun May 22 21:37:11 2016"));
		user.setLastLoginIp("Pic.nju.edu.cn");
		user.setExperience(6501);
		user.setPerformance(8);
		user.setLife(701);
		user.setModerators(null);
		
		IUserDAO iuserdao = new UserDAOImpl();
		iuserdao.insertUser(user);
	}

}
