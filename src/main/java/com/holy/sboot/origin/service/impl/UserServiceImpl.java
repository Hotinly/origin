package com.holy.sboot.origin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holy.sboot.origin.basic.BaseSvc;
import com.holy.sboot.origin.dao.UserDao;
import com.holy.sboot.origin.entity.User;
import com.holy.sboot.origin.service.UserService;

@Service
public class UserServiceImpl extends BaseSvc<UserDao, User> implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> showUserList() {
//		Page<Object> page = PageHelper.startPage(1, 2, true);
//		logger.debug(page);
		return userDao.showUserList();
	}

}
