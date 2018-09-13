/**
 * Copyright (C), 2018-2018,xxx有限公司
 * FileName: BaseDaoImpl
 * Author: haoc
 * Date: 2018/9/8 15:52
 * Description: d
 * History:
 * <author>        <time>        <Version>
 * 作者姓名         修改时间         版本号
 */
package com.csic.bos.dao.base.impl;

import com.csic.bos.dao.base.IBaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * <一句话功能简述><br>
 * <持久层通用实现>
 *继承HibernateDaoSupport可以获得一个模板对象，实现增删改查
 *@author haoc
 *@date 2018/9/8
 *@since 1.0.0
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {

    /**
     * 代表的是某个实体的类型
     */
    private Class<T> entityClass;

    /**
     * 在父类（BaseDaoImpl）的构造方法中动态获得entityClass
     */
    public BaseDaoImpl() {
        ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        //获得父类上声明的泛型数组
        Type[] actualTypeArguments = superclass.getActualTypeArguments();
        entityClass = (Class<T>) actualTypeArguments[0];
    }

    /**
     * @Resource该注解的意思是根据类型注入Spring工厂中的会话工厂对象SessionFactory
     * @param sessionFactory
     */
    @Resource
    public void setMySessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public void save(T entity) {
        this.getHibernateTemplate().save(entity);
    }

    @Override
    public void delete(T entity) {
        this.getHibernateTemplate().delete(entity);
    }

    @Override
    public void update(T entity) {
        this.getHibernateTemplate().update(entity);
    }

    @Override
    public T findById(Serializable id) {
        return this.getHibernateTemplate().get(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        String hql = "FROM " + entityClass.getSimpleName();
        return (List<T>) this.getHibernateTemplate().find(hql);
    }

	/**
	 * 执行更新
	 * @param queryName 更新语句的名字
	 * @param objects
	 */
	@Override
	public void executeUpdate(String queryName, Object... objects) {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.getNamedQuery(queryName);
		int i = 0;
		for (Object object : objects) {
			//为HQL语句中的？赋值
			query.setParameter(i++, object);
		}
		//执行更新
		query.executeUpdate();
	}
}