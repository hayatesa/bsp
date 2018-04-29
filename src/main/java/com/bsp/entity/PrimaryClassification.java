package com.bsp.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 图书一级分类类
 * 2018年2月24日22:55:05
 * @author wjb
 *
 */
public class PrimaryClassification {
	private int pcId;			//图书一级分类唯一标识
	private String pcName;		//一级分类名称
	private byte pcDelete;	//是否删除分类 0表示删除，1没有删除
	
	private Set<SecondaryClassification> sClassificationsSet = new HashSet<SecondaryClassification>();//一级分类含有的所有二级分类
	
	/*
	 * 无参构造函数
	 */
	public PrimaryClassification() {
		
	}
	
	public int getPcId() {
		return pcId;
	}

	public void setPcId(int pcId) {
		this.pcId = pcId;
	}

	public Set<SecondaryClassification> getsClassificationsSet() {
		return sClassificationsSet;
	}

	public void setsClassificationsSet(Set<SecondaryClassification> sClassificationsSet) {
		this.sClassificationsSet = sClassificationsSet;
	}

	public String getPcName() {
		return pcName;
	}
	public void setPcName(String pcName) {
		this.pcName = pcName;
	}

	public byte getPcDelete() {
		return pcDelete;
	}

	public void setPcDelete(byte pcDelete) {
		this.pcDelete = pcDelete;
	}

}
