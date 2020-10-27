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
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    
    
    private static void addComponentsToPane(Container pane, Lab2_HenryCaicedo_BreynnerHurtado_ElianaVelasquez sim) {
        
        
        
        //PANEL IZQUIERDO  
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(340, 600));
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
                        if(sim.numNodos>=2){
                        sim.numNodos--;                       
                        }
                        
                    jlbNumNodos.setText(Integer.toString(sim.numNodos));    
                    }
                }); 
                
                jbMenos10.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(sim.numNodos>=11){
                        sim.numNodos=sim.numNodos-10; 
                        
                        }else{
                            sim.numNodos=1;
                        }
                    jlbNumNodos.setText(Integer.toString(sim.numNodos));
                    }
                }); 
                
                jbMas1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        sim.numNodos++; 
                        jlbNumNodos.setText(Integer.toString(sim.numNodos));
                    }
                }); 
                
                jbMas10.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        sim.numNodos=sim.numNodos+10;
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
               contenidoMascarilla.add(rbConMascarilla);
               contenidoMascarilla.add(rbSinMascarilla);
               contenidoMascarilla.add(rbAleatorio);
               
               //Botón de iniciar
               JPanel panel7 = new JPanel();
               JLabel jlbFuenteIniciar = new JLabel();
               jlbFuenteIniciar.setFont(new Font("Arial", Font.PLAIN, 19));

               JButton jbIniciar = new JButton("Iniciar simulación");
               
               jbIniciar.setFont(jlbFuenteIniciar.getFont());
               panel7.add(jbIniciar);
               panel7.setPreferredSize(new Dimension(310, 55));

               jbIniciar.setPreferredSize(new Dimension(310, 50));
               hGroup.addComponent(panel7);
                vGroup.addComponent(panel7, GroupLayout.PREFERRED_SIZE,
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
        
        ShapePanel shapePanel = new ShapePanel(sim.firstIteracion);

        
        margen.add(shapePanel);
              
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
     
        pane.add(leftPanel, "West");
        pane.add(rightPanel, "East");
        
        //Paginación
        JPanel paginacion = new JPanel(new GridLayout(1,3));
        paginacion.setPreferredSize(new Dimension(704, 69));
        paginacion.setBorder(BorderFactory.createLineBorder(Color.gray));
        rightPanel.add(paginacion, BorderLayout.SOUTH);
        JPanel jpIzq = new JPanel();
        JPanel jpDer = new JPanel();
        //Barra de reproducción
        JPanel jpMediaControl = new JPanel(new GridLayout(1,3));
        JButton jbAnterior = new JButton("<");
        JButton jbPlayPause = new JButton("D");
        JButton jbSiguiente = new JButton(">");
        jpMediaControl.add(jbAnterior);
        jpMediaControl.add(jbPlayPause);
        jpMediaControl.add(jbSiguiente);
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
                                        System.out.println("ENTRÓ AL CONDICIONAAAAAAL");
                                        margen.remove(shapePanel2);
                                    }else{
                                        System.out.println("ENTRÓ AL ELSEEEEEEEEE");
                                    }
                                    margen.add(shapePanel2);
                                    margen.revalidate();
                                    margen.repaint();
                                    shapePanel.revalidate();
                                    shapePanel.repaint();
                                    
                                    }
                                 }
                            }); 
        
         //ACTION LISTENER MEDIA 
        jbSiguiente.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        
                            System.out.println("mostrarIteracion: "+sim.mostrarIteracion);
                        
                                    if(sim.mostrarIteracion<sim.getNumIteraciones()){
                                     margen.remove(shapePanel);
                                    
                                    if(shapePanel2 != null){
                                        margen.remove(shapePanel2);
                                    }
                                    
                                    sim.mostrarIteracion++;
                                    
                                    shapePanel2 = new ShapePanel(sim.getIteracion(sim.mostrarIteracion));
                                    System.out.println("Iteracion "+sim.getIteracion(sim.mostrarIteracion).num);
                                    
                                    if(shapePanel2.getParent() == margen){   
                                        margen.remove(shapePanel2);
                                    }
                                    
                                    margen.add(shapePanel2);
                                    margen.revalidate();
                                    margen.repaint();
                                    shapePanel.revalidate();
                                    shapePanel.repaint();
                                    
                                    
                                    }
                                    
                                    
                        
                    }
                }); 
        
        
        //ACTION LISTENER ANTERIOR ITERACIÓN
        jbAnterior.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if(sim.mostrarIteracion>1){
                                    margen.remove(shapePanel);
                                    
                                    if(shapePanel2 != null){
                                        margen.remove(shapePanel2);
                                    }
                                    
                                    sim.mostrarIteracion--;
                                    
                                    shapePanel2 = new ShapePanel(sim.getIteracion(sim.mostrarIteracion));
                                    System.out.println("Iteracion "+sim.getIteracion(sim.mostrarIteracion).num);
                                    
                                    if(shapePanel2.getParent() == margen){   
                                        margen.remove(shapePanel2);
                                    }
                                    margen.add(shapePanel2);
                                    margen.revalidate();
                                    margen.repaint();
                                    shapePanel.revalidate();
                                    shapePanel.repaint();
                                    
                                    }
                                }
                            }); 
        

        
        //ACTION LISTENER PLAY/PAUSE
        jbPlayPause.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    
                                   
                                    
                                    }
                              //  }
                            }); 
        
    }
    
    
    
    
    
    static class ShapePanel extends JPanel {
        
        

    private Dimension dim = new Dimension(anchoSim, altoSim);
    Iteracion iteracion;

 
    public ShapePanel(Iteracion iteracion) {
         
        this.iteracion=iteracion;


        addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                Nodo p = iteracion.firstNodo;
                do{                  
                    //Revisa si se hizo clic dentro del área del círculo
                    if (p.contains(me.getPoint())) {                      
                        System.out.println(p.id+": ("+p.x+","+p.y+")");
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
        
        addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered( MouseEvent me ) {
                super.mouseEntered(me);
                Nodo p = iteracion.firstNodo;
                do{                  
                    //Revisa si se hizo clic dentro del área del círculo
                    if (p.contains(me.getX(), me.getY())) {                      
                        System.out.println("Mouse dentro de "+p.id);                 
                    }
                    p = p.nextNodo;                 
                }while(p!=null);             
            }        
        });
        
        
        
        addMouseListener(new MouseAdapter() {
            
            @Override
                public void mouseMoved(MouseEvent me) {
                    System.out.println("lol");
                    
                        Nodo p = iteracion.firstNodo;
                    
                        int mx = me.getX();
                        int my = me.getY();
                        
                        do{ 
                        if (mx > p.x && mx < p.x + p.width && my > p.y
                                && my < p.y + p.height) {
                            System.out.println("yes");
                        } else {
                            System.out.println("no");
                        }
                            p = p.nextNodo;                 
                    }while(p!=null);  
                        
                }
                   
        });
        
       
        /*
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
        */
        //setBorder(BorderFactory.createLineBorder(Color.red));

        setBackground(Color.WHITE);
        
        /*
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
        */
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
   
        do{
             if(p.infectado==true){
             g2d.setColor(colorInfectado);
             }else{
                 g2d.setColor(colorSano);
             }
             g2d.fillOval((int)p.x, (int)p.y, (int)p.height, (int)p.width);
             g2d.setColor(Color.black);
             g2d.setStroke(new java.awt.BasicStroke(3));
             if(p.tapabocas==true){
             g2d.drawOval((int)p.x, (int)p.y, (int)p.height, (int)p.width);
             }
                          //g2d.setColor(Color.red);

            //g2d.drawString(p.getIdString(), (int)p.x+(int)p.height/2, (int)p.y+(int)p.height/2);
            
            

     
  
            
             p = p.nextNodo;
        }while(p!=null);
        
       g2d.drawString("Iteración "+iteracion.num, 20, 40);

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
