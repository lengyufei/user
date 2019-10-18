package com.miaotu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miaotu.model.Role;
import com.miaotu.service.RoleService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Resource RoleService roleService;
	@RequestMapping(value = "/getRoles")
	public List<Role> getRoles(@RequestBody Role role){
		Map a = new HashMap();
		return roleService.selectRoles(role);
		
	}
}
