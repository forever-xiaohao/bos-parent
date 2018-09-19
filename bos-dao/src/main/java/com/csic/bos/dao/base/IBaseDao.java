/**
 * Copyright (C),2018-2018, xxx有限公司
 * FileName: IBaseDao
 * Author: haoc
 * Date: 2018/9/8 15:48
 * Description: 持久层通用接口
 * History:
 * <author>       <time>        <version>
 * 作者姓名        修改时间         版本号
 */
package com.csic.bos.dao.base;

import com.csic.bos.utils.PageBean;

import java.io.Serializable;
import java.util.List;

/**
 * <一句话功能简述><br>
 * <持久层通用接口>
 *
 *@author haoc
 *@date 2018/9/8
 *@since 1.0.0
 */
public interface IBaseDao<T> {
    public void save(T entity);
    public void delete(T entity);
    public void update(T entity);
    public void saveOrUpdate(T entity);
    public T findById(Serializable id);
    public List<T> findAll();
    public void executeUpdate(String queryName, Object...objects);
    public void pageQuery(PageBean pageBean);
}
