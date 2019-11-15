package com.windf.study.rpc;

import com.windf.study.rpc.demo.User;
import com.windf.study.rpc.demo.UserService;

public class Client {
    public static void main(String[] args) {
        RpcNetTransport.initInstance("localhost", 6543);
        UserService userService = RemoteBeanFactory.getBean(UserService.class);
        User user = userService.getUser();
        System.out.println(user);
    }
}
