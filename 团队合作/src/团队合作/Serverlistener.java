package project;


import project.Serverwait;
import java.io.*;
import java.net.*;
import java.util.*;

public class Serverlistener extends Thread {

    static HashMap<String, Integer> map = new HashMap<>();
     String clientid;
    String user;
    Socket s;
    String line = "";
    Serverwait serverwait;
    List<Socket> client;
    String chatstyle;
    int user_thread;
    static int j;

    public Serverlistener(Socket s, List<Socket> client, HashMap<String, Integer> map, int j) {
        this.s = s;
        this.client = client;
        this.map = map;
        this.start();
        this.j = j;
    }

    /*广播给所有用户*/
    public void broadcast(String line) {
        try {

            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8")), true);
            for (int i = 0; i < client.size(); i++) {
                Socket s = client.get(i);
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8")), true);
                out.println("用户：" + clientid + ":" + line);

            }
        } catch (IOException x) {
            System.err.print("IOException");
        }
    }

    /*将当前在线用户广播给当前用户 */
    public void broad_to_user() {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8")), true);
            out.println(map.entrySet());
        } catch (IOException x) {
            System.out.println("IOException");
        }
    }

    /*私聊给用户*/
    public void privatemessage(int user_thread,String line) {
        try {

            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8")), true);
            Socket s = client.get(user_thread);
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8")), true);
            out.println("[私聊消息]用户：" + clientid + ":" + line);

        } catch (IOException x) {
            System.err.print("IOException");
        }
    }

    /* 接收消息同时进行功能选择*/
    public void run() {
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8")), true);
            clientid = in.readLine();
            map.put(clientid, j);
            chatstyle = in.readLine();
            switch (chatstyle) {
                case "a":
                    while (!line.equalsIgnoreCase("bye")) {
                        line = in.readLine();
                        broadcast(line);
                    }
                    break;
                case "b":
//                    if(map.isEmpty()){ 
//                        out.println("当前没有在线用户 请耐心等待");
//                                        while(true){if(!map.isEmpty()) break;}
//                    }
//                   
                    broad_to_user();

                    while (true) {
                        if ((user = in.readLine()) != null) {
                            break;
                        }
                    }
                    //输错怎么办？
                    user_thread = map.get(user);
                    while (!line.equalsIgnoreCase("bye")) {
                        line = in.readLine();
                        privatemessage(user_thread,line);
                   
                    }
            }
        } catch (IOException x) {
            System.out.println("IOException");
        }

    }

}
