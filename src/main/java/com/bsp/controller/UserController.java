package com.bsp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bsp.exceptions.SystemErrorException;
import com.bsp.service.IUserService;
import com.bsp.utils.Result;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private IUserService userService;
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("lockOrDelete")
	@Autowired
	public Result lockOrDeleteUser(String id) {
		try {
			userService.lockOrDeleteUser(id);
		} catch (SystemErrorException e) {
			e.printStackTrace();
			return Result.error(e.getMessage());
		}
		return Result.success();
	}
}