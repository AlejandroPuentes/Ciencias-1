/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multiplicacion_Strassen;

/**
 *
 * @author User
 */
public class Operaciones {
    
    public int[][] multiply(int[][] A, int[][] B)
    {        
        int n = A.length;
        int[][] R = new int[n][n];
        /* caso base*/
        if (n == 1)
            R[0][0] = A[0][0] * B[0][0];
        else
        {
            int[][] A11 = new int[n/2][n/2];
            int[][] A12 = new int[n/2][n/2];
            int[][] A21 = new int[n/2][n/2];
            int[][] A22 = new int[n/2][n/2];
            int[][] B11 = new int[n/2][n/2];
            int[][] B12 = new int[n/2][n/2];
            int[][] B21 = new int[n/2][n/2];
            int[][] B22 = new int[n/2][n/2];
 
            /*Dividiendo la matriz A en 4 mitades */
            divide(A, A11, 0 , 0);
            divide(A, A12, 0 , n/2);
            divide(A, A21, n/2, 0);
            divide(A, A22, n/2, n/2);
            /*Dividiendo la matriz A en 4 mitades*/
            divide(B, B11, 0 , 0);
            divide(B, B12, 0 , n/2);
            divide(B, B21, n/2, 0);
            divide(B, B22, n/2, n/2);
 
            /** 
              M1 = (A11 + A22)(B11 + B22)
              M2 = (A21 + A22) B11
              M3 = A11 (B12 - B22)
              M4 = A22 (B21 - B11)
              M5 = (A11 + A12) B22
              M6 = (A21 - A11) (B11 + B12)
              M7 = (A12 - A22) (B21 + B22)
            **/
 
            int [][] M1 = multiply(suma(A11, A22), suma(B11, B22));
            int [][] M2 = multiply(suma(A21, A22), B11);
            int [][] M3 = multiply(A11, resta(B12, B22));
            int [][] M4 = multiply(A22, resta(B21, B11));
            int [][] M5 = multiply(suma(A11, A12), B22);
            int [][] M6 = multiply(resta(A21, A11), suma(B11, B12));
            int [][] M7 = multiply(resta(A12, A22), suma(B21, B22));
 
            /**
              C11 = M1 + M4 - M5 + M7
              C12 = M3 + M5
              C21 = M2 + M4
              C22 = M1 - M2 + M3 + M6
            **/
            int [][] C11 = suma(resta(suma(M1, M4), M5), M7);
            int [][] C12 = suma(M3, M5);
            int [][] C21 = suma(M2, M4);
            int [][] C22 = suma(resta(suma(M1, M3), M2), M6);
 
            /* Une las 4 mitades en una matriz resultante */
            reune(C11, R, 0 , 0);
            reune(C12, R, 0 , n/2);
            reune(C21, R, n/2, 0);
            reune(C22, R, n/2, n/2);
        }
            
        return R;
    }
    /* Funcion para llenar matrices */
    public int[][] resta(int[][] A, int[][] B)
    {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }
    
    public int[][] suma(int[][] A, int[][] B)
    {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }
    /* Función para dividir la matriz principal en matrices secundarias */
    public void divide(int[][] P, int[][] C, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                C[i1][j1] = P[i2][j2];
    }
    /* Función para unir matrices secundarias a matriz primaria */
    public void reune(int[][] C, int[][] P, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                P[i2][j2] = C[i1][j1];
    }  
    public int tamano(int n, int m){
        int B []={2,4,8,16,32,64};
        int result;
        for (int i=0;i<B.length;i++){
            if (n<B[i] && m<B[i]){
                n=B[i];
                m=B[i];
            }
            if (m==n && n==B[i]){
                break;
            }
        }
        
        result=m+n;       
        return result;
    }
    
    
      
    
}
