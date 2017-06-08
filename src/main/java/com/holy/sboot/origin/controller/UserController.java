package com.holy.sboot.origin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.holy.sboot.origin.basic.BaseCtrl;
import com.holy.sboot.origin.entity.User;
import com.holy.sboot.origin.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseCtrl {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> showUserList(){
		Map<String, Object> map = new HashMap<>();
		List<User> userList = userService.showUserList();
		map.put("data", userList);
		return map;
	}
}