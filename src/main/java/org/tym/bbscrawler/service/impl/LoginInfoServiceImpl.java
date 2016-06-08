package org.tym.bbscrawler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tym.bbscrawler.dao.ILoginInfoDAO;
import org.tym.bbscrawler.model.LoginInfo;
import org.tym.bbscrawler.service.ILoginInfoService;

@Service("loginInfoService")
public class LoginInfoServiceImpl implements ILoginInfoService {
	
	private ILoginInfoDAO loginInfoDAO;
	
	public int insertLoginInfo(LoginInfo loginInfo) {
		return loginInfoDAO.insertLoginInfo(loginInfo);
	}

	public LoginInfo findLoginInfoById(int id) {
		return loginInfoDAO.findLoginInfoById(id);
	}

	public List<LoginInfo> findLoginInfoByUserid(String userid) {
		return loginInfoDAO.findLoginInfoByUserid(userid);
	}

	public List<String> findLoginIpByUserid(String userid) {
		return loginInfoDAO.findLoginIpByUserid(userid);
	}

	public int findLoginInfoByUseridLoginip(LoginInfo info) {
		return loginInfoDAO.findLoginInfoByUseridLoginip(info);
	}

	public ILoginInfoDAO getLoginInfoDAO() {
		return loginInfoDAO;
	}
	
	@Autowired
	public void setLoginInfoDAO(ILoginInfoDAO loginInfoDAO) {
		this.loginInfoDAO = loginInfoDAO;
	}

}
