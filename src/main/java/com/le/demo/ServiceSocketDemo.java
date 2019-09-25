package com.le.demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServiceSocketDemo {
    private static  int PORT=8080;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=null;
        try {
            serverSocket=new ServerSocket(PORT);
            System.out.println("the tine server is start in port :"+PORT);
            Socket socket=null;
            while (true){
                socket=serverSocket.accept();
                new Thread(new TimeServerHandle(socket)).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if (serverSocket!=null){
                System.out.println("the time server close");
                serverSocket.close();
            }
        }

    }
}
