package com.bsp.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsp.dao.AdministratorMapper;
import com.bsp.dto.QueryObject;
import com.bsp.entity.Administrator;
import com.bsp.exceptions.DataUpdateException;
import com.bsp.exceptions.SystemErrorException;
import com.bsp.service.IAdminService;
import com.bsp.utils.Cryptography;
import com.bsp.utils.Page;

@Service("adminService")
public class AdminService implements IAdminService {
	
	@Autowired
	private AdministratorMapper administratorMapper;
	
	public void setAdministratorMapper(AdministratorMapper administratorMapper) {
		this.administratorMapper = administratorMapper;
	}

	@Override
	public Administrator findByAID(String username) {
		Administrator admin = null;
		try {
			admin = administratorMapper.selectByAID(username);
		} catch (Exception e) {
			throw new SystemErrorException("系统异常，查询失败");
		}
		return admin;
	}

	@Override
	public void changePassword(Administrator admin, String currentPassword, String newPassword,
			String confirmPassword) {
		if (!StringUtils.equals(newPassword, confirmPassword)) {
			throw new DataUpdateException("更改失败，密两次输入密码不一致");
		}
		Administrator newAdmin = null;
		try {
			newAdmin = administratorMapper.selectByPrimaryKey(admin.getaUuid());
		} catch (Exception e) {
			throw new SystemErrorException("密码更改失败，系统异常，请联系管理员");
		}
		boolean correct = Cryptography.checkMd5Hash(newAdmin.getaPassword(), currentPassword, newAdmin.getaId());
		if (!correct) {
			throw new DataUpdateException("密码更改失败，原密码错误");
		}
		newPassword = Cryptography.MD5Hash(newPassword, newAdmin.getaId());
		// 只更新密码
		newAdmin.setaPassword(newPassword);
		try {
			administratorMapper.updateByPrimaryKeySelective(newAdmin);
		} catch (Exception e) {
			throw new SystemErrorException("系统异常，密码更改失败，请联系管理员");
		}
	}

	@Override
	public Page findByQueryObject(QueryObject queryObject) {
		Integer totalCount = null;
		List<Administrator> list = null;
		try {
			totalCount = administratorMapper.getTotalCount(queryObject);
			list = administratorMapper.selectByQueryObject(queryObject);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemErrorException("系统异常，查询数据失败");
		}
		return new Page(list, totalCount, queryObject.getLimit(), queryObject.getPageNumber());
	}

	@Override
	public void lockOrUnlock(String uuid) {
		Administrator admin = null;
		try {
			admin = administratorMapper.selectByPrimaryKey(uuid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemErrorException("操作失败，系统异常");
		}
		if (admin.getaLevel()==0) {
			throw new DataUpdateException("不允许操作永久用户");
		}
		try {
			admin.lockOrUnlock();
			administratorMapper.updateByPrimaryKeySelective(admin);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemErrorException("操作失败，系统异常");
		}
	}

}
