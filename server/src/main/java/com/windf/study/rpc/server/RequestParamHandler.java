package com.windf.study.rpc.server;

import com.windf.study.rpc.RpcRequest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RequestParamHandler {

    public Object invoke(RpcRequest requestParam) {
        Object result = null;
        try {
            Object object = BeanFactory.getBean(requestParam.getClassName());

            Class clazz = object.getClass();

            Class[] clazzes = this.getParamTypes(requestParam.getParams());

            Method method = clazz.getMethod(requestParam.getMethod(), clazzes);

            result = method.invoke(object, requestParam.getParams());

            System.out.println("【服务端】调用了" + clazz.getSimpleName() + "，的" + method.getName() + "方法，返回值是" + result);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return result;

    }

    private Class[] getParamTypes(Object[] params) {
        Class[] clazzes = new Class[0];

        if (params != null) {
            clazzes = new Class[params.length];

            for (int i = 0; i < params.length; i++) {
                clazzes[i] = params[i].getClass();
            }
        }

        return clazzes;
    }
}
