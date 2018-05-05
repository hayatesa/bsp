package com.bsp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsp.enums.BussCode;
import com.bsp.shiro.ShiroUtils;
import com.bsp.utils.Result;

/**
 * 控制页面跳转
 * 
 * @author hayate
 *
 */
@Controller
@Scope(value="prototype")
public class PageController {
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	/**
	 * 控制页面跳转
	 *
	 * @param request
	 * @param moduleName 模块名
	 * @param htmlName 页面
	 * @return
	 */
	@RequestMapping("/module/{moduleName}/{htmlName}")
	public String showPage(HttpServletRequest request, @PathVariable("moduleName") String moduleName,
			@PathVariable("htmlName") String htmlName) {
		return "/" + moduleName + "/" + htmlName;
	}

	/**
	 * Home页面跳转 私有
	 */
	/*
	 * @RequestMapping("/home") public ModelAndView home() { Map<String,Object>
	 * map=new HashMap<>();
	 * 
	 * map.put("LOGINER",ShiroUtils.getSubject().getPrincipal()); //登陆校验 //return
	 * "index"; return new ModelAndView("index",map); }
	 */

	/**
	 * Login页面跳转 公开
	 */
	@ResponseBody
	@RequestMapping(value = "/not_login", method = RequestMethod.GET)
	public Result login() {
		System.err.println("111");
		return Result.error(BussCode.NOT_LOGIN, "账户未登录");
	}

	/**
	 * 退出
	 */
	@RequestMapping(value = "/log_out", method = RequestMethod.GET)
	public Result logout() {
		try {
			ShiroUtils.logout();
		} catch (Exception e) {
			logger.error("errorMessage:" + e.getMessage());
			return Result.error("退出登录失败");
		}

		return Result.success();
	}

	@RequestMapping("/no_access")
	public String ban() {
		return "no_access";
	}

	/**
	 * 测试角色权限
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/testRole")
	@RequiresRoles("USER")
	public Result tt() {
		return Result.success("登录用户才能看到的消息");
	}
}
