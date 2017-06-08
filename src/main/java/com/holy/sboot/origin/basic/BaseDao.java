package com.holy.sboot.origin.basic;

import java.util.List;

/**
 * Dao的通用增删改查（泛型）
 * 
 * @author Holy
 * @date 2017年6月8日 下午1:50:15
 * @ref
 * @param <T>
 */
public interface BaseDao<T> {

	/**
	 * 通过id获取单条数据
	 * 
	 * @param id
	 * @return
	 */
	public T get(int id);

	/**
	 * 通过对象信息获取对象
	 * 
	 * @param entity
	 * @return
	 */
	public T get(T entity);

	/**
	 * 分页查询
	 * 
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity);

	/**
	 * 查询所有，参数？？？
	 * 
	 * @param entity
	 * @return
	 */
	public List<T> findAllList(T entity);

	/**
	 * 插入数据
	 * 
	 * @param entity
	 * @return
	 */
	public int insert(T entity);

	/**
	 * 删除数据（逻辑删除，status置为0）
	 * 
	 * @param entity
	 * @return
	 */
	public int delete(T entity);

	/**
	 * 更新数据
	 * 
	 * @param entity
	 * @return
	 */
	public int update(T entity);
}
