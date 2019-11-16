package com.windf.study.rpc.server;

import com.windf.study.rpc.demo.UserService;
import com.windf.study.rpc.demo.service.impl.UserServiceImpl;

public class Server {
    public static void main(String[] args) {
        BeanFactory.setBean(UserService.class.getName(), new UserServiceImpl());

        NetworkListener networkListener = new NetworkListener();
        networkListener.listener(6543);
    }
}
