package com.bsp.dto;

/**
 * 封装LendingRecord和lendingHistory的查询参数
 * @author hayate
 *
 */
public class OrderQueryObject extends QueryObject {
	
	private Integer status;// 状态

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
