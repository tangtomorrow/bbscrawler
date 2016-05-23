package org.tym.bbscrawler.pipeline;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.tym.bbscrawler.model.User;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.utils.FilePersistentBase;

public class FilePipeLine extends FilePersistentBase implements Pipeline {

    private PrintWriter printWriter;

    /**
     * create a FilePipeline with default path"/data/webmagic/"
     */
    public FilePipeLine() throws FileNotFoundException, UnsupportedEncodingException {
        //this("/Users/tangtomorrow/Work/Eclipse/bbscrawler/data.txt");
    	this("D:/hello.txt");
    }

    public FilePipeLine(String path) throws FileNotFoundException, UnsupportedEncodingException {
        setPath(path);
        printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(getFile(path)), "UTF-8"));
    }

	public void process(ResultItems resultItems, Task task) {
		/*
		
        printWriter.println("url:\t" + resultItems.getRequest().getUrl());
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            if (entry.getValue() instanceof Iterable) {
                Iterable value = (Iterable) entry.getValue();
                printWriter.println(entry.getKey() + ":");
                for (Object o : value) {
                    printWriter.println(o);
                }
            } else {
                printWriter.println(entry.getKey() + ":\t" + entry.getValue());
            }
        }
        printWriter.flush();
        */
        
		
		User user = resultItems.get("user");
		if (user != null) {
			printWriter.println(user.toString());
			printWriter.flush();
		}		
	}
}
