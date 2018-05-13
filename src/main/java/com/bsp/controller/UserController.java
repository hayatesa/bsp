package com.bsp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bsp.dto.PageParams;
import com.bsp.exceptions.SystemErrorException;
import com.bsp.service.IUserService;
import com.bsp.utils.Result;

@Controller
@Scope(value="prototype")
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private IUserService userService;
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("lockOrDelete")
	public Result lockOrDeleteUser(String id) {
		try {
			userService.lockOrDeleteUser(id);
		} catch (SystemErrorException e) {
			e.printStackTrace();
			return Result.error(e.getMessage());
		}
		return Result.success();
	}
	
	/**
	 * 获取用户列表
	 * @param pageParams
	 * @return
	 */
	@RequestMapping("list")
	public Result list(PageParams pageParams) {
		return Result.success();
	}
	
	/**
	 * 获取一条用户记录
	 * @param uuid 用户主键
	 */
	@RequestMapping("detial")
	public Result getUserDetial(@RequestParam("uuid") Integer uuid) {
		return Result.success();
	}
}