package com.mcfly.crud_rest_demo.dao;

import com.mcfly.crud_rest_demo.entity.Role;

public interface RoleDAO {
    Role findRoleByName(String roleName);
}
