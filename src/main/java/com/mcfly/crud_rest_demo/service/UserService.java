package com.mcfly.crud_rest_demo.service;

import com.mcfly.crud_rest_demo.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUserName(String userName);
}
