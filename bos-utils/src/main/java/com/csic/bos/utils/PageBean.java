/**
 * Copyright (C), 2018-2018,xxx有限公司
 * FileName: PageBean
 * Author: haoc
 * Date: 2018/9/17 16:38
 * Description: 封装分页属性
 * History:
 * <author>        <time>        <Version>
 * 作者姓名         修改时间         版本号
 */
package com.csic.bos.utils;

import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * <一句话功能简述><br>
 * <封装分页属性>
 *
 *@author haoc
 *@date 2018/9/17
 *@since 1.0.0
 */
public class PageBean {
	/**当前页码**/
	private int currentPage;
	/**每页显示的记录数**/
	private int pageSize;
	/**查询条件**/
	private DetachedCriteria detachedCriteria;
	/**总记录数**/
	private int total;
	/**当前页需要展示的数据集合**/
	private List rows;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public DetachedCriteria getDetachedCriteria() {
		return detachedCriteria;
	}

	public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
		this.detachedCriteria = detachedCriteria;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}
}