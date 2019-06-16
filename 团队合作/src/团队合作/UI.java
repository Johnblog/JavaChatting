package 团队合作;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UI {

    private JFrame frmtcp;
    private JTextArea SL;//私聊框体
    private JTextField NAME;//用户名
    private JTextField PASSWORD;//密码
    private JTextField person;//私聊用户
    private JTextArea textAreaRecord;//消息文本记录框
    private JButton btnSend;//发送按钮
    private JButton btnConnect;//登录按钮
    private JButton btnclear;//清屏按钮
    private JButton siliao;//私聊按钮
    private JTextField way;//登录后的聊天方式（这个以后可以去掉）
    private JTextArea textAreaMsg;//消息框
//主函数

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UI window = new UI();
                    window.frmtcp.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UI() {
        kehuduan();

    }
    

//客户端界面
    private void kehuduan() {
        frmtcp = new JFrame();
        frmtcp.setResizable(false);
        frmtcp.setTitle("聊天客户端1.0");
        frmtcp.setBounds(100, 100, 715, 476);
        frmtcp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmtcp.getContentPane().setLayout(null);
//切换用户文本框
        JLabel pe = new JLabel("私聊 :");
        pe.setBounds(590, 230, 121, 18);
        frmtcp.getContentPane().add(pe);
        person = new JTextField();
        person.setText("");
        person.setBounds(590, 255, 100, 24);
        frmtcp.getContentPane().add(person);
        person.setColumns(10);
//用户名文本框
        NAME = new JTextField();
        NAME.setText("");
        NAME.setBounds(121, 21, 121, 24);
        frmtcp.getContentPane().add(NAME);
        NAME.setColumns(10);

        JLabel lblNewLabel = new JLabel("用户名");
        lblNewLabel.setBounds(14, 24, 121, 18);
        frmtcp.getContentPane().add(lblNewLabel);
//用户名文本框
        NAME = new JTextField();
        NAME.setText("");
        NAME.setBounds(121, 21, 121, 24);
        frmtcp.getContentPane().add(NAME);
        NAME.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("密码");
        lblNewLabel_1.setBounds(256, 24, 58, 18);
        frmtcp.getContentPane().add(lblNewLabel_1);
//密码文本框
        PASSWORD = new JTextField();
        PASSWORD.setText("");
        PASSWORD.setBounds(313, 21, 48, 24);
        frmtcp.getContentPane().add(PASSWORD);
        PASSWORD.setColumns(10);

//登录按钮
        btnConnect = new JButton("登录");
        btnConnect.setBounds(596, 20, 95, 27);
        frmtcp.getContentPane().add(btnConnect);
// 连接按钮事件处理程序
        btnConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (btnConnect.getText().equals("登录")) {
//这个地方写和服务器建立连接方法或者线程   后期加入检测审核用户名和密码
                } else {
//退出操作
                }

            }
        });
//私聊按钮
        siliao = new JButton("切换");
        siliao.setBounds(596, 300, 95, 27);
        frmtcp.getContentPane().add(siliao);
// 连接按钮事件处理程序
        siliao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (siliao.getText().equals("切换")) {
//转到某人的私聊
                }
            }
        });
//清屏按钮
        btnclear = new JButton("清屏");
        btnclear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                textAreaRecord.setText("");
            }
        });
        btnclear.setBounds(474, 306, 58, 23);
        frmtcp.getContentPane().add(btnclear);
        JLabel lblNewLabel_2 = new JLabel("消息");
        lblNewLabel_2.setBounds(14, 313, 72, 18);
        frmtcp.getContentPane().add(lblNewLabel_2);

//发送按钮
        btnSend = new JButton("发送");
        btnSend.setEnabled(true);
        btnSend.setBounds(444, 409, 88, 27);
        frmtcp.getContentPane().add(btnSend);
// 连接按钮事件处理程序
        btnSend.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                //发送消息方法
            }

        });

        JLabel label = new JLabel("消息记录");
        label.setBounds(14, 55, 72, 18);
        frmtcp.getContentPane().add(label);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(14, 72, 518, 228);
        frmtcp.getContentPane().add(scrollPane);

//聊天记录框
        textAreaRecord = new JTextArea();
        textAreaRecord.setEditable(false);
        scrollPane.setViewportView(textAreaRecord);

        JLabel label_1 = new JLabel("聊天方式");
        label_1.setBounds(375, 24, 58, 18);
        frmtcp.getContentPane().add(label_1);
//私聊用户表
        JLabel labe1 = new JLabel("私聊用户表");
        labe1.setBounds(600, 100, 110, 18);
        frmtcp.getContentPane().add(labe1);
        JScrollPane sl = new JScrollPane();
        sl.setBounds(590, 120, 100, 100);
        frmtcp.getContentPane().add(sl);
        SL = new JTextArea();
        SL.setEditable(false);
        sl.setViewportView(SL);
//用户名框
        way = new JTextField();
        way.setBounds(433, 21, 95, 24);
        frmtcp.getContentPane().add(way);
        way.setColumns(10);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(14, 332, 518, 73);
        frmtcp.getContentPane().add(scrollPane_1);

//消息输入框
        textAreaMsg = new JTextArea();
        scrollPane_1.setViewportView(textAreaMsg);
    }
}
