package com.bsp.shiro.realms;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bsp.entity.User;
import com.bsp.exceptions.UserDefinedException;
import com.bsp.service.user.IUserService;

/**
 * shiro认证权限处理
 * @author chenyihui
   2018年3月22日
 */
@Service
@Transactional
public class UserRealm  extends AuthorizingRealm {
	
	private static final Logger logger=Logger.getLogger(UserRealm.class);
	
	/**
	 * 获得角色和权限处理
	* @Title: selectRole   
	* @Description: TODO(这里用一句话描述这个方法的作用)   
	* @param @param username
	* @param @param info    设定文件   
	* @return void    返回类型   
	* @throws
	 */
	
	@Autowired
	private IUserService userService;
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	private void selectRole(String username, SimpleAuthorizationInfo info)
	{
		
	}

    /**
     * 获取授权信息
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// TODO Auto-generated method stub
		User user=(User) principals.getPrimaryPrincipal();
		String username=user.getMail();
		if(!org.apache.commons.lang3.StringUtils.isEmpty(username))
		{
			SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
            selectRole(username, authorizationInfo);
            return authorizationInfo;
		}
		return null;
	}


	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticationToken) throws AuthenticationException {
		// TODO Auto-generated method stub
		SimpleAuthenticationInfo authenticationInfo = null;
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getPrincipal().toString();  
		User user =new User();
		user.setMail(username);
		try {
			if(userService.getUserByMail(user)!=null)
			{
						Object principal = user.getMail();
						Object credentials = user.getPassword();
						String realmName = this.getName();
						ByteSource credentialsSalt = ByteSource.Util.bytes(principal);
						authenticationInfo = new SimpleAuthenticationInfo(principal,
								credentials, credentialsSalt, realmName);
						logger.info("[用户:" + username + "|系统权限认证完成]");
						return authenticationInfo;
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserDefinedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
 
		
		return null;
	}
	

}
	

