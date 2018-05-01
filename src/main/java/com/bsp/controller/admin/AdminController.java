package com.bsp.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsp.controller.BaseController;
import com.bsp.entity.Administrator;
import com.bsp.enums.BussCode;
import com.bsp.exceptions.SystemErrorException;
import com.bsp.shiro.ShiroUtils;
import com.bsp.utils.Cryptography;
import com.bsp.utils.Result;

@Controller
@RequestMapping("admin")
public class AdminController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	/**
	 * 管理员登录
	 */
	@RequestMapping("login")
	@ResponseBody
	public Result login(HttpServletRequest request, String userName, String password, String vcode) {
		Subject subject = ShiroUtils.getSubject();
		if (!vcode.equals(request.getSession().getAttribute("session_vcode"))) {
			return Result.error(BussCode.NOT_LOGIN, "验证码错误");
		}
		try {
			UsernamePasswordToken token = new UsernamePasswordToken(userName.toString(),
					Cryptography.MD5Hash(password, userName));
			subject.login(token);
		} catch (UnknownAccountException e) {
			return Result.error(e.getMessage());
		} catch (IncorrectCredentialsException e) {
			return Result.error(BussCode.NOT_LOGIN, "账号或密码不正确");
		} catch (LockedAccountException e) {
			return Result.error(e.getMessage());
		} catch (AuthenticationException e) {
			return Result.error("账户验证失败");
		} catch (SystemErrorException e) {
			return Result.error(e.getMessage());
		} catch (Exception e) {
			return Result.error(BussCode.ERR_UNKNOWN, "系统错误");
		}
		logger.info(((Administrator) ShiroUtils.getToken(Administrator.class)).getaId() + "登录系统");
		return Result.success();
	}

}
