package com.bsp.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bsp.dao.IUserDAO;
import com.bsp.entity.User;
import com.bsp.entity.UserInfor;
import com.bsp.exceptions.UserDefinedException;
import com.bsp.service.user.IUserService;
import com.bsp.utils.md5.MD5Utils;

@Service
@Transactional
public class UserService implements IUserService {
	@Autowired
	private IUserDAO userDao;

	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}

	/**
	 * 通过邮箱获取用户
	 * @param mail
	 * @return
	 */
	@Override
	public List<User> checkMail(String mail) {
		return userDao.getUserByMail(mail);
	}
	
	@Override
	@Transactional
	public void addUser(User user, UserInfor userInfor) {
		//md5加密
		user.setPassword(MD5Utils.encodeByMD5(user.getPassword()));
		userDao.addUser(user,userInfor);
	}
	
	@Override
	public User getUserByMail(User user) throws UserDefinedException {
		List<User> users = userDao.getUserByMail(user.getMail());
		if (users.size()==0) {
			throw new UserDefinedException("用户名不存在！");
		}else{
			String MD5password = MD5Utils.encodeByMD5(user.getPassword());
			if (MD5password.equals(users.get(0).getPassword())) {
				return users.get(0);//登录成功
			}else {
				throw new UserDefinedException("密码错误！");
			}
		}
	}
}