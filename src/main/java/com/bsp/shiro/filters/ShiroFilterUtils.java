package com.bsp.shiro.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bsp.utils.JsonUtils;

public class ShiroFilterUtils {
	// 登录页面
	static final String LOGIN_URL = "/module/admin/login";
	// 没有权限提醒
	final static String UNAUTHORIZED_URL = "/module/admin/unauthorized";

	/**
	 * 是否是Ajax请求
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isAjax(ServletRequest request) {
		return "XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"));
	}

	/**
	 * response 输出JSON
	 * 
	 * @param hresponse
	 * @param resultMap
	 * @throws IOException
	 */
	public static void out(ServletResponse response, Map<String, String> resultMap) {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		PrintWriter out = null;
		response.setContentType("application/json; charset=utf-8");
		try {
			out = httpServletResponse.getWriter();
			out.println(JsonUtils.toJsonStr(resultMap));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != out) {
				out.flush();
				out.close();
			}
		}
	}
}