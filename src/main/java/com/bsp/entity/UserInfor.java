package com.bsp.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
* @ClassName: UserInfor 
* @Description: 用户信息类
* @version: 1.0 
* @author WJB
* @date 2018年3月15日 下午6:09:52 
*  
*/
@Entity
@Table(name = "user_infor")
public class UserInfor {
	private String UUID;		// 用户唯一标识来源于user表主键
	private String uNickname;	// 用户的昵称
	private String uSex;		// 用户性别
	private String uPhone;		// 用户联系手机号码
	private String uQQ;			// 用户QQ号
	private String uWeChat;		// 用户微信号
	private String uSignature;	// 用户个性签名 	
	private String uAddress;	// 用户联系地址
	private String uHeadPath;	// 头像路径
		
	/*
	 * 无参构造函数
	 */
	public UserInfor() {}

	@Id
	@Column(name = "uuid", length = 33, unique = true)
	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}
	
	@Column (name = "u_nickname", nullable = false, length = 15)
	public String getuNickname() {
		return uNickname;
	}

	public void setuNickname(String uNickname) {
		this.uNickname = uNickname;
	}
	
	@Column (name = "u_sex", nullable = false, length = 2)
	public String getuSex() {
		return uSex;
	}

	public void setuSex(String uSex) {
		this.uSex = uSex;
	}

	@Column (name = "u_phone", nullable = false, length = 12)
	public String getuPhone() {
		return uPhone;
	}

	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}

	@Column (name = "u_qq", length = 16)
	public String getuQQ() {
		return uQQ;
	}

	public void setuQQ(String uQQ) {
		this.uQQ = uQQ;
	}

	@Column (name = "u_wechat", length = 25)
	public String getuWeChat() {
		return uWeChat;
	}

	public void setuWeChat(String uWeChat) {
		this.uWeChat = uWeChat;
	}

	@Column (name = "u_signature")
	public String getuSignature() {
		return uSignature;
	}

	public void setuSignature(String uSignature) {
		this.uSignature = uSignature;
	}

	@Column (name = "u_address")
	public String getuAddress() {
		return uAddress;
	}

	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}
	@Column (name = "u_headpath")
	public String getuHeadPath() {
		return uHeadPath;
	}

	public void setuHeadPath(String uHeadPath) {
		this.uHeadPath = uHeadPath;
	}	
}
