package com.bsp.entity;

import java.util.Date;
/**
 * 图书借出记录类（未还）
 * 2018年2月25日18:41:06
 * @author wjb
 *
 */
public class ResponseRecord {
	private int rrId;				//需求响应记录标识
	private Date lendingTime;		//借出时间
	private Date expectedRT;		//预计还书时间
	
	private User user;				//响应需求者
	private DemandBooks demandBooks;//需求的图书标识,以及需求人信息
	/*
	 * 无参构造函数
	 */
	public ResponseRecord() {
		
	}
	public int getRrId() {
		return rrId;
	}
	public void setRrId(int rrId) {
		this.rrId = rrId;
	}
	public Date getLendingTime() {
		return lendingTime;
	}
	public void setLendingTime(Date lendingTime) {
		this.lendingTime = lendingTime;
	}
	public Date getExpectedRT() {
		return expectedRT;
	}
	public void setExpectedRT(Date expectedRT) {
		this.expectedRT = expectedRT;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public DemandBooks getDemandBooks() {
		return demandBooks;
	}
	public void setDemandBooks(DemandBooks demandBooks) {
		this.demandBooks = demandBooks;
	}
}
