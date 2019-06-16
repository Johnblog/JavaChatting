package project;


import java.io.*;
import java.net.*;
import java.util.*;

public class Serverwait {

    final static int serverport = 9999;
    static List<Socket> client;  //注意此处必须为静态的变量（类变量）
    static HashMap<String, Integer> map = new HashMap<>();
    static int i = 0;

    public static void main(String[] args) {
        client = new ArrayList<Socket>();

        try {
            ServerSocket server = new ServerSocket(serverport);
            while (true) {
                Socket s = server.accept();//接收用户的套接字
                client.add(s);
                new Serverlistener(s, client, map, i);
                i++;

            }

        } catch (IOException e) {
            System.err.println("IOException");
        }

    }
}
