package org.tym.bbscrawler.model;

import java.sql.Timestamp;

public class User {
	private int id;
	private String userid; // ID
	private String username; // 昵称
	private int loginTimes; // 上站次数
	private int postArticles; // 发表文章数
	private String title; // 站内职务，可能为null

	private String constellation; // 星座，可能为null
	private Timestamp lastLoginTime; // 上次上站时间戳
	private String lastLoginIp; // 上次上站IP，可能IP，也可能*.nju.edu.cn

	private int experience; // 经验值，可能为“不告诉你”。上述情况分别处理成准确数字和－1
	private int performance; // 表现值
	private int life; // 生命力

	private String moderators; // 担任版主的版面（使用,隔开）
	
	public static final int UnToldExperience = -1;	//“不告诉你”的经验值，默认－1

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getConstellation() {
		return constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	public String getModerators() {
		return moderators;
	}

	public void setModerators(String moderators) {
		this.moderators = moderators;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLoginTimes() {
		return loginTimes;
	}

	public void setLoginTimes(int loginTimes) {
		this.loginTimes = loginTimes;
	}

	public int getPostArticles() {
		return postArticles;
	}

	public void setPostArticles(int postArticles) {
		this.postArticles = postArticles;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getPerformance() {
		return performance;
	}

	public void setPerformance(int performance) {
		this.performance = performance;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getUserid()).append(",").append(this.getUsername()).append(",").append(this.getLoginTimes())
				.append(",").append(this.getPostArticles()).append(",").append(this.getTitle()).append(",")
				.append(this.getConstellation()).append(",").append(this.getLastLoginTime()).append(",")
				.append(this.getLastLoginIp()).append(",").append(this.getExperience()).append(",")
				.append(this.getPerformance()).append(",").append(this.getLife()).append(",")
				.append(this.getModerators());
		return sb.toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
