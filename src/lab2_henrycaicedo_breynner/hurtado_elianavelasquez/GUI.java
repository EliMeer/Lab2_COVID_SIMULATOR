/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_henrycaicedo_breynner.hurtado_elianavelasquez;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static lab2_henrycaicedo_breynner.hurtado_elianavelasquez.Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez.calcProporcion;
import static lab2_henrycaicedo_breynner.hurtado_elianavelasquez.Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez.crearEnlacesPrimarios;
import static lab2_henrycaicedo_breynner.hurtado_elianavelasquez.Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez.crearEnlacesSecundarios;
import static lab2_henrycaicedo_breynner.hurtado_elianavelasquez.Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez.crearPrimeraIteracion;
import static lab2_henrycaicedo_breynner.hurtado_elianavelasquez.Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez.dibujarMatriz;
import static lab2_henrycaicedo_breynner.hurtado_elianavelasquez.Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez.numNodos;

/**
 *
 * @author Usuario
 */
public class GUI {

        final static int anchoSim=680;
        final static int altoSim=510;
        public static ShapePanel shapePanel2;
        static final Color colorInfectado = new Color(255,160,160);
        static final Color colorSano = new Color(191, 186, 255);
        static final Color colorInfectadoSeleccionado = new Color(255, 0, 0);
        static final Color colorSanoSeleccionado = new Color(255, 174, 0);
    
    
    private static void addComponentsToPane(Container pane, Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez sim) {
        
        
        
        //PANEL IZQUIERDO  
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(340, 610));
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.gray));

    
        //Contenido
        JPanel leftTopPanel = new JPanel();
        leftTopPanel.setPreferredSize(new Dimension(290, 25));
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
        
        leftPanel.add(content);
        
        //Propiedades
                JPanel panel1 = new JPanel();
                panel1.setPreferredSize(new Dimension(290, 35));
                JLabel jlbPropiedades = new JLabel("Propiedades");
                jlbPropiedades.setFont(new Font("Arial", Font.PLAIN, 25));
                panel1.add(jlbPropiedades); 
                hGroup.addComponent(panel1);
                vGroup.addComponent(panel1, GroupLayout.PREFERRED_SIZE,
                GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE);
                vGroup.addGap(10);

        //Num nodos
                JPanel panel2 = new JPanel();
                panel2.setPreferredSize(new Dimension(290, 33));
                panel2.setBackground(new Color(235, 238, 240));
                JLabel jlbCantidadNodos = new JLabel("Cantidad de nodos");
                jlbCantidadNodos.setForeground(Color.black);
                jlbCantidadNodos.setFont(new Font("Arial", Font.PLAIN, 18));
                panel2.setBorder(BorderFactory.createLineBorder(Color.black)); 

                panel2.add(jlbCantidadNodos); 
                hGroup.addComponent(panel2);
                vGroup.addComponent(panel2, GroupLayout.PREFERRED_SIZE,
                GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE);
                vGroup.addGap(0);                
                //Contenedor Nodos
                JPanel panel3 = new JPanel(new GridLayout(0, 1));
                panel3.setBorder(BorderFactory.createLineBorder(Color.lightGray)); 
                panel3.setBackground(Color.white);
                //Botones
                JPanel nodoPanel = new JPanel(new GridLayout(1,5));

                nodoPanel.setPreferredSize(new Dimension(290, 58));
                nodoPanel.setBorder(BorderFactory.createLineBorder(Color.gray)); 

                hGroup.addComponent(nodoPanel);
                vGroup.addComponent(nodoPanel, GroupLayout.PREFERRED_SIZE,
                GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE);
                vGroup.addGap(15);
                
        //Botones
                JButton jbMenos1 = new JButton("<");
                JButton jbMenos10 = new JButton("<<");
                JLabel jlbNumNodos = new JLabel(Integer.toString(sim.numNodos));
                JButton jbMas1 = new JButton(">");
                JButton jbMas10 = new JButton(">>");
                
                JLabel jlbFuenteBotones = new JLabel();
                jlbFuenteBotones.setFont(new Font("Arial", Font.BOLD, 12));
                jbMenos1.setFont(jlbFuenteBotones.getFont());
                jbMenos10.setFont(jlbFuenteBotones.getFont());
                jbMas1.setFont(jlbFuenteBotones.getFont());
                jbMas10.setFont(jlbFuenteBotones.getFont());

                 
                //ACTION LISTENERS            
                jbMenos1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(sim.numNodos>=3){
                        sim.numNodos--;                       
                        }
                        
                        
                        
                    jlbNumNodos.setText(Integer.toString(sim.numNodos));  
                            jbMas1.setEnabled(true);
                            jbMas10.setEnabled(true);
                    if(sim.numNodos==2){
                            jbMenos1.setEnabled(false);
                            jbMenos10.setEnabled(false);
                        }
                    }
                }); 
                
                jbMenos10.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(sim.numNodos>=12){
                        sim.numNodos=sim.numNodos-10; 
                        
                        }else{
                            sim.numNodos=2;
                        }
                    jlbNumNodos.setText(Integer.toString(sim.numNodos));
                            jbMas1.setEnabled(true);
                            jbMas10.setEnabled(true);
                    if(sim.numNodos==2){
                            jbMenos1.setEnabled(false);
                            jbMenos10.setEnabled(false);
                        }
                    }
                }); 
                
                jbMas1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(numNodos<100){
                        sim.numNodos++; 
                        jlbNumNodos.setText(Integer.toString(sim.numNodos));
                            jbMenos1.setEnabled(true);
                            jbMenos10.setEnabled(true);
                        if(sim.numNodos>=100){
                            jbMas1.setEnabled(false);
                            jbMas10.setEnabled(false);
                        }
                        }
                    }
                }); 
                
                jbMas10.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(sim.numNodos<=100-10){
                        sim.numNodos=sim.numNodos+10;
                        }else{
                            sim.numNodos=100;
                        }
                            jbMenos1.setEnabled(true);
                            jbMenos10.setEnabled(true);
                        if(sim.numNodos>=100){
                            jbMas1.setEnabled(false);
                            jbMas10.setEnabled(false);
                        }
                        jlbNumNodos.setText(Integer.toString(sim.numNodos));
                    }
                }); 
                
                
                
                jlbNumNodos.setFont(new Font("Arial", Font.BOLD, 20));
                jlbNumNodos.setHorizontalAlignment(JLabel.CENTER);
                jlbNumNodos.setVerticalAlignment(JLabel.CENTER);
                              
                nodoPanel.add(jbMenos10);
                nodoPanel.add(jbMenos1);
                nodoPanel.add(jlbNumNodos);
                nodoPanel.add(jbMas1);
                nodoPanel.add(jbMas10);
                
                
        //Mascarilla
                JPanel panel4 = new JPanel();
                panel4.setPreferredSize(new Dimension(290, 33));
                panel4.setBackground(new Color(235, 238, 240));
                JLabel jlbUsoMascarilla = new JLabel("Uso de Mascarilla");
                jlbUsoMascarilla.setForeground(Color.black);
                                panel4.setBorder(BorderFactory.createLineBorder(Color.black)); 

                jlbUsoMascarilla.setFont(new Font("Arial", Font.PLAIN, 18));
                panel4.add(jlbUsoMascarilla); 
                hGroup.addComponent(panel4);
                vGroup.addComponent(panel4, GroupLayout.PREFERRED_SIZE,
                GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE);
                vGroup.addGap(0);     
        //Contenedor mascarilla
                JPanel panel5 = new JPanel(new GridLayout(0, 1));
                panel5.setBorder(BorderFactory.createLineBorder(Color.lightGray)); 
                panel5.setBackground(Color.white);
                JPanel panel6 = new JPanel();
                
                JPanel contenidoMascarilla = new JPanel(new GridLayout(3,1));
                panel6.add(contenidoMascarilla);
                contenidoMascarilla.setPreferredSize(new Dimension(290, 45*3));
                panel6.setBorder(BorderFactory.createLineBorder(Color.gray)); 

                hGroup.addComponent(panel6);
                vGroup.addComponent(panel6, GroupLayout.PREFERRED_SIZE,
                GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE);
                vGroup.addGap(15);
                //Botones
               // JPanel nodoPanel = new JPanel(new GridLayout(1,5));
               JLabel jlbFuente = new JLabel();
               jlbFuente.setFont(new Font("Arial", Font.PLAIN, 17));
               JRadioButton rbConMascarilla = new JRadioButton("Todos usan mascarilla");
               JRadioButton rbSinMascarilla = new JRadioButton("Nadie usa mascarilla");
               JRadioButton rbAleatorio = new JRadioButton("Aleatorio");
               rbConMascarilla.setFont(jlbFuente.getFont());
               rbSinMascarilla.setFont(jlbFuente.getFont());
               rbAleatorio.setFont(jlbFuente.getFont());
               ButtonGroup bG = new ButtonGroup();      
               bG.add(rbConMascarilla);
               bG.add(rbSinMascarilla); 
               bG.add(rbAleatorio);
               rbAleatorio.setSelected(true);
               contenidoMascarilla.add(rbConMascarilla);
               contenidoMascarilla.add(rbSinMascarilla);
               contenidoMascarilla.add(rbAleatorio);
               
               
        //Información
                JPanel panel7 = new JPanel();
                panel7.setPreferredSize(new Dimension(290, 33));
                panel7.setBackground(new Color(235, 238, 240));
                JLabel jlbInfo = new JLabel("Información de nodos");
                jlbInfo.setForeground(Color.black);
                jlbInfo.setFont(new Font("Arial", Font.PLAIN, 18));
                panel7.setBorder(BorderFactory.createLineBorder(Color.black)); 
                panel7.add(jlbInfo); 
                hGroup.addComponent(panel7);
                vGroup.addComponent(panel7, GroupLayout.PREFERRED_SIZE,
                GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE);
                vGroup.addGap(0);       
                //Contenedor información
                JPanel panel8 = new JPanel();
                panel8.setBorder(BorderFactory.createLineBorder(Color.lightGray)); 
                panel8.setPreferredSize(new Dimension(290, 139));
                hGroup.addComponent(panel8);
                vGroup.addComponent(panel8, GroupLayout.PREFERRED_SIZE,
                GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE);
                vGroup.addGap(15);
               
                JPanel contenidoInfo = new JPanel() {

                    @Override
                    protected void paintComponent(Graphics grphcs) {
                        super.paintComponent(grphcs);
                        Graphics2D g = (Graphics2D) grphcs;
                        int x=0, y=-6, separacion=30;
                        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        
                        
                        g.setStroke(new java.awt.BasicStroke(2));
                        g.setColor(colorSano);
                        g.fillOval(4+x, 10+y, 20, 20);
                        g.fillOval(4+x, 10+y+separacion, 20, 20);
                        g.setColor(colorInfectado);
                        g.fillOval(4+x, 10+y+separacion*2, 20, 20);
                        g.fillOval(4+x, 10+y+separacion*3, 20, 20);
                        g.setColor(Color.BLACK);
                        g.drawOval(4+x, 10+y+separacion, 20, 20);
                        g.drawOval(4+x, 10+y+separacion*3, 20, 20);
                        g.setStroke(new java.awt.BasicStroke());
                        Font font = g.getFont().deriveFont( 16.5f );
                        g.setFont(font);
                        g.drawString("Sano - sin mascarilla", 35+x, 26+y);
                        g.drawString("Sano - con mascarilla", 35+x, 26+y+separacion);
                        g.drawString("Contagiado - sin mascarilla", 35+x, 26+y+separacion*2);
                        g.drawString("Contagiado - con mascarilla", 35+x, 26+y+separacion*3);
                        //setBackground(Color.WHITE);
                    }
                };
                
                contenidoInfo.setPreferredSize(new Dimension(290, 39*3));
                
                contenidoInfo.repaint();
               
                panel8.add(contenidoInfo);
               
               //Botón de iniciar
               JPanel panel9 = new JPanel();
               JLabel jlbFuenteIniciar = new JLabel();
               jlbFuenteIniciar.setFont(new Font("Arial", Font.PLAIN, 19));

               JButton jbIniciar = new JButton("Iniciar simulación");
               
               jbIniciar.setFont(jlbFuenteIniciar.getFont());
               panel9.add(jbIniciar);
               panel9.setPreferredSize(new Dimension(310, 55));

               jbIniciar.setPreferredSize(new Dimension(310, 50));
               hGroup.addComponent(panel9);
                vGroup.addComponent(panel9, GroupLayout.PREFERRED_SIZE,
                GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE);
                vGroup.addGap(15);
                
                
            
                
                
                
      
        //PANEL DERECHO
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(704, 602));
        JPanel margen = new JPanel();
        margen.setPreferredSize(new Dimension(692, 522));
        margen.setBackground(Color.WHITE);
        margen.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        rightPanel.add(margen);
        
        //ShapePanel shapePanel = new ShapePanel(sim.firstIteracion);
        
        JPanel shapePanel = new JPanel() {

                    @Override
                    protected void paintComponent(Graphics grphcs) {
                        super.paintComponent(grphcs);
                        Graphics2D g = (Graphics2D) grphcs;
   
                        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        int x=30, y=170;
                        
                        Font font = g.getFont().deriveFont( 35f );
                        g.setFont(font);
                        g.setColor(new Color(120, 112, 224));
                        g.drawString("¡Bienvenid@ a Covid Simulator!", 65+x, 25+y);
                        g.setColor(Color.black);
                        g.drawString("Para empezar, elige las propiedades", 35+x, 90+y);
                        g.drawString("de tu simulación y haz clic en iniciar.", 32+x, 130+y);

                        setBackground(Color.WHITE);
                        
                    }
                };

        shapePanel.setPreferredSize(new Dimension(682, 512));
        
        
        margen.add(shapePanel);
              
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
     
        pane.add(leftPanel, "West");
        pane.add(rightPanel, "East");
        
        //Paginación
        JPanel paginacion = new JPanel();
        paginacion.setPreferredSize(new Dimension(704, 75));
        paginacion.setBorder(BorderFactory.createLineBorder(Color.gray));
        rightPanel.add(paginacion, BorderLayout.SOUTH);
        JPanel jpIzq = new JPanel();
        JPanel jpDer = new JPanel();
        //Barra de reproducción
        JPanel jpMediaControl = new JPanel(new GridLayout(1,5));
        JButton jbAnteriorPlus = new JButton("<<");
        JButton jbAnterior = new JButton("<");
        JPanel jpIteraciones = new JPanel();
        JButton jbSiguiente = new JButton(">");
        JButton jbSiguientePlus = new JButton(">>");
        jbAnterior.setPreferredSize(new Dimension(70, 63));
        
        JLabel jlbIteracion = new JLabel();
        jlbIteracion.setFont(new Font("Arial", Font.BOLD, 18));
        jlbIteracion.setHorizontalAlignment(JLabel.CENTER);
        jlbIteracion.setVerticalAlignment(JLabel.CENTER);
        jpIteraciones.add(jlbIteracion);
        
        jpMediaControl.add(jbAnteriorPlus);
        jpMediaControl.add(jbAnterior);
        jpMediaControl.add(jlbIteracion);
        jpMediaControl.add(jbSiguiente);
        jpMediaControl.add(jbSiguientePlus);
        
        jbAnteriorPlus.setEnabled(false);
        jbAnterior.setEnabled(false);
        jbSiguiente.setEnabled(false);
        jbSiguientePlus.setEnabled(false);

        
        
        
        JLabel jlbFuenteBotones2 = new JLabel();
        jlbFuenteBotones2.setFont(new Font("Arial", Font.BOLD, 16));
        
        
        jbAnteriorPlus.setFont(jlbFuenteBotones2.getFont());
        jbAnterior.setFont(jlbFuenteBotones2.getFont());
        jbSiguiente.setFont(jlbFuenteBotones2.getFont());
        jbSiguientePlus.setFont(jlbFuenteBotones2.getFont());
        
         
        paginacion.add(jpIzq);
        paginacion.add(jpMediaControl);
        paginacion.add(jpDer);
        
       
   
        
        //ACTION LISTENER BOTÓN INICIAR SIMULACIÓN
        jbIniciar.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    
                                    if(rbConMascarilla.isSelected() || rbSinMascarilla.isSelected() || rbAleatorio.isSelected()){
                                    
                                    if(rbConMascarilla.isSelected()){
                                        sim.opcionMascarilla=0;
                                    }
                                    if(rbSinMascarilla.isSelected()){
                                        sim.opcionMascarilla=1;
                                    }
                                    
                                    if(rbAleatorio.isSelected()){
                                        sim.opcionMascarilla=2;
                                    }
                                    
                                    
                                    sim.iniciar();
                                    
                                    margen.remove(shapePanel);
                                    
                                    if(shapePanel2 != null){
                                        margen.remove(shapePanel2);
                                    }
                                    
                                    
                                    shapePanel2 = new ShapePanel(sim.firstIteracion.getIteracion(1));
                                    if(shapePanel2.getParent() == margen){
                                        margen.remove(shapePanel2);
                                    }else{
                                        
                                    }
                                    jbAnterior.setEnabled(false);
                                    jbAnteriorPlus.setEnabled(false);
                                    jbSiguiente.setEnabled(true);
                                    jbSiguientePlus.setEnabled(true);
                                    margen.add(shapePanel2);
                                    margen.revalidate();
                                    margen.repaint();
                                    shapePanel.revalidate();
                                    shapePanel.repaint();
                                    jlbIteracion.setText(sim.mostrarIteracion+"/"+sim.getNumIteraciones());
                                    }
                                 }
                            }); 
        
         //ACTION LISTENER MEDIA 
        jbSiguiente.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                                
                                    jbAnterior.setEnabled(true);
                                    jbAnteriorPlus.setEnabled(true);
                        
                                    if(sim.mostrarIteracion<sim.getNumIteraciones()){
                                     margen.remove(shapePanel);
                                    
                                    if(shapePanel2 != null){
                                        margen.remove(shapePanel2);
                                    }
                                    
                                    sim.mostrarIteracion++;
                                    
                                    shapePanel2 = new ShapePanel(sim.getIteracion(sim.mostrarIteracion));

                                    
                                    if(shapePanel2.getParent() == margen){   
                                        margen.remove(shapePanel2);
                                    }
                                    
                                    margen.add(shapePanel2);
                                    margen.revalidate();
                                    margen.repaint();
                                    shapePanel.revalidate();
                                    shapePanel.repaint();
                                    
                                    jlbIteracion.setText(sim.mostrarIteracion+"/"+sim.getNumIteraciones());
                                    
                                    }
                                    
                                    if(sim.mostrarIteracion==sim.getNumIteraciones()){
                                        jbSiguiente.setEnabled(false);
                                        jbSiguientePlus.setEnabled(false);
                                    }
                                    
                                    
                                    
                        
                    }
                }); 
        
        
        //ACTION LISTENER ANTERIOR ITERACIÓN
        jbAnterior.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    
                                    jbSiguiente.setEnabled(true);
                                    jbSiguientePlus.setEnabled(true);
                                    
                                    if(sim.mostrarIteracion>1){
                                    margen.remove(shapePanel);
                                    
                                    if(shapePanel2 != null){
                                        margen.remove(shapePanel2);
                                    }
                                    
                                    sim.mostrarIteracion--;
                                    
                                    shapePanel2 = new ShapePanel(sim.getIteracion(sim.mostrarIteracion));
                                    
                                    if(shapePanel2.getParent() == margen){   
                                        margen.remove(shapePanel2);
                                    }
                                    margen.add(shapePanel2);
                                    margen.revalidate();
                                    margen.repaint();
                                    shapePanel.revalidate();
                                    shapePanel.repaint();
                                    
                                    }
                                    
                                    jlbIteracion.setText(sim.mostrarIteracion+"/"+sim.getNumIteraciones());
                                    
                                    if(sim.mostrarIteracion==1){
                                        jbAnterior.setEnabled(false);
                                        jbAnteriorPlus.setEnabled(false);
                                    }
                                    
                                }
                            }); 
        

        jbSiguientePlus.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        
                                if(sim.mostrarIteracion<=sim.getNumIteraciones()-10){
                                    
                                    jbAnterior.setEnabled(true);
                                    jbAnteriorPlus.setEnabled(true);
                            
                                    if(sim.mostrarIteracion<sim.getNumIteraciones()){
                                     margen.remove(shapePanel);
                                    
                                    if(shapePanel2 != null){
                                        margen.remove(shapePanel2);
                                    }
                                    
                                    sim.mostrarIteracion=sim.mostrarIteracion+10;
                                    
                                    shapePanel2 = new ShapePanel(sim.getIteracion(sim.mostrarIteracion));

                                    
                                    if(shapePanel2.getParent() == margen){   
                                        margen.remove(shapePanel2);
                                    }
                                    
                                    margen.add(shapePanel2);
                                    margen.revalidate();
                                    margen.repaint();
                                    shapePanel.revalidate();
                                    shapePanel.repaint();
                                    
                                    jlbIteracion.setText(sim.mostrarIteracion+"/"+sim.getNumIteraciones());
                                    
                                    if(sim.mostrarIteracion==sim.getNumIteraciones()){
                                        jbSiguiente.setEnabled(false);
                                        jbSiguientePlus.setEnabled(false);
                                    }
                                    
                                    }
                                    
                                }else{
                                    if(sim.mostrarIteracion<sim.getNumIteraciones()){
                                     margen.remove(shapePanel);
                                    
                                    if(shapePanel2 != null){
                                        margen.remove(shapePanel2);
                                    }
                                    
                                    sim.mostrarIteracion=sim.getNumIteraciones();
                                    
                                    shapePanel2 = new ShapePanel(sim.getIteracion(sim.mostrarIteracion));

                                    
                                    if(shapePanel2.getParent() == margen){   
                                        margen.remove(shapePanel2);
                                    }
                                    
                                    margen.add(shapePanel2);
                                    margen.revalidate();
                                    margen.repaint();
                                    shapePanel.revalidate();
                                    shapePanel.repaint();
                                    jlbIteracion.setText(sim.mostrarIteracion+"/"+sim.getNumIteraciones());
                                    
                                    if(sim.mostrarIteracion==sim.getNumIteraciones()){
                                        jbSiguiente.setEnabled(false);
                                        jbSiguientePlus.setEnabled(false);
                                    }
                                    
                                    }
                                    
                                }
                        
                    }
                }); 
        
        
        //ACTION LISTENER ANTERIOR ITERACIÓN
        jbAnteriorPlus.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    
                                    jbSiguiente.setEnabled(true);
                                    jbSiguientePlus.setEnabled(true);
                                    
                                    if(sim.mostrarIteracion>10){
                                    
                                    if(sim.mostrarIteracion>1){
                                    margen.remove(shapePanel);
                                    
                                    if(shapePanel2 != null){
                                        margen.remove(shapePanel2);
                                    }
                                    
                                    sim.mostrarIteracion=sim.mostrarIteracion-10;
                                    
                                    shapePanel2 = new ShapePanel(sim.getIteracion(sim.mostrarIteracion));
                                    
                                    if(shapePanel2.getParent() == margen){   
                                        margen.remove(shapePanel2);
                                    }
                                    margen.add(shapePanel2);
                                    margen.revalidate();
                                    margen.repaint();
                                    shapePanel.revalidate();
                                    shapePanel.repaint();
                                    jlbIteracion.setText(sim.mostrarIteracion+"/"+sim.getNumIteraciones());
                                    }
                                    }else{
                                        
                                        if(sim.mostrarIteracion>1){
                                    margen.remove(shapePanel);
                                    
                                    if(shapePanel2 != null){
                                        margen.remove(shapePanel2);
                                    }
                                    
                                    sim.mostrarIteracion=1;
                                    
                                    shapePanel2 = new ShapePanel(sim.getIteracion(sim.mostrarIteracion));
                                    
                                    if(shapePanel2.getParent() == margen){   
                                        margen.remove(shapePanel2);
                                    }
                                    margen.add(shapePanel2);
                                    margen.revalidate();
                                    margen.repaint();
                                    shapePanel.revalidate();
                                    shapePanel.repaint();
                                    jlbIteracion.setText(sim.mostrarIteracion+"/"+sim.getNumIteraciones());
                                    }
                                        
                                        
                                    }
                                    
                                    if(sim.mostrarIteracion==1){
                                        jbAnterior.setEnabled(false);
                                        jbAnteriorPlus.setEnabled(false);
                                    }
                                    
                                }
                                
                                
                                
                            }); 
        
   
        
    }
    
    
    
    
    
    
    
    
    static class ShapePanel extends JPanel {
        
        

    private Dimension dim = new Dimension(anchoSim, altoSim);
    Iteracion iteracion;

        static boolean arrastrado=false;
    
    public ShapePanel(Iteracion iteracion) {
         
        this.iteracion=iteracion;
        
        
        addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent me) {
                arrastrado=false;
                super.mouseMoved(me);
                Nodo p = iteracion.firstNodo;
                do{                  
                    if (p.contains(me.getPoint())) {                      
                        System.out.println(p.id+": ("+p.x+","+p.y+")");
                        p.seleccionado=true;
                    }else{
                        p.seleccionado=false;
                    }
                    p = p.nextNodo;     
                    if(shapePanel2!=null)shapePanel2.repaint();
                }while(p!=null);                 
            }
            public void mouseExited(MouseEvent e) {
                arrastrado=true;
            }
            
            @Override
            public void mouseDragged(MouseEvent e) {
                arrastrado=true;
            }
        });
        
        addMouseListener(new MouseAdapter() {
              
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                Nodo p = iteracion.firstNodo;
                do{                  
                    //Revisa si se hizo clic dentro del área del círculo
                    if (p.contains(me.getPoint())) {                      
                        System.out.println(p.id+": ("+p.x+","+p.y+")");
                        System.out.println("firstEnlace: "+p.firstEnlace.nodo.getIdString());
                        System.out.print("Enlaces: ");
                            if(p.firstEnlace != null){
                                Enlace e = p.firstEnlace;
                                
                                    do{
                                        System.out.print(e.nodo.id+", "); 
                                        e = e.nextEnlace;
                                    }while(e!=null);
                                     System.out.println();   
                                }
                                          
                    }
                    p = p.nextNodo;                 
                }while(p!=null);             
            }        
        });
        
        setBackground(Color.WHITE);
        
    }

    
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2d = (Graphics2D) grphcs;
        Nodo p = iteracion.firstNodo;
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setStroke(new java.awt.BasicStroke(1));
         do{
            //Dibujar aristas
            if(p.firstEnlace != null){
            Enlace e = p.firstEnlace;
            do{
                if(p.id<e.nodo.id){
                g2d.drawLine((int)(p.x+p.height/2), (int)(p.y+p.height/2), (int)(e.nodo.x+p.height/2), (int)(e.nodo.y+p.height/2)); 
                }      
                e = e.nextEnlace;        
            }while(e!=null);                  
            }        
            p = p.nextNodo;
            
        }while(p!=null);        
                p = iteracion.firstNodo;
    
                
                BasicStroke contorno = new java.awt.BasicStroke(3);
                if(numNodos>60){
                    contorno = new java.awt.BasicStroke(2);
                }
                
        //DOBUJAR NODOS
        do{                   
            if(!p.yaFueDibujado){
            if(p.infectado==true){
                if(p.seleccionado){
                Enlace e = p.firstEnlace;
                 do{
                     if(!e.nodo.infectado){
                         g2d.setStroke(contorno);
                         g2d.setColor(colorInfectadoSeleccionado);
                         g2d.drawLine((int)(p.x+p.height/2), (int)(p.y+p.height/2), (int)(e.nodo.x+p.height/2), (int)(e.nodo.y+p.height/2)); 
                         g2d.setStroke(new java.awt.BasicStroke());
                         g2d.setColor(colorSano);
                         g2d.fillOval((int)e.nodo.x, (int)e.nodo.y, (int)e.nodo.height, (int)e.nodo.width);
                         g2d.setColor(colorInfectadoSeleccionado);
                         g2d.setStroke(new java.awt.BasicStroke(4));
                         g2d.drawOval((int)e.nodo.x, (int)e.nodo.y, (int)e.nodo.height, (int)e.nodo.width);
                         
                         e.nodo.yaFueDibujado=true;
                     }
                     e = e.nextEnlace;
                 }while(e!=null);
                }
                g2d.setColor(colorInfectado);
             }else{
                if(p.seleccionado){
                        
                    
                    //DIBUJAR ARISTAS DEL CAMINO
                    Nodo n = p;
                    //n se va a ir desplazando y dibujando el camino con los nodos
                    Nodo anteriorNodo = null;
                    System.out.println("=================================================");
                    System.out.println("P: "+p.getIdString());
                    
                    while(!n.infectado){
                        
                        System.out.println("N: "+n.getIdString());
                        
                        Enlace e;
                        int c;
                        int menorDistancia = Integer.MAX_VALUE;
                        int numEnlaceMenorDistancia=0;
                        
                       
                        
                        for(int i = 1; i<=n.getNumEnlaces(); i++){
                            e = n.getEnlace(i);
                            System.out.println("Revisando enlace "+i+" (Nodo "+n.getIdString()+")");
                            if(anteriorNodo==null || e.nodo != anteriorNodo){
                            c = e.distanciaHastaNodoInfectado(n);
                                System.out.println("Distancia desde "+e.nodo.getIdString()+":  "+c);
                            if(c<menorDistancia && c>=0){   
                                menorDistancia = c;
                                numEnlaceMenorDistancia = e.getNum();
                            }
                                System.out.println("Menor distancia:  "+menorDistancia);
                            }
                        }
                        
                  
                        anteriorNodo = n;
                        e = n.getEnlace(numEnlaceMenorDistancia);
                        n = e.nodo;
                        
                                    
                        //DIBUJAR N
                         g2d.setStroke(contorno);
                         g2d.setColor(colorSanoSeleccionado);
                         g2d.drawLine((int)(anteriorNodo.x+anteriorNodo.height/2), (int)(anteriorNodo.y+anteriorNodo.height/2), (int)(n.x+anteriorNodo.height/2), (int)(n.y+anteriorNodo.height/2));  
                    }
                    
                    //DIBUJAR ARISTAS DEL CAMINO
                    n = p;
                    //n se va a ir desplazando y dibujando el camino con los nodos
                    anteriorNodo = null;
                    System.out.println("=================================================");
                    System.out.println("P: "+p.getIdString());
                    
                    while(!n.infectado){
                        
                        System.out.println("N: "+n.getIdString());
                        
                        Enlace e;
                        int c;
                        int menorDistancia = Integer.MAX_VALUE;
                        int numEnlaceMenorDistancia=0;
                        
                       
                        
                        for(int i = 1; i<=n.getNumEnlaces(); i++){
                            e = n.getEnlace(i);
                            System.out.println("Revisando enlace "+i+" (Nodo "+n.getIdString()+")");
                            if(anteriorNodo==null || e.nodo != anteriorNodo){
                            c = e.distanciaHastaNodoInfectado(n);
                                System.out.println("Distancia desde "+e.nodo.getIdString()+":  "+c);
                            if(c<menorDistancia && c>=0){   
                                menorDistancia = c;
                                numEnlaceMenorDistancia = e.getNum();
                            }
                                System.out.println("Menor distancia:  "+menorDistancia);
                            }
                        }
                        
                  
                        anteriorNodo = n;
                        e = n.getEnlace(numEnlaceMenorDistancia);
                        n = e.nodo;
                        
                                    
                        //DIBUJAR N
                         g2d.setStroke(contorno);
                         g2d.setColor(colorSanoSeleccionado);
                         g2d.setStroke(new java.awt.BasicStroke());
                         g2d.setColor(colorSano);
                         if(n.infectado)g2d.setColor(colorInfectado);
                         g2d.fillOval((int)n.x, (int)n.y, (int)n.height, (int)n.width);
                         g2d.setColor(colorSanoSeleccionado);
                         g2d.setStroke(new java.awt.BasicStroke(4));
                         g2d.drawOval((int)n.x, (int)n.y, (int)n.height, (int)n.width);
                         n.yaFueDibujado=true;      
                    }
                    
                    
                    
                }
                
                g2d.setColor(colorSano);
             }
     
             g2d.fillOval((int)p.x, (int)p.y, (int)p.height, (int)p.width);
             
                
             if(p.tapabocas==true){
                g2d.setColor(Color.black);
                g2d.setStroke(contorno);
                g2d.drawOval((int)p.x, (int)p.y, (int)p.height, (int)p.width);
             }  
             
             if(p.seleccionado && !p.infectado){
                 g2d.setColor(colorSanoSeleccionado);
                g2d.setStroke(new java.awt.BasicStroke(4));
                g2d.drawOval((int)p.x, (int)p.y, (int)p.height, (int)p.width);
             }
             
                
            }
             

          // g2d.setColor(Color.black);
          // g2d.drawString(p.getIdString(), (int)p.x+(int)p.height/2, (int)p.y+(int)p.height/2);
            
             p = p.nextNodo;
        }while(p!=null);
        
        p = iteracion.firstNodo;
        do{
            p.yaFueDibujado=false;
            p=p.nextNodo;
        }while(p!=null);
        g2d.setColor(Color.black);
        //g2d.drawString("Iteración "+iteracion.num, 10, 10);

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
