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

	@Autowired
	private D dao;

	@Override
	public T get(T entity) {
		return dao.get(entity);
	}

	@Override
	public int delete(T entity) {
		return dao.delete(entity);
	}

	@Override
	public int insert(T entity) {
		return dao.insert(entity);
	}

	@Override
	public int update(T entity) {
		return dao.update(entity);
	}

}
