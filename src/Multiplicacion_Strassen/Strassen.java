/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multiplicacion_Strassen;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Strassen {



    public static void main(String []args ){
        InterStrassen Stra = new InterStrassen();
        Stra.show();
        int n,m,i,j,tam;
        int [][] A;
        int [][]B;
        int [][]C;
        
        Operaciones ope = new Operaciones();
        Scanner sc = new Scanner(System.in);
        Random ra = new Random();
        System.out.println("dijite el numro de filas de la matriz");
        n=sc.nextInt();
        System.out.println("dijite el numero de columnas de la matriz");
        m=sc.nextInt();
        
        
        
        
        int t=(ope.tamano(n, m))/2;      
                  
        A=new int [t][t];
        B= new int [t][t];
        for(i=0;i<t;i++){
           for(j=0;j<t;j++){
              A[i][j]=0;
              B[i][j]=0;
           } 
        }
        for(i=0;i<n;i++){
           for(j=0;j<m;j++){
              A[i][j]=ra.nextInt(9)+1;
              B[i][j]=ra.nextInt(9)+1;
           } 
        }
        System.out.println("Matris A");
        for(i=0;i<t;i++){
           for(j=0;j<t;j++){
               System.out.print(A[i][j]);
           } 
           System.out.println();
        }
        System.out.println("Matris B");
         for(i=0;i<t;i++){
           for(j=0;j<t;j++){
               System.out.print(B[i][j]);
           } 
           System.out.println();
        }
        C=ope.multiply(A, B);
        for(i=0;i<t;i++){
           for(j=0;j<t;j++){
               System.out.print(C[i][j]+"       ");
           } 
           System.out.println();
        }
        
        
    }
    
    
}

 
