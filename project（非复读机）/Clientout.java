package project;


import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Clientout extends Thread {

    Socket s;//传递socket方法
    String clientid;
    String chatstyle;
    String user;

    public Clientout(Socket s, String clientid, String chatstyle) {
        this.s = s;
        this.clientid = clientid;
        this.chatstyle = chatstyle;
    }
    String line = "";

    public void run() {

        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8")), true);
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

            out.println(clientid);
           out.println(chatstyle);
           

            System.out.println("请选择您要私聊的对象：");
            line = stdin.readLine();
            out.println(line);
            while (!line.equalsIgnoreCase("bye")) {

                line = stdin.readLine();
                out.println(line);
            }

        } catch (IOException e) {

            System.err.println("IOException");

        } 

    }
}
