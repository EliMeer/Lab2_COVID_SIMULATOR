/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_henrycaicedo_breynner.hurtado_elianavelasquez;

import java.awt.BorderLayout;
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
        final static int ancho=677;
        final static int alto=508;
    
    
    private static void addComponentsToPane(Container pane, Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez sim) {
        
        //PANEL IZQUIERDO  
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(300, 600));
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.gray));

    
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
        rightPanel.setPreferredSize(new Dimension(701, 600));
        JPanel margen = new JPanel();
        margen.setPreferredSize(new Dimension(689, 520));
        margen.setBackground(Color.WHITE);
        margen.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        rightPanel.add(margen);
        
        margen.add(new ShapePanel(sim));
              
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
     
        pane.add(leftPanel, "West");
        pane.add(rightPanel, "East");
        
        //Paginación
        JPanel paginacion = new JPanel();
        paginacion.setPreferredSize(new Dimension(700, 69));
        paginacion.setBorder(BorderFactory.createLineBorder(Color.gray));
        rightPanel.add(paginacion, BorderLayout.SOUTH);

    }
    
    static class ShapePanel extends JPanel {

    private Dimension dim = new Dimension(ancho, alto);
    private final ArrayList<Nodo> nodos;
 
    public ShapePanel(Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez sim) {
        Nodo nodo1 = new Nodo(null, true, true, 0, 0, 100, 1);
        nodos = new ArrayList<>(); 
                
        nodos.add(nodo1);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                for (Nodo n : nodos) {                    
                    //Revisa si se hizo clic dentro del área del círculo
                    if (n.contains(me.getPoint())) {                      
                        System.out.println(n.id);
                    }
                }
            }        
        });
        setBackground(Color.WHITE);
        //setBorder(BorderFactory.createLineBorder(Color.red));

        addMouseListener( new MouseAdapter() {
            public void mouseEntered( MouseEvent e ) {
                super.mouseEntered(e);
                for (Nodo n : nodos) { 
                    
                    //Revisa si se el cursor está dentro del área del círculo
                    if (n.contains(e.getPoint())) {                                  
                        System.out.println("Mouse dentro de "+n.id);
                    }
                }
            }
        });
    }

    
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2d = (Graphics2D) grphcs;
        for (Nodo n : nodos) {
            g2d.draw(n);
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
