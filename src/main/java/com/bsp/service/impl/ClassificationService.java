package com.bsp.service.impl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bsp.dao.IClassificationDAO;
import com.bsp.entity.PrimaryClassification;
import com.bsp.service.IClassificationService;

@Service
public class ClassificationService implements IClassificationService {
	
	@Autowired
	private IClassificationDAO classificationDao;

	public void setClassificationDao(IClassificationDAO classificationDao) {
		this.classificationDao = classificationDao;
	}
	
	/**
	 * 获取一级分类所有条目,获取id和name转化为json格式
	 * @return
	 */
	@Override
	public String getPrimaryClassification() {
		List<PrimaryClassification> setPrimaryClassifications = new ArrayList<PrimaryClassification>();
		List<JSONObject> list = new ArrayList<JSONObject>();
		setPrimaryClassifications=classificationDao.getPrimaryClassification();
		for (PrimaryClassification primaryClassification : setPrimaryClassifications) {
			JSONObject jObject = new JSONObject();
			if (primaryClassification.getIsDelete()==0){ 
				jObject.put("pcId", primaryClassification.getPcId());
				jObject.put("cname", primaryClassification.getPcName());
				list.add(jObject);
				}
		}
		return JSON.toJSONString(list);
	}
	
}
