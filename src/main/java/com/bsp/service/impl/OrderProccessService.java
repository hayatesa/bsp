package com.bsp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.bsp.dao.AdministratorMapper;
import com.bsp.dao.LendingHistoryMapper;
import com.bsp.dao.LendingRecordMapper;
import com.bsp.entity.Administrator;
import com.bsp.service.IOrderProccessService;

public class OrderProccessService implements IOrderProccessService {
	
	@Autowired
	private LendingRecordMapper LendingRecordMapper;
	@Autowired
	private LendingHistoryMapper LendingHistoryMapper;
	@Autowired
	private AdministratorMapper AdministratorMapper;

	public void setLendingRecordMapper(LendingRecordMapper lendingRecordMapper) {
		LendingRecordMapper = lendingRecordMapper;
	}

	public void setLendingHistoryMapper(LendingHistoryMapper lendingHistoryMapper) {
		LendingHistoryMapper = lendingHistoryMapper;
	}

	public void setAdministratorMapper(AdministratorMapper administratorMapper) {
		AdministratorMapper = administratorMapper;
	}

	@Override
	public void nextStep(Integer oId, Administrator operator) {
		
	}

}
