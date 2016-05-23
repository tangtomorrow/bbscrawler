package org.tym.bbscrawler.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.tym.bbscrawler.model.User;

public class StringUtil {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy", Locale.US);
	
	/**
	 * 根据个人页面的内容，解析出User对象
	 * 
	 * @param content
	 *            经过处理之后的个人信息
	 * @return
	 */
	public static User parseUser(String content) {
		if (content == null || content.equals("")) {
			return null;
		}
		
		String[] strs = content.split("\n");
		if (strs.length < 4) {
			return null;
		}
		
		//System.out.println(content);
		//System.out.println("---------------------------");
		//System.out.println("Length:\t" + strs.length);
	
		User user = new User();
		
		// 第一行
		user.setUserid(strs[0].substring(0, strs[0].indexOf('(') - 1).trim());
		user.setUsername(strs[0].substring(strs[0].indexOf('(') + 1, strs[0].indexOf(')')).trim());
		user.setLoginTimes(Integer.parseInt(strs[0].substring(strs[0].indexOf("共上站") + 4, strs[0].lastIndexOf("发表文章") - 3).trim()));
		user.setPostArticles(Integer.parseInt(strs[0].substring(strs[0].lastIndexOf("发表文章") + 5, strs[0].lastIndexOf("篇") - 1).trim()));
		int firstStarIndex = strs[0].indexOf("★"), secondStarIndex = strs[0].lastIndexOf("★");
		if (firstStarIndex != secondStarIndex) {
			user.setTitle(strs[0].substring(firstStarIndex + 1, secondStarIndex).trim());
		}
		
		//System.out.println(user.getUserid() + "\t" + user.getUsername() + "\t" + user.getLoginTimes() + "\t" + user.getPostArticles() + "\t" + user.getTitle());
		/*
		String userid = strs[0].substring(0, strs[0].indexOf('(') - 1);
		String username = strs[0].substring(strs[0].indexOf('(') + 1, strs[0].indexOf(')'));
		String loginTimes = strs[0].substring(strs[0].indexOf("共上站") + 4, strs[0].lastIndexOf("发表文章") - 3);
		String postArticles = strs[0].substring(strs[0].lastIndexOf("发表文章") + 5, strs[0].lastIndexOf("篇") - 1);
		String title = null;
		int firstStarIndex = strs[0].indexOf("★"), secondStarIndex = strs[0].lastIndexOf("★");
		if (firstStarIndex != secondStarIndex) {
			title = strs[0].substring(firstStarIndex + 1, secondStarIndex);
		}
		*/
		
		// 第二行
		if (strs[1].startsWith("[")) {
			user.setConstellation(strs[1].substring(1, 5).trim());
			strs[1] = strs[1].substring(7);
		}		
		user.setLastLoginTime(StringUtil.formatDate(strs[1].substring(strs[1].indexOf('[') + 1, strs[1].indexOf(']')).trim()));
		user.setLastLoginIp(strs[1].substring(strs[1].lastIndexOf('[') + 1, strs[1].lastIndexOf(']')).trim());
		
		//System.out.println(user.getConstellation() + "\t" + user.getLastLoginTime() + "\t" + user.getLastLoginIp());
		/*
		String constellation = null;
		if (strs[1].startsWith("[")) {
			constellation = strs[1].substring(1, 5);
			strs[1] = strs[1].substring(7);
		}
		System.out.println(strs[1]);
		String lastLoginTime = strs[1].substring(strs[1].indexOf('[') + 1, strs[1].indexOf(']'));
		String lastLoginIp = strs[1].substring(strs[1].lastIndexOf('[') + 1, strs[1].lastIndexOf(']'));
		*/

		// 第三行
		if (!strs[2].contains("经验值：(不告诉你)")) {
			user.setExperience(Integer.parseInt((strs[2].substring(strs[2].indexOf("经验值") + 6, strs[2].indexOf('(') - 1)).trim()));
		}
		else {
			user.setExperience(User.UnToldExperience);
		}
		user.setPerformance(Integer.parseInt(strs[2].substring(strs[2].indexOf("表现值") + 6, strs[2].lastIndexOf('(') - 1).trim()));
		user.setLife(Integer.parseInt(strs[2].substring(strs[2].indexOf("生命力") + 6, strs[2].indexOf('。') - 1).trim()));
		
		//System.out.println(user.getExperience() + "\t" + user.getPerformance() + "\t" + user.getLife());
		/*
		String experience = "unknown";
		if (!strs[2].contains("经验值：(不告诉你)")) {
			experience = strs[2].substring(strs[2].indexOf("经验值") + 6, strs[2].indexOf('(') - 1);
		}
		String performance = strs[2].substring(strs[2].indexOf("表现值") + 6, strs[2].lastIndexOf('(') - 1);
		String life = strs[2].substring(strs[2].indexOf("生命力") + 6, strs[2].indexOf('。') - 1);
		*/
		
		// 版主多行
		if (strs.length > 5 && strs[3].startsWith("★")) {
			int thirdEnterIndex = content.indexOf('\n', content.indexOf("表现值："));
			String newStr = content.substring(thirdEnterIndex + 1).replace("\n", "");
			//System.out.println(newStr);
			user.setModerators(newStr.substring(newStr.indexOf("现任") + 2, newStr.lastIndexOf("版版主(版副)")).trim());
		}
		
		//System.out.println(user);
		
		return user;
	}

	/**
	 * 将网页中获取的个人信息内容，进行处理
	 * @param originContent 处理之前的个人信息
	 * @return
	 */
	public static String formatContent(String originContent) {
		String finalStr = originContent.replaceAll("\\[\\d\\dm", "").replaceAll("\\[m", "")
				.replaceAll("\\[\\d;\\d\\dm", "").replace("[[brd]", "").replace("[/brd]]", "");

		int index = finalStr.indexOf("个人说明档如下");
		if (index == -1) {
			index = finalStr.indexOf("没有个人说明档");
		}
		finalStr = finalStr.substring(0, index).trim();
		//System.out.println(finalStr);
		return finalStr;
	}
	
	/**
	 * 格式化时间
	 * @param originDate 原始时间字符串，如"Sun May 22 21:37:11 2016"
	 * @return 时间戳，如"2016-05-03 13:29:15.0"
	 */
	public static Timestamp formatDate(String originDate) {
		long times = 0;
		try {
			times = sdf.parse(originDate).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Timestamp(times);
	}
}
