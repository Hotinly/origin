package com.holy.sboot.origin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.holy.sboot.origin.basic.BaseCtrl;
import com.holy.sboot.origin.basic.JsonResponseMsg;
import com.holy.sboot.origin.dao.RoleDao;
import com.holy.sboot.origin.dao.UserDao;
import com.holy.sboot.origin.entity.Role;
import com.holy.sboot.origin.entity.User;

public class LoginController extends BaseCtrl {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;

	@SuppressWarnings("deprecation")
	@GetMapping("/roleIds")
	public JsonResponseMsg<User> getRoleIds(Long userId) {
		List<Long> roleIds = userDao.getRoleIds(userId);
		// user.setRoleIdList(roleIds);
		List<Role> roleList = roleDao.getRoleList(roleIds);
		User user = userDao.get(userId);
		user.setRoleList(roleList);
		Role role = roleDao.get(roleList.get(0));
		user.setRole(role);
		System.out.println(user.getRoleList().get(0).toString());
		System.out.println(user.toString());
		return JsonResponseMsg.createResponseMsg(user);
	}
}
