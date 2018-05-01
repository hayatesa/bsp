package com.bsp.dao;

import java.util.List;

import com.bsp.entity.PrimaryClassification;

public interface IClassificationDAO extends IGenericDAO {
	
	/**
	 * @return 获取一级分类所有条目
	 */
	public List<PrimaryClassification> getPrimaryClassification();
}
