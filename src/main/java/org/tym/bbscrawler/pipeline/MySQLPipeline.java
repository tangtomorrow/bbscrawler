package org.tym.bbscrawler.pipeline;

import org.tym.bbscrawler.dao.IUserDAO;
import org.tym.bbscrawler.dao.impl.UserDAOImpl;
import org.tym.bbscrawler.model.User;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class MySQLPipeline implements Pipeline {

	public void process(ResultItems resultItems, Task task) {
		User user = resultItems.get("user");

		IUserDAO userDAO = new UserDAOImpl();
		if (userDAO.findUserByUserid(user.getUserid()) == null) {
			userDAO.insertUser(user);
		} else {
			System.out.println(user.getUserid());
		}

	}

}
