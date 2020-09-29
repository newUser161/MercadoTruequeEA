/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadotrueque;

import java.awt.Color;
import java.awt.Cursor;
import static java.awt.Image.SCALE_SMOOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * Clase JFrame de que muestra historial de las publicaciones del usuario actual
 *
 * @author Gonzalo Astorga
 * @author Alonso Robledo
 * @since mercadotrueque 0.2
 */
public class JFHistorialPublicaciones extends javax.swing.JFrame implements IModoHistorialPublicacion ,IVentanaEstatica{

    private boolean salir;
    private int estadoEliminar;
    private int modo;
    private int idAEliminar;
    private Aviso solicitudAvisoModificacion;
    private JFMofidicarAviso ventanaModificar;
    private int posicionX, posicionY, ancho, alto, offsetX, offsetY, cantidadX, count;

    public JFHistorialPublicaciones() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelAvisos = new javax.swing.JPanel();
        botonAtras = new javax.swing.JLabel();
        cosa = new javax.swing.JLabel();
        botonEliminar = new javax.swing.JLabel();
        botonVer = new javax.swing.JLabel();
        textModo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("historial Publicdad");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, -1, -1));

        panelAvisos.setBackground(new java.awt.Color(204, 255, 204));
        panelAvisos.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 30, 50));
        getContentPane().add(panelAvisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 1070, 450));

        botonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mercadotrueque/imgDefault.png"))); // NOI18N
        botonAtras.setText("Atras");
        botonAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAtrasMouseClicked(evt);
            }
        });
        getContentPane().add(botonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        cosa.setText("jLabel2");
        getContentPane().add(cosa, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 40, -1, -1));

        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mercadotrueque/imgDefault.png"))); // NOI18N
        botonEliminar.setText("Eliminar");
        botonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEliminarMouseClicked(evt);
            }
        });
        getContentPane().add(botonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 600, -1, -1));

        botonVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mercadotrueque/imgDefault.png"))); // NOI18N
        botonVer.setText("Ver");
        botonVer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonVerMouseClicked(evt);
            }
        });
        getContentPane().add(botonVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 600, -1, -1));

        textModo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        textModo.setText("jLabel2");
        getContentPane().add(textModo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 220, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mercadotrueque/imgDefault.png"))); // NOI18N
        jLabel2.setText("Modificar");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 600, -1, -1));
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAtrasMouseClicked
        salir = true;
    }//GEN-LAST:event_botonAtrasMouseClicked

    private void botonEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarMouseClicked
        modo = ELIMINAR;
        textModo.setText("Cual deseas Eliminar?");
    }//GEN-LAST:event_botonEliminarMouseClicked

    private void botonVerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonVerMouseClicked
        modo = VER;
        textModo.setText("Cual deseas Ver?");
    }//GEN-LAST:event_botonVerMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        modo = MODIFICAR;
        textModo.setText("Cual deseas Modificar?");
    }//GEN-LAST:event_jLabel2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFHistorialPublicaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFHistorialPublicaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFHistorialPublicaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFHistorialPublicaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFHistorialPublicaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel botonAtras;
    private javax.swing.JLabel botonEliminar;
    private javax.swing.JLabel botonVer;
    private javax.swing.JLabel cosa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel panelAvisos;
    private javax.swing.JLabel textModo;
    // End of variables declaration//GEN-END:variables
    /**
     * Inicia la visializacion y posicion de la ventana, inicia los valores
     * necesarios a atributos de la clase
     *
     * @since mercadotrueque 0.2
     */
    public void start() {
        // visualizacion y posicion
        if (!this.isVisible()) {
            this.setLocationRelativeTo(null);
        }
        this.setVisible(true);
        //posicion de los avisos
        posicionX = 50;
        posicionY = 50;
        ancho = 100;
        alto = 100;
        offsetX = 20;
        offsetY = 20;
        cantidadX = 4;
        // inicio de valores a variables
        salir = false;
        idEliminar = -1;
        count = 0;
        estadoEliminar = -1;
        modo = VER;
        idAEliminar = -1;
        solicitudAvisoModificacion = null;
        textModo.setText("Cual deseas Ver?");
        ventanaModificar = null;
    }

    /**
     * Asigna los valores necesarios para el funcionamiento de la ventana y para
     * visualizar la informacion
     *
     * @param AvisosUser lista de avisos publicados por usuario
     * @since mercadotrueque 0.2
     */
    public void setInfoHistorialPublicaciones(ArrayList AvisosUser) {
        //
        cosa.setText("Total Avisos = " + AvisosUser.size());
        //
        if (AvisosUser.isEmpty()) {
            //mostrar que no hay avisos 
        } else {
            for (int i = 0; i < AvisosUser.size(); i++) {
                Aviso aviso = (Aviso) AvisosUser.get(i);
                crearCuadro(aviso);
            }
        }
    }

    /**
     * Crea los cuadros/botones de las publicaciones del usuario actual
     *
     * @since mercadotrueque 0.2
     */
    private void crearCuadro(Aviso aviso) {
        // se crea boton
        JButton boton = crearBoton();
        //se agrega al panel
        panelAvisos.add(boton);
        //se genera el cuadro de texto con titulo del aviso
        textoBoton(aviso, boton);
        //se crea y definen las interacciones
        ActionListener action = interactividadCuadroPublicidad(aviso);
        //se agrega la interaccion
        boton.addActionListener(action);
        //se actualiza visualmente el panel
        panelAvisos.updateUI();
    }

    /**
     * genera la interactividad del boton del aviso, se define las disintas
     * interactividad segun en que modo se encuentra la ventana
     *
     * @since mercadotrueque 0.2
     */
    private ActionListener interactividadCuadroPublicidad(Aviso aviso) {

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                switch (modo) {
                    case VER: {
                        abrirVentanAvisoPublicado(aviso);
                        break;
                    }
                    case ELIMINAR: {
                        eliminarAviso(aviso.getIdAviso());
                        break;
                    }
                    case MODIFICAR: {
                        abrirModificarAviso(aviso);
                        break;
                    }
                }
            }
        };
        return action;
    }

    /**
     * personaliza el cuadro de titulo dentro del panel de cada aviso
     *
     * @since mercadotrueque 0.2
     */
    private void textoBoton(Aviso aviso, JButton boton) {
        String texto = "";
        for (int i = 0; i < 20 && i < aviso.getTitulo().length(); i++) {
            texto += aviso.getTitulo().charAt(i);
        }
        boton.setText(texto);
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    /**
     * Se crea boton que esta inserto en el panel creado por cada aviso
     *
     * @since mercadotrueque 0.2
     */
    private JButton crearBoton() {
        // se crea boton
        JButton boton = new JButton();
        // se le asigna una imagen
        ImageIcon imagen = new ImageIcon("src/img/imgDefault.png");
        // se dimensiona la imagen
        boton.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(ancho, alto, SCALE_SMOOTH)));
        // se dimensiona el boton
        boton.setSize(ancho, alto);
        boton.setContentAreaFilled(false);
        //
        return boton;
    }

    /**
     * Asigna id de aviso que se desea elimnar y señala que esta listo para
     * salir
     *
     * @since mercadotrueque 0.3
     */
    private void eliminarAviso(int idAviso) {
        idAEliminar = idAviso;
        salir = true;
    }

    /**
     * Abre ventena de informacion de aviso
     *
     * @since mercadotrueque 0.3
     */
    private void abrirVentanAvisoPublicado(Aviso aviso) {
        JFVEntanaAvisoVistaPublicador ventanaAvisoPublicador = new JFVEntanaAvisoVistaPublicador();
        ventanaAvisoPublicador.setInfo(aviso);
    }

    /**
     * Actualiza la posicino donde estaran los cuadros de las publicaciones
     *
     * @since mercadotrueque 0.2
     */
    private void posicion() {
        posicionX += ancho * offsetX;
        // en caso de completar una fila
        if (count != 0 && cantidadX % count == 0) {
            posicionX = offsetX;
            posicionY += offsetY + alto;
        }
    }
    private int idEliminar;

    /**
     * Obtiene hash a eliminar
     *
     * @return hash a eliminar
     * @since mercadotrueque 0.2
     */
    public int getHashEliminar() {
        return idEliminar;
    }

    /**
     * Limpia pantalla
     *
     * @since mercadotrueque 0.2
     */
    public void clear() {
        panelAvisos.removeAll();
        idAEliminar = -1;
    }

    /**
     * Obtiene id de publicacion a eliminar
     *
     * @return id de publicacino que se desea eliminar
     * @since mercadotrueque 0.3
     */
    public int getIdEliminar() {
        return idAEliminar;
    }

    /**
     * Cierra ventana
     *
     * @since mercadotrueque 0.2
     */
    public void cerrarVentana() {
        //limpia la pantalla
        this.clear();
        // cierra ventana
        this.dispose();
    }

    /**
     * Abre ventena de modificacion de aviso
     *
     * @since mercadotrueque 0.4
     */
    private void abrirModificarAviso(Aviso aviso) {
        ventanaModificar = new JFMofidicarAviso();
        ventanaModificar.setInfo(aviso);
    }

    /**
     * Retorna solicitud de modificacion
     *
     * @return solicitud de modificacion
     * @since mercadotrueque 0.4
     */
    public Aviso getSolicitudAvisoModificacion() {
        return solicitudAvisoModificacion;
    }

    /**
     * Retorna si se ha creado una solicitud de modificacion de historial
     *
     * @return verdadero si existe solicitud de modificacion
     * @since mercadotrueque 0.4
     */
    public boolean isSolicitudUpdateHistorial() {
        if (ventanaModificar == null) {
            return false;
        }
        return ventanaModificar.isSalir();
    }

    /**
     * Cierro ventana
     *
     * @return valor de atributo salir,que indica si esta listo para salir de ventana
     * @since mercadotrueque 0.2
     */
    public boolean isSalir() {
        return salir;
    }
}
