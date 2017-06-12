package com.holy.sboot.origin.service;

import java.util.List;

import com.holy.sboot.origin.basic.BaseSvc;
import com.holy.sboot.origin.dao.UserDao;
import com.holy.sboot.origin.entity.User;

public interface UserService extends BaseSvc<UserDao, User>{

	List<User> showUserList();
	
}
