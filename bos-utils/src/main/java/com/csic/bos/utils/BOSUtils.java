/**
 * Copyright (C), 2018-2018,xxx有限公司
 * FileName: BOSUtils
 * Author: haoc
 * Date: 2018/9/9 16:38
 * Description: 通用工具类
 * History:
 * <author>        <time>        <Version>
 * 作者姓名         修改时间         版本号
 */
package com.csic.bos.utils;

import com.csic.bos.domain.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * <一句话功能简述><br>
 * <通用工具类>
 *
 *@author haoc
 *@date 2018/9/9
 *@since 1.0.0
 */
public class BOSUtils {
	/**
	 * 获取session对象
	 */
	public static HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}

	/**
	 * 获取登录用户对象
	 */
	public static User getLoginUser() {
		return (User) getSession().getAttribute("loginUser");
	}
}