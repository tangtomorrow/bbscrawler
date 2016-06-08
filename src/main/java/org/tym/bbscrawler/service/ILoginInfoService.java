package org.tym.bbscrawler.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.tym.bbscrawler.model.LoginInfo;

@Transactional
public interface ILoginInfoService {
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
}
