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
	@Deprecated
	public T get(Long id);

	/**
	 * 删除数据（参数为对象） mapper映射文件中，不再需要参数parameterType，并可获取实体中的数据
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
	public List<T> findAllList();

	/**
	 * 插入数据
	 * 
	 * @param entity
	 * @return
	 */
	public int insert(T entity);

	/**
	 * 删除数据（id）（逻辑删除，status置为0）
	 * 
	 * @param entity
	 * @return
	 */
	@Deprecated
	public int delete(Long id);

	/**
	 * 删除数据（参数为对象） mapper映射文件中，不再需要参数parameterType，并可获取实体中的数据
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
