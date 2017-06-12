package com.holy.sboot.origin.service.impl;

import org.springframework.stereotype.Service;

import com.holy.sboot.origin.basic.BaseSvcImpl;
import com.holy.sboot.origin.dao.AuthDao;
import com.holy.sboot.origin.entity.Auth;
import com.holy.sboot.origin.service.AuthService;

@Service
public class AuthServiceImpl extends BaseSvcImpl<AuthDao, Auth> implements AuthService {

}
