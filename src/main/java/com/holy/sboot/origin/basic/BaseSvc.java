package com.holy.sboot.origin.basic;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Service的通用方法
 * 
 * @author Holy
 * @date 2017年6月9日 下午4:59:56
 * @ref
 * @param <D>
 * @param <T>
 */
public abstract class BaseSvc<D extends BaseDao<T>, T extends BaseEty<T>> extends BaseObj {

	
	
//	/**
//	 * 持久层对象(只注入了一个，但可能存在有多个的情况)
//	 */
//	@Autowired
//	private D dao;
//
//	/**
//	 * 通过id获取单条数据
//	 * 
//	 * @param id
//	 * @return
//	 */
//	public T get(Long id) {
//		return dao.get(id);
//	}
//
//	/**
//	 * 通过对象信息获取对象
//	 * 
//	 * @param entity
//	 * @return
//	 */
//	public T get(T entity) {
//		return dao.get(entity);
//	}
}
