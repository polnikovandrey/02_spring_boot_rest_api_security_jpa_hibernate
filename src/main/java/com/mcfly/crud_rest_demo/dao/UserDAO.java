package com.mcfly.crud_rest_demo.dao;

import com.mcfly.crud_rest_demo.entity.User;

public interface UserDAO {

    User findByUserName(String userName);
}
