package com.bsp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bsp.entity.Administrator;
import com.bsp.exceptions.DataUpdateException;
import com.bsp.exceptions.SystemErrorException;
import com.bsp.service.IAdminService;
import com.bsp.shiro.ShiroUtils;
import com.bsp.utils.Result;

@Controller
@Scope(value="prototype")
@RequestMapping("admin")
public class AdminController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private IAdminService adminService;
	
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}

	/**
	 * 修改密码
	 * @return
	 */
	@RequestMapping(value="password", method=RequestMethod.POST)
	public Result changePassword(String currentPassword, String newPassword, String confirmPassword) {
		Administrator admin = ShiroUtils.getToken();
		try {
			adminService.changePassword(admin, currentPassword, newPassword, confirmPassword);
		} catch (DataUpdateException e) {
			e.printStackTrace();
			return Result.error(e.getMessage());
		} catch (SystemErrorException e) {
			return Result.error(e.getMessage());
		}
		return Result.success();
	}
}
