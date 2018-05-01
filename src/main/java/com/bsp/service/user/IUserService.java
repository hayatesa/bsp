package com.bsp.service.user;

import java.util.List;

import com.bsp.entity.User;
import com.bsp.entity.UserInfor;
import com.bsp.exceptions.UserDefinedException;

public interface IUserService {

	public List<User> checkMail(String mail);

	public void addUser(User user, UserInfor userInfor);

	public User getUserByMail(User user) throws UserDefinedException;

}
