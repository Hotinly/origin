package com.holy.sboot.origin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.holy.sboot.origin.basic.BaseDao;
import com.holy.sboot.origin.entity.Role;

@Mapper
public interface RoleDao extends BaseDao<Role> {

	/**
	 * 通过roleIds 获取Role对象
	 * 
	 * @param roleIds
	 * @return
	 */
	public List<Role> getRoleList(@Param("roleIds") List<Long> roleIds);

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
