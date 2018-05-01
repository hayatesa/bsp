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
 * @ClassName:  LoanableBook   
 * @Description:  可以借阅的图书信息
 * @version: 1.2  
 * @author: WJB
 * @date:   2018年3月24日 下午5:47:25   
 *   
 */  
@Entity
@Table (name = "loanable_book")
public class LoanableBook {
	private int lbId;				// 共享的图书标识，来源CheckLoanableBook表主键
	private String lbName;			// 共享图书名称
	private String lbAuthor;		// 共享图书作者
	private String lbPublishing;	// 共享图书出版社
	private String isbn;			// 共享图书的ISBN
	private int lbDuration;			// 共享图书可共享时长
	private int lbNumber;			// 可共享图书数量
	private String phone;			// 共享者的联系电话
	private String lbComment;  	 	// 备注
	private byte lbStatus = 1;		// 开启借阅状态：0停止共享，1开始共享，默认为1
	private byte isDelete = 0;		// 删除图书：0没有删除，1表示删除，默认为0
	private String imagePath;		// 共享图书照片路径
	private Date openLoanTime;		// 开启图书共享的时间
	private int TotalLending = 0;	// 共享累计借出总数
	
	private SecondaryClassification sClassification;	// 共享图书所属的二级分类
	private User user ;		 // 共享图书所属的用户

	/*
	 * 无参构造函数
	 */
	public LoanableBook() {}

	@Id
	@Column (name = "lb_id")
	public int getLbId() {
		return lbId;
	}

	public void setLbId(int lbId) {
		this.lbId = lbId;
	}

	@Column (name = "lb_name", nullable = false)
	public String getLbName() {
		return lbName;
	}

	public void setLbName(String lbName) {
		this.lbName = lbName;
	}

	@Column (name = "lb_author", nullable = false, length = 100)
	public String getLbAuthor() {
		return lbAuthor;
	}

	public void setLbAuthor(String lbAuthor) {
		this.lbAuthor = lbAuthor;
	}

	@Column (name = "lb_publishing", length = 100)
	public String getLbPublishing() {
		return lbPublishing;
	}

	public void setLbPublishing(String lbPublishing) {
		this.lbPublishing = lbPublishing;
	}

	@Column (name = "isbn", length = 30, nullable = false)
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Column (name = "lb_duratuin", nullable = false)
	public int getLbDuration() {
		return lbDuration;
	}

	public void setLbDuration(int lbDuration) {
		this.lbDuration = lbDuration;
	}

	@Column (name = "lb_number", nullable = false)
	public int getLbNumber() {
		return lbNumber;
	}

	public void setLbNumber(int lbNumber) {
		this.lbNumber = lbNumber;
	}

	@Column (name = "phone", nullable = false, length = 12)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column (name = "lb_comment")
	public String getLbComment() {
		return lbComment;
	}

	public void setLbComment(String lbComment) {
		this.lbComment = lbComment;
	}
	
	@Column (name = "lb_status", nullable = false)
	public byte getLbStatus() {
		return lbStatus;
	}

	public void setLbStatus(byte lbStatus) {
		this.lbStatus = lbStatus;
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

	@Column (name = "total_lending")
	public int getTotalLending() {
		return TotalLending;
	}

	public void setTotalLending(int totalLending) {
		TotalLending = totalLending;
	}
	
	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "open_loan_time")
	public Date getOpenLoanTime() {
		return openLoanTime;
	}

	public void setOpenLoanTime(Date openLoanTime) {
		this.openLoanTime = openLoanTime;
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
