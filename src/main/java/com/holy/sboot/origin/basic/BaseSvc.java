package com.holy.sboot.origin.basic;

/**
 * Service的通用方法
 * 
 * @author Holy
 * @date 2017年6月9日 下午4:59:56
 * @ref
 * @param <D>
 * @param <T>
 */
public interface BaseSvc<D, T> {

	/**
	 * 通过id获取单条数据
	 * 
	 * @param id
	 * @return
	 */
	public T get(Long id);

	/**
	 * 通过对象信息获取对象
	 * 
	 * @param entity
	 * @return
	 */
	public T get(T entity);
}
