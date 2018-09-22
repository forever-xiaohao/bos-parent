/**
 * Copyright (C), 2018-2018,xxx有限公司
 * FileName: DecidedzoneAction
 * Author: haoc
 * Date: 2018/9/22 11:30
 * Description: 定区管理
 * History:
 * <author>        <time>        <Version>
 * 作者姓名         修改时间         版本号
 */
package com.csic.bos.web.action;

import com.csic.bos.domain.Decidedzone;
import com.csic.bos.service.IDecidedzoneService;
import com.csic.bos.web.action.base.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * <一句话功能简述><br>
 * <定区管理>
 *
 *@author haoc
 *@date 2018/9/22
 *@since 1.0.0
 */
@Controller
@Scope("prototype")
public class DecidedzoneAction extends BaseAction<Decidedzone> {
	/**属性驱动，接收多个分区id**/
	private String[] subareaid;

	public void setSubareaid(String[] subareaid) {
		this.subareaid = subareaid;
	}
	@Autowired
	private IDecidedzoneService decidedzoneService;

	/**
	 * 添加定区方法
	 */
	public String add() {
		decidedzoneService.save(model, subareaid);
		return LIST;
	}

	/**
	 * 分页查询方法
	 */
	public String pageQuery() throws IOException {
		decidedzoneService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[] {"currentPage","detachedCriteria","pageSize","subareas","decidedzones"});
		return NONE;
	}
}