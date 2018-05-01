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
* @ClassName: SecondaryClassification 
* @Description: 图书二级分类
* @version: 1.0 
* @author WJB
* @date 2018年3月15日 下午7:15:40 
*  
*/
@Entity
@Table (name = "secondary_classification")
public class SecondaryClassification {
	private int scId;				// 图书二级分类唯一标识，数字增长值
	private String scName;			// 二级分类名称
	private byte isDelete = 0;		// 是否删除分类 0表示没有删除，1表示删除，默认为0
	private PrimaryClassification pClassification; // 所属一级分类
	
	/*
	 * 无参构造函数
	 */
	public SecondaryClassification() {}
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "sc_id")
	public int getScId() {
		return scId;
	}
	
	public void setScId(int scId) {
		this.scId = scId;
	}
	
	@Column (name = "sc_name", length = 50, nullable = false)
	public String getScName() {
		return scName;
	}
	
	public void setScName(String scName) {
		this.scName = scName;
	}
	
	@Column (name = "is_dalete", nullable = false)
	public byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(byte isDelete) {
		this.isDelete = isDelete;
	}
	
	@ManyToOne (fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REFRESH)
	@JoinColumn (name = "pc_id")
	public PrimaryClassification getpClassification() {
		return pClassification;
	}
	
	public void setpClassification(PrimaryClassification pClassification) {
		this.pClassification = pClassification;
	}
}
