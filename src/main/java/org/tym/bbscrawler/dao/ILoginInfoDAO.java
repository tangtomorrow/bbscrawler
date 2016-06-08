package org.tym.bbscrawler.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.tym.bbscrawler.model.LoginInfo;

@Repository("loginInfoDAO")
public interface ILoginInfoDAO {
	
	public int insertLoginInfo(LoginInfo loginInfo);
	
	public LoginInfo findLoginInfoById(int id);
	
	public List<LoginInfo> findLoginInfoByUserid(String userid);
	
	public List<String> findLoginIpByUserid(String userid);
	
	/**
	 * 查询是否已存在
	 * @param info 拼成的LoginInfo，不包含id
	 * @return
	 */
	public int findLoginInfoByUseridLoginip(LoginInfo info);
	
	/**
	 * 根据userid和loginIp，验证是否已存在
	 * 如果存在，返回对应id
	 * 如果不存在，返回－1
	 * @return
	 */
	//public int findLoginInfoByUseridLoginip(String userid, String loginIp);
	
}
