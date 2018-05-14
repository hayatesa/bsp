package com.bsp.utils;

import java.io.Serializable;
import java.util.List;

/**
 * 分页工具类
 */
public class Page implements Serializable {
	private static final long serialVersionUID = 1L;
	//总记录数
	private int total;
	//每页记录数
	private int limit;
	//总页数
	private int totalPage;
	//当前页数
	private int currPage;
	//列表数据
	private List<?> rows;

	/**
	 * 分页
	 * @param list        列表数据
	 * @param totalCount  总记录数
	 * @param pageSize    每页记录数
	 * @param currPage    当前页数
	 */
	public Page(List<?> list, int totalCount, int pageSize, int currPage) {
		this.rows = list;
		this.total = totalCount;
		this.limit = pageSize;
		this.currPage = currPage;
		this.totalPage = (int)Math.ceil((double)totalCount/pageSize);
	}

	public int getTotalCount() {
		return total;
	}

	public void setTotalCount(int totalCount) {
		this.total = totalCount;
	}

	public int getPageSize() {
		return limit;
	}

	public void setPageSize(int pageSize) {
		this.limit = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public List<?> getList() {
		return rows;
	}

	public void setList(List<?> list) {
		this.rows = list;
	}


}
