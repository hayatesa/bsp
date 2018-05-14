package com.bsp.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsp.dto.QueryObject;
import com.bsp.utils.Result;

/**
 * 已归档订单管理
 * @author hayate
 *
 */
@RestController
@Scope(value="prototype")
@RequestMapping("history")
public class HistoryOrderController {
	
	/**
	 * 获取异常订单列表
	 * @param queryObject 查询对象
	 */
	@RequestMapping("list")
	public Result list(QueryObject queryObject) {
		return Result.success();
	}
	
}