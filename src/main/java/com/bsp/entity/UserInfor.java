package com.bsp.entity;
/**
 * 用户个人信息类
 * 2018年2月24日17:32:18
 * @author wjb
 *
 */
public class UserInfor {
	private String UUID;		//用户唯一标识来源于user
	private String uNickname;	//用户的昵称
	private String uSex;		//用户性别
	private String uPhone;		//用户联系手机号码
	private String uQQ;			//用户QQ号
	private String uWeChat;		//用户微信号
	private String uSignature;	//用户个性签名 	
	private String uAddress;	//用户联系地址
		
	/*
	 * 无参构造函数
	 */
	public UserInfor() {
		
	}	

	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public String getuNickname() {
		return uNickname;
	}
	public void setuNickname(String uNickname) {
		this.uNickname = uNickname;
	}
	public String getuSex() {
		return uSex;
	}
	public void setuSex(String uSex) {
		this.uSex = uSex;
	}
	public String getuPhone() {
		return uPhone;
	}
	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}
	public String getuQQ() {
		return uQQ;
	}
	public void setuQQ(String uQQ) {
		this.uQQ = uQQ;
	}
	public String getuWeChat() {
		return uWeChat;
	}
	public void setuWeChat(String uWeChat) {
		this.uWeChat = uWeChat;
	}
	public String getuSignature() {
		return uSignature;
	}
	public void setuSignature(String uSignature) {
		this.uSignature = uSignature;
	}
	public String getuAddress() {
		return uAddress;
	}
	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}
}
