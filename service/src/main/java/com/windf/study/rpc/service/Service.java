package com.windf.study.rpc.service;

import com.windf.study.rpc.demo.UserService;
import com.windf.stydy.rpc.demo.service.impl.UserServiceImpl;

public class Service {
    public static void main(String[] args) {
        BeanFactory.setBean(UserService.class.getName(), new UserServiceImpl());

        NetworkListener networkListener = new NetworkListener();
        networkListener.listener(6543);
    }
}
