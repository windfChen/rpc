package com.windf.stydy.rpc.demo.service.impl;

import com.windf.study.rpc.demo.User;
import com.windf.study.rpc.demo.UserService;

public class UserServiceImpl implements UserService {
    public User getUser() {
        return new User("cyf", 300);
    }
}
