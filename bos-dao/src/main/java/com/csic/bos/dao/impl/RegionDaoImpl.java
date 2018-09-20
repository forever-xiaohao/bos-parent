/**
 * Copyright (C), 2018-2018,xxx有限公司
 * FileName: RegionDaoImpl
 * Author: haoc
 * Date: 2018/9/19 21:55
 * Description: RegionDao的实现类
 * History:
 * <author>        <time>        <Version>
 * 作者姓名         修改时间         版本号
 */
package com.csic.bos.dao.impl;

import com.csic.bos.dao.IRegionDao;
import com.csic.bos.dao.base.impl.BaseDaoImpl;
import com.csic.bos.domain.Region;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <一句话功能简述><br>
 * <RegionDao的实现类>
 *
 *@author haoc
 *@date 2018/9/19
 *@since 1.0.0
 */
@Repository
public class RegionDaoImpl extends BaseDaoImpl<Region> implements IRegionDao {
	/**
	 * 根据q参数进行模糊查询
	 * @param q
	 * @return
	 */
	@Override
	public List<Region> findListByQ(String q) {
		String hql = "FROM Region r WHERE r.shortcode LIKE ? OR r.citycode LIKE ? OR r.province LIKE ? OR r.city LIKE ? OR r.district LIKE ?";
		List<Region> list = (List<Region>) this.getHibernateTemplate().find(hql, "%" + q + "%", "%" + q + "%", "%" + q + "%", "%" + q + "%", "%" + q + "%");
		return list;
	}
}