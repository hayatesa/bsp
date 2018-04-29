package com.bsp.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 可借阅图书信息类
 * 2018年2月24日23:17:25
 * @author wjb
 *
 */
public class BorrowBooks {
	private int bId;			//可借阅图书标识
	private String bName;		//图书名称
	private String bAuthor;		//图书作者
	private String bPublishing;	//图书出版社
	private int bDuration;		//图书借阅时长	
	private String bImage1;		//图书照片
	private String bImage2;		//图书照片
	private String bImage3;		//图书照片
	private String bComment;    //备注
	private byte bStatus;		//借阅状态0停止借阅1开始借阅2正在借阅默认为0
	private byte bDelete;		//删除图书0没有删除1删除默认为0
	
	private SecondaryClassification sClassification;//图书所属的分类
	private User user;			//图书所属的用户
	
	private Set<ReturnBookRecord> rBookRecordsSet = new HashSet<ReturnBookRecord>();//所属还书记录表
	/*
	 * 无参构造函数
	 */
	public BorrowBooks() {
		
	}
	
	public String getbComment() {
		return bComment;
	}

	public void setbComment(String bComment) {
		this.bComment = bComment;
	}

	public Set<ReturnBookRecord> getrBookRecordsSet() {
		return rBookRecordsSet;
	}

	public void setrBookRecordsSet(Set<ReturnBookRecord> rBookRecordsSet) {
		this.rBookRecordsSet = rBookRecordsSet;
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbAuthor() {
		return bAuthor;
	}
	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}
	public String getbPublishing() {
		return bPublishing;
	}
	public void setbPublishing(String bPublishing) {
		this.bPublishing = bPublishing;
	}
	public int getbDuration() {
		return bDuration;
	}
	public void setbDuration(int bDuration) {
		this.bDuration = bDuration;
	}
	public String getbImage1() {
		return bImage1;
	}
	public void setbImage1(String bImage1) {
		this.bImage1 = bImage1;
	}
	public String getbImage2() {
		return bImage2;
	}
	public void setbImage2(String bImage2) {
		this.bImage2 = bImage2;
	}
	public String getbImage3() {
		return bImage3;
	}
	public void setbImage3(String bImage3) {
		this.bImage3 = bImage3;
	}
	public byte getbStatus() {
		return bStatus;
	}
	public void setbStatus(byte bStatus) {
		this.bStatus = bStatus;
	}
	public byte getbDelete() {
		return bDelete;
	}
	public void setbDelete(byte bDelete) {
		this.bDelete = bDelete;
	}
	public SecondaryClassification getsClassification() {
		return sClassification;
	}
	public void setsClassification(SecondaryClassification sClassification) {
		this.sClassification = sClassification;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
