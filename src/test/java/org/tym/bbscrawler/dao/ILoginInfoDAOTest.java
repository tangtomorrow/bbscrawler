package org.tym.bbscrawler.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tym.bbscrawler.dao.impl.LoginInfoDAOImpl;
import org.tym.bbscrawler.model.LoginInfo;
import org.tym.bbscrawler.service.IUserService;

public class ILoginInfoDAOTest {
	
	public static ILoginInfoDAO loginInfodao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		loginInfodao = (ILoginInfoDAO) ac.getBean("loginInfoDAO");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testInsertLoginInfo() {
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setUserid("tangtomorrow");
		loginInfo.setLoginip("114.212.51.111");
		loginInfodao.insertLoginInfo(loginInfo);
	}

	@Test
	public void testFindLoginInfoById() {
		System.out.println(loginInfodao.findLoginInfoById(1));
	}
	
	@Test
	public void testFindLoginInfoByUserid() {
		List<LoginInfo> list = loginInfodao.findLoginInfoByUserid("911117");
		for (LoginInfo loginInfo : list) {
			System.out.println(loginInfo);
		}	
	}
	
	@Test
	public void testFindLoginIpByUserid() {
		List<String> list = loginInfodao.findLoginIpByUserid("911117");
		for (String loginIp : list) {
			System.out.println(loginIp);
		}
	}
	
	@Test
	public void testFindLoginInfoByUseridLoginip() {
		LoginInfo info = new LoginInfo();
		info.setLoginip("114.212.83.990");
		info.setUserid("911117");
		System.out.println(loginInfodao.findLoginInfoByUseridLoginip(info));
	}
}
