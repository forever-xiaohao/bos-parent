/**
 * Copyright (C), 2018-2018,xxx有限公司
 * FileName: UserDaoImpl
 * Author: haoc
 * Date: 2018/9/8 16:41
 * Description: UserDao实现类
 * History:
 * <author>        <time>        <Version>
 * 作者姓名         修改时间         版本号
 */
package com.csic.bos.dao.impl;

import com.csic.bos.dao.IUserDao;
import com.csic.bos.dao.base.impl.BaseDaoImpl;
import com.csic.bos.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <一句话功能简述><br>
 * <UserDao实现类>
 *
 *@author haoc
 *@date 2018/9/8
 *@since 1.0.0
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao{

	/***
	 * 根据用户名和密码查询用户
	 * @param username
	 * @param password
	 * @return
	 */
	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		String hql = "FROM User u WHERE u.username = ? AND u.password = ?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, username, password);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}