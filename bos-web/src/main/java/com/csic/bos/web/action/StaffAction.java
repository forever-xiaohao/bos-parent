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

import java.io.IOException;
import java.util.List;

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


	/**
	 * 分页查询方法
	 */
	public String pageQuery() throws IOException {
		staffService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[] {"currentPage","detachedCriteria","pageSize"});
		return NONE;
	}



	/**属性驱动,接收页面提交的ids参数**/
	private String ids;
	/**
	 * 取派员批量删除
	 * @return
	 */
	public String deleteBatch() {
		staffService.deleteBatch(ids);
		return LIST;
	}

	/**
	 * 修改取派员信息
	 * @return
	 */
	public String edit() {
		//先查询数据库，根据id查询原始数据
		Staff staff = staffService.findById(model.getId());
		//使用页面提交的数据进行覆盖
		staff.setName(model.getName());
		staff.setTelephone(model.getTelephone());
		staff.setHaspda(model.getHaspda());
		staff.setStandard(model.getStandard());
		staff.setStation(model.getStation());
		staffService.update(staff);
		return LIST;
	}

	/**
	 * 查询所有未删除的取派员，返回json
	 * @return
	 */
	public String listajax() {
		List<Staff> list = staffService.findListNotDelete();
		this.java2Json(list, new String[]{"decidedzones"});
		return NONE;
	}


	public void setIds(String ids) {
		this.ids = ids;
	}

}