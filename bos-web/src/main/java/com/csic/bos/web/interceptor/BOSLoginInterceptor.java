/**
 * Copyright (C), 2018-2018,xxx有限公司
 * FileName: BOSLoginInterceptor
 * Author: haoc
 * Date: 2018/9/9 16:29
 * Description: 自定义拦截器
 * History:
 * <author>        <time>        <Version>
 * 作者姓名         修改时间         版本号
 */
package com.csic.bos.web.interceptor;

import com.csic.bos.domain.User;
import com.csic.bos.utils.BOSUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * <一句话功能简述><br>
 * <自定义拦截器，实现用户未登录自动登录到登录页面>
 *
 *@author haoc
 *@date 2018/9/9
 *@since 1.0.0
 */
public class BOSLoginInterceptor extends MethodFilterInterceptor {
	/**
	 * 拦截方法
	 * @param invocation
	 * @return
	 * @throws Exception
	 */
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//获得代理
		ActionProxy proxy = invocation.getProxy();
		String actionName = proxy.getActionName();
		String namespace = proxy.getNamespace();
		String url = namespace + actionName;
		System.out.println(url);
		//从session中获取用户对象
		User user = BOSUtils.getLoginUser();
		if (user == null) {
			//没有登陆，跳转到登录页面
			return "login";
		}
		//放行
		return invocation.invoke();
	}
}