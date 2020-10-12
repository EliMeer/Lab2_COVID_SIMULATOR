/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_henrycaicedo_breynner.hurtado_elianavelasquez;

import javax.swing.UIManager;

/**
 *
 * @author Eliana Velasquez
 */
public class Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez {

    /**
     * @param args the command line arguments
     */
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
    
}
