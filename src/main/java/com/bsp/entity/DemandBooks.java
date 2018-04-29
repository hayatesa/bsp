package com.bsp.entity;

import java.util.HashSet;
import java.util.Set;
/**
 * 可借阅图书信息类
 * 2018年2月24日23:17:25
 * @author wjb
 *
 */
public class DemandBooks {
	private int dbId;			//需求图书标识
	private String dbName;		//图书名称
	private String dbAuthor;	//图书作者
	private String dbPublishing;//图书出版社
	private int dbDuration;		//图书需求时长
	private String dbImage1;	//图书照片
	private String dbImage2;	//图书照片
	private String dbImage3;	//图书照片
	private String dbComment;   //备注
	private byte dbStatus;		//借阅状态0停止借阅1开始借阅2正在借阅默认为0
	private byte dbDelete;		//删除图书0没有删除1删除默认为0
	
	private SecondaryClassification sClassification;//图书所属的分类
	private User user;			//需求图书者
	
	private Set<DemandReturnRecord> dReturnRecordsSet = new HashSet<DemandReturnRecord>();//需求成功响应并且还书记录
	
	/*
	 * 无参构造函数
	 */
	public DemandBooks() {	}
	
	public String getDbComment() {
		return dbComment;
	}

	public void setDbComment(String dbComment) {
		this.dbComment = dbComment;
	}

	public Set<DemandReturnRecord> getdReturnRecordsSet() {
		return dReturnRecordsSet;
	}

	public void setdReturnRecordsSet(Set<DemandReturnRecord> dReturnRecordsSet) {
		this.dReturnRecordsSet = dReturnRecordsSet;
	}

	public int getDbId() {
		return dbId;
	}

	public void setDbId(int dbId) {
		this.dbId = dbId;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getDbAuthor() {
		return dbAuthor;
	}

	public void setDbAuthor(String dbAuthor) {
		this.dbAuthor = dbAuthor;
	}

	public String getDbPublishing() {
		return dbPublishing;
	}

	public void setDbPublishing(String dbPublishing) {
		this.dbPublishing = dbPublishing;
	}

	public int getDbDuration() {
		return dbDuration;
	}

	public void setDbDuration(int dbDuration) {
		this.dbDuration = dbDuration;
	}

	public String getDbImage1() {
		return dbImage1;
	}

	public void setDbImage1(String dbImage1) {
		this.dbImage1 = dbImage1;
	}

	public String getDbImage2() {
		return dbImage2;
	}

	public void setDbImage2(String dbImage2) {
		this.dbImage2 = dbImage2;
	}

	public String getDbImage3() {
		return dbImage3;
	}

	public void setDbImage3(String dbImage3) {
		this.dbImage3 = dbImage3;
	}

	public byte getDbStatus() {
		return dbStatus;
	}

	public void setDbStatus(byte dbStatus) {
		this.dbStatus = dbStatus;
	}

	public byte getDbDelete() {
		return dbDelete;
	}

	public void setDbDelete(byte dbDelete) {
		this.dbDelete = dbDelete;
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
