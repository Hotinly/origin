package com.holy.sboot.origin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.holy.sboot.origin.basic.BaseCtrl;
import com.holy.sboot.origin.basic.JsonResponseMsg;
import com.holy.sboot.origin.entity.User;
import com.holy.sboot.origin.service.UserService;

@RestController
@RequestMapping("/sys/user")
public class UserController extends BaseCtrl {

	@Autowired
	private UserService systemService;

	@GetMapping("/list")
	public Map<String, Object> showUserList() {
		Map<String, Object> map = new HashMap<>();
		List<User> userList = systemService.showUserList();
		map.put("data", userList);
		return map;
	}

	@GetMapping("/get")
	public JsonResponseMsg<User> getById(User user) {
		User usr = systemService.get(user);
		logger.debug(usr);
		return JsonResponseMsg.createResponseMsg(usr);
	}

	@PostMapping("/delete")
	public JsonResponseMsg<String> delete(@RequestBody User user) {
		int row = systemService.delete(user);
		return JsonResponseMsg.createResponseMsg(row);
	}

	@PostMapping("/insert")
	public JsonResponseMsg<String> insert(@RequestBody User user) {
		int row = systemService.insert(user);
		return JsonResponseMsg.createResponseMsg(row);
	}

	@PostMapping("/update")
	public JsonResponseMsg<String> update(@RequestBody User user) {
		int row = systemService.update(user);
		return JsonResponseMsg.createResponseMsg(row);
	}
	
}
