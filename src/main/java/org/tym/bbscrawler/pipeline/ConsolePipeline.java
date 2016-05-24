package org.tym.bbscrawler.pipeline;

import org.tym.bbscrawler.model.User;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class ConsolePipeline implements Pipeline {

    public void process(ResultItems resultItems, Task task) {    	
    	//System.out.println(resultItems);
    	//System.out.println(resultItems.get("user"));
    	User user = resultItems.get("user");
    	System.out.println(user.getUserid() + "\t" + user.getUsername());
    }
}
