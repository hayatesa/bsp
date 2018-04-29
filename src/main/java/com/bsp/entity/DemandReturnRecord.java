package com.bsp.entity;

import java.util.Date;

/**
 * 图书还书记录表（已还）
 * 2018年2月25日00:16:53
 * @author wjb
 *
 */
public class DemandReturnRecord {
	private int drrId;			//需求还书记录标识
	private Date lendingTime;	//借出时间
	private Date actualRT;		//实际还书时间
	private byte starRating;	//星级评分
	private byte drrDelete;		//删除借阅成功记录
	private User user;			//响应需求者
	private DemandBooks demandBooks;//需求的图书标识以及需求者
	
	public DemandReturnRecord() {
		
	}

	public int getDrrId() {
		return drrId;
	}

	public void setDrrId(int drrId) {
		this.drrId = drrId;
	}

	public Date getLendingTime() {
		return lendingTime;
	}

	public void setLendingTime(Date lendingTime) {
		this.lendingTime = lendingTime;
	}

	public Date getActualRT() {
		return actualRT;
	}

	public void setActualRT(Date actualRT) {
		this.actualRT = actualRT;
	}

	public byte getStarRating() {
		return starRating;
	}

	public void setStarRating(byte starRating) {
		this.starRating = starRating;
	}

	public byte getDrrDelete() {
		return drrDelete;
	}

	public void setDrrDelete(byte drrDelete) {
		this.drrDelete = drrDelete;
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
