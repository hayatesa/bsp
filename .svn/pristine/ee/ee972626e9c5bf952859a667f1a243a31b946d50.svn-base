package com.bsp.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsp.dto.ResultMsgDTO;
import com.bsp.entity.User;
import com.bsp.entity.UserInfor;
import com.bsp.service.IUserService;
import com.bsp.utils.exceptions.UserDefinedException;
import com.bsp.utils.mail.MailSendUtils;

import cn.itcast.commons.CommonUtils;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private IUserService userService;
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("login")
	public String login() {
		return "user/login"; 
	}
	
	@RequestMapping("register")
	public String register() {
		return "user/register";
	}
	
	@RequestMapping("completeInfo")
	public String completeInfo() {
		return "user/completeInfo";
	}
	
	/**
	 * 进行邮箱校验
	 * 
	 * @return
	 */
	@RequestMapping("checkMail.do")
	@ResponseBody
	public ResultMsgDTO checkMail(HttpServletRequest request) {
		String mail = request.getParameter("email");
		List<User> users = this.userService.checkMail(mail);
		// 校验邮箱
		if (!mail.matches(EMAIL_REGEX)) {
			super.result = new ResultMsgDTO(false, "邮箱格式错误", null);
		} else {
			if (users.size() == 0) {
				super.result = new ResultMsgDTO(true, "邮箱可用", null);
			} else {
				super.result = new ResultMsgDTO(false, "此邮箱已被注册,您可以尝试找回密码", null);
			}
		}
		return super.result;
	}

	/**
	 * 发送邮箱验证码，并进行校验邮箱
	 * 
	 * @return
	 */
	@RequestMapping("sendMailCode.do")
	@ResponseBody
	public ResultMsgDTO sendMailCode(HttpServletRequest request) {
		// 获取邮箱账号和验证码
		String to = request.getParameter("email");
		String vcode = request.getParameter("vcode");
		String session_vcode = (String) request.getSession().getAttribute("session_vcode");
		// 校验验证码
		if (!vcode.toLowerCase().equals(session_vcode)) {
			super.result = new ResultMsgDTO(false, "验证码错误", null);
		} else {
			// 校验邮箱
			if (!to.matches(EMAIL_REGEX)) {
				super.result = new ResultMsgDTO(false, "邮箱格式错误", null);
			} else {
				// 生成邮箱验证码
				String mailVcode = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
				// 保存邮箱验证码到session中
				request.getSession().setAttribute("session_mailVcode", mailVcode);
				request.getSession().setAttribute("email", to);
				// 生成邮件主题内容
				String subject = "注册验证码"; // 邮件主题
				String content = "您的的验证码为：" + mailVcode + "，有效期30分钟。"; // 邮件主体内容
				MailSendUtils mailSendUtils = new MailSendUtils();
				try {
					mailSendUtils.sendMail(to, subject, content);// 发送邮件
					super.result = new ResultMsgDTO(true, "验证码发送成功，请登录邮箱查看", null);
				} catch (UserDefinedException e) {
					super.result = new ResultMsgDTO(false, "发生未知错误，请联系管理员，错误信息：" + e.getMessage(), null);
				}
			}
		}
		return super.result;
	}

	/**
	 * 校验邮箱验证码，确定邮箱可用
	 * 
	 * @return
	 */
	@RequestMapping("checkMailCode.do")
	@ResponseBody
	public ResultMsgDTO checkMailVcode(HttpServletRequest request) {
		String mail = request.getParameter("email");
		String mailVcode = request.getParameter("mailVcode");
		if (!mail.equals(request.getSession().getAttribute("email"))) {
			super.result = new ResultMsgDTO(false, "邮箱账号与发送验证码邮箱不匹配", null);
		} else {
			if (request.getSession().getAttribute("session_mailVcode").equals(mailVcode)) {
				// map.put("url", "/jsps/user/register2.jsp");
				super.result = new ResultMsgDTO(true, "验证通过，请完善个人资料", null);
			} else {
				super.result = new ResultMsgDTO(false, "验证码错误，请重新输入", null);
			}
		}
		return result;
	}

	/**
	 * 用户填写个人信息注册
	 * 
	 * @return
	 */
	@RequestMapping("register.do")
	@ResponseBody
	public ResultMsgDTO register(HttpServletRequest request) {
		String uNickname = request.getParameter("uNickname");
		String uSex = request.getParameter("uSex");
		String uPhone = request.getParameter("uPhone");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		// 表单验证
		if (uNickname.length() > 20) { // 昵称校验
			super.result = new ResultMsgDTO(false, "昵称长度过长不能超过20位", null);
		} else if (!password1.equals(password2)) { // 密码校验
			super.result = new ResultMsgDTO(false, "密码不一致", null);
		} else if (password1.length() < 8 || password1.length() > 20) {
			super.result = new ResultMsgDTO(false, "密码长度为8-20位", null);
		} else if (!uPhone.matches(PHONE_REGEX)) { // 手机号码校验
			super.result = new ResultMsgDTO(false, "请正确填写手机号码", null);
		} else {
			User user = new User();
			user.setMail((String) request.getSession().getAttribute("email"));
			user.setPassword(password1);
			UserInfor userInfor = new UserInfor();
			userInfor.setuNickname(uNickname);
			userInfor.setuSex(uSex);
			userInfor.setuPhone(uPhone);
			this.userService.addUser(user, userInfor);
			super.result = new ResultMsgDTO(true, "注册成功", null);

		}
		return super.result;
	}

	/**
	 * 用户登录
	 * 
	 * @return
	 */
	@RequestMapping("login.do")
	@ResponseBody
	public ResultMsgDTO login(HttpServletRequest request) {
		User user = CommonUtils.toBean(request.getParameterMap(), User.class);
		String vcode = request.getParameter("vcode");
		if (!vcode.equals(request.getSession().getAttribute("session_vcode"))) {
			super.result = new ResultMsgDTO(false, "验证码错误", null);
		} else {
			try {
				User succuser = this.userService.getUserByMail(user);
				request.getSession().setAttribute("user", succuser.getUUID());
				super.result = new ResultMsgDTO(true, "登录成功", null);
			} catch (UserDefinedException e) {
				super.result = new ResultMsgDTO(false, "密码错误", null);
			}
		}
		return super.result;
	}
	
}