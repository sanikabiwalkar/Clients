/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.net.*;

/**
 *
 * @author sanikabiwalkar
 */
public class ConcurrentClient {

    public static void main(String[] args) throws Exception {
        Socket soc = new Socket("127.0.0.1", 9081);
        PrintWriter nos = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                soc.getOutputStream()
                        )
                ), true
        );
        BufferedReader nis = new BufferedReader(
                new InputStreamReader(
                        soc.getInputStream()
                )
        );
        String usr = JOptionPane.showInputDialog("Enter your username");
        nos.println(usr);
        String r = "-1";
        while (r.equals("-1")) {

            String rev = JOptionPane.showInputDialog("Enter username of reciever");
            nos.println(rev);
            r = nis.readLine();
            if (rev == null) {
                System.exit(1);
            }
        }
        JFrame f1 = new JFrame(usr);
        JButton b1 = new JButton("Ok");
        JTextArea ta = new JTextArea(10, 10);
        ta.setEditable(false);
        JTextField tf = new JTextField(20);
        JPanel p1 = new JPanel();
        p1.add(tf);
        p1.add(b1);
        f1.add(p1, BorderLayout.SOUTH);
        f1.add(ta);
        f1.setSize(400, 400);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        L2 l2 = new L2(tf, ta, nos, nis);
        b1.addActionListener(l2);
        tf.addActionListener(l2);
        l2.read();
        
    }
}

class L2 implements ActionListener {

    JTextField tf;
    JTextArea ta;
    PrintWriter nos;
    BufferedReader nis;

    L2(JTextField tf, JTextArea ta, PrintWriter nos, BufferedReader nis) {
        this.tf = tf;
        this.ta = ta;
        this.nos = nos;
        this.nis = nis;
    }

    void read() throws IOException {
        String str = "";
        while (!str.equals("End")) {
            str = nis.readLine();
            ta.append(str + "\n");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String str = tf.getText();
        tf.setText("");
        nos.println(str);
        if (str.equals("End")) {
            System.exit(1);
        }

    }

}
