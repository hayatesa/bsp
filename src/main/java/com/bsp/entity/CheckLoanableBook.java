package com.bsp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**   
 * @ClassName:  CheckLoanableBook   
 * @Description:  共享图书审核类
 * @version: 1.0  
 * @author: WJB
 * @date:   2018年3月21日 下午11:17:28   
 *   
 */  
@Entity
@Table (name = "check_loanable_book ")
public class CheckLoanableBook {
	private int clbId;				// 共享的图书标识，数字自增长
	private String clbName;			// 共享图书名称
	private String clbAuthor;		// 共享图书作者
	private String clbPublishing;	// 共享图书出版社
	private String isbn;			// 共享图书的ISBN
	private int clbDuration;		// 共享图书可共享时长
	private int clbNumber;			// 可共享图书数量
	private String phone;			// 共享者的联系电话
	private String clbComment;  	// 备注
	private String imagePath;		// 共享图书照片路径
	private byte clbStatus = 0;		// 图书审核状态:0提交申请未审核转态，1申请失败返回原因
	private String failureCause;	// 审核人员填写，审核失败的原因
	
	private SecondaryClassification sClassification;    // 共享图书所属的二级分类
	private User user;	 // 共享图书申请人
	
	
	public CheckLoanableBook() {}
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "clb_id")
	public int getClbId() {
		return clbId;
	}
	
	public void setClbId(int clbId) {
		this.clbId = clbId;
	}
	
	@Column (name = "clb_name", nullable = false)
	public String getClbName() {
		return clbName;
	}
	
	public void setClbName(String clbName) {
		this.clbName = clbName;
	}
	
	@Column (name = "clb_author", nullable = false, length = 100)
	public String getClbAuthor() {
		return clbAuthor;
	}
	
	public void setClbAuthor(String clbAuthor) {
		this.clbAuthor = clbAuthor;
	}
	
	@Column (name = "clb_publishing", length = 100)
	public String getClbPublishing() {
		return clbPublishing;
	}
	
	public void setClbPublishing(String clbPublishing) {
		this.clbPublishing = clbPublishing;
	}
	
	@Column (name = "isbn", length = 30, nullable = false)
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	@Column (name = "clb_duration", nullable = false)
	public int getClbDuration() {
		return clbDuration;
	}
	
	public void setClbDuration(int clbDuration) {
		this.clbDuration = clbDuration;
	}
	
	@Column (name = "clb_number", nullable = false)
	public int getClbNumber() {
		return clbNumber;
	}
	
	public void setClbNumber(int clbNumber) {
		this.clbNumber = clbNumber;
	}
	
	@Column (name = "phone", nullable = false, length = 12)
	public String getPhone() { 
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column (name = "clb_comment")
	public String getClbComment() {
		return clbComment;
	}
	
	public void setClbComment(String clbComment) {
		this.clbComment = clbComment;
	}
	
	@Column (name = "image_path")
	public String getImagePath() {
		return imagePath;
	}
	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	@Column (name = "clb_status", nullable = false)
	public byte getClbStatus() {
		return clbStatus;
	}
	
	public void setClbStatus(byte clbStatus) {
		this.clbStatus = clbStatus;
	}
	
	@Column (name = "failure_cause")
	public String getFailureCause() {
		return failureCause;
	}
	
	public void setFailureCause(String failureCause) {
		this.failureCause = failureCause;
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
