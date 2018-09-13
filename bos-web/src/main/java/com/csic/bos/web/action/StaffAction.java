/**
 * Copyright (C), 2018-2018,xxx有限公司
 * FileName: StaffAction
 * Author: haoc
 * Date: 2018/9/11 22:27
 * Description: 取派员管理
 * History:
 * <author>        <time>        <Version>
 * 作者姓名         修改时间         版本号
 */
package com.csic.bos.web.action;

import com.csic.bos.domain.Staff;
import com.csic.bos.service.IStaffService;
import com.csic.bos.web.action.base.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * <一句话功能简述><br>
 * <取派员管理>
 *
 *@author haoc
 *@date 2018/9/11
 *@since 1.0.0
 */
@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {

	@Autowired
	private IStaffService staffService;

	/**
	 * 添加取派员
	 */
	public String add() {
		staffService.save(model);
 		return LIST;
	}
}