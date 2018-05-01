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
 * @ClassName:  RespondRecord   
 * @Description:  响应活动记录
 * @version: 1.0  
 * @author: WJB
 * @date:   2018年3月24日 下午5:07:33   
 *   
 */  
@Entity
@Table (name = "respond_record")
public class RespondRecord {
	private int rrId;					// 响应记录标识，数字自增长
	private Date respondTime;			// 需求者响应时间
	private Date sendToTime;			// 响应者送达运营商服务点时间
	private Date takeAwayTime ;		    // 需求者取走图书时间
	private Date expectedReturnTime;	// 需求者预期还书时间
	private Date ActualReturnTime;		// 需求者实际还书时间
	private Date takeBackTime;			// 响应者取回图书时间
	// 0需求被响应，4响应者送达图书到运营方，5需求者逾期未取书，6需求者取走图书，7需求者逾期未还，8需求者还书，9响应者逾期未取回
	private byte rrStruts;				
	private String	respondPhone;		// 响应者电话号码
	
	private DemandBook demandBook;		// 需求的图书
	private User user;					// 响应者
	private Administrator receiveAdmin; // 收到借出人送到图书的机构
	private Administrator backAdmin;	// 收到借阅人还图书的机构
	
	/*
	 * 无参构造函数
	 */
	public RespondRecord() {}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "rr_id")
	public int getRrId() {
		return rrId;
	}

	public void setRrId(int rrId) {
		this.rrId = rrId;
	}

	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "respond_time")
	public Date getRespondTime() {
		return respondTime;
	}

	public void setRespondTime(Date respondTime) {
		this.respondTime = respondTime;
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

	@Column (name = "rr_struts", nullable = false)
	public byte getRrStruts() {
		return rrStruts;
	}

	public void setRrStruts(byte rrStruts) {
		this.rrStruts = rrStruts;
	}

	@Column (name = "respond_phone", length = 12)
	public String getRespondPhone() {
		return respondPhone;
	}

	public void setRespondPhone(String respondPhone) {
		this.respondPhone = respondPhone;
	}

	@ManyToOne (fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REFRESH)
	@JoinColumn (name = "db_id")
	public DemandBook getDemandBook() {
		return demandBook;
	}

	public void setDemandBook(DemandBook demandBook) {
		this.demandBook = demandBook;
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