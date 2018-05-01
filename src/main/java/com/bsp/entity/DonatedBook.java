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
 * @ClassName:  DonatedBook   
 * @Description:  捐赠图书类
 * @version: 1.0  
 * @author: WJB
 * @date:   2018年3月26日 下午7:49:27   
 *   
 */  
@Entity
@Table (name = "donated_book ")
public class DonatedBook {
	private int dobId;		// 捐赠的图书标识，数字自增值
	private String dobName;	// 捐赠的图书名称
	private String isbn;	// 捐赠的图书ISBN号
	private int number;		// 捐赠的图书数量
	
	private SecondaryClassification sClassification; // 捐赠图书所属的二级分类
	private User user;		// 捐赠人
	
	public DonatedBook() {}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "dob_id")
	public int getDobId() {
		return dobId;
	}

	public void setDobId(int dobId) {
		this.dobId = dobId;
	}

	@Column (name = "dob_name", nullable = false)
	public String getDobName() {
		return dobName;
	}

	public void setDobName(String dobName) {
		this.dobName = dobName;
	}

	@Column (name = "isbn", length = 30, nullable = false)
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Column (name = "number", nullable = false)
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@ManyToOne (fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REFRESH)
	@JoinColumn (name = "sc_id")
	public SecondaryClassification getsClassification() {
		return sClassification;
	}

	public void setsClassification(SecondaryClassification sClassification) {
		this.sClassification = sClassification;
	}

	@ManyToOne (fetch =FetchType.LAZY, optional = false, cascade = CascadeType.REFRESH)
	@JoinColumn (name = "uuid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
