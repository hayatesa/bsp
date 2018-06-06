package com.bsp.service;

import com.bsp.dto.LoanableBookQueryObject;
import com.bsp.utils.Page;

public interface ILoanableBookService {
	
	Page findByQueryObject(LoanableBookQueryObject queryObject);
	
}
