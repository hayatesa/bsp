package com.bsp.service;

import org.springframework.stereotype.Service;

import com.bsp.entity.Administrator;

@Service
public interface IAdminService {
	
	/**
	 * 根据用户名查找记录
	 * @param aid 用户名
	 */
	Administrator selectByAID(String username);
	
	/**
	 * 修改密码
	 * @param admin 登录对象
	 * @param currentPassword 原密码
	 * @param newPassword 新密码
	 * @param confirmPassword 确认密码
	 */
	void changePassword(Administrator admin, String currentPassword, String newPassword, String confirmPassword);
}
