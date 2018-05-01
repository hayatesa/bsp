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
 * @ClassName:  LendingHistory   
 * @Description:  借阅图书完成或终止历史记录
 * @version: 1.0  
 * @author: WJB
 * @date:  2018年3月19日 下午11:36:16   
 *   
 */  
@Entity
@Table (name = "lending_history")
public class LendingHistory {
	private int lhId;					// 借出记录历史标识，来源于LendingRecord表的主键
	private Date createTime;			// 借阅人申请时间，创建订单
	private Date agreeTime;				// 借出人同意申请时间
	private Date sendToTime;			// 借出人送达运营商服务点时间
	private Date takeAwayTime;		    // 借阅人取走图书时间
	private Date expectedReturnTime;	// 借阅人预期还书时间
	private Date ActualReturnTime;		// 借阅人实际还书时间
	private Date takeBackTime;			// 借出人取回图书时间
	// 1借阅人取消，2借出人拒绝申请，3申请超时借出人未同意，5借出人逾期未送达运营方，12借出人取回归还的图书，13借出人捐赠图书
	private byte lhStruts;				
	private String loanPhone;			// 借阅人电话号码
	
	private LoanableBook loanableBook;	// 借阅的图书
	private User user;					// 借阅人
	private Administrator receiveAdmin;	// 收到借出人送达图书的机构
	private Administrator backAdmin;	// 收到借阅人还图书的机构
	
	/*
	 * 无参构造函数
	 */
	public LendingHistory() {}

	@Id
	@Column (name = "lh_id")
	public int getLhId() {
		return lhId;
	}

	public void setLhId(int lhId) {
		this.lhId = lhId;
	}

	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "create_time")
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "agree_time")
	public Date getAgreeTime() {
		return agreeTime;
	}

	public void setAgreeTime(Date agreeTime) {
		this.agreeTime = agreeTime;
	}

	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "send_to_time")
	public Date getSendToTime() {
		return sendToTime;
	}

	public void setSendToTime(Date sendToTime) {
		this.sendToTime = sendToTime;
	}

	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "take_away_time")
	public Date getTakeAwayTime() {
		return takeAwayTime;
	}

	public void setTakeAwayTime(Date takeAwayTime) {
		this.takeAwayTime = takeAwayTime;
	}

	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "expected_return_time")
	public Date getExpectedReturnTime() {
		return expectedReturnTime;
	}

	public void setExpectedReturnTime(Date expectedReturnTime) {
		this.expectedReturnTime = expectedReturnTime;
	}

	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "actual_return_time")
	public Date getActualReturnTime() {
		return ActualReturnTime;
	}

	public void setActualReturnTime(Date actualReturnTime) {
		ActualReturnTime = actualReturnTime;
	}

	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "take_back_time")
	public Date getTakeBackTime() {
		return takeBackTime;
	}

	public void setTakeBackTime(Date takeBackTime) {
		this.takeBackTime = takeBackTime;
	}

	@Column (name = "lh_struts", nullable = false)
	public byte getLhStruts() {
		return lhStruts;
	}

	public void setLhStruts(byte lhStruts) {
		this.lhStruts = lhStruts;
	}
	
	@Column (name = "loan_phone")
	public String getLoanPhone() {
		return loanPhone;
	}
	
	public void setLoanPhone(String loanPhone) {
		this.loanPhone = loanPhone;
	}

	@ManyToOne (fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REFRESH)
	@JoinColumn (name = "lb_id")
	public LoanableBook getLoanableBook() {
		return loanableBook;
	}

	public void setLoanableBook(LoanableBook loanableBook) {
		this.loanableBook = loanableBook;
	}
	
	@ManyToOne (fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REFRESH)
	@JoinColumn (name = "uuid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne (fetch = FetchType.LAZY, optional = true, cascade = CascadeType.REFRESH)
	@JoinColumn (name = "receive_uuid")
	public Administrator getReceiveAdmin() {
		return receiveAdmin;
	}

	public void setReceiveAdmin(Administrator receiveAdmin) {
		this.receiveAdmin = receiveAdmin;
	}

	@ManyToOne (fetch = FetchType.LAZY, optional = true, cascade = CascadeType.REFRESH)
	@JoinColumn (name = "back_uuid")
	public Administrator getBackAdmin() {
		return backAdmin;
	}

	public void setBackAdmin(Administrator backAdmin) {
		this.backAdmin = backAdmin;
	}
}
