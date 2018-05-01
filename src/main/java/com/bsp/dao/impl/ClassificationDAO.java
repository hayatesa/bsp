package com.bsp.dao.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.bsp.dao.IClassificationDAO;
import com.bsp.entity.PrimaryClassification;

@Component
public class ClassificationDAO extends GenericDAO implements IClassificationDAO {
	
	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<PrimaryClassification> getPrimaryClassification() {
		ArrayList<PrimaryClassification> setPrimaryClassifications = new ArrayList<PrimaryClassification>();
		setPrimaryClassifications = (ArrayList<PrimaryClassification>) super.getHibernateTemplate().find("from PrimaryClassification");
		return setPrimaryClassifications;
	}
	
}
