/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_henrycaicedo_breynner.hurtado_elianavelasquez;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.UIManager;


/**
 *
 * @author Eliana Velasquez
 */
public class Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez {
    
    static Iteracion firstIteracion;
    static int numNodos, anchoCuadricula, altoCuadricula;
    static int[][] matriz;

    

    public Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez() {
        firstIteracion = null;     
    }
      
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez sim = new Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez();
        
        //GUI
        try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
       GUI gui = new GUI();
       gui.showGUI(sim);
        
        sim.numNodos =9;
        calcProporcion(numNodos);
        System.out.println("Ancho: "+anchoCuadricula);
        System.out.println("Alto: "+altoCuadricula);
        System.out.println(anchoCuadricula);
        sim.matriz = new int[altoCuadricula+1][anchoCuadricula+1];

        crearPrimeraIteracion();
        System.out.println(firstIteracion.num);
        
        
        addIteracion();
        addIteracion();
        addIteracion();
        addIteracion();

        System.out.println(firstIteracion.firstNodo.nextNodo.nextNodo.nextNodo.id);
        System.out.println(firstIteracion.firstNodo.nextNodo.nextNodo.nextNodo.x);
        System.out.println(firstIteracion.firstNodo.nextNodo.nextNodo.nextNodo.y);
        
        
      
        escribirMatriz();


        
    }
    
  
    
    
    public static void calcProporcion(int numNodos){
        if(numNodos%5 != 0){
            anchoCuadricula = (numNodos/5+1)*4;
            altoCuadricula = (numNodos/5+1)*3;
        }else{
            anchoCuadricula = (numNodos/5)*4;
            altoCuadricula = (numNodos/5)*3;
        }   
    }
    
    
  
    
    public static int[] ubicarNodo (int id){ 
        int coordenadas [] = new int[2];
        Random x = new Random();
        Random y = new Random();
        int posX, posY;
        
        do{
        posY = x.nextInt(anchoCuadricula-1) + 1;
        posX = y.nextInt(altoCuadricula-1) + 1;
        
        System.out.println("Calculando coordenadas");
        }while(espacioDisponible(posX, posY)==false);
        
        System.out.println("("+posX+","+posY+")");
        matriz[posX][posY] = id;
        coordenadas[0]=posX;
        coordenadas[1]=posY;
        
        return coordenadas;
    }

    public static boolean espacioDisponible(int posX, int posY) {
        System.out.println("Verificando disponibilidad de ("+posX+","+posY+")");
        boolean disponible = true;      
        if(matriz[posX][posY]!=0){
            System.out.println("No disponible");
            disponible = false;
        }else{
            System.out.println("Disponible");
        }
        
        return disponible;
    }
    
    
    public static void escribirMatriz(){
                 
            for(int i=1; i<=altoCuadricula; i++){
                for(int j=1; j<=anchoCuadricula; j++){
                    if(matriz[i][j]!=0){
                    System.out.print("["+matriz[i][j]+"]");
                    }else{
                        System.out.print("[ ]");
                    }
                    if(j==anchoCuadricula){
                        System.out.println("");
                    }
                }
            }
            
       
        
    }
    
    public static void crearPrimeraIteracion() {
        firstIteracion = new Iteracion();
        int radio = anchoCuadricula/680/4*3;
        for(int i = 1; i<=numNodos; i++){
            int[] coordenadas = ubicarNodo(i);      
            
              int x = coordenadas[0];
              int y = coordenadas[1];
       
              firstIteracion.addNodo(new Nodo(null, true, true, x, y, radio));
            
        }
        
        
    }
    
    public static void addIteracion(){
       
            Iteracion p;
            p=firstIteracion;
            while(p.nextIteracion!=null){
                p=p.nextIteracion;
            }
            p.nextIteracion = new Iteracion();
            System.out.println(p.nextIteracion.num);          
        
        
        
    }
    
    public static Nodo addNodo(Nodo nextNodo, boolean tapabocas, boolean infectado){
        Nodo nodo=null;
        
        
        
        return nodo;
    }
      
}


