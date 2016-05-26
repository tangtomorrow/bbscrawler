package org.tym.bbscrawler.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

public class BBSUtil {
	/**
	 * 获取版面名列表
	 * @return
	 */
	public static List<String> getAllBoardNames() {
		List<String> boardList = null;

		InputStream in = null;
		try {
			in = new FileInputStream("bbsboard/Boards.xml");
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
}
