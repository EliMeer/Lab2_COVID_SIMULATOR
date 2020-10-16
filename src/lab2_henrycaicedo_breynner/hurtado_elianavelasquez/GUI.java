/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_henrycaicedo_breynner.hurtado_elianavelasquez;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

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
        leftTopPanel.setPreferredSize(new Dimension(290, 25));
        leftPanel.add(leftTopPanel, "North");
        JLabel jlTitle = new JLabel("Propiedades");
        jlTitle.setFont(new Font("Arial", Font.BOLD, 18));
        leftTopPanel.add(jlTitle);


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
        
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel1.setPreferredSize(new Dimension(290, 50));

        JLabel jlNumNodes = new JLabel("Número de nodos");
                 jlNumNodes.setFont(new Font("Arial", Font.PLAIN, 17));
                 jlNumNodes.setHorizontalAlignment(SwingConstants.RIGHT);
                 panel1.add(jlNumNodes);
                 hGroup.addComponent(panel1);
                 vGroup.addComponent(panel1, GroupLayout.PREFERRED_SIZE,
                 GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE);
                 vGroup.addGap(10);
        
          
        
        //PANEL DERECHO
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(700, 600));
        
        rightPanel.add(new ShapePanel(sim));
              
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
     
        pane.add(leftPanel, "West");
        pane.add(rightPanel, "East");
        
       
        
           
    }
    
    static class ShapePanel extends JPanel {

    
        
   
    private Dimension dim = new Dimension(690, 600);
    private final ArrayList<Shape> shapes;

    
    
    public ShapePanel(Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez sim) {
        Shape nodo1 = new Ellipse2D.Double(50, 100, 100, 100);
        Shape nodo2 = new Ellipse2D.Double(260, 100, 100, 100);
        Shape nodo3 = new Ellipse2D.Double(200, 260, 100, 100);
        shapes = new ArrayList<>(); 
        
    //    for(int i=1; i<=sim.numNodosEntero; i++){
    //        shapes.add(new Ellipse2D.Double(260, 100, 100, 100));
    //    }
        
          
        shapes.add(nodo1);
        shapes.add(nodo2);
        shapes.add(nodo3);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                for (Shape s : shapes) { 
                    
                    //Revisa si se hizo clic dentro del área del círculo
                    if (s.contains(me.getPoint())) {                      
                        
                        System.out.println(s.getClass().getName());
  
                    }
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2d = (Graphics2D) grphcs;
        for (Shape s : shapes) {
            g2d.draw(s);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return dim;
    }  
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
