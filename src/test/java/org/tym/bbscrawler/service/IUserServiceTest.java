package org.tym.bbscrawler.service;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tym.bbscrawler.constant.BBSUrl;
import org.tym.bbscrawler.model.User;
import org.tym.bbscrawler.utils.NetUtil;

public class IUserServiceTest {

	private static IUserService userService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		userService = (IUserService) ac.getBean("userService");
	}

	@Test
	public void testInsertUser() {
		System.out.println("Test IUserService.insertUser()");
		User user = NetUtil.parseUserUrl(BBSUrl.UserPrefix + "lifegamer");
		System.out.println(user);
		userService.insertUser(user);
		System.out.println(user.getId());
	}

	@Test
	public void testQueryAllUsers() {
		System.out.println("Test IUserService.queryAllUsers()");
		System.out.println(userService.queryAllUsers().size());
	}

	@Test
	public void testFindUserById() {
		System.out.println("Test IUserService.findUserById()");
		System.out.println(userService.findUserById(87));
	}

	@Test
	public void testFindUserByUserid() {
		System.out.println("Test IUserService.findUserByUserid()");
		System.out.println(userService.findUserByUserid("SYSOP"));
	}

	@Test
	public void testUpdateUser() {
		System.out.println("Test IUserService.updateUser()");
		String userid = "SYSOP";
		System.out.println(userService.findUserByUserid(userid));
		User user = NetUtil.parseUserUrl(BBSUrl.UserPrefix + userid);
		System.out.println(userService.updateUser(user));
		System.out.println(userService.findUserByUserid(userid));
	}

	@Test
	public void testGetUserNum() {
		System.out.println("Test IUserService.getUserNum()");
		System.out.println(userService.getUserNum());
	}
	
	@Test
	public void testDeleteUserById() {
		System.out.println("Test IUserService.deleteUserById()");
		System.out.println(userService.deleteUserById(27));
	}
	
	@Test
	public void testQureyModeratorsByBoard() {
		System.out.println("Test IUserService.qureyModeratorsByBoard()");
		List<User> users = userService.qureyModeratorsByBoard("TaiZhou");
		for (User user : users) {
			System.out.println(user.getUserid());
		}
	}
}
