/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_henrycaicedo_breynner.hurtado_elianavelasquez;

/**
 *
 * @author HenryCaicedo
 */
public class Enlace {
    Nodo nodo;
    Enlace nextEnlace;
    int num;


    public Enlace(Nodo nodo) {
        this.nodo = nodo;
    }

    

    

    int getNum() {
        return num;
    }

    int distanciaHastaNodoInfectado(Nodo n) {
        
        if(!this.nodo.infectado){
        
        int c=0;
        Enlace e = this;
        boolean infectadoEncontrado = false;
        Nodo anteriorNodo = n;
        
        /*
        if(e.nodo.getNumEnlaces()==1){
            
            if(e.nodo.firstEnlace.nodo == n){
                n=e.nodo;
                e=e.nodo.firstEnlace.nextEnlace;    
            }else{
                n=e.nodo;
                e=e.nodo.firstEnlace;
            }
            
            
            c=e.distanciaHastaNodoInfectado(n);
            c++;
            
            
        }
        */
        
        while(e.nodo.getNumEnlaces()==2 && !e.nodo.infectado){
            
            
            if(e.nodo.firstEnlace.nodo == anteriorNodo){
                anteriorNodo = e.nodo;
                e = e.nodo.firstEnlace.nextEnlace;
            }else{
                anteriorNodo = e.nodo;
                e = e.nodo.firstEnlace;
            }
            
            c++;
            
        }
        
        if(e.nodo.infectado){
                infectadoEncontrado = true;
            }
            
        
        if(e.nodo.getNumEnlaces()>2 && !infectadoEncontrado){
  
            
            int menorDistancia = Integer.MAX_VALUE;
            int numEnlaceMenorDistancia;
            int c2=0;
            Enlace k;
            
            Nodo p = e.nodo;
            
            for(int i=1; i<=p.getNumEnlaces(); i++){
                k = p.getEnlace(i);
                    if(anteriorNodo==null || k.nodo != anteriorNodo){
                    c2 = k.distanciaHastaNodoInfectado(p);       
                    if(c2<menorDistancia && c2>=0){   
                        menorDistancia = c2;
                        numEnlaceMenorDistancia = k.getNum();
                    }
                    }
                
            }
            c = c+menorDistancia;
        }
        

        if(e.nodo.getNumEnlaces()==1 && !e.nodo.infectado){
            return -100;
        }
            
        
        return c;
        
        }else{
            return 0;
        }
    }
        

    
    
    
}
