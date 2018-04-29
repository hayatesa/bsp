package com.bsp.utils.enums;

/**
 * 排序方式
 * @author Hayate
 *
 */
public enum OrderType {
	
	ASC("asc"),DESC("desc");
	
	private String order;

	private OrderType(String order) {
		this.order = order;
	}

	public String getOrder() {
		return order;
	}

}
