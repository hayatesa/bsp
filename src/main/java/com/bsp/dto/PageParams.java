package com.bsp.dto;

/**
 * 封装分页请求中的参数
 * 
 * @author hayate
 *
 */
public class PageParams {

	private Integer limit; // 页大小
	private Integer pageNumber; // 页码
	private String order; // 排序，desc|asc
	private String sort; // 排序字段
	private String search; // 搜索关键字
	
	/**
	 * 封装分页请求参数
	 * @param limit 页大小
	 * @param pageNumber 页码
	 * @param order 排序，desc|asc
	 * @param sort 排序字段
	 * @param search 搜索关键字
	 */
	public PageParams(Integer limit, Integer pageNumber, String order, String sort, String search) {
		super();
		this.limit = limit;
		this.pageNumber = pageNumber;
		this.order = order;
		this.sort = sort;
		this.search = search;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

}
