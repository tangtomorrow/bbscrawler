package org.tym.bbscrawler.pipeline;

import org.tym.bbscrawler.App;
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
		// 查找数据库中是否已有该userid对应的用户
		User userExist = userDAO.findUserByUserid(user.getUserid());
		if (userExist == null) {
			// 如果用户不存在
			userDAO.insertUser(user);
			App.totalCount++;
			System.out.println("[Insert]\t" + user.getUserid());
		} else if (!user.equals(userExist)) {
			System.out.println("[Update]\t" + user.getUserid());
			// 如果用户存在，但网页数据更新过
			userDAO.updateUser(user);
		} else {
			System.out.println("[**********]\t" + user.getUserid() + "\texists");
		}

	}

}
