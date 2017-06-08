package com.holy.sboot.origin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.holy.sboot.origin.basic.BaseDao;
import com.holy.sboot.origin.entity.User;

//@Repository
@Mapper
public interface UserDao extends BaseDao<User> {

//	public List<User> selectUsers(User user);
//
//	public void createUser(User user);
//
//	public List<User> searchUserByRole(@Param("page") int page, @Param("rows") int rows, @Param("roleId") String roleId,
//			@Param("owned") boolean owned);
//
//	public int countUserByRole(@Param("roleId") String roleId, @Param("owned") boolean owned);
//
//	public List<String> getUserIdByRoleId(String roleId);
//
//	public void deleteRoleUsers(@Param("userIds") List<String> userIds, @Param("roleId") String roleId);
//
//	public void insertRoleUsers(@Param("userIds") List<String> userIds, @Param("roleId") String roleId);
//
	public List<User> showUserList();
	
//
//	public void deleteUsers(List<String> userIds);
//
//	public void updataUser(User user);
	
}
