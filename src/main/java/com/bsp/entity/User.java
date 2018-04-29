package com.bsp.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户账号类，所有UUID的来源
 * 2018年2月24日17:32:27
 * @author wjb
 *
 */
public class User {
	private String UUID;		//用户唯一标识符号
	private String mail;		//用户邮箱，作为用户登录账号
	private String password;	//用户登录账号密码
	
	private Set<News> newsSet = new HashSet<News>();//用户对应的消息
	
	private Set<BorrowBooks> borrowBooksSet = new HashSet<BorrowBooks>();//用户拥有的所有图书
	private Set<LendingRecord> lendingRecordsSet = new HashSet<LendingRecord>();//用户的正在借阅的图书
	private Set<ReturnBookRecord> returnBookRecordsSet = new HashSet<ReturnBookRecord>();//用户完成借阅的记录
	
	private Set<DemandBooks> demandBooksSet = new HashSet<DemandBooks>();//用户需求的所有图书
	private Set<DemandReturnRecord> dReturnRecordsSet = new HashSet<DemandReturnRecord>();//用户需求借阅完成的图书
	private Set<ResponseRecord> responseRecordsSet = new HashSet<ResponseRecord>();//用户被响应的记录
	
	
	/*
	 * 无参构造函数
	 */
	public User(){}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<News> getNewsSet() {
		return newsSet;
	}

	public void setNewsSet(Set<News> newsSet) {
		this.newsSet = newsSet;
	}

	public Set<BorrowBooks> getBorrowBooksSet() {
		return borrowBooksSet;
	}

	public void setBorrowBooksSet(Set<BorrowBooks> borrowBooksSet) {
		this.borrowBooksSet = borrowBooksSet;
	}

	public Set<LendingRecord> getLendingRecordsSet() {
		return lendingRecordsSet;
	}

	public void setLendingRecordsSet(Set<LendingRecord> lendingRecordsSet) {
		this.lendingRecordsSet = lendingRecordsSet;
	}

	public Set<ReturnBookRecord> getReturnBookRecordsSet() {
		return returnBookRecordsSet;
	}

	public void setReturnBookRecordsSet(Set<ReturnBookRecord> returnBookRecordsSet) {
		this.returnBookRecordsSet = returnBookRecordsSet;
	}

	public Set<DemandBooks> getDemandBooksSet() {
		return demandBooksSet;
	}

	public void setDemandBooksSet(Set<DemandBooks> demandBooksSet) {
		this.demandBooksSet = demandBooksSet;
	}

	public Set<DemandReturnRecord> getdReturnRecordsSet() {
		return dReturnRecordsSet;
	}

	public void setdReturnRecordsSet(Set<DemandReturnRecord> dReturnRecordsSet) {
		this.dReturnRecordsSet = dReturnRecordsSet;
	}

	public Set<ResponseRecord> getResponseRecordsSet() {
		return responseRecordsSet;
	}

	public void setResponseRecordsSet(Set<ResponseRecord> responseRecordsSet) {
		this.responseRecordsSet = responseRecordsSet;
	}
}
