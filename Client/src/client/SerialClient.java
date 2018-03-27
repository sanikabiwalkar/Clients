/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class SerialClient {
    
    public static void main(String[] args) throws Exception {
        System.out.println("Client Signing ON");
        JFrame f1 = new JFrame(" Serial Client");
        JTextArea ta = new JTextArea();
        ta.setEditable(false);
        JTextField tf = new JTextField(15);
        JButton b1 = new JButton("Send");
        JPanel p = new JPanel();
        p.add(tf);
        p.add(b1);
        f1.add(ta);
        f1.add(BorderLayout.SOUTH,p);
        f1.setSize(400,400);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Socket soc = new Socket("127.0.0.1",9081);
        PrintWriter nos = new PrintWriter(
                              new BufferedWriter(
                                  new OutputStreamWriter(
                                          soc.getOutputStream()
                                  )
                              )
        ,true);
        BufferedReader nis = new BufferedReader(
                                 new InputStreamReader(
                                     soc.getInputStream()
                                 )
        );
        L1 l1 = new L1(ta,tf,nos);
        b1.addActionListener(l1);
        tf.addActionListener(l1);
        String str = nis.readLine();
        while(!str.equals("End")){
            ta.append(str+"\n");
            str = nis.readLine();
        }
        System.out.println("bound status" + soc.isBound());
        nos.println("Signing Off");
        soc.close();
        
        Thread.sleep(3000);
        System.out.println("Client Signing Off");
        System.out.println("bound status" + soc.isBound());
         System.out.println("Closed status" + soc.isClosed());
         System.out.println("Connected status" + soc.isConnected());
        System.exit(0);
    }  
}

class L1 implements ActionListener{
    private JTextArea ta;
    private JTextField tf;
    private PrintWriter nos;

    public L1(JTextArea ta, JTextField tf, PrintWriter nos) {
        this.ta = ta;
        this.tf = tf;
        this.nos = nos;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        String str = tf.getText();
        nos.println(str);
        tf.setText("");
        /*if(str.equals("End")) {
            nos.close();
            
            System.exit(0);
        }*/
    }
}

