package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.domain.Role;

public interface RoleService extends DaoSupport<Role>{

	List<Role> findAll();

	void delete(Long id);

	void add(Role role);

	Role getById(Long id);

	void update(Role role);

}
