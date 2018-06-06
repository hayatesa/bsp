package com.bsp.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsp.dto.LoanableBookQueryObject;
import com.bsp.service.ILoanableBookService;
import com.bsp.utils.CommonUtil;
import com.bsp.utils.Page;

/**
 * 可借图书数据调取
 * @author hayate
 *
 */
@RestController
@Scope(value="prototype")
@RequestMapping("/loanableBook")
public class LoanableBookController extends BaseController {
	
	@Autowired
	private ILoanableBookService loanableBookService;
	
	public void setLoanableBookService(ILoanableBookService loanableBookService) {
		this.loanableBookService = loanableBookService;
	}
	
	/**
	 * 调取一页数据
	 * @param queryObject 查询对象
	 */
	@RequestMapping("page")
	public Page page(LoanableBookQueryObject queryObject) {
		if (!StringUtils.isBlank(queryObject.getSort())) {
			queryObject.setSort(CommonUtil.HumpToUnderline(queryObject.getSort()));
		}
		return loanableBookService.findByQueryObject(queryObject);
	}
}
