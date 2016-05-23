package org.tym.bbscrawler.pageprocessor;

import org.tym.bbscrawler.model.User;
import org.tym.bbscrawler.utils.NetUtil;
import org.tym.bbscrawler.utils.StringUtil;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class BBSUserPageProcessor implements PageProcessor {
	
	public static final String URL_ALL = "http://bbs\\.nju\\.edu\\.cn.*";

	public static final String URL_USER = "http://bbs\\.nju\\.edu\\.cn/.*bbsqry\\?userid=[\\d\\w]+";
	
	//public static final String URL_BOARD = "http://bbs\\.nju\\.edu\\.cn/.*bbsdoc\\?board=.+";
	
	//public static final String URL_POST = "http://bbs\\.nju\\.edu\\.cn/.*bbstcon.+";

	// 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
	private Site site = Site.me().setDomain("bbs.nju.edu.cn").setRetryTimes(3).setSleepTime(500).setUserAgent(NetUtil.UserAgent);

	public Site getSite() {
		return site;
	}

	public void process(Page page) {		
		if (page.getUrl().regex(URL_USER).match()) {
			/*
			 * 获取用户信息部分
			 * 并放入结果集　
			 */
			String content = page.getHtml().xpath("//textarea").get();
			int index = content.lastIndexOf("</textarea>");
			content = content.substring(21, index);
			User user = StringUtil.parseUser(StringUtil.formatContent(content));
			page.putField("user", user);
		} else {
			page.addTargetRequests(page.getHtml().links().regex(URL_ALL).all());
			page.setSkip(true);
		}
	}

}
