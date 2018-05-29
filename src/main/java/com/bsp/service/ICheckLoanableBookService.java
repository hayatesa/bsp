package com.bsp.service;

import com.bsp.dto.CheckLoanableBookQueryObject;
import com.bsp.utils.Page;

public interface ICheckLoanableBookService {
	
	/**
	 * 分页+高级查询
	 * @param queryObject 查询对象
	 * @return 页
	 */
	Page findByQueryObject(CheckLoanableBookQueryObject queryObject);
	
	/**
	 * 审核通过
	 * @param clbId 记录id
	 */
	void agree(Integer clbId);
	
	/**
	 * 审核不通过
	 * @param clbId 记录id
	 */
	void disagree(Integer clbId);
	
}
