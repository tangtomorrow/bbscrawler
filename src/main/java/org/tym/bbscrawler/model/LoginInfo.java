package org.tym.bbscrawler.model;

import java.io.Serializable;

public class LoginInfo implements Serializable {
	private static final long serialVersionUID = -5103276809495862499L;
	private int id;
	private String userid;
	private String loginip;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getLoginip() {
		return loginip;
	}
	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getUserid()).append(",").append(this.getLoginip());
		return sb.toString();
	}
}
