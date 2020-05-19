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
        Operaciones ope = new Operaciones();
        System.out.println(ope.contador());
    }
    
    
}

 
