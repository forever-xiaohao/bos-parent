/**
 * Copyright (C), 2018-2018,xxx有限公司
 * FileName: SubareaAction
 * Author: haoc
 * Date: 2018/9/20 19:59
 * Description: 区域划分
 * History:
 * <author>        <time>        <Version>
 * 作者姓名         修改时间         版本号
 */
package com.csic.bos.web.action;

import com.csic.bos.domain.Subarea;
import com.csic.bos.service.ISubareaService;
import com.csic.bos.web.action.base.BaseAction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <一句话功能简述><br>
 * <区域划分>
 *
 *@author haoc
 *@date 2018/9/20
 *@since 1.0.0
 */
@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<Subarea> {
	@Resource
	private ISubareaService subareaService;
	/**
	 * 添加分区
	 */
	public String add() {
		subareaService.save(model);
		return LIST;
	}
	/**
	 * 分页插叙
	 */
	public String pageQuery() {
		subareaService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"currentPage","detachedCriteria","pageSize","subareas","decidedzone","subareas"});
		return NONE;
	}
}
