package com.bsp.dao;

import java.util.List;

import com.bsp.entity.User;
import com.bsp.entity.UserInfor;

public interface IUserDAO extends IGenericDAO {
	
	/**
	 * 
	 * @param user
	 * @param userInfor
	 */
	public void addUser(User user, UserInfor userInfor);
	
	/**
	 * 
	 * @param mail
	 * @return
	 */
	public List<User> getUserByMail(String mail);
}
