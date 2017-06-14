package com.holy.sboot.origin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holy.sboot.origin.basic.BaseSvcImpl;
import com.holy.sboot.origin.dao.RoleDao;
import com.holy.sboot.origin.entity.Role;
import com.holy.sboot.origin.service.RoleService;

@Service
public class RoleServiceImpl extends BaseSvcImpl<RoleDao, Role> implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Override
	public Role getRoleByName(Role role) {
		return roleDao.getByName(role);
	}

	@Override
	public void updateRoleAuth(Role role) {
		roleDao.deleteRoleAuth(role);
		roleDao.insertRoleAuth(role);
	}

}
