/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sws;

/**
 *
 * @author sanikabiwalkar
 */
public class RSAlgo {
        public static int N;
    private static int phi;
    private static int e=0;

    static int generatePublicKey(int p, int q) {
        N = p * q;
        phi = (p - 1) * (q - 1);
        System.out.println("phi= "+phi);
        return N;
    }

    static int generateE() {
        System.out.println("Generate E , phi is = "+phi );
        for (int i = 2; i < phi; i++) {
            
            if (gcd(i, phi) == 1) {
               // System.out.println(i+"");
                e=i;
                break;
                //System.out.print(e+" ");
            }
        }
        return e;
    }

    static int gcd(int a, int b) {
     /*   int t;
        while (b != 0) {
            t = a;
            a = b;
            b = t % b;
        }
        System.out.println(a);
        return a;*/
        if (b==0) return a;
       return gcd(b,a%b);
    }

    static int generateD() {
        int i;
        for ( i = 1;; i++) {
                if ((i * e) % phi == 1&& i!=e) {
                    break;
                }
            }
       
        
    return i;
    }
}
