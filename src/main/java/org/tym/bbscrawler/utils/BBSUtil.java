package org.tym.bbscrawler.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import org.tym.bbscrawler.constant.BBSUrl;
import org.tym.bbscrawler.model.LoginInfo;
import org.tym.bbscrawler.model.User;

public class BBSUtil {
	/**
	 * 获取版面名列表
	 * 
	 * @return
	 */
	public static List<String> getAllBoardNames() {
		List<String> boardList = null;

		InputStream in = null;
		try {
			// in = new FileInputStream("bbsboard/Boards.xml");
			/*
			 * 因为maven打包后资源路径会变，因此使用了mybatis的读取资源的工具 具体实现原理再看～
			 */
			in = Resources.getResourceAsStream("bbsboard/Boards.xml");
			Document doc = Jsoup.parse(in, "UTF-8", "", Parser.xmlParser());
			Elements elements = doc.select("Board");
			if (elements.size() > 0) {
				boardList = new ArrayList<String>();
				for (Element e : elements) {
					boardList.add(e.text());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return boardList;
	}

	/**
	 * 更新数据库user表中的所有纪录
	 */
	public static void updateAllUsers() {
		// 已有数据的记录数
		int totalCount = ServiceUtil.getUserService().getUserNum();

		for (int i = 1; i <= totalCount; i++) {
			long start = new Date().getTime();

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			User userExist = ServiceUtil.getUserService().findUserById(i);
			// System.out.println(userExist);
			if (userExist != null) {
				String userid = userExist.getUserid();
				User user = NetUtil.parseUserUrl(BBSUrl.UserPrefix + userid);
				if (!user.equals(userExist)) {
					System.out.println("[Update]:\t" + user.getUserid());
					ServiceUtil.getUserService().updateUser(user);

					LoginInfo loginInfo = new LoginInfo();
					loginInfo.setUserid(user.getUserid());
					loginInfo.setLoginip(user.getLastLoginIp());
					if (ServiceUtil.getLoginInfoService().findLoginInfoByUseridLoginip(loginInfo) == -1) {
						ServiceUtil.getLoginInfoService().insertLoginInfo(loginInfo);
					}
				}
			}

			long end = new Date().getTime();
			// System.out.println(end - start + "ms");

		}
	}

	/**
	 * 向数据库logininfo表中插入纪录
	 */
	public static void updateAllUsersLoginInfo() {
		// 已有数据的记录数
		int totalCount = ServiceUtil.getUserService().getUserNum();

		for (int i = 1; i <= totalCount; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			User userExist = ServiceUtil.getUserService().findUserById(i);
			// System.out.println(userExist);
			if (userExist != null) {
				String userid = userExist.getUserid();
				User user = NetUtil.parseUserUrl(BBSUrl.UserPrefix + userid);
				LoginInfo loginInfo = new LoginInfo();
				loginInfo.setUserid(user.getUserid());
				loginInfo.setLoginip(user.getLastLoginIp());
				if (ServiceUtil.getLoginInfoService().findLoginInfoByUseridLoginip(loginInfo) == -1) {
					ServiceUtil.getLoginInfoService().insertLoginInfo(loginInfo);
				}
			}
		}
	}
}
