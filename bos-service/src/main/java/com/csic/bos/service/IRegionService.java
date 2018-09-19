/**
 * Copyright (C),2018-2018, xxx有限公司
 * FileName: IRegionService
 * Author: haoc
 * Date: 2018/9/19 21:47
 * Description:
 * History:
 * <author>       <time>        <version>
 * 作者姓名        修改时间         版本号
 */
package com.csic.bos.service;

import com.csic.bos.domain.Region;

import java.util.List;

/**
 * <一句话功能简述><br>
 * <>
 *
 *@author haoc
 *@date 2018/9/19
 *@since 1.0.0
 */
public interface IRegionService {

	public void saveBatch(List<Region> regionList);
}
