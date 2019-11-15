package com.windf.study.rpc;

import com.windf.study.rpc.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RemoteInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethod(method.getName());
        rpcRequest.setParams(args);

        RpcNetTransport rpcNetTransport = RpcNetTransport.getInstance();
        Object obj = rpcNetTransport.executeRemote(rpcRequest);

        return obj;
    }
}
