package com.bsp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/** 
* @ClassName: Administrator 
* @Description: 管理员/运营者类
* @version: 1.0 
* @author WJB
* @date 2018年3月21日22:20:05
*  
*/
@Entity
@Table (name = "administrator")
public class Administrator {
	private String aUUId;		//管理员唯一标识
	private String aId;			//管理员登录账号
	private String aPassword;	//密码
	private String aname;   	//运营方名称
	private String aAddress;	//运营方地址
	private String aPhone;		//联系电话
	private String aComments;	//运营者描述
	private byte isDelete = 0;	//是否可用，登录时需要判断，0没有禁用，1被禁用
	
	public Administrator() {}
	
	@Id
	@GeneratedValue (generator = "uuid")
	@GenericGenerator (name = "uuid", strategy = "uuid")
	@Column (name = "a_uuid", length = 33)
	public String getaUUId() {
		return aUUId;
	}
	
	public void setaUUId(String aUUId) {
		this.aUUId = aUUId;
	}
	
	@Column (name = "a_id", nullable = false, length = 30)
	public String getaId() {
		return aId;
	}
	
	public void setaId(String aId) {
		this.aId = aId;
	}
	
	@Column (name = "a_password", length = 21, nullable = false)	//密码8-20位
	public String getaPassword() {
		return aPassword;
	}

	public void setaPassword(String aPassword) {
		this.aPassword = aPassword;
	}
	
	@Column (name = "a_name", length = 100, nullable = false)
	public String getAname() {
		return aname;
	}
	
	public void setAname(String aname) {
		this.aname = aname;
	}
	
	@Column (name = "a_address", nullable = false)
	public String getaAddress() {
		return aAddress;
	}

	public void setaAddress(String aAddress) {
		this.aAddress = aAddress;
	}
	
	@Column (name = "a_phone", length = 12, nullable = false)
	public String getaPhone() {
		return aPhone;
	}

	public void setaPhone(String aPhone) {
		this.aPhone = aPhone;
	}
	
	@Column (name = "a_comments")
	public String getaComments() {
		return aComments;
	}
	
	public void setaComments(String aComments) {
		this.aComments = aComments;
	}
	
	@Column (name = "isdelete", nullable = false) //0没有禁用，1被禁用
	public byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(byte isDelete) {
		this.isDelete = isDelete;
	}
}
