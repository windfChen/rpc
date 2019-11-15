package com.windf.study.rpc;

import java.lang.reflect.Proxy;

public class RemoteBeanFactory {
    public static  <T> T getBean(Class<T> interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class[]{interfaceClass}, new RemoteInvocationHandler());
    }
}
