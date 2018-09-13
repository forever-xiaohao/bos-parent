/**
 * Copyright (C), 2018-2018,xxx有限公司
 * FileName: UserServiceImpl
 * Author: haoc
 * Date: 2018/9/9 2:46
 * Description: userservice实现类
 * History:
 * <author>        <time>        <Version>
 * 作者姓名         修改时间         版本号
 */
package com.csic.bos.service.impl;

import com.csic.bos.dao.IUserDao;
import com.csic.bos.domain.User;
import com.csic.bos.service.IUserService;
import com.csic.bos.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <一句话功能简述><br>
 * <userservice实现类>
 *
 *@author haoc
 *@date 2018/9/9
 *@since 1.0.0
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	@Override
	public User login(User user) {
		//使用MD5加密密码
		String password = MD5Utils.md5(user.getPassword());
		return 	userDao.findUserByUsernameAndPassword(user.getUsername(), password);
	}

	/**
	 * 根据用户id修改密码
	 * @param id
	 * @param password
	 */
	@Override
	public void editPassword(String id, String password) {
		//使用MD5加密密码
		password = MD5Utils.md5(password);
		userDao.executeUpdate("user.editpassword", password,id);
	}
}