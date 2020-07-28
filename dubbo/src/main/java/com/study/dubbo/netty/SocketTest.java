package com.study.dubbo.netty;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hangwu
 * @date 2020/7/14 19:25
 */
public class SocketTest {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println("received: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
