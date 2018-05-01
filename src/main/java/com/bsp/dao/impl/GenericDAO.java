package com.bsp.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.bsp.dao.IGenericDAO;

/**
 * 所有DAO的父类，抽取共同属性、字段和方法
 * @author Hayate
 *
 */
public class GenericDAO extends HibernateDaoSupport implements IGenericDAO  {
	
	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
}
