package com.bsp.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * 图书二级分类类
 * @author wjb
 *
 */
public class SecondaryClassification {
	private int scId;			//图书二级分类唯一标识
	private String scName;		//二级分类名称
	private byte scDelete;	//是否删除分类 0表示删除，1没有删除
	private PrimaryClassification pClassification; //所属一级分类
	
	private Set<BorrowBooks> borrowBooksSet = new HashSet<BorrowBooks>();//属于这个分类的所有图书
	private Set<DemandBooks> demandBooksSet = new HashSet<DemandBooks>();//属于此分类的所有需求图书
	/*
	 * 无参构造函数
	 */
	public SecondaryClassification() {
		
	}
	
	public Set<DemandBooks> getDemandBooksSet() {
		return demandBooksSet;
	}

	public void setDemandBooksSet(Set<DemandBooks> demandBooksSet) {
		this.demandBooksSet = demandBooksSet;
	}

	public Set<BorrowBooks> getBorrowBooksSet() {
		return borrowBooksSet;
	}

	public void setBorrowBooksSet(Set<BorrowBooks> borrowBooksSet) {
		this.borrowBooksSet = borrowBooksSet;
	}

	public int getScId() {
		return scId;
	}
	public void setScId(int scId) {
		this.scId = scId;
	}
	public String getScName() {
		return scName;
	}
	public void setScName(String scName) {
		this.scName = scName;
	}
	public byte getScDelete() {
		return scDelete;
	}
	public void setScDelete(byte scDelete) {
		this.scDelete = scDelete;
	}
	public PrimaryClassification getpClassification() {
		return pClassification;
	}
	public void setpClassification(PrimaryClassification pClassification) {
		this.pClassification = pClassification;
	}
	
}
