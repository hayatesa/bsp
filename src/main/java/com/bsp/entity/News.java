package com.bsp.entity;


public class News {
	private int nId;
	private String nContent;
	private byte nStatus;
	private User user;
	/*
	 * 无参构造函数
	 */
	public News() {
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getnId() {
		return nId;
	}

	public void setnId(int nId) {
		this.nId = nId;
	}
	public String getnContent() {
		return nContent;
	}
	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	public byte getnStatus() {
		return nStatus;
	}
	public void setnStatus(byte nStatus) {
		this.nStatus = nStatus;
	}
}
