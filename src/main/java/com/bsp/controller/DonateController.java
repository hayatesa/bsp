package com.bsp.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsp.dto.PageParams;
import com.bsp.utils.Result;

@RestController
@Scope(value="prototype")
@RequestMapping("donate")
public class DonateController {
	
	/**
	 * 获取订单列表捐赠
	 * @param pageParams 分页参数
	 */
	@RequestMapping("list")
	public Result list(PageParams pageParams) {
		return Result.success();
	}
	
}
