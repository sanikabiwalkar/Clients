/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sws;

import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author sanikabiwalkar
 */
public class RClient {
 static private int e;
    void sendMessage() {

        String line = "";
        while (!line.equals("End")) {
            String s = "";
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                long f = (long) c;
                f = (long) (Math.pow(f, e));
                
                        }
        }
    }

    public static void main(String[] args) throws Exception {
        /*Socket soc = new Socket("127.0.0.1", 9081);
        PrintWriter nos = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                soc.getOutputStream()
                        )
                ), true
        );*/
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 2 prime numbers");
        int p = sc.nextInt();
        int q = sc.nextInt();
        int N = RSAlgo.generatePublicKey(p, q);
        System.out.println("N= " + N);
         e = RSAlgo.generateE();
         System.out.println("e= "+e);
        int d = RSAlgo.generateD();
        System.out.println("d= "+d);
        System.out.println(e + " " + N + "" + d);
    }
}
