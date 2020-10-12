/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_henrycaicedo_breynner.hurtado_elianavelasquez;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Usuario
 */
public class GUI {
    
    
    
    private static void addComponentsToPane(Container pane, Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez sim) {

        


        //PANEL IZQUIERDO  
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(300, 600));
    
        //Contenido
        JPanel leftTopPanel = new JPanel();
        leftTopPanel.setPreferredSize(new Dimension(300, 25));
        leftPanel.add(leftTopPanel, "North");
        JLabel title = new JLabel("Preferencias");
        leftTopPanel.add(title);


        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        GroupLayout gLayout = new GroupLayout(content);
        content.setLayout(gLayout);
        GroupLayout.ParallelGroup hGroup = gLayout.createParallelGroup();
        gLayout.setHorizontalGroup(hGroup);
        GroupLayout.SequentialGroup vGroup = gLayout.createSequentialGroup();
        gLayout.setVerticalGroup(vGroup);
        
        JScrollPane leftScroll = new JScrollPane(content);    
        leftPanel.add(leftScroll);
        
        JPanel panel1 = new JPanel();
        JLabel jlNumNodes = new JLabel("Número de nodos");
                 jlNumNodes.setFont(new Font("Arial", Font.PLAIN, 16));
                 panel1.add(jlNumNodes);
                 hGroup.addComponent(panel1);
                 vGroup.addComponent(panel1, GroupLayout.PREFERRED_SIZE,
                 GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE);
                 vGroup.addGap(10);
        
        
        
        
        
        
        
        //PANEL DERECHO
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(700, 600));
        

        
        
        
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.red));
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.green));




        
        pane.add(leftPanel, "West");
        pane.add(rightPanel, "East");
           
    }
    
    
    public static void showGUI(Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez sim) {
        
        JFrame frame = new JFrame("Covid Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane(), sim);
        frame.setSize(10, 10);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        
    }

    
}
