package com.bsp.service;

import org.springframework.stereotype.Service;

import com.bsp.dto.QueryObject;
import com.bsp.entity.Administrator;
import com.bsp.utils.Page;

@Service
public interface IAdminService {
	
	/**
	 * 根据用户名查找记录
	 * @param aid 用户名
	 */
	Administrator findByAID(String username);
	
	/**
	 * 修改密码
	 * @param admin 登录对象
	 * @param currentPassword 原密码
	 * @param newPassword 新密码
	 * @param confirmPassword 确认密码
	 */
	void changePassword(Administrator admin, String currentPassword, String newPassword, String confirmPassword);
	
	/**
	 * 查找一页数据
	 * @param queryObject
	 * @return
	 */
	Page findByQueryObject(QueryObject queryObject);
	
	/**
	 * 冻结|解冻管理员
	 * @param uuid
	 */
	void lockOrUnlock(String uuid);
}
