package com.miaotu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.StringUtil;
import com.miaotu.dao.RoleMapper;
import com.miaotu.model.Role;
import com.miaotu.model.RoleExample;
import com.miaotu.model.RoleExample.Criteria;

@Service
public class RoleServiceImpl implements RoleService{
@Resource RoleMapper mapper;
	@Override
	public List<Role> selectRoles(Role role) {
		RoleExample example = new RoleExample();
		Criteria criteria = example.createCriteria();
		if(role.getId()!=null) {
			criteria.andIdEqualTo(role.getId());
		}
		if(StringUtil.isNotEmpty(role.getUsername())) {
			criteria.andUsernameEqualTo(role.getUsername());
		}
		return mapper.selectByExample(example);
	}

}
