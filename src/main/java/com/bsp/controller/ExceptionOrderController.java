package com.bsp.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsp.dto.QueryObject;
import com.bsp.utils.Result;

/**
 * 异常订单处理
 * @author hayate
 *
 */
@RestController
@Scope(value="prototype")
@RequestMapping("exception")
public class ExceptionOrderController {
	
	/**
	 * 获取异常订单列表
	 * @param queryObject
	 */
	@RequestMapping("list")
	public Result list(QueryObject queryObject) {
		return Result.success();
	} 
	
	
}