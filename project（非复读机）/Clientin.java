package project;


import java.net.*;
import java.io.*;

public class Clientin extends Thread {

    Socket s;

    public Clientin(Socket s) {
        this.s = s;
    }

    public void run() {
        String line = "1";
        try {
            BufferedReader in;
            in = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));

            while (!line.equalsIgnoreCase("bye")) {
                line = in.readLine();
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.println("IOException");
        }

    }

}
