package org.tym.bbscrawler;

import java.util.List;

import org.tym.bbscrawler.dao.IUserDAO;
import org.tym.bbscrawler.dao.impl.UserDAOImpl;
import org.tym.bbscrawler.pageprocessor.BBSUserPageProcessor;
import org.tym.bbscrawler.pipeline.ConsolePipeline;
import org.tym.bbscrawler.pipeline.MySQLPipeline;
import org.tym.bbscrawler.utils.BBSUtil;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;

/**
 * Hello world!
 *
 */
public class App {
	// 已有数据的记录数
	public static int totalCount = new UserDAOImpl().getUserNum();

	public static void main(String[] args) {

		/*
		 * Spider.create(new BBSUserPageProcessor())
		 * .addUrl("http://bbs.nju.edu.cn/board?board=Pictures")
		 * //.addPipeline(new FilePipeline("D:/hello.txt")) //.addPipeline(new
		 * FilePipeline()) .addPipeline(new MySQLPipeline()) .addPipeline(new
		 * ConsolePipeline()) // 开启5个线程抓取 .thread(1) // 启动爬虫 .run();
		 */
		
		startSpider();
	}

	public static void startSpider() {
		String BBSBoardPrefix = "http://bbs.nju.edu.cn/board?board=";
		Spider spider = Spider.create(new BBSUserPageProcessor());

		// Add urls
		List<String> boardList = BBSUtil.getAllBoardNames();
		if (boardList != null && boardList.size() > 0) {
			for (String boardName : boardList) {
				spider.addUrl(BBSBoardPrefix + boardName);
				//System.out.println(BBSBoardPrefix + boardName);
			}
		}

		spider.addPipeline(new MySQLPipeline()).thread(1).run();
	}
}
