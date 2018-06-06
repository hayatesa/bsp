package com.bsp.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bsp.dto.OrderQueryObject;
import com.bsp.exceptions.SystemErrorException;
import com.bsp.service.IDonateService;
import com.bsp.service.ILendingRecordService;
import com.bsp.utils.CommonUtil;
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
public class OrderProccessController extends BaseController {
	
	@Autowired
	private ILendingRecordService lendingRecordService;
	
	@Autowired
	private IDonateService donateService;
	
	public void setDonateService(IDonateService donateService) {
		this.donateService = donateService;
	}

	public void setLendingRecordService(ILendingRecordService lendingRecordService) {
		this.lendingRecordService = lendingRecordService;
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
		if (!StringUtils.isBlank(queryObject.getSort())) {
			queryObject.setSort(CommonUtil.HumpToUnderline(queryObject.getSort()));
		}
		Page page = lendingRecordService.findByQueryObject(queryObject);
		return page;
	}
	
	/**
	 * 来自订单的捐赠，图书在中转站的状态有效
	 * @param lrId 订单Id
	 */
	@RequestMapping("donate")
	public Result donate(Integer lrId) {
		try {
			donateService.donateFormLendingRecord(lrId);
		} catch (SystemErrorException e) {
			e.printStackTrace();
			return Result.error(e.getMessage());
		}
		return Result.success();
	}
}
