package com.bsp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 控制页面跳转
 * 
 * @author hayate
 *
 */
@Controller
@Scope(value="prototype")
public class PageController {
	
	/**
	 * 控制页面跳转
	 *
	 * @param request
	 * @param htmlName 页面
	 * @return
	 */
	@RequestMapping("/p/{htmlName}")
	public String showPage(HttpServletRequest request, @PathVariable("htmlName") String htmlName) {
		return "/admin/" + htmlName;
	}
	
	/**
	 * 账号登陆页面
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String signIn() {
		return "/admin/login";
	}
	
	/**
	 * 首页
	 */
	@RequestMapping({"/index","/"})
	public String index() {
		return "/admin/index";
	}

}
