package com.bsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bsp.dto.CheckLoanableBookQueryObject;
import com.bsp.exceptions.SystemErrorException;
import com.bsp.service.ICheckLoanableBookService;
import com.bsp.utils.Page;
import com.bsp.utils.Result;

/**
 * 图书审核
 * @author hayate
 *
 */
@RestController
@Scope(value="prototype")
@RequestMapping("clb")
public class CheckBookController {
	
	@Autowired
	private ICheckLoanableBookService checkLoanableBookService;
	
	public void setCheckLoanableBookService(ICheckLoanableBookService checkLoanableBookService) {
		this.checkLoanableBookService = checkLoanableBookService;
	}

	/**
	 * 审核不通过
	 * @param clbId 待审核的图书id
	 * @param failureCause 失败原因
	 */
	@RequestMapping("deny")
	public Result deny(@RequestParam("clbId") Integer clbId, @RequestParam("failureCause") String failureCause) {
		try {
			checkLoanableBookService.deny(clbId, failureCause);
		} catch (SystemErrorException e) {
			e.printStackTrace();
			return Result.error(e.getMessage());
		}
		return Result.success();
	}
	
	/**
	 * 审核通过
	 * @param clbId 待审核的图书id
	 */
	@RequestMapping("approve")
	public Result approve(@RequestParam("clbId") Integer clbId) {
		try {
			checkLoanableBookService.approve(clbId);
		} catch (SystemErrorException e) {
			e.printStackTrace();
			return Result.error(e.getMessage());
		}
		return Result.success();
	}
	
	/**
	 * 获取一条待审核的图书记录
	 * @param clbId 待审核的图书id
	 * @return
	 */
	@RequestMapping("detial")
	public Result detial(@RequestParam("clbId") Integer clbId) {
		return Result.success();
	}
	
	/**
	 * 获取待审核的书的列表
	 * @param queryObject
	 */
	@RequestMapping(value="page", method=RequestMethod.GET)
	public Page list(CheckLoanableBookQueryObject queryObject) {
		Page page = checkLoanableBookService.findByQueryObject(queryObject);
		return page;
	}
}
