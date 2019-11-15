package com.windf.study.rpc;

import java.io.Serializable;

public class RpcRequest implements Serializable {
    private String className;
    private String method;
    private Object[] params;

    public RpcRequest() {
    }

    public RpcRequest(String className, String method, Object[] params) {
        this.className = className;
        this.method = method;
        this.params = params;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
