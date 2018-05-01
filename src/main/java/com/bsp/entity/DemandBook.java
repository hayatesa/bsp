package com.bsp.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**   
 * @ClassName:  DemandBook   
 * @Description:  需求的图书信息
 * @version: 1.0  
 * @author: WJB
 * @date:   2018年3月26日 下午11:39:48   
 *   
 */  
@Entity
@Table (name = "demand_book")
public class DemandBook {
	private int dbId;				// 需求图书标识，来源于CheckDemandBook表的主键
	private String dbName;			// 需求图书名称
	private String dbAuthor;		// 需求图书作者
	private String dbPublishing;	// 需求图书出版社
	private String isbn;			// 需求图书的ISBN
	private int dbDuration;			// 需求图书时长
	private int dbNumber;			// 需求图书数量
	private String phone;			// 需求者的联系电话
	private String dbComment;  	 	// 备注
	private byte dbStatus = 1;		// 开启需求状态：0停止需求，1开始需求
	private byte isDelete = 0;		// 删除图书：0没有删除，1表示删除，默认为0
	private String imagePath;		// 图书照片路径
	private Date openDemandTime;	// 开启图书需求的时间
	
	private SecondaryClassification sClassification;	// 需求图书所属的分类
	private User user ;	 			// 需求图书所属的用户

	
	/*
	 * 无参构造函数
	 */
	public DemandBook() {}

	@Id
	@Column (name = "db_id")
	public int getDbId() {
		return dbId;
	}

	public void setDbId(int dbId) {
		this.dbId = dbId;
	}

	@Column (name = "db_name", nullable = false)
	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	@Column (name = "db_author", nullable = false, length = 100)
	public String getDbAuthor() {
		return dbAuthor;
	}

	public void setDbAuthor(String dbAuthor) {
		this.dbAuthor = dbAuthor;
	}

	@Column (name = "db_publishing", length = 100)
	public String getDbPublishing() {
		return dbPublishing;
	}

	public void setDbPublishing(String dbPublishing) {
		this.dbPublishing = dbPublishing;
	}

	@Column (name = "isbn", length = 30)
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Column (name = "db_duratuin", nullable = false)
	public int getDbDuration() {
		return dbDuration;
	}

	public void setDbDuration(int dbDuration) {
		this.dbDuration = dbDuration;
	}

	@Column (name = "db_number", nullable = false)
	public int getDbNumber() {
		return dbNumber;
	}

	public void setDbNumber(int dbNumber) {
		this.dbNumber = dbNumber;
	}

	@Column (name = "phone", nullable = false, length = 12)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column (name = "db_comment")
	public String getDbComment() {
		return dbComment;
	}

	public void setDbComment(String dbComment) {
		this.dbComment = dbComment;
	}

	@Column (name = "db_status", nullable = false)
	public byte getDbStatus() {
		return dbStatus;
	}

	public void setDbStatus(byte dbStatus) {
		this.dbStatus = dbStatus;
	}

	@Column (name = "is_delete", nullable = false)
	public byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(byte isDelete) {
		this.isDelete = isDelete;
	}

	@Column (name = "image_path")
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "open_demand_time")
	public Date getOpenDemandTime() {
		return openDemandTime;
	}

	public void setOpenDemandTime(Date openDemandTime) {
		this.openDemandTime = openDemandTime;
	}

	@ManyToOne (fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REFRESH)
	@JoinColumn (name = "sc_id")
	public SecondaryClassification getsClassification() {
		return sClassification;
	}

	public void setsClassification(SecondaryClassification sClassification) {
		this.sClassification = sClassification;
	}

	@ManyToOne (fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REFRESH)
	@JoinColumn (name = "uuid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
