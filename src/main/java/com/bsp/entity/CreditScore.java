package com.bsp.entity;

/**
 * 用户信誉积分类
 * 2018年2月25日00:42:21
 * @author wjb
 *
 */
public class CreditScore {
	private String UUID;
	private int credit;			//总信誉积分
	private int highOpinionC;	//累计4、5星好评总数
	private int negativeCommentC;//累计1、2星差评总数
	private int addBookC;		//添加图书总数
	private int deleteBookC;	//删除图书总数
	private int commentC;		//评论总条数
	private int responseC;		//响应需求者图书需求总数

	public CreditScore() {
		
	}
	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getHighOpinionC() {
		return highOpinionC;
	}

	public void setHighOpinionC(int highOpinionC) {
		this.highOpinionC = highOpinionC;
	}

	public int getNegativeCommentC() {
		return negativeCommentC;
	}

	public void setNegativeCommentC(int negativeCommentC) {
		this.negativeCommentC = negativeCommentC;
	}

	public int getAddBookC() {
		return addBookC;
	}

	public void setAddBookC(int addBookC) {
		this.addBookC = addBookC;
	}

	public int getDeleteBookC() {
		return deleteBookC;
	}

	public void setDeleteBookC(int deleteBookC) {
		this.deleteBookC = deleteBookC;
	}

	public int getCommentC() {
		return commentC;
	}

	public void setCommentC(int commentC) {
		this.commentC = commentC;
	}

	public int getResponseC() {
		return responseC;
	}

	public void setResponseC(int responseC) {
		this.responseC = responseC;
	}

}
