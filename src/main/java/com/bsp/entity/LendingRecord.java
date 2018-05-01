package com.bsp.entity;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**   
 * @ClassName:  LendingRecord   
 * @Description: 借出图书记录类
 * @version: 1.0  
 * @author: WJB
 * @date:   2018年3月19日 下午11:22:46   
 *   
 */
@Entity
@Table (name = "lending_record")
public class LendingRecord {
	private int lrId;					// 借出记录标识，数字自增长
	private Date createTime;			// 借阅人申请时间，创建订单
	private Date agreeTime;				// 借出人同意申请时间
	private Date sendToTime;			// 借出人送达运营商服务点时间
	private Date takeAwayTime;		    // 借阅人取走图书时间
	private Date expectedReturnTime;	// 借阅人预期还书时间
	private Date ActualReturnTime;		// 借阅人实际还书时间
	private Date takeBackTime;			// 借出人取回图书时间
	// 借出记录状态 0发布申请，4借出人同意借书申请，6借出人送达运营商，7借阅人逾期未取书，8借阅人拿到图书，9借阅人逾期未还，10借出方已经还书，11借出方逾期没有取回图书
	private byte lrStruts;				
	private String loanPhone;			// 借阅人电话号码
	
	private LoanableBook loanableBook;	// 借阅的图书
	private User user;					// 借阅人
	private Administrator receiveAdmin;	// 收到借出人送达图书的机构
	private Administrator backAdmin;	// 收到借阅人还图书的机构
	
	/*
	 * 无参构造函数
	 */
	public LendingRecord() {}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "lr_id")
	public int getLrId() {
		return lrId;
	}

	public void setLrId(int lrId) {
		this.lrId = lrId;
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

	@Column (name = "lr_struts", nullable = false)
	public byte getLrStruts() {
		return lrStruts;
	}

	public void setLrStruts(byte lrStruts) {
		this.lrStruts = lrStruts;
	}

	@Column (name = "loan_phone", length = 12)
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
