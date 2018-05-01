package com.bsp.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/** 
* @ClassName: Mapping 
* @Description: 键值对类，用于构建一键一值的数据表存储
* @version: 1.0 
* @author WJB
* @date 2018年3月15日 下午6:44:29 
*  
*/
@Entity
@Table (name = "mapping")
public class Mapping {
	private String mapkey;		//键
	private String mValue;		//值
	
	/*
	 * 无参构造函数
	 */
	public Mapping() {}

	@Id
	@Column (name = "mapkey")
	public String getMapkey() {
		return mapkey;
	}
	
	public void setMapkey(String mapkey) {
		this.mapkey = mapkey;
	}
	
	@Column (name = "m_value", length = 500)
	public String getmValue() {
		return mValue;
	}
	
	public void setmValue(String mValue) {
		this.mValue = mValue;
	}
}
