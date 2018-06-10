package com.bsp.service;

import com.bsp.dto.QueryObject;
import com.bsp.entity.SecondaryClassification;
import com.bsp.utils.Page;

public interface ISecondaryClassificationService {
	
	/**
	 * 获取一页数据
	 * @param queryObject
	 */
	Page findByQueryObject(QueryObject queryObject);
	
	/**
	 * 增加一条记录
	 * @param secondaryClassification 实体
	 */
	void add(SecondaryClassification secondaryClassification);
	
	/**
	 * 删除一条记录
	 * @param id 记录id
	 */
	void delete(Integer id);
}
