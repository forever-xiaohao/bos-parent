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
import com.csic.bos.utils.PageBean;
import com.csic.bos.web.action.base.BaseAction;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;

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

	//属性驱动，接收页面提交的分页参数
	private int page;
	private int rows;


	/**
	 * 分页查询方法
	 */
	public String pageQuery() throws IOException {
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(page);
		pageBean.setPageSize(rows);
		//创建离线提交查询对象
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Staff.class);
		pageBean.setDetachedCriteria(detachedCriteria);
		staffService.pageQuery(pageBean);

		//使用json-lib将PageBean对象转为json，通过输出流写回页面中
		//JSONObject---将单一对象转为json
		//JSONArray---将数组或集合对象转为json
		//设置哪些属性不需要转为json
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] {"currentPage","detachedCriteria","pageSize"});
		String json = JSONObject.fromObject(pageBean, jsonConfig).toString();
		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(json);

		return NONE;
	}
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

}