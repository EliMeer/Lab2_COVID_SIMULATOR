/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_henrycaicedo_breynner.hurtado_elianavelasquez;

import java.util.concurrent.ThreadLocalRandom;
import javax.swing.UIManager;

/**
 *
 * @author Eliana Velasquez
 */
public class Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez {
    
    public Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez() {
        
        
    }
    
    public static void main(String[] args) {
        
        Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez sim = new Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez();
        
        
        try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
        
       GUI gui = new GUI();
       gui.showGUI(sim);
        
        System.out.println("PULL");
        System.out.println("PUSH 2");
        System.out.println("PRUEBA SOLICITADA POR HENRRRRY ");
    }
    
    static int numNodosEntero = 7;
    static int[] listaX = new int[numNodosEntero];
    int[] listaY = new int[numNodosEntero];
    
    public void UbicarNodoEnX(int numNodosEntero){
        
    double numNodos = (double)numNodosEntero;
    double anchoD = numNodos*1.5; 
    int ancho = (int)anchoD;
    int alto = numNodosEntero;
    
    
    }
    
    public void UbicarNodoEnY(int numNodosEntero){      
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


