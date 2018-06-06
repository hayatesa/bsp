package com.bsp.service;

import com.bsp.entity.DonatedBook;

public interface IDonateService {
	
	/**
	 * 来自订单捐赠
	 * @param lrId 订单记录Id
	 */
	void donateFormLendingRecord(Integer lrId);
	
	/**
	 * 捐赠
	 * @param donatedBook 捐赠实体
	 */
	void donate(DonatedBook donatedBook);
	
}
