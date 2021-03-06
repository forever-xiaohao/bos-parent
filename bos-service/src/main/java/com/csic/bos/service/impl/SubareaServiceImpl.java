/**
 * Copyright (C), 2018-2018,xxx有限公司
 * FileName: SubareaServiceImpl
 * Author: haoc
 * Date: 2018/9/20 20:04
 * Description: 实现SubareaService接口
 * History:
 * <author>        <time>        <Version>
 * 作者姓名         修改时间         版本号
 */
package com.csic.bos.service.impl;

import com.csic.bos.dao.ISubareaDao;
import com.csic.bos.domain.Subarea;
import com.csic.bos.service.ISubareaService;
import com.csic.bos.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <一句话功能简述><br>
 * <实现SubareaService接口>
 *
 *@author haoc
 *@date 2018/9/20
 *@since 1.0.0
 */
@Service
@Transactional
public class SubareaServiceImpl implements ISubareaService {
	@Autowired
	private ISubareaDao subareaDao;

	@Override
	public void save(Subarea model) {
		subareaDao.save(model);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		subareaDao.pageQuery(pageBean);
	}

	@Override
	public List<Subarea> findAll() {
		return subareaDao.findAll();
	}

	/**
	 * 查询所有未关联到定区的分区
	 * @return
	 */
	@Override
	public List<Subarea> findListNotAssociation() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Subarea.class);
		//添加过滤条件，即分区对象中detachedCriteria属性为null
		detachedCriteria.add(Restrictions.isNull("decidedzone"));
		return subareaDao.findByCriteria(detachedCriteria);
	}

	/**
	 * 根据定区id查询关联的分区
	 * @param decidedzoneId
	 * @return
	 */
	@Override
	public List<Subarea> findListByDecidedzoneId(String decidedzoneId) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Subarea.class);
		//添加过滤条件
		detachedCriteria.add(Restrictions.eq("decidedzone.id", decidedzoneId));
		return subareaDao.findByCriteria(detachedCriteria);
	}
}