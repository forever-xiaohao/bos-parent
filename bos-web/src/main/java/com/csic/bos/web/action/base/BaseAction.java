/**
 * Copyright (C), 2018-2018,xxx有限公司
 * FileName: BaseAction
 * Author: haoc
 * Date: 2018/9/8 16:28
 * Description: d
 * History:
 * <author>        <time>        <Version>
 * 作者姓名         修改时间         版本号
 */
package com.csic.bos.web.action.base;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * <一句话功能简述><br>
 * <表现层通用实现>
 *
 *@author haoc
 *@date 2018/9/8
 *@since 1.0.0
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
    public static final String HOME = "home";
	public static final String LIST = "list";

	/**
     * 模型对象
     */
    protected T model;

    @Override
    public T getModel() {
        return model;
    }

    /**
     * 在构造方法中动态获取实体类型，通过反射创建model对象
     */
    public BaseAction() {
        //获得父类类型,并向下强制类型转换
        ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        //获得<T>中的泛型数组
        Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
        //转成实现类的类型
        Class<T> entityClass = (Class<T>) actualTypeArguments[0];
        //通过反射创建对象
        try {
            model = entityClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}