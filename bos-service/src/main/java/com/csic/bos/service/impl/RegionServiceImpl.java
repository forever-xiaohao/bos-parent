/**
 * Copyright (C), 2018-2018,xxx有限公司
 * FileName: RegionServiceImpl
 * Author: haoc
 * Date: 2018/9/19 21:49
 * Description: RegionService接口实现
 * History:
 * <author>        <time>        <Version>
 * 作者姓名         修改时间         版本号
 */
package com.csic.bos.service.impl;

import com.csic.bos.dao.IRegionDao;
import com.csic.bos.domain.Region;
import com.csic.bos.service.IRegionService;
import com.csic.bos.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <一句话功能简述><br>
 * <RegionService接口实现>
 *
 *@author haoc
 *@date 2018/9/19
 *@since 1.0.0
 */
@Service
@Transactional
public class RegionServiceImpl implements IRegionService {
	@Autowired
	private IRegionDao regionDao;
	/**
	 * 区域数据批量保存
	 * @param regionList
	 */
	@Override
	public void saveBatch(List<Region> regionList) {
		for (Region region : regionList) {
			regionDao.saveOrUpdate(region);
		}
	}

	/**
	 * 区域分页查询
	 * @param pageBean
	 */
	@Override
	public void pageQuery(PageBean pageBean) {
		regionDao.pageQuery(pageBean);
	}

	@Override
	public List<Region> findAll() {
		return regionDao.findAll();
	}

	/**
	 * 根据页面输入进行模糊查询
	 * @param q
	 * @return
	 */
	@Override
	public List<Region> findListByQ(String q) {
		return regionDao.findListByQ(q);
	}
}