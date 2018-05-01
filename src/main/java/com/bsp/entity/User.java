package com.bsp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**   
 * @ClassName:  User   
 * @Description:  用户账号类
 * @version: 1.0  
 * @author: WJB
 * @date:  2018年3月23日 下午9:34:04   
 *   
 */  
@Entity
@Table (name = "user")
public class User {
	private String UUID;		// 用户唯一标识符号
	private String mail;		// 用户邮箱，作为用户登录账号
	private String password;	// 用户登录账号密码
	private byte isDelete = 0;	// 0没有禁用，1被禁用，默认为0
	private UserInfor userInfor;
	/*
	 * 无参构造函数
	 */
	public User(){}
	
	@Id
	@GeneratedValue (generator = "uuid")
	@GenericGenerator (name = "uuid", strategy = "uuid")
	@Column (name = "uuid", length = 33)
	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}
	
	@Column (name = "mail", nullable = false)
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column (name = "password", nullable = false, length = 21)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column (name = "is_delete")
	public void setIsDelete(byte isDelete) {
		this.isDelete = isDelete;
	}	
	
	public byte getIsDelete() {
		return isDelete;
	}

	@OneToOne (cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	public UserInfor getUserInfor() {
		return userInfor;
	}

	public void setUserInfor(UserInfor userInfor) {
		this.userInfor = userInfor;
	}
}
