package com.bsp.service.admin;

import org.springframework.stereotype.Service;

import com.bsp.entity.Administrator;

@Service
public interface IAdminService {
	
	/**
	 * 根据用户名查找记录
	 * @param aid 用户名
	 */
	Administrator selectByAID(String username);
	
}
