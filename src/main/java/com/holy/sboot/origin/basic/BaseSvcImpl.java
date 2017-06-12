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
public class BaseSvcImpl<D extends BaseDao<T>, T extends BaseEty<T>> implements BaseSvc<D, T> {

	/**
	 * 持久层对象
	 */
	@Autowired
	private D dao;

	/**
	 * 通过id获取单条数据
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public T get(Long id) {
		return dao.get(id);
	}

	/**
	 * 通过对象信息获取对象
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public T get(T entity) {
		return dao.get(entity);
	}

}
