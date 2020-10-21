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
    static int contId=1;
    Enlace firstEnlace;
    int getNumEnlaces;

    public Nodo(Nodo nextNodo, boolean tapabocas, boolean infectado, double x, double y, double diametro) {
        super(x, y, diametro, diametro);
        this.nextNodo = nextNodo;
        this.tapabocas = tapabocas;
        this.infectado = infectado;
        this.id = contId++;
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
    
    public int getNumEnlaces(){
        int c=0;
        if(firstEnlace != null){
        Enlace p = firstEnlace;
            do{
                c++;
            }while(p!=null);
            p = p.nextEnlace;
        }
        return c;
    }

    String getId() {
        return Integer.toString(id) ;
    }
    
    
    
    
    

    
    
    
}
