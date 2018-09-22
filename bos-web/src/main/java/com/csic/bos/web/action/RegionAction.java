/**
 * Copyright (C), 2018-2018,xxx有限公司
 * FileName: RegionAction
 * Author: haoc
 * Date: 2018/9/19 16:36
 * Description: 区域管理
 * History:
 * <author>        <time>        <Version>
 * 作者姓名         修改时间         版本号
 */
package com.csic.bos.web.action;

import com.csic.bos.domain.Region;
import com.csic.bos.service.IRegionService;
import com.csic.bos.utils.PinYin4jUtils;
import com.csic.bos.web.action.base.BaseAction;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述><br>
 * <区域管理>
 *
 *@author haoc
 *@date 2018/9/19
 *@since 1.0.0
 */
@Controller
@Scope("prototype")
public class RegionAction extends BaseAction<Region> {
	/**属性驱动，接收上传的文件**/
	private File regionFile;
	@Autowired
	private IRegionService regionService;

	public void setRegionFile(File regionFile) {
		this.regionFile = regionFile;
	}
	/**
	 * 区域导入
	 */
	public String importXls() throws IOException {
		List<Region> regionList = new ArrayList<Region>();
		//使用POI解析Excel文件
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(regionFile));
		//根据名称获得指定Sheet对象
		HSSFSheet hssfSheet = workbook.getSheet("Sheet1");
		for (Row row : hssfSheet) {
			int rowNum = row.getRowNum();
			if (rowNum == 0) {
				continue;
			}

			String id = row.getCell(0).getStringCellValue();
			String province = row.getCell(1).getStringCellValue();
			String city = row.getCell(2).getStringCellValue();
			String district = row.getCell(3).getStringCellValue();
			String postcode = row.getCell(4).getStringCellValue();

			//包装一个区域对象
			Region region = new Region(id, province, city, district, postcode, null, null, null);
			province = province.substring(0, province.length() - 1);
			city = city.substring(0, city.length() - 1);
			district = district.substring(0, district.length() - 1);
			String info = province + city + district;
			System.out.println("info:--------------------------" + info);
			String[] headByString = PinYin4jUtils.getHeadByString(info);
			String shortcode = StringUtils.join(headByString);
			//城市编码----->shijiazhuang
			String citycode = PinYin4jUtils.hanziToPinyin(city, "");
			region.setShortcode(shortcode);
			region.setCitycode(citycode);
			regionList.add(region);
		}
		//批量保存
		regionService.saveBatch(regionList);
		return NONE;
	}


	/**
	 * 分页查询
	 */
	public String pageQuery() throws IOException {
		regionService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[] {"currentPage","detachedCriteria","pageSize","subareas"});
		return NONE;
	}

	/**属性驱动，接收参数q**/
	private String q;
	/**
	 * 查询所有区域，写回json数据
	 * @return
	 */
	public String listajax() {
		List<Region> list = null;
		if (StringUtils.isNotBlank(q)) {
			list = regionService.findListByQ(q);
		}else {
			list = regionService.findAll();
		}
		this.java2Json(list, new String[]{"subareas"});
		return NONE;
	}


	public void setQ(String q) {
		this.q = q;
	}




}