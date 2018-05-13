package com.bsp.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bsp.dto.QueryObject;
import com.bsp.utils.Result;

/**
 * 图书审核
 * @author hayate
 *
 */
@RestController
@Scope(value="prototype")
public class CheckBookController {
	
	/**
	 * 审核不通过
	 * @param clbId 待审核的图书id
	 */
	@RequestMapping("deny")
	public Result deny(@RequestParam("clbId") Integer clbId) {
		return Result.success();
	}
	
	/**
	 * 审核通过
	 * @param clbId 待审核的图书id
	 */
	@RequestMapping("approve")
	public Result approve(@RequestParam("clbId") Integer clbId) {
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
	@RequestMapping("list")
	public Result list(QueryObject queryObject) {
		return Result.success();
	}
}
