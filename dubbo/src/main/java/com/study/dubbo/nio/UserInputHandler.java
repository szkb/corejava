package com.study.dubbo.nio;

import java.io.*;

public class UserInputHandler implements Runnable {
    ChatClient client;
    public UserInputHandler(ChatClient chatClient) {
        this.client=chatClient;
    }
    @Override
    public void run() {
        BufferedReader read=new BufferedReader(
                new InputStreamReader(System.in)
        );
        while (true){
            try {
                String input=read.readLine();
                client.send(input);
                if (input.equals("quit")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}