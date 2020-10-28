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
    static int numNodos = 10, anchoCuadricula, altoCuadricula, opcionMascarilla=2;
    static int[][] matriz;
    static int mostrarIteracion=1;

    
    
    
    
 

    public Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez() {
        firstIteracion = null;     
    }
      
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez sim = new Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez();
                 
        
        calcProporcion(numNodos);
        sim.matriz = new int[altoCuadricula+1][anchoCuadricula+1];
        crearPrimeraIteracion();    
        crearEnlacesPrimarios();
        crearEnlacesSecundarios(); 
        serializarEnlaces();
        dibujarMatriz();     
        while(!todosInfectados()){
            addIteracion();
        }
        
    
  
        
        /*
        System.out.println(firstIteracion.nextIteracion.firstNodo.nextNodo.nextNodo.getId());
        System.out.println("ID: "+firstIteracion.nextIteracion.firstNodo.nextNodo.nextNodo.getId());
        System.out.println("Primer enlace: "+firstIteracion.nextIteracion.firstNodo.nextNodo.nextNodo.firstEnlace.num);
        System.out.println("Primer enlace: "+firstIteracion.nextIteracion.firstNodo.nextNodo.nextNodo.firstEnlace.nodo.getId());
        System.out.println("Segundo enlace: "+firstIteracion.nextIteracion.firstNodo.nextNodo.nextNodo.firstEnlace.nextEnlace.nodo.getId());
        */
        
       // System.out.println("Distancia entre "+firstIteracion.firstNodo.getId()+" y "+firstIteracion.firstNodo.nextNodo.getId()+": "+calcularDistancia(firstIteracion.firstNodo,firstIteracion.firstNodo.nextNodo));
        
       

        //GUI
        try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
        
        
       GUI gui = new GUI();
       gui.showGUI(sim);

        
    }
    
  
    public void iniciar(){
                                
                                mostrarIteracion=1;
                                Iteracion.numIteracion=1;
                                calcProporcion(numNodos);
                                matriz = new int[altoCuadricula+1][anchoCuadricula+1];
                                crearPrimeraIteracion();    
                                crearEnlacesPrimarios();
                                crearEnlacesSecundarios(); 
                                serializarEnlaces();
                                dibujarMatriz();    
                                
                                while(!todosInfectados()){
                                    addIteracion();
                                };
                                System.out.println("Número de iteraciones: "+getNumIteraciones());
    }
    
    public static void calcProporcion(int numNodos){
        int densidadNodos=8;
        if(numNodos%densidadNodos != 0){
            anchoCuadricula = (numNodos/densidadNodos+1)*4;
            altoCuadricula = (numNodos/densidadNodos+1)*3;
        }else{
            anchoCuadricula = (numNodos/densidadNodos)*4;
            altoCuadricula = (numNodos/densidadNodos)*3;
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
        }while(espacioDisponible(posX, posY)==false);
              
        matriz[posX][posY] = id;
        coordenadas[0]=posX;
        coordenadas[1]=posY;
        
        return coordenadas;
    }

    public static boolean espacioDisponible(int posX, int posY) {
        boolean disponible = true;      
        if(matriz[posX][posY]!=0){
            disponible = false;
        }else{
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
                  case 0: firstIteracion.addNodo(new Nodo(null, true, false, y, x, diametro, i));
                  break;
                  //Nadie usa tapabocas
                  case 1: firstIteracion.addNodo(new Nodo(null, false, false, y, x, diametro, i));
                  break;
                  //Uso aleatorio de tapabocas
                  default: Random a = new Random();
                           int num = a.nextInt(2) + 0;
                           if(num==1){
                               firstIteracion.addNodo(new Nodo(null, true, false, y, x, diametro, i));
                           }else{
                               firstIteracion.addNodo(new Nodo(null, false, false, y, x, diametro, i));
                           }
                  break;
              }
            
             
              
              
        }
        
         //Escoger el primer infectado aleatoriamente
              Random covid = new Random();
              int primerInfectado = covid.nextInt(numNodos) + 1;
              System.out.println("Primer infectado: "+primerInfectado);
              firstIteracion.getNodo(primerInfectado).infectado=true;
              
        
        
    }
    
    public static void addIteracion(){
            Iteracion p = firstIteracion;     
            while(p.nextIteracion!=null){
                p=p.nextIteracion;
            }
            Iteracion nuevaIteracion = new Iteracion();
            
            p.nextIteracion = nuevaIteracion;           
            duplicarUltimaIteracion(nuevaIteracion);  
            
            ejecutarVirusDos(nuevaIteracion);
            
               
    }
    
    private static void duplicarUltimaIteracion(Iteracion nuevaIteracion) {
        Iteracion anteriorIteracion = firstIteracion.getIteracion(nuevaIteracion.num-1);
        
        Nodo firstNodoNuevaIteracion = new Nodo(null, anteriorIteracion.firstNodo.tapabocas, anteriorIteracion.firstNodo.infectado,
                                        anteriorIteracion.firstNodo.x, anteriorIteracion.firstNodo.y, anteriorIteracion.firstNodo.diametro,
                                        anteriorIteracion.firstNodo.id);
        nuevaIteracion.firstNodo=firstNodoNuevaIteracion;
        
        Nodo p = firstNodoNuevaIteracion;
        
        //Duplicar nodos
        for(int i=2; i<=anteriorIteracion.getNumNodos(); i++){
            Nodo nodoOriginal = anteriorIteracion.getNodo(i);
            Nodo nodoCopia = new Nodo(null, nodoOriginal.tapabocas, nodoOriginal.infectado,
                              nodoOriginal.x, nodoOriginal.y, nodoOriginal.diametro, nodoOriginal.id);         
            p.nextNodo = nodoCopia;
            p=p.nextNodo;
        }
        
        //Duplicar enlaces
        Nodo q = anteriorIteracion.firstNodo;
        for(int i=1; i<=firstIteracion.getNumNodos(); i++){
            /*
            System.out.println("=============================");
            System.out.println("Duplicando enlaces de "+i);
            System.out.println("Número de enlaces: "+q.getNumEnlaces());
            System.out.println("Buscando nodo "+i);
*/
            Nodo m = nuevaIteracion.getNodo(i);
         
            
            //Enlace enlaceOriginal = q.getEnlace(1);
            
            for(int j=1; j<=q.getNumEnlaces(); j++){
                Enlace enlaceOriginal = q.getEnlace(j);
                Enlace enlaceCopia = new Enlace(nuevaIteracion.getNodo(enlaceOriginal.nodo.id));
                enlaceCopia.num = enlaceOriginal.num;
                m.addEnlace(enlaceCopia);
            }
  
             q = q.nextNodo; 
             
        }
        
        
    }
    
    private static void ejecutarVirusDos(Iteracion nuevaIteracion) {
        Random r = new Random();
        
        for(int i=1; i<=nuevaIteracion.getNumNodos(); i++){
            
            Nodo transmisor = nuevaIteracion.getNodo(i);
            
            //Si está infectado, se recorren sus nodos adyacentes, sino, se ignora y se pasa al siguiente.
            //Igualmente se verifica si se infectó en esta iteración
            if(transmisor.infectado && transmisor.yaFueRecorrido==false){
                
                for(int j=1; j<=transmisor.getNumEnlaces(); j++){
                   
                    Nodo receptor = transmisor.getEnlace(j).nodo;
                    
                    //Si este enlace no está infectado, se procede a evaluar las probabilidades
                    if(receptor.infectado == false){
                        
                        //Generar número entre 1 y 10 para usar los porcentajes dados
                        int probabilidad = r.nextInt(10) + 1;
                        System.out.println("Probabilidad: "+probabilidad);
                        int distancia = calcularDistancia(transmisor, receptor);
                        System.out.println("Distancia entre "+transmisor.getIdString()+" y "+receptor.getIdString()+": "+distancia);
                        if(distancia>2){
                            if(transmisor.tapabocas==false){
                                if(receptor.tapabocas==false){
                                    if(probabilidad<=8){
                                    receptor.infectado=true;
                                    receptor.yaFueRecorrido=true;  
                                    }
                                }
                                if(receptor.tapabocas==true){
                                    if(probabilidad<=4){
                                    receptor.infectado=true;
                                    receptor.yaFueRecorrido=true;  
                                    }
                                }                              
                            }else{
                                if(receptor.tapabocas==false){
                                    if(probabilidad<=3){
                                    receptor.infectado=true;
                                    receptor.yaFueRecorrido=true;  
                                    }
                                }
                                if(receptor.tapabocas==true){
                                    if(probabilidad<=2){
                                    receptor.infectado=true;
                                    receptor.yaFueRecorrido=true;  
                                    }
                                } 
                                                             
                            }       
                        }else{
                            if(transmisor.tapabocas==false){
                                if(receptor.tapabocas==false){
                                    if(probabilidad<=9){
                                    receptor.infectado=true;
                                    receptor.yaFueRecorrido=true;  
                                    }            
                                }
                                if(receptor.tapabocas==true){
                                    if(probabilidad<=6){
                                    receptor.infectado=true;
                                    receptor.yaFueRecorrido=true;  
                                    }
                                }                              
                            }else{
                                if(receptor.tapabocas==false){
                                    if(probabilidad<=4){
                                    receptor.infectado=true;
                                    receptor.yaFueRecorrido=true;  
                                    }
                                }
                                if(receptor.tapabocas==true){
                                    if(probabilidad<=3){
                                    receptor.infectado=true;
                                    receptor.yaFueRecorrido=true;  
                                    }
                                } 
                                                             
                            } 
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        }
                        
                        
                        
                    }
                    
                        
                    
                }
                
            }
       
        }
        /*
        Nodo p = nuevaIteracion.firstNodo;
        do{
            p.yaFueRecorrido=true;
            p=p.nextNodo;
        }while(p!=null);
        */
        
    }

    
    private static void ejecutarVirus(Iteracion nuevaIteracion) {
          
        for(int i=1; i<=nuevaIteracion.getNumNodos(); i++){
            
            Nodo transmisor = nuevaIteracion.getNodo(i);
            
            if(transmisor.infectado==true && transmisor.yaFueRecorrido==false){      
                     
                for(int j=1; j<=transmisor.getNumEnlaces(); j++){
                    
                    Nodo receptor = transmisor.getEnlace(j).nodo;      
                    
                    if(receptor.infectado==false){
                        Random r = new Random();
                        int probabilidad = r.nextInt(10) + 1;
                        System.out.println("Probabilidad: "+probabilidad);
                        int distancia = calcularDistancia(transmisor, receptor);
                        if(distancia>2){
                            if(transmisor.tapabocas==false && receptor.tapabocas==false){
                                if(probabilidad<=8){
                                    receptor.infectado=true;
                                    System.out.println(receptor.id+" Infectado");
                                }
                            }
                            if(transmisor.tapabocas==false && receptor.tapabocas==true){
                                if(probabilidad<=4){
                                    receptor.infectado=true;
                                    System.out.println(receptor.id+" Infectado");
                                }
                            }
                            if(transmisor.tapabocas==true && receptor.tapabocas==false){
                                if(probabilidad<=3){
                                    receptor.infectado=true;
                                    System.out.println(receptor.id+" Infectado");
                                }
                            }
                            if(transmisor.tapabocas==true && receptor.tapabocas==true){
                                if(probabilidad<=2){
                                    receptor.infectado=true;
                                    System.out.println(receptor.id+" Infectado");
                                }
                            }                      
                        }else{
                            if(transmisor.tapabocas==false && receptor.tapabocas==false){
                                if(probabilidad<=9){
                                    receptor.infectado=true;
                                    System.out.println(receptor.id+" Infectado");
                                }
                            }
                            if(transmisor.tapabocas==false && receptor.tapabocas==true){
                                if(probabilidad<=6){
                                    receptor.infectado=true;
                                    System.out.println(receptor.id+" Infectado");
                                }
                            }
                            if(transmisor.tapabocas==true && receptor.tapabocas==false){
                                if(probabilidad<=40){
                                    receptor.infectado=true;
                                    System.out.println(receptor.id+" Infectado");
                                }
                            }
                            if(transmisor.tapabocas==true && receptor.tapabocas==true){
                                if(probabilidad<=30){
                                    receptor.infectado=true;
                                    System.out.println(receptor.id+" Infectado");
                                }
                            }                 
                        }  
                        receptor.yaFueRecorrido = true; 
                    } 
                    
                }              
            }      
        }
        
        /*
          Nodo p = nuevaIteracion.firstNodo;
          do{
              p.yaFueRecorrido = false;
              p = p.nextNodo;
          }while(p!=null);
          */
    }
    
    private static int calcularDistancia(Nodo transmisor, Nodo receptor) {
        int distancia;
        int i=1, j=1, k=1, m=1;
        int puntoA=transmisor.getId(), puntoB=receptor.getId();
        int aVertical=0, aHorizontal=0, bVertical=0, bHorizontal=0;
        boolean aEncontrado=false, bEncontrado=false;

        while(i<=altoCuadricula && aEncontrado==false){

            j=1;
            while(j<=anchoCuadricula && aEncontrado==false){  
                if(matriz[i][j]==puntoA){
                    aVertical=i;
                    aHorizontal=j;
                    aEncontrado=true;
                }
                j++;
            }
            i++;
        }
        
        while(k<=altoCuadricula && bEncontrado==false){
            m=1;
            while(m<=anchoCuadricula && bEncontrado==false){  
                if(matriz[k][m]==puntoB){
                    bVertical=k;
                    bHorizontal=m;
                    bEncontrado=true;
                }
                m++;
            }
            k++;
        }
        
        distancia = Math.abs(bVertical-aVertical)+Math.abs(bHorizontal-aHorizontal)-1;   
         
        return distancia;
    }

    

    
    public static void crearEnlacesPrimarios(){
        int numColumnas=anchoCuadricula/4;        
        for(int i=1; i<=numColumnas; i++){
            if(!columnaVacia(i)){
                    enlazarColumna(i);
            }
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
            System.out.println("Columna no vacía: #"+numColumna);
        }else{
             System.out.println("Columna vacía: #"+numColumna);
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
                    }else{         
                        q=firstIteracion.getNodo(matriz[i][j]);
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
                                distancia = Math.abs(k-i)+Math.abs(m-j)-1;   
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

    
    
    public static void serializarEnlaces() {
        Nodo p = firstIteracion.firstNodo;
        for(int i=1; i<=firstIteracion.getNumNodos(); i++){   
            Enlace e = p.firstEnlace;
            int c = 1;       
            do{
                e.num = c;
                c++;
                e=e.nextEnlace;
            }while(e!=null);
            p=p.nextNodo;
        }
    }

    Iteracion getIteracion(int i) {
        System.out.println("Buscando iteracion "+i);
        Iteracion p = firstIteracion;
        while(p.num!=i ){
            p=p.nextIteracion;
        }
        return p;
    }
    
    public static boolean todosInfectados(){
        boolean todosInfectados=true;
        
        Iteracion i = firstIteracion;
        while(i.nextIteracion!=null){
            i = i.nextIteracion;
        }
        
        Nodo p = i.firstNodo;
        
        do{            
            if(p.infectado==false){
                todosInfectados=false;
            } 
            p=p.nextNodo;
        }while(p!=null && todosInfectados==true);
        
        return todosInfectados;
    }

    int getNumIteraciones() {
        int c = 0;
        if(firstIteracion!=null){
        Iteracion i = firstIteracion;
        do{
            c++;
            i=i.nextIteracion;
        }while(i!=null);
        }
        return c;
    }
    
    
      
}


