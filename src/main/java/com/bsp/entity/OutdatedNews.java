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
* @ClassName: News 
* @Description: 通知信息类，用于构造用户的系统通知消息
* @version: 1.1 
* @author WJB
* @date 2018年3月19日16:03:38
*  
*/

@Entity
@Table (name = "outdated_news")
public class OutdatedNews {
	private int nId;			// 通知消息记录ID，数字自增长	
	private String nSubject;	// 通知消息标题
	private String nContent;	// 通知消息内容
	private Date newsTime;  	// 产生消息的时间
	private User user;			// 通知消息所属的用户 
	 
	/*
	 * 无参构造函数
	 */
	public OutdatedNews() {}

	@Id
	@Column (name = "n_id")
	public int getnId() {
		return nId;
	}

	public void setnId(int nId) {
		this.nId = nId;
	}
	
	@Column (name = "n_content", length = 1000, nullable = false)
	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	
	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "news_time", nullable = false)
	public Date getNewsTime() {
		return newsTime;
	}

	public void setNewsTime(Date newsTime) {
		this.newsTime = newsTime;
	}
	
	@Column (name = "n_subject", nullable = false)
	public String getnSubject() {
		return nSubject;
	}

	public void setnSubject(String nSubject) {
		this.nSubject = nSubject;
	}

	@ManyToOne (fetch = FetchType.EAGER, optional = true, cascade = CascadeType.REFRESH)
	@JoinColumn (name = "uuid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
