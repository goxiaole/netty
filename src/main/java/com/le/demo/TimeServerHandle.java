package com.le.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class TimeServerHandle implements Runnable {

    public Socket socket;

    public TimeServerHandle(Socket socket) {
        this.socket = socket;
    }

    public void run() {
            BufferedReader in=null;
            PrintWriter out=null;
        try {
            in=new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out =new PrintWriter(this.socket.getOutputStream(),true);

            String body=null;
            while ((body=in.readLine())!=null&&body.length()!=0){
                System.out.println("this time server msg :"+body);
                out.println(new Date().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (out!=null){
                    out.close();
                }
                if (in!=null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
