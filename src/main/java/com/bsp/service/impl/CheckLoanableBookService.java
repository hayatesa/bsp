package com.bsp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsp.dao.CheckLoanableBookMapper;
import com.bsp.dto.CheckLoanableBookQueryObject;
import com.bsp.entity.CheckLoanableBook;
import com.bsp.exceptions.SystemErrorException;
import com.bsp.service.ICheckLoanableBookService;
import com.bsp.utils.Page;

@Service("checkLoanableBookService")
public class CheckLoanableBookService implements ICheckLoanableBookService {
	
	@Autowired
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
	public void approve(Integer clbId) {
		
	}

	@Override
	public void deny(Integer clbId) {
		
	}

}
