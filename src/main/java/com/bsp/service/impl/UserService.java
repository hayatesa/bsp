package com.bsp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bsp.dao.UserInforMapper;
import com.bsp.dao.UserMapper;
import com.bsp.entity.User;
import com.bsp.entity.UserInfor;
import com.bsp.exceptions.SystemErrorException;
import com.bsp.exceptions.UserDefinedException;
import com.bsp.service.IUserService;
import com.bsp.utils.md5.MD5Utils;

@Service
@Transactional
public class UserService implements IUserService {
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	UserInforMapper userInforMapper;

	public void setUserInforMapper(UserInforMapper userInforMapper) {
		this.userInforMapper = userInforMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	@Transactional
	public void addUser(User user, UserInfor userInfor) {
		//md5加密
		user.setPassword(MD5Utils.encodeByMD5(user.getPassword()));
		userMapper.insertSelective(user);
	}
	
	@Override
	public User getUserByMail(User user) {
		List<User> users = userMapper.selectByMail(user.getMail());
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
	
	@Override
	public UserInfor getUserInforByUser(User user) {
		UserInfor userInfor;
		try {
			userInfor = userInforMapper.selectByPrimaryKey(user.getUuid());
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemErrorException("系统异常，获取用户信息失败");
		}
		return userInfor;
	}

	@Override
	public void lockOrDeleteUser(String uuid) {
		User newUser;
		try {
			newUser = userMapper.selectByPrimaryKey(uuid);
			newUser.lockOrDelete();
			userMapper.updateByPrimaryKeySelective(newUser);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemErrorException("操作失败，系统异常");
		}
	}
}
