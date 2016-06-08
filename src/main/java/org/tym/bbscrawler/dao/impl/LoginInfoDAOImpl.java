package org.tym.bbscrawler.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.tym.bbscrawler.dao.ILoginInfoDAO;
import org.tym.bbscrawler.model.LoginInfo;

public class LoginInfoDAOImpl extends SqlSessionDaoSupport implements ILoginInfoDAO {

	public int insertLoginInfo(LoginInfo loginInfo) {
		return this.getSqlSession().insert("org.tym.bbscrawler.dao.ILoginInfoDAO.insertLoginInfo", loginInfo);
	}

	public LoginInfo findLoginInfoById(int id) {
		return this.getSqlSession().selectOne("org.tym.bbscrawler.dao.ILoginInfoDAO.findLoginInfoById", id);
	}

	public List<LoginInfo> findLoginInfoByUserid(String userid) {
		return this.getSqlSession().selectList("org.tym.bbscrawler.dao.ILoginInfoDAO.findLoginInfoByUserid", userid);
	}

	public List<String> findLoginIpByUserid(String userid) {
		return this.getSqlSession().selectList("org.tym.bbscrawler.dao.ILoginInfoDAO.findLoginIpByUserid", userid);
	}

	/*
	public int findLoginInfoByUseridLoginip(String userid, String loginIp) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("userid", userid);
		params.put("loginIp", loginIp);
		LoginInfo loginInfo = this.getSqlSession().selectOne("org.tym.bbscrawler.dao.ILoginInfoDAO.checkIfLoginInfoExist", params);
		if (loginInfo != null) {
			return loginInfo.getId();
		}
		return -1;
	}
	*/

	public int findLoginInfoByUseridLoginip(LoginInfo info) {
		return this.getSqlSession().selectOne("org.tym.bbscrawler.dao.ILoginInfoDAO.findLoginInfoByUseridLoginip", info);
	}
}
