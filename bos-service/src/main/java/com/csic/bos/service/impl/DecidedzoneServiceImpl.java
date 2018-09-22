/**
 * Copyright (C), 2018-2018,xxx有限公司
 * FileName: DecidedzoneServiceImpl
 * Author: haoc
 * Date: 2018/9/22 11:54
 * Description: 定区管理service实现类
 * History:
 * <author>        <time>        <Version>
 * 作者姓名         修改时间         版本号
 */
package com.csic.bos.service.impl;

import com.csic.bos.dao.IDecidedzoneDao;
import com.csic.bos.dao.ISubareaDao;
import com.csic.bos.domain.Decidedzone;
import com.csic.bos.domain.Subarea;
import com.csic.bos.service.IDecidedzoneService;
import com.csic.bos.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <一句话功能简述><br>
 * <定区管理service实现类>
 *
 *@author haoc
 *@date 2018/9/22
 *@since 1.0.0
 */
@Service
@Transactional
public class DecidedzoneServiceImpl implements IDecidedzoneService{

	@Autowired
	private IDecidedzoneDao decidedzoneDao;
	@Autowired
	private ISubareaDao subareaDao;

	/**
	 * 添加定区，同时关联分区
	 * @param model
	 * @param subareaid
	 */
	@Override
	public void save(Decidedzone model, String[] subareaid) {
		decidedzoneDao.save(model);
		for (String id : subareaid) {
			Subarea subarea = subareaDao.findById(id);
			//model.getSubareas().add(subarea);一方(定区)已经放弃维护外键权利，只能由多方（分区）负责维护
			//分区关联定区,维护外键
			subarea.setDecidedzone(model);
		}
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		decidedzoneDao.pageQuery(pageBean);
	}
}