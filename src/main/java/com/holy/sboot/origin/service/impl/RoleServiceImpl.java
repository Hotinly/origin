package com.holy.sboot.origin.service.impl;

import org.springframework.stereotype.Service;

import com.holy.sboot.origin.basic.BaseSvcImpl;
import com.holy.sboot.origin.dao.RoleDao;
import com.holy.sboot.origin.entity.Role;
import com.holy.sboot.origin.service.RoleService;

@Service
public class RoleServiceImpl extends BaseSvcImpl<RoleDao, Role> implements RoleService {

}
