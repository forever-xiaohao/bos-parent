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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}