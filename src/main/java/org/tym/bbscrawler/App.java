package org.tym.bbscrawler;

import java.util.Collections;
import java.util.List;

import org.tym.bbscrawler.constant.BBSUrl;
import org.tym.bbscrawler.pageprocessor.BBSUserPageProcessor;
import org.tym.bbscrawler.pipeline.MySQLPipeline;
import org.tym.bbscrawler.utils.BBSUtil;
import org.tym.bbscrawler.utils.ServiceUtil;

import us.codecraft.webmagic.Spider;

/**
 * Hello world!
 *
 */
public class App {
	// 已有数据的记录数
	public static int totalCount = ServiceUtil.getUserService().getUserNum();

	public static void main(String[] args) {
		
		startSpider();
	}

	public static void startSpider() {
		Spider spider = Spider.create(new BBSUserPageProcessor());

		// Add urls
		List<String> boardList = BBSUtil.getAllBoardNames();
		if (boardList != null && boardList.size() > 0) {
			// 逆序添加url
			Collections.reverse(boardList);
			for (String boardName : boardList) {
				spider.addUrl(BBSUrl.BoardPrefix + boardName);
				//System.out.println(BBSUrl.BoardPrefix + boardName);
			}
		}

		spider.addPipeline(new MySQLPipeline()).thread(1).run();
	}
}
