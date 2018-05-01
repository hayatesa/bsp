package com.bsp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.FlushMode;
import org.springframework.stereotype.Component;

import com.bsp.dao.IUserDAO;
import com.bsp.entity.User;
import com.bsp.entity.UserInfor;

@Component
public class UserDAO extends GenericDAO implements IUserDAO {
	
	@Override
	@SuppressWarnings("unchecked")
	public List<User> getUserByMail(String mail) {
		return (ArrayList<User>) super.getHibernateTemplate().find("from User where mail = ?", mail);
	}
	
	@Override
	public void addUser(User user, UserInfor userInfor) {
		this.getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		this.getHibernateTemplate().save(user);
		userInfor.setUUID(user.getUUID());
		this.getHibernateTemplate().save(userInfor);
		getSessionFactory().getCurrentSession().flush();
	}

}
