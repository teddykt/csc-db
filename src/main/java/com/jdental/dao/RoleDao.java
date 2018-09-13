package com.jdental.dao;

import org.springframework.data.repository.CrudRepository;

import com.jdental.domain.security.Role;

public interface RoleDao extends CrudRepository<Role, Integer>{
	Role findByName(String name);
}
