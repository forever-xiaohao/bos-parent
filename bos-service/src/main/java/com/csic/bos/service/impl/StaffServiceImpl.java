/**
 * Copyright (C), 2018-2018,xxx有限公司
 * FileName: StaffServiceImpl
 * Author: haoc
 * Date: 2018/9/11 22:34
 * Description: dfdfd
 * History:
 * <author>        <time>        <Version>
 * 作者姓名         修改时间         版本号
 */
package com.csic.bos.service.impl;

import com.csic.bos.dao.IStaffDao;
import com.csic.bos.domain.Staff;
import com.csic.bos.service.IStaffService;
import com.csic.bos.utils.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <一句话功能简述><br>
 * <dfdfd>
 *
 *@author haoc
 *@date 2018/9/11
 *@since 1.0.0
 */
@Service
@Transactional
public class StaffServiceImpl implements IStaffService {

	@Autowired
	private IStaffDao staffDao;
	@Override
	public void save(Staff model) {
		staffDao.save(model);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		staffDao.pageQuery(pageBean);
	}

	/**
	 * 取派员批量删除
	 * 逻辑删除，将deltag改为1
	 * @param ids  1,2,3,4
	 */
	@Override
	public void deleteBatch(String ids) {
		if (StringUtils.isNotBlank(ids)) {
			String[] staffIds = ids.split(",");
			for (String id : staffIds) {
				staffDao.executeUpdate("staff.delete", id);
			}
		}
	}

	/**
	 * 根据id查询取派员
	 * @param id
	 * @return
	 */
	@Override
	public Staff findById(String id) {
		return staffDao.findById(id);
	}

	/**
	 * 根据id修改取派员
	 * @param staff
	 */
	@Override
	public void update(Staff staff) {
		staffDao.update(staff);
	}

	/**
	 * 查询所有未删除取派员的数据
	 * @return
	 */
	@Override
	public List<Staff> findListNotDelete() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Staff.class);
		//添加过滤条件，deltag等于0
		detachedCriteria.add(Restrictions.eq("deltag", "0"));
		return staffDao.findByCriteria(detachedCriteria);
	}
}