package org.tym.bbscrawler.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tym.bbscrawler.service.IUserService;

public class ServiceUtil {
	
	private final static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
	
	/**
	 * 获取UserService实例
	 * @return
	 */
	public static IUserService getUserService() {
		return (IUserService) applicationContext.getBean("userService");
	}
}
