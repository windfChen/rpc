package com.windf.study.rpc.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkListener {

    private ExecutorService executorService = Executors.newCachedThreadPool();

    public void listener(int port){
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            System.out.println("【服务端】(" + socket.getInetAddress() + ")过来了");
            executorService.execute(new NetworkHandler(socket));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
