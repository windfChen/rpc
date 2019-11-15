package com.windf.study.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RpcNetTransport {

    private static RpcNetTransport rpcNetTransport = null;

    public static void initInstance(String host, int ip) {
        if (rpcNetTransport == null) {
            synchronized(RpcNetTransport.class) {
                if (rpcNetTransport == null) {
                    rpcNetTransport = new RpcNetTransport(host, ip);
                }
            }
        }
    }

    public static RpcNetTransport getInstance() {
        return rpcNetTransport;
    }

    private String host;
    private int port;

    private RpcNetTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Object executeRemote(RpcRequest rpcRequest) {
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            Socket socket = new Socket(host, port);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(rpcRequest);
            objectOutputStream.flush();

            objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object obj = objectInputStream.readObject();

            return obj;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;

    }
}
