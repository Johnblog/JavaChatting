package project;


import project.Clientin;
import project.Clientout;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {

    final static int serverport = 9999;

    /* ui 页面*/
    public static void uimessage() {
        System.out.println("请选择您要进行的操作：");
        System.out.println("a.群聊");
        System.out.println("b.私聊");
    }

    public static void main(String[] args) {
        String clientid;
        String chatstyle;

        System.out.println("请输入你的id:");
        Scanner stdin = new Scanner(System.in);
        clientid = stdin.nextLine();
        uimessage();
        chatstyle = stdin.nextLine();

        try {
            Socket s = new Socket("localhost", serverport);
            Clientin in = new Clientin(s);
            Clientout out = new Clientout(s, clientid, chatstyle);
            out.start();
            in.start();

        } catch (IOException e) {
            System.out.println("IOException");
        }

    }
}
