/**
 * Copyright (C), 2018-2018,xxx有限公司
 * FileName: IUserDao
 * Author: haoc
 * Date: 2018/9/8 16:40
 * Description: IUserDao
 * History:
 * <author>        <time>        <Version>
 * 作者姓名         修改时间         版本号
 */
package com.csic.bos.dao;

import com.csic.bos.dao.base.IBaseDao;
import com.csic.bos.domain.User;

/**
 * <一句话功能简述><br>
 * <IUserDao>
 *
 *@author haoc
 *@date 2018/9/8
 *@since 1.0.0
 */
public interface IUserDao extends IBaseDao<User> {

	public User findUserByUsernameAndPassword(String username, String password);
}