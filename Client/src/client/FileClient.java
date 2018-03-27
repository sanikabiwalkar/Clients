
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class FileClient {

    public static void main(String[] args) throws Exception {
        System.out.println("Client Signing ON");
        JFrame f1 = new JFrame("GUI Echo Client");
        JTextArea ta = new JTextArea();
        ta.setEditable(false);
        JTextField tf = new JTextField(15);
        JButton b1 = new JButton("Send");
        JPanel p = new JPanel();
        p.add(tf);
        p.add(b1);
        f1.add(ta);
        f1.add(BorderLayout.SOUTH, p);
        f1.setSize(400, 400);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Socket soc = new Socket("127.0.0.1", 9081);
        PrintWriter nos = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                soc.getOutputStream()
                        )
                ),
                 true);
        BufferedReader nis = new BufferedReader(
                new InputStreamReader(
                        soc.getInputStream()
                )
        );
    }
}
