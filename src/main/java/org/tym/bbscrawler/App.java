package org.tym.bbscrawler;

import org.tym.bbscrawler.pageprocessor.BBSUserPageProcessor;
import org.tym.bbscrawler.pipeline.ConsolePipeline;
import org.tym.bbscrawler.pipeline.MySQLPipeline;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;

/**
 * Hello world!
 *
 */
public class App {
	
	// 插入数据的记录数
	public static int totalCount = 0;
	
	public static void main(String[] args) {
			
		Spider.create(new BBSUserPageProcessor())
				.addUrl("http://bbs.nju.edu.cn/board?board=Pictures")
				//.addPipeline(new FilePipeline("D:/hello.txt"))
				//.addPipeline(new FilePipeline())
				.addPipeline(new MySQLPipeline())
				.addPipeline(new ConsolePipeline())
				// 开启5个线程抓取
				.thread(1)
				// 启动爬虫
				.run();		
	}
}
