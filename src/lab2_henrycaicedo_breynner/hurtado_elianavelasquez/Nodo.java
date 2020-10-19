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

    public Nodo(Nodo nextNodo, boolean tapabocas, boolean infectado, double x, double y, double radio) {
        super(x, y, radio, radio);
        this.nextNodo = nextNodo;
        this.tapabocas = tapabocas;
        this.infectado = infectado;
        this.id = contId++;
    }
    
    

    
    
    
}
