/**
 * Copyright (C),2018-2018, xxx有限公司
 * FileName: IStaffService
 * Author: haoc
 * Date: 2018/9/11 22:29
 * Description:
 * History:
 * <author>       <time>        <version>
 * 作者姓名        修改时间         版本号
 */
package com.csic.bos.service;

import com.csic.bos.domain.Staff;
import com.csic.bos.utils.PageBean;

import java.util.List;

/**
 * <一句话功能简述><br>
 * <>
 *
 *@author haoc
 *@date 2018/9/11
 *@since 1.0.0
 */
public interface IStaffService {

	public void save(Staff model);

	public void pageQuery(PageBean pageBean);

	public void deleteBatch(String ids);

	public Staff findById(String id);

	public void update(Staff staff);

	public List<Staff> findListNotDelete();
}
