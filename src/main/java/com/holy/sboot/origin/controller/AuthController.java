package com.holy.sboot.origin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.holy.sboot.origin.basic.BaseCtrl;
import com.holy.sboot.origin.basic.JsonResponseMsg;
import com.holy.sboot.origin.entity.Auth;
import com.holy.sboot.origin.service.AuthService;

@RestController
@RequestMapping("/sys/auth")
public class AuthController extends BaseCtrl {

	@Autowired
	private AuthService authService;

//	@GetMapping("/list")
//	public Map<String, Object> showAuthList() {
//		Map<String, Object> map = new HashMap<>();
//		List<Auth> authList = authService.showAuthList();
//		map.put("data", authList);
//		return map;
//	}

	@GetMapping("/get")
	public JsonResponseMsg<Auth> getById(Auth auth) {
		Auth usr = authService.get(auth);
		logger.debug(usr);
		return JsonResponseMsg.createResponseMsg(usr);
	}

	@PostMapping("/delete")
	public JsonResponseMsg<String> delete(@RequestBody Auth auth) {
		int row = authService.delete(auth);
		return JsonResponseMsg.createResponseMsg(row);
	}

	@PostMapping("/insert")
	public JsonResponseMsg<String> insert(@RequestBody Auth auth) {
		int row = authService.insert(auth);
		return JsonResponseMsg.createResponseMsg(row);
	}

	@PostMapping("/update")
	public JsonResponseMsg<String> update(@RequestBody Auth auth) {
		int row = authService.update(auth);
		return JsonResponseMsg.createResponseMsg(row);
	}
	
}
