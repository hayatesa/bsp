package com.bsp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bsp.dao.IUserDAO;
import com.bsp.entity.CreditScore;
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
	@Transactional
	public void addUser(User user, UserInfor userInfor, CreditScore creditScore) {
		this.getHibernateTemplate().save(user);
		userInfor.setUUID(user.getUUID());
		creditScore.setUUID(user.getUUID());
		this.getHibernateTemplate().save(userInfor);
		this.getHibernateTemplate().save(creditScore);
	}
 

}
