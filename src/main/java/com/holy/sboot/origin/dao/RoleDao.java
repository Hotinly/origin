package com.holy.sboot.origin.dao;

import org.apache.ibatis.annotations.Mapper;

import com.holy.sboot.origin.basic.BaseDao;
import com.holy.sboot.origin.entity.Role;

@Mapper
public interface RoleDao extends BaseDao<Role> {

	/**
	 * 通过设置roleName 或 roleEName查询角色
	 * 
	 * @param role
	 * @return
	 */
	public Role getByName(Role role);

	/**
	 * 维护角色与权限表： 通过角色id删除所对应的权限（单个）
	 * 
	 * @param role
	 * @return
	 */
	public int deleteRoleAuth(Role role);

	/**
	 * 维护角色与权限表： 通过Role里面的authList添加角色对应的权限（多个）
	 * 
	 * @param role
	 * @return
	 */
	public int insertRoleAuth(Role role);
}
