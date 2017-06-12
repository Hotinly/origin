package com.holy.sboot.origin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.holy.sboot.origin.basic.BaseSvcImpl;
import com.holy.sboot.origin.dao.UserDao;
import com.holy.sboot.origin.entity.User;
import com.holy.sboot.origin.service.UserService;

@Service
public class UserServiceImpl extends BaseSvcImpl<UserDao, User> implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> showUserList() {
		Page<Object> page = PageHelper.startPage(1, 2, true);
		// logger.debug(page);
		System.out.println(page);
		return userDao.showUserList();
	}

}
