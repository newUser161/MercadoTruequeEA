/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadotrueque;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Clase JFrame que muestra el menu de modoMaster donde se pude ver toda la
 * informacion de mercadotrueque
 *
 * @author Gonzalo Astorga
 * @author Alonso Robledo
 * @since mercadotrueque 0.1
 */
public class JFModoMaster extends javax.swing.JFrame implements IModoMaster ,IVentanaEstatica{

    private boolean salir;//indica si esta listo para salir
    private int estado; // indica estado de ventana
    private ArrayList<Aviso> coleccionAvisos;
    private ArrayList<Usuario> coleccionUsuarios;
    private ArrayList<String> listaHashUsuario;
    private String idUsuarioEliminar;
    private Integer idAvisoPublicado;
    private Integer idComentarioEliminar;

    public JFModoMaster() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        botonInfo = new javax.swing.JButton();
        botonEliminarPublicacion = new javax.swing.JButton();
        botonEliminarUsuario = new javax.swing.JButton();
        bg = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Modo Master");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        botonInfo.setText("Ver Info MercadoTrueque");
        botonInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonInfoMouseClicked(evt);
            }
        });
        botonInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInfoActionPerformed(evt);
            }
        });
        getContentPane().add(botonInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 250, 60));

        botonEliminarPublicacion.setText("Eliminar Publicacion");
        botonEliminarPublicacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEliminarPublicacionMouseClicked(evt);
            }
        });
        botonEliminarPublicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarPublicacionActionPerformed(evt);
            }
        });
        getContentPane().add(botonEliminarPublicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, 160, 60));

        botonEliminarUsuario.setText("Eliminar usuario");
        botonEliminarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEliminarUsuarioMouseClicked(evt);
            }
        });
        botonEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(botonEliminarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 160, 60));
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 420));

        jToggleButton1.setText("Eliminar comentario");
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 310, 180, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonInfoActionPerformed

    private void botonEliminarPublicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarPublicacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEliminarPublicacionActionPerformed

    private void botonEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEliminarUsuarioActionPerformed
    /**
     * Genera ventana de informe total e envia infromacion necesaria para su
     * funcionameinto
     *
     * @since mercadotrueque 0.3
     */
    private void botonInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonInfoMouseClicked
        JFInformeUsuarioPublicacion ventanaInforme = new JFInformeUsuarioPublicacion();
        ventanaInforme.start();
        ventanaInforme.addInfo(coleccionAvisos, coleccionUsuarios, listaHashUsuario);
    }//GEN-LAST:event_botonInfoMouseClicked
    /**
     * Elimina Usuario indicando id/correo
     *
     * @since mercadotrueque 0.3
     */
    private void botonEliminarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarUsuarioMouseClicked
        // obtengo id/correo de usaurio
        do {
            idUsuarioEliminar = JOptionPane.showInputDialog(null, "Ingresa correo de usuario a eliminar", null);
        } while (idUsuarioEliminar == null);
        // cambio estado
        estado = ELIMINAR_USUARIO;
        // indico que deseo salir para enviar solicitud
        salir = true;

    }//GEN-LAST:event_botonEliminarUsuarioMouseClicked
    /**
     * Elimina comentario pidiendo id de comentario
     *
     * @since mercadotrueque 0.3
     */
    private void botonEliminarPublicacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarPublicacionMouseClicked
        // pido id de comentario que deseo eliminar
        do {
            idAvisoPublicado = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa id de aviso a eliminar", null));
        } while (idAvisoPublicado == null);
        // aviso nuevo estado
        estado = ELIMINAR_AVISO;
        // aviso que deseo salir para la solicitud
        salir = true;
    }//GEN-LAST:event_botonEliminarPublicacionMouseClicked
    /**
     * Elimina comentario pidiendo id aviso e id
     *
     * @since mercadotrueque 0.3
     */
    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked
        //obtengo id aviso
        do {
            idAvisoPublicado = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa id publicacion", null));
        } while (idAvisoPublicado == null);
        //obtengo id comentario que deseo eliminar
        do {
            idComentarioEliminar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa id de comentario a eliminar", null));
        } while (idComentarioEliminar == null);
        //cambio estado
        estado = ELIMINAR_COMENTARIO;
        // aviso que deseo salir parala solicitud
        salir = true;
    }//GEN-LAST:event_jToggleButton1MouseClicked
    /**
     * Obtengo id de comentario que deseo eliminar
     *
     * @return id de comentario que deseo eliminar
     * @since mercadotrueque 0.3
     */
    public Integer getComentarioEliminar() {
        return idComentarioEliminar;
    }

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
            java.util.logging.Logger.getLogger(JFModoMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFModoMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFModoMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFModoMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFModoMaster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton botonEliminarPublicacion;
    private javax.swing.JButton botonEliminarUsuario;
    private javax.swing.JButton botonInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
    /**
     * Inicia valores de atributos, posicion y visualizacion de ventana
     *
     * @since mercadotrueque 0.3
     */
    public void start() {
        // inicio visualizacion y posicion
        if (!this.isVisible()) {
            this.setLocationRelativeTo(null);
        }
        this.setVisible(true);
        // inicio los valores a los atributos
        salir = false;
        idUsuarioEliminar = null;
        idAvisoPublicado = null;
        idComentarioEliminar = null;
        estado = SIN_ACCION;
    }

    /**
     * Retorna estado de atributo salir que indica si esta listo para salir
     *
     * @return atributo salir que indica si esta listo para salir
     * @since mercadotrueque 0.3
     */
    public boolean isSalir() {
        return salir;
    }

    /**
     * Asigna valores necesarios para el funcionamiento de la ventana
     *
     * @param coleccionAvisos coleccion de avisos
     * @param coleccionUsuarios coleccion de usuarios
     * @param listaHashUsuario lista hash7correos de los uusarios
     * @since mercadotrueque 0.3
     */
    public void setInfo(ArrayList<Aviso> coleccionAvisos, ArrayList<Usuario> coleccionUsuarios, ArrayList<String> listaHashUsuario) {
        this.coleccionAvisos = coleccionAvisos;
        this.coleccionUsuarios = coleccionUsuarios;
        this.listaHashUsuario = listaHashUsuario;
    }

    /**
     * Obtiene valor de estado
     *
     * @return valor de estado
     * @since mercadotrueque 0.3
     */
    public int getEstado() {
        return estado;
    }

    /**
     * Obtiene correo de usuario a eliminar
     *
     * @return correo de usuario a eliminar
     * @since mercadotrueque 0.3
     */
    public String getCorreoUsuarioEliminado() {
        return idUsuarioEliminar;
    }

    /**
     * Obtiene id de aviso a eliminar
     *
     * @return id de aviso a eliminar
     * @since mercadotrueque 0.3
     */
    public int getIdAvisoEliminar() {
        return idAvisoPublicado;
    }

    /**
     * Cierra ventana
     *
     * @since mercadotrueque 0.3
     */
    public void cerrarVentana() {
        this.dispose();
    }

}
