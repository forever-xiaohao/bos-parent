/**
 * Copyright (C),2018-2018, xxx有限公司
 * FileName: ISubareaService
 * Author: haoc
 * Date: 2018/9/20 20:03
 * Description:
 * History:
 * <author>       <time>        <version>
 * 作者姓名        修改时间         版本号
 */
package com.csic.bos.service;

import com.csic.bos.domain.Subarea;
import com.csic.bos.utils.PageBean;

/**
 * <一句话功能简述><br>
 * <>
 *
 *@author haoc
 *@date 2018/9/20
 *@since 1.0.0
 */
public interface ISubareaService {

	public void save(Subarea model);

	public void pageQuery(PageBean pageBean);
}
