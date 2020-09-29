/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadotrueque;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import static java.awt.Image.SCALE_SMOOTH;
import java.awt.PopupMenu;
import static java.awt.SystemColor.window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Clase JFrame que muestra el menu principal luego del login
 *
 * @author Gonzalo Astorga
 * @author Alonso Robledo
 * @since mercadotrueque 0.1
 */
public class JFMenu extends javax.swing.JFrame implements IEstados, IVentanaEstatica{


    private int estado;// indica donde se diriguirá
    private boolean check;// indica si se ha realizado alguna accion
    
    public JFMenu() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        botonCerrar = new javax.swing.JLabel();
        botonBuscar = new javax.swing.JLabel();
        botonPublicar = new javax.swing.JLabel();
        bienvenido = new javax.swing.JLabel();
        botonPublicaciones = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelPublicidad = new javax.swing.JPanel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Menu Principal");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, -1, -1));

        botonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mercadotrueque/imgDefault.png"))); // NOI18N
        botonCerrar.setText("cerrar");
        botonCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCerrarMouseClicked(evt);
            }
        });
        getContentPane().add(botonCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 20, 100, 50));

        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mercadotrueque/imgDefault.png"))); // NOI18N
        botonBuscar.setText("buscar");
        botonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonBuscarMouseClicked(evt);
            }
        });
        getContentPane().add(botonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 100, 50));

        botonPublicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mercadotrueque/imgDefault.png"))); // NOI18N
        botonPublicar.setText("publicar");
        botonPublicar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonPublicarMouseClicked(evt);
            }
        });
        getContentPane().add(botonPublicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 200, 100, 50));

        bienvenido.setText("jLabel2");
        getContentPane().add(bienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        botonPublicaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mercadotrueque/imgDefault.png"))); // NOI18N
        botonPublicaciones.setText("publicaciones");
        botonPublicaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonPublicacionesMouseClicked(evt);
            }
        });
        getContentPane().add(botonPublicaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 400, 150, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mercadotrueque/imgDefault.png"))); // NOI18N
        jLabel2.setText("ConfigDatos");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, -1, -1));
        getContentPane().add(panelPublicidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 550, 740, 130));
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Accion de click en boton cerrar programa, indica que accedera a esa
     * opcion y que ha realizado una accion
     *
     * @since mercadotrueque 0.1
     */
    private void botonCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCerrarMouseClicked
        estado=EXIT;
        check=true;
    }//GEN-LAST:event_botonCerrarMouseClicked
    /**
     * Accion de click en boton formulario, indica que accedera a esa opcion y que ha realizado una accion
     * 
     * @since mercadotrueque 0.1
     */
    private void botonPublicarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonPublicarMouseClicked
        estado=FORMULARIO;
        check=true;
    }//GEN-LAST:event_botonPublicarMouseClicked
    /**
     * Accion de click en boton historialPublicaciones, indica que accedera a esa opcion y que ha realizado una accion
     * 
     * @since mercadotrueque 0.1
     */
    private void botonPublicacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonPublicacionesMouseClicked
        estado=HISTORIALPUBLICACIONES;
        check=true;
    }//GEN-LAST:event_botonPublicacionesMouseClicked
    /**
     * Accion de click en boton busqueda, indica que accedera a esa opcion y que ha realizado una accion
     * 
     * @since mercadotrueque 0.1
     */
    private void botonBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBuscarMouseClicked
        estado=BUSQUEDA;
        check=true;
    }//GEN-LAST:event_botonBuscarMouseClicked
    /**
     * Accion de click en boton configuracion, indica que accedera a esa opcion y que ha realizado una accion
     * 
     * @since mercadotrueque 0.1
     */
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        estado=CONFIGURACION;
        check=true;
    }//GEN-LAST:event_jLabel2MouseClicked


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
            java.util.logging.Logger.getLogger(JFMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bienvenido;
    private javax.swing.JLabel botonBuscar;
    private javax.swing.JLabel botonCerrar;
    private javax.swing.JLabel botonPublicaciones;
    private javax.swing.JLabel botonPublicar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel panelPublicidad;
    // End of variables declaration//GEN-END:variables
    /**
     * Inicializa posicion y visual de ventana, 
     * 
     * @param nickname nombre de usuario
     * @since mercadotrueque 0.1
     */
    public void start() {
        if(!this.isVisible())   this.setLocationRelativeTo(null);
        this.setVisible(true);
        check=false;
        
    }
    public void setInfo(String nickname){
        bienvenido.setText("Bienvenido "+nickname);
    }
     /**
     * Retorna valor de estado que indica que accion se realizo
     * 
     * @return valor de estado que indica que accion se realizo
     * @since mercadotrueque 0.1
     */
    public int getEstado(){
        return estado;
    }
    /**
     * Retorna estado de atributo check
     * 
     * @return estado de atributo check
     * @since mercadotrueque 0.1
     */
    public boolean isCheck(){
        return check;
    }
    /**
     * asigna un valor a atributo check que indica si se ah realizado alguna accion
     * 
     * @param valor se asigna al atributo check
     * @since mercadotrueque 0.1
     */
    public void setCheck(boolean valor){
        check=valor;
    }
    /**
     * Cierra ventana
     * 
     * @since mercadotrueque 0.1
     */
    public void cerrarVentana() {
        this.dispose();
    }

    public void crearBanner(BannerPublicitario banner) {
        
        //cosa.setText(banner.getTitulo());
        JButton boton=new JButton();
        boton.setPreferredSize(new Dimension(740, 120));
        ImageIcon imagen = new ImageIcon(banner.getNombreImagen());
        boton.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(740, 120, SCALE_SMOOTH)));
        // configuro cursor
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        ActionListener action = interactividadPublicidadClienteEmpresa(banner.getLink());
        boton.addActionListener(action);
        panelPublicidad.add(boton);
    }

    private ActionListener interactividadPublicidadClienteEmpresa(String link) {
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                URL url=null;
                try {
                    url = new URL(link);
                    try {
                        Desktop.getDesktop().browse(url.toURI());
                    } catch (IOException | URISyntaxException e) {
                        System.out.println("error de lectura de link");
                    }
                } catch (MalformedURLException e1) {
                    System.out.println("error en obtener link");
                }
            }
        };
        return action;
    }

    public void destruirPublicidadCliente() {
        panelPublicidad.remove(0);
    }
}
