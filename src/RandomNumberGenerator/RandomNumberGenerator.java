/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RandomNumberGenerator;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author SMJPX
 */


class MidSquare{
    int z0, zi, i, n;
    double rnd, temp;
    
    DecimalFormat df=new DecimalFormat("0.####");
    
    void insert(int seed, int number){
        z0=seed;
        n=number;
    }
    
    void generate(){
        for(i=1; i<=n; i++){
            zi=(int) Math.pow(z0,2);
            zi=zi/100;
            zi=zi%10000;
            temp=(double) zi;
            rnd=temp/10000;
            
            
            System.out.println("Random Number "+i+": "+df.format(rnd));
            z0=zi;
        }
    }
}

class LCG{
        int z0, a, c, m, n, i;
        double zi; 
        
        DecimalFormat df=new DecimalFormat("0.####");
        
         void insert(int seed, int multiplier, int increment, int modulus, int number){
             z0=seed;
             a=multiplier;
             c=increment;
             m=modulus;
             n=number;
        }
         void generate(){
            for(i=1; i<=n; i++){
            
            zi=(a*z0+c)%m;
            
            System.out.println("Random number "+i+": "+df.format(zi/m));
            
            z0=(int) zi;
        }
       }      
}

public class RandomNumberGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int f;
        int z0, a, c, m, n;
        
        Scanner sc=new Scanner(System.in);
        
        System.out.print("Choose option (1 for Mid Square 2 for LCG method):");
        f=sc.nextInt();
        
        System.out.println("");
        
        MidSquare midsquare=new MidSquare();
        LCG lcg=new LCG();
        
        switch (f) {
            case 1:
                System.out.println("***Mid Square Method***");
                System.out.println("");
                System.out.print("4 digit Seed (z0)=");
                z0=sc.nextInt();
                if(z0>=1000 && z0<=9999){
                System.out.print("Random Numbers to be generated (n)=");
                n=sc.nextInt();
                System.out.println("");
                midsquare.insert(z0, n);
                midsquare.generate();
                }
                else{
                    System.out.println("Seed must be 4 digit");
                }
                break;
            
            case 2:
                System.out.println("***LCG Method***");
                System.out.println("");
                System.out.print("Seed (z0)=");
                z0=sc.nextInt();
                System.out.print("Multiplier (a)=");
                a=sc.nextInt();
                System.out.print("Increment (c)=");
                c=sc.nextInt();
                System.out.print("Modulus (m)=");
                m=sc.nextInt();
                System.out.print("Random Numbers to be generated (n)=");
                n=sc.nextInt();
                System.out.println("");
                lcg.insert(z0, a, c, m, n);
                lcg.generate();
                break;
            default:
                System.out.println("Invalid choice! Please enter either 1 or 2!");
                break;
        }
        
        
    }
    
}