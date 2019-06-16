/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 团队合作;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextArea;
import javax.xml.crypto.Data;
import org.omg.CORBA.Any;
import org.omg.CORBA.DataInputStream;
//将消息报文的发送、接受封装在Utils工具类中

public class Utils {
//通过套接字S发送字符串

    public static void sendMsg(Socket s, String msg) {
        try {
//字符流
            PrintWriter dos = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8")), true);
            dos.println(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//在套接字S上读取字符串，如果TCP连接关闭，返回null
    public static String recvMsg(Socket s) throws IOException {
        String msg = null;
        BufferedReader dis = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
        msg = dis.readLine();
        return msg;

    }
//获取格式化的当前时间字符串形式

    public static String getTimeStr() {
        SimpleDateFormat fm = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");

        return fm.format(new Date());

    }
//添加消息到文本记录框JTextArea ，并且滚动显示到最后一行

    public static void addMsgRec(JTextArea textArea, String msg) {
        textArea.append(msg + "\n");
        textArea.setCaretPosition(textArea.getText().length());
    }
}
