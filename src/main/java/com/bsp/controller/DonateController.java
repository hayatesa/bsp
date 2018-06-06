package com.bsp.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsp.dto.QueryObject;
import com.bsp.entity.DonatedBook;
import com.bsp.utils.Result;

@RestController
@Scope(value="prototype")
@RequestMapping("donate")
public class DonateController {
	
	/**
	 * 获取订单列表捐赠
	 * @param queryObject 分页参数
	 */
	@RequestMapping("page")
	public Result list(QueryObject queryObject) {
		return Result.success();
	}
	
	/**
	 * 捐赠
	 */
	@RequestMapping("donate")
	public Result donate(DonatedBook donatedBook) {
		return Result.success();
	}
	
}
