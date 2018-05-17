package com.bsp.dao;

import java.util.List;

import com.bsp.entity.LendingRecord;

public interface LendingRecordMapper extends GenericMapper<LendingRecord, Integer> {

	/**
	 * 查找所有的记录
	 * @return 所有的对象
	 */
	List<LendingRecord> selectAllLendingRecord();
}