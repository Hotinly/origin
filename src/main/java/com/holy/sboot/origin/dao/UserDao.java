package com.holy.sboot.origin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.holy.sboot.origin.basic.BaseDao;
import com.holy.sboot.origin.entity.User;

//@Repository
@Mapper
public interface UserDao extends BaseDao<User> {

	public List<User> showUserList();

	/**
	 * 通过userId获取对应的roleIds(暂为一个)
	 * 
	 * @param userId
	 * @return
	 */
	public List<Long> getRoleIds(Long userId);
}
