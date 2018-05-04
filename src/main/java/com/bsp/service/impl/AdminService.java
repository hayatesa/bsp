package com.bsp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsp.dao.AdministratorMapper;
import com.bsp.entity.Administrator;
import com.bsp.exceptions.SystemErrorException;
import com.bsp.service.IAdminService;

@Service("adminService")
public class AdminService implements IAdminService {
	
	@Autowired
	private AdministratorMapper administratorMapper;
	
	public void setAdministratorMapper(AdministratorMapper administratorMapper) {
		this.administratorMapper = administratorMapper;
	}

	@Override
	public Administrator selectByAID(String username) {
		Administrator admin = null;
		try {
			admin = administratorMapper.selectByAID(username);
		} catch (Exception e) {
			throw new SystemErrorException("系统异常，查询失败");
		}
		return admin;
	}

}
