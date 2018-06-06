package com.bsp.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsp.dao.LoanableBookMapper;
import com.bsp.dto.LoanableBookQueryObject;
import com.bsp.entity.LoanableBook;
import com.bsp.exceptions.SystemErrorException;
import com.bsp.service.ILoanableBookService;
import com.bsp.utils.Page;

@Service("loanableBookService")
public class LoanableBookService implements ILoanableBookService {
	
	@Autowired
	private LoanableBookMapper loanableBookMapper;
	
	public void setLoanableBookMapper(LoanableBookMapper loanableBookMapper) {
		this.loanableBookMapper = loanableBookMapper;
	}

	@Override
	public Page findByQueryObject(LoanableBookQueryObject queryObject) {
		Integer totalCount = null;
		List<LoanableBook> list = null;
		try {
			totalCount = loanableBookMapper.getTotalCount(queryObject);
			list = loanableBookMapper.selectByQueryObject(queryObject);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemErrorException("系统异常，查询数据失败");
		}
		return new Page(list, totalCount, queryObject.getLimit(), queryObject.getPageNumber());
	}

}
