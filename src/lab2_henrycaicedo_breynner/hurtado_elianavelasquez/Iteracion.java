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
public class Iteracion {
    int num;
    Iteracion nextIteracion;
    Nodo firstNodo;
    static int numIteracion=1;
    
    public Iteracion() {
        this.num = numIteracion++;
    }

    void addNodo(Nodo nodo) {
        if(firstNodo == null){
            firstNodo = nodo;
        }else{
            Nodo p = firstNodo;
            while(p.nextNodo != null){
                p=p.nextNodo;
            }
            p.nextNodo = nodo;
        }
    }

    Nodo getNodo(int i) {
        Nodo p = firstNodo;
        while(p.id != i && p.nextNodo!=null){
            p = p.nextNodo;
        }
        return p;
    }

    Iteracion getIteracion(int num) {
        Iteracion p = this;
        while(p.num != num && p.nextIteracion!=null){
            p = p.nextIteracion;
        }
        return p;
    }


    
    
    
    
}
