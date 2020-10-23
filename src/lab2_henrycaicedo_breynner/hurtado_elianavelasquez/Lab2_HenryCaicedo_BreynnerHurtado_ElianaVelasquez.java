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
    
    final static int anchoSim=680;
    final static int altoSim=510;
    static Iteracion firstIteracion;
    static int numNodos = 15, anchoCuadricula, altoCuadricula, opcionMascarilla=1;
    static int[][] matriz;

    
    

   
    

    public Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez() {
        firstIteracion = null;     
    }
      
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez sim = new Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez();
               
        
        
   //     System.out.println("Ancho: "+anchoCuadricula);
   //     System.out.println("Alto: "+altoCuadricula);
   //     System.out.println(anchoCuadricula);
        
        
        calcProporcion(numNodos);
        sim.matriz = new int[altoCuadricula+1][anchoCuadricula+1];
        crearPrimeraIteracion();    
        crearEnlacesPrimarios();
        crearEnlacesSecundarios();      
        
        
        dibujarMatriz();
        

        //GUI
        try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
        
        
       GUI gui = new GUI();
       gui.showGUI(sim);

        
    }
    
  
    public void iniciar(){
                                    Nodo.contId=1;
                                    calcProporcion(numNodos);
                                    matriz = new int[altoCuadricula+1][anchoCuadricula+1];
                                    crearPrimeraIteracion();    
                                    crearEnlacesPrimarios();
                                    crearEnlacesSecundarios();
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
        posY = x.nextInt(anchoCuadricula) + 1;
        posX = y.nextInt(altoCuadricula) + 1;
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
    
    
    public static void dibujarMatriz(){
                 
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
        int diametro = anchoSim/anchoCuadricula/4*3;
        
      //  if(numNodos<11){
      //      diametro = anchoSim/anchoCuadricula/4*2;
      //  }
        
        for(int i=1; i<=numNodos; i++){
            int[] coordenadas = ubicarNodo(i);      
            
              double x = (coordenadas[0]-1)*((double)anchoSim/(double)anchoCuadricula) + ((anchoSim/anchoCuadricula)-diametro)/2;
              double y = (coordenadas[1]-1)*((double)anchoSim/(double)anchoCuadricula) + ((anchoSim/anchoCuadricula)-diametro)/2;
              
              Random r = new Random();
              int resultado = r.nextInt(10) + 1;
              System.out.println("Resultado: "+resultado);
              
              
              
              switch(resultado){
                  case 1: x=x-diametro/10;
                  break;
                  case 2: x=x+diametro/10;
                  break;
                  case 3: y=y-diametro/10;
                  break;
                  case 4: x=x-diametro/8;
                  break;
                  case 5: x=x+diametro/8;
                  break;
                  case 6: y=y-diametro/8;
                  break;
                  case 7: x=x-diametro/8;
                  break;
                  case 8: x=x+diametro/8;
                  break;
                  case 9: y=y-diametro/8;
                  break;
                  default: 
                  break;
              }
              
              switch(opcionMascarilla){
                  //Todos usan tapabocas
                  case 0: firstIteracion.addNodo(new Nodo(null, true, false, y, x, diametro));
                  break;
                  //Nadie usa tapabocas
                  case 1: firstIteracion.addNodo(new Nodo(null, false, false, y, x, diametro));
                      System.out.println("SIN MASCARILLAAAAAAAAAAAAA");
                  break;
                  //Uso aleatorio de tapabocas
                  default: Random a = new Random();
                           int num = a.nextInt(2) + 0;
                           if(num==1){
                               firstIteracion.addNodo(new Nodo(null, true, false, y, x, diametro));
                           }else{
                               firstIteracion.addNodo(new Nodo(null, false, false, y, x, diametro));
                           }
                  break;
              }
            
             
              
              
        }
        
         //Escoger el primer infectado aleatoriamente
              Random covid = new Random();
              int primerInfectado = covid.nextInt(numNodos+1) + 1;
              firstIteracion.getNodo(primerInfectado).infectado=true;
              
        
        
    }
    
    public static void addIteracion(){
            
            Iteracion p;
            p=firstIteracion;
            while(p.nextIteracion!=null){
                p=p.nextIteracion;
            }
            p.nextIteracion = new Iteracion();
            
            Iteracion nuevaIteracion = p.nextIteracion;
            
            duplicarNodos(nuevaIteracion);
            
        
        
        
    }
    
    private static void duplicarNodos(Iteracion nuevaIteracion) {
        Iteracion anteriorIteracion = firstIteracion.getIteracion(nuevaIteracion.num-1);
        Iteracion prueba = new Iteracion();
        
        
    }
    
    public static void crearEnlacesPrimarios(){
        System.out.println("Creando enlaces primarios");
        int numColumnas=anchoCuadricula/4;
        System.out.println("numColumnas: "+numColumnas);
        
        for(int i=1; i<=numColumnas; i++){
                    enlazarColumna(i);
        }
    }
    
    public static void crearEnlacesSecundarios(){
        int numColumnas=anchoCuadricula/4;
        
        for(int i=1; i<numColumnas; i++){
            if(!columnaVacia(i)){
            int j=i+1;
            while(columnaVacia(j)==true && j<=numColumnas){
                j++;
            }
            
            if(!columnaVacia(j) && !columnaVacia(i)){
            unirDosColumnasEnlazadas(i,j);
            }
            }   
        }      
    }
    

    
    //DEBO REVISAR ESTO
     private static boolean columnaVacia(int numColumna) {
        boolean vacia=true;
        
        
        for(int j=1*numColumna*4-3; j<=4*numColumna; j++){
        for(int i=1; i<=altoCuadricula; i++){ 
                         
                if(matriz[i][j]!=0){
                    vacia=false;     
                    
                }         
            }
        }     
        
        if(vacia==false){
            System.out.println("Columna #"+numColumna+" no vacía.");
        }else{
             System.out.println("Columna #"+numColumna+" vacía.");
        }
        
        return vacia;
    }
    

    
    
    public static void enlazarColumna(int numColumna){
        Nodo p=null;
        Nodo q=null;  
            for(int i=1; i<=altoCuadricula; i++){ 
            for(int j=1*numColumna*4-3; j<=4*numColumna; j++){             
                if(matriz[i][j]!=0){
                    if(p==null){
                        p=firstIteracion.getNodo(matriz[i][j]);
                        System.out.println("p es igual a "+p.getId());
                    }else{         
                        q=firstIteracion.getNodo(matriz[i][j]);
                        System.out.println("q es igual a "+q.getId());
                        p.addEnlace(q);
                        q.addEnlace(p);
                        p=q;           
                    }
                }           
            }
        }
        
    }
    
    public static void unirDosColumnasEnlazadas(int columnaIzquierda, int columnaDerecha){
        int menorDistancia=(anchoCuadricula-1)+(altoCuadricula-1);
        int distancia, puntoA=0, puntoB=0;
        Nodo p = null;
        Nodo q = null;
        
        for(int i=1; i<=altoCuadricula; i++){ 
            for(int j=1*columnaIzquierda*4-3; j<=4*columnaIzquierda; j++){             
                if(matriz[i][j]!=0){
                    
                    for(int k=1; k<=altoCuadricula; k++){ 
                        for(int m=1*columnaDerecha*4-3; m<=4*columnaDerecha; m++){             
                            if(matriz[k][m]!=0){
                           //     System.out.println("Punto A: "+matriz[i][j]);
                           //     System.out.println("Punto B: "+matriz[k][m]);
                                distancia = Math.abs(k-i)+Math.abs(m-j)-1;   
                           //     System.out.println("Distancia: "+distancia);
                                if(distancia<menorDistancia){
                                    menorDistancia = distancia;
                                    puntoA = matriz[i][j];
                                    puntoB = matriz[k][m];
                                    
                                }
                            }           
                        }
                    }   
                }           
            }
        }
        
        p=firstIteracion.getNodo(puntoA);
        q=firstIteracion.getNodo(puntoB);
        
        p.addEnlace(q);
        q.addEnlace(p);
        
    }
    
    
      
}


