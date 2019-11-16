package com.windf.study.rpc.server;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory {
    private static Map<String, Object> objMap = new HashMap<String, Object>();

    public static void setBean(String name, Object obj) {
        objMap.put(name, obj);
    }

    public static Object getBean(String name) {
        return objMap.get(name);
    }
}
