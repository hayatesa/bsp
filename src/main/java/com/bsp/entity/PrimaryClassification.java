package com.bsp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
* @ClassName: PrimaryClassification 
* @Description: 图书一级分类类别类，用于归类图书
* @version: 1.0 
* @author WJB
* @date 2018年3月15日 下午6:41:27 
*  
*/
@Entity
@Table (name = "primary_classification")
public class PrimaryClassification {
	private int pcId;			// 图书一级分类唯一标识，数字自增长
	private String pcName;		// 一级分类名称
	private byte isDelete = 0;	// 是否删除分类 0表示没有删除，1表示删除，默认为0
	
	/*
	 * 无参构造函数
	 */
	public PrimaryClassification() {}
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "pc_id")
	public int getPcId() {
		return pcId;
	}

	public void setPcId(int pcId) {
		this.pcId = pcId;
	}

	@Column (name = "pc_name", length = 50)
	public String getPcName() {
		return pcName;
	}
	
	public void setPcName(String pcName) {
		this.pcName = pcName;
	}
	
	@Column (name = "is_delete", nullable = false)
	public byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(byte isDelete) {
		this.isDelete = isDelete;
	}
}
