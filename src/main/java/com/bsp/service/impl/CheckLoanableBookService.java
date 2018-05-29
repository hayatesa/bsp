package com.bsp.service.impl;

import java.util.List;

import com.bsp.dao.CheckLoanableBookMapper;
import com.bsp.dto.CheckLoanableBookQueryObject;
import com.bsp.entity.CheckLoanableBook;
import com.bsp.exceptions.SystemErrorException;
import com.bsp.service.ICheckLoanableBookService;
import com.bsp.utils.Page;

public class CheckLoanableBookService implements ICheckLoanableBookService {
	
	private CheckLoanableBookMapper checkLoanableBookMapper;
	
	public void setCheckLoanableBookMapper(CheckLoanableBookMapper checkLoanableBookMapper) {
		this.checkLoanableBookMapper = checkLoanableBookMapper;
	}

	@Override
	public Page findByQueryObject(CheckLoanableBookQueryObject queryObject) {
		Integer totalCount = null;
		List<CheckLoanableBook> list = null;
		try {
			totalCount = checkLoanableBookMapper.getTotalCount(queryObject);
			list = checkLoanableBookMapper.selectByQueryObject(queryObject);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemErrorException("系统异常");
		}
		return new Page(list, totalCount, queryObject.getLimit(), queryObject.getPageNumber());
	}

	@Override
	public void agree(Integer clbId) {
		
	}

	@Override
	public void disagree(Integer clbId) {
		
	}

}
