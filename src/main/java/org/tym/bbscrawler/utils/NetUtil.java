package org.tym.bbscrawler.utils;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.tym.bbscrawler.model.User;

public class NetUtil {

	public final static String UserAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31";

	public static User parseUserUrl(String url) {
		User user = null;
		
		try {
			Document doc = Jsoup.connect(url).userAgent(UserAgent).get();
			String textArea = doc.getElementsByTag("textarea").get(0).text();
			user = StringUtil.parseUser(StringUtil.formatContent(textArea));
		} catch (IOException e) {
			System.out.println("Connection Error!:\t" + url);
			e.printStackTrace();
		}
		
		return user;
	}
}
