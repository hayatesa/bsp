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
 * @ClassName:  CheckDemandBook   
 * @Description:  需求图书审核表
 * @version: 1.0  
 * @author: WJB
 * @date:   2018年3月22日 上午12:03:42   
 *   
 */  
@Entity
@Table (name = "check_demand_book ")
public class CheckDemandBook {
	private int cdbId;				// 需求图书标识，数字自增长
	private String cdbName;			// 需求图书名称
	private String cdbAuthor;		// 需求图书作者
	private String cdbPublishing;	// 需求图书出版社
	private String isbn;			// 需求图书的ISBN
	private int cdbDuration;		// 需求图书需求时长
	private int cdbNumber;			// 需要图书数量
	private String phone;			// 需求者联系电话
	private String cdbComment;  	// 备注
	private String imagePath;		// 需求图书照片路径
	private byte cdbStatus = 0;		// 图书审核状态:0提交申请未审核转态，1申请失败返回原因
	private String failureCause;	// 审核人员填写，审核失败的原因
	
	private SecondaryClassification sClassification;    //	需求图书所属的二级分类
	private User user;	 //	需求图书申请人
	
	public CheckDemandBook() {}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "cdb_id")
	public int getCdbId() {
		return cdbId;
	}

	public void setCdbId(int cdbId) {
		this.cdbId = cdbId;
	}

	@Column (name = "cdb_name", nullable = false)
	public String getCdbName() {
		return cdbName;
	}

	public void setCdbName(String cdbName) {
		this.cdbName = cdbName;
	}

	@Column (name = "cdb_author", nullable = false, length = 100)
	public String getCdbAuthor() {
		return cdbAuthor;
	}

	public void setCdbAuthor(String cdbAuthor) {
		this.cdbAuthor = cdbAuthor;
	}

	@Column (name = "cdb_publishing", length = 100)
	public String getCdbPublishing() {
		return cdbPublishing;
	}

	public void setCdbPublishing(String cdbPublishing) {
		this.cdbPublishing = cdbPublishing;
	}
	
	@Column (name = "isbn", length = 30)
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	@Column (name = "cdb_duration", nullable = false)
	public int getCdbDuration() {
		return cdbDuration;
	}

	public void setCdbDuration(int cdbDuration) {
		this.cdbDuration = cdbDuration;
	}

	@Column (name = "cdb_number", nullable = false)
	public int getCdbNumber() {
		return cdbNumber;
	}

	public void setCdbNumber(int cdbNumber) {
		this.cdbNumber = cdbNumber;
	}

	@Column (name = "phone", nullable = false, length = 12)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column (name = "cdb_comment")
	public String getCdbComment() {
		return cdbComment;
	}

	public void setCdbComment(String cdbComment) {
		this.cdbComment = cdbComment;
	}

	@Column (name = "image_path")
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Column (name = "cdb_status", nullable = false)
	public byte getCdbStatus() {
		return cdbStatus;
	}

	public void setCdbStatus(byte cdbStatus) {
		this.cdbStatus = cdbStatus;
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

