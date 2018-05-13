package com.bsp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bsp.dto.QueryObject;
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
	 * 更新资料，只能修改当前用户资料的部分字段，实现时请完成参数列表
	 */
	@RequestMapping("update")
	public Result update() {
		return Result.success();
	}
	
	/**
	 * 修改当前用户密码
	 */
	@RequestMapping(value="password", method=RequestMethod.POST)
	public Result changePassword(String currentPassword, String newPassword, String confirmPassword) {
		Administrator admin = ShiroUtils.getToken();
		try {
			adminService.changePassword(admin, currentPassword, newPassword, confirmPassword);
		} catch (DataUpdateException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return Result.error(e.getMessage());
		} catch (SystemErrorException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return Result.error(e.getMessage());
		}
		logger.info(admin.getaId()+"修改密码成功");
		return Result.success();
	}
	
	/**
	 * 获取管理员列表
	 * @param pageParams 分页参数
	 */
	@RequestMapping("list")
	public Result list(QueryObject pageParams) {
		return Result.success();
	}
	
	/**
	 * 添加管理员，只有超级管理员能调用，实现时请完成参数列表
	 */
	@RequestMapping("add")
	public Result add() {
		return Result.success();
	}
	
	/**
	 * 禁用|删除一个管理员，只有超级管理员能调用，不能禁用当前用户
	 * @param uuid 管理员id
	 */
	@RequestMapping("lockOrDelete")
	public Result lockOrDelete(@RequestParam("uuid") String uuid) {
		return Result.success();
	}
}
