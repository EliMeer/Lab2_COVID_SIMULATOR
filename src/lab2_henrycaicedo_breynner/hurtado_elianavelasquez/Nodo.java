/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_henrycaicedo_breynner.hurtado_elianavelasquez;

import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 *
 * @author HenryCaicedo
 */
public class Nodo extends Ellipse2D.Double{
    
    Nodo nextNodo;
    boolean tapabocas;
    boolean infectado;
    int id;
    Enlace firstEnlace;
    double diametro;
    boolean yaFueRecorrido;
    boolean seleccionado;

    public Nodo(Nodo nextNodo, boolean tapabocas, boolean infectado, double x, double y, double diametro, int id) {
        super(x, y, diametro, diametro);
        this.nextNodo = nextNodo;
        this.tapabocas = tapabocas;
        this.infectado = infectado;
        this.id = id;
        this.diametro = diametro;
        this.yaFueRecorrido=false;
        this.seleccionado=false;
    }

    public void addEnlace(Nodo q) {
        Enlace e = new Enlace(q);
        if(firstEnlace==null){
            firstEnlace = e;
        }else{
           Enlace p = firstEnlace;
           while(p.nextEnlace != null){
               p = p.nextEnlace;
           }
           p.nextEnlace = e;
        }
    }
    
    public void addEnlace(Enlace e) {
        if(firstEnlace==null){
            firstEnlace = e;
        }else{
           Enlace p = firstEnlace;
           while(p.nextEnlace != null){
               p = p.nextEnlace;
           }
           p.nextEnlace = e;
        }
    }
    
    public int getNumEnlaces(){
        int c=0;
        if(firstEnlace != null){
        Enlace p = firstEnlace;
            do{
                c++;
            p = p.nextEnlace;
            }while(p!=null);
        

        }
        return c;
    }

    int getId() {
        return id;
    }

    Enlace getEnlace(int i) {
        Enlace e = firstEnlace;
        
        while(e.num!=i){
            e = e.nextEnlace;
        }
        
        return e;
    }

    String getIdString() {
        return Integer.toString(id) ;
    }

    
    
    
    
    
    

    
    
    
}
