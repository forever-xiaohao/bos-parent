/**
 * Copyright (C),2018-2018, xxx有限公司
 * FileName: IUserService
 * Author: haoc
 * Date: 2018/9/9 2:41
 * Description: userservice
 * History:
 * <author>       <time>        <version>
 * 作者姓名        修改时间         版本号
 */
package com.csic.bos.service;

import com.csic.bos.domain.User;

/**
 * <一句话功能简述><br>
 * <userservice>
 *
 *@author haoc
 *@date 2018/9/9
 *@since 1.0.0
 */
public interface IUserService {

	public User login(User model);

	void editPassword(String id, String password);
}
