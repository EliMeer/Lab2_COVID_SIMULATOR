/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_henrycaicedo_breynner.hurtado_elianavelasquez;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.UIManager;


/**
 *
 * @author Eliana Velasquez
 */
public class Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez {
    
    Iteracion firstIteracion;

    public Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez() {
        firstIteracion = null;
    }
    
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez sim = new Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez();
        
        
        try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
        
       GUI gui = new GUI();
       gui.showGUI(sim);
        
        System.out.println("Digite el número de nodos:");
        numNodosEntero = sc.nextInt();
        System.out.println(numNodosEntero);
        
        //Lee info (num nodos, mascarilla, etc)
        
        //Simulación
        
    }
    
    
    static int numNodosEntero;
    static int[] listaX = new int[numNodosEntero];
    int[] listaY = new int[numNodosEntero];
    
    public void crearSimulacion(Iteracion firstIteracion){
        
        
    }
    
    public void ubicarNodoEnX(int numNodosEntero){
        
    double numNodos = (double)numNodosEntero;
    double anchoD = numNodos*1.5; 
    int ancho = (int)anchoD;
    int alto = numNodosEntero;
    
    
    }
    
    public void ubicarNodoEnY(int numNodosEntero){      
    int alto = numNodosEntero;
    int randomNum;
    do{
        randomNum = ThreadLocalRandom.current().nextInt(0, numNodosEntero + 1);
    }while(!DisponibleX(randomNum));
    
    }
    
    public boolean DisponibleX(int num){
        boolean disponible=false;
        
        
        
        return disponible;
    }
    
}


