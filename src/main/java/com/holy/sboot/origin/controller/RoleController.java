package com.holy.sboot.origin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.holy.sboot.origin.basic.BaseCtrl;
import com.holy.sboot.origin.basic.JsonResponseMsg;
import com.holy.sboot.origin.entity.Role;
import com.holy.sboot.origin.service.RoleService;

@RestController
@RequestMapping("/sys/role")
public class RoleController extends BaseCtrl {

	@Autowired
	private RoleService roleService;

	@GetMapping("/search")
	public JsonResponseMsg<Role> getRoleByName(Role role) {
		if(StringUtils.isEmpty(role.getRoleEName()) && StringUtils.isEmpty(role.getRoleName())){
			return JsonResponseMsg.createErrorResponseMsg();
		}
		Role rol = roleService.getRoleByName(role);
		return JsonResponseMsg.createResponseMsg(rol);
	}

	@PostMapping("/updRoleAuth")
	public JsonResponseMsg<String> updateRoleAuth(@RequestBody Role role) {
		roleService.updateRoleAuth(role);
		return JsonResponseMsg.createSuccessResponseMsg();
	}

	// ==============================================================\\
	@GetMapping("/get")
	public JsonResponseMsg<Role> getById(Role role) {
		Role rol = roleService.get(role);
		logger.debug(rol);
		return JsonResponseMsg.createResponseMsg(rol);
	}

	@PostMapping("/delete")
	public JsonResponseMsg<String> delete(@RequestBody Role role) {
		int row = roleService.delete(role);
		return JsonResponseMsg.createResponseMsg(row);
	}

	@PostMapping("/insert")
	public JsonResponseMsg<String> insert(@RequestBody Role role) {
		int row = roleService.insert(role);
		return JsonResponseMsg.createResponseMsg(row);
	}

	@PostMapping("/update")
	public JsonResponseMsg<String> update(@RequestBody Role role) {
		int row = roleService.update(role);
		return JsonResponseMsg.createResponseMsg(row);
	}

}
