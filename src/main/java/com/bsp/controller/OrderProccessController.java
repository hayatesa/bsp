package com.bsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bsp.dao.LendingRecordMapper;
import com.bsp.dto.OrderQueryObject;
import com.bsp.utils.Page;
import com.bsp.utils.Result;

/**
 * 订单流转
 * @author hayate
 *
 */
@RestController
@Scope(value="prototype")
@RequestMapping("proccess")
public class OrderProccessController {
	
	@Autowired
	private LendingRecordMapper lendingRecordMapper;
	
	public void setLendingRecordMapper(LendingRecordMapper lendingRecordMapper) {
		this.lendingRecordMapper = lendingRecordMapper;
	}

	/**
	 * 进行下一步，即正常订单状态转换
	 * @param lrId 订单记录ID，查表lending_record
	 */
	@RequestMapping("next_step")
	public Result nextStep(@RequestParam("lrId") Integer lrId) {
		return Result.success();
	}
	
	/**
	 * 获取数据页
	 */
	@RequestMapping("page")
	public Page list(OrderQueryObject queryObject) {
		return null;
	}
}
