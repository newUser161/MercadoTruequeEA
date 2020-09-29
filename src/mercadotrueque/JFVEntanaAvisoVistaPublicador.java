/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadotrueque;

/**
 * Clase JFrame en mostrar Informacion de aviso publicado
 *
 * @author Gonzalo Astorga
 * @author Alonso Robledo
 * @since mercadotrueque 0.2
 */
public class JFVEntanaAvisoVistaPublicador extends javax.swing.JFrame {

    private Aviso avisoActual;

    public JFVEntanaAvisoVistaPublicador() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        descripcion = new javax.swing.JLabel();
        alonsoCoin = new javax.swing.JLabel();
        precio = new javax.swing.JLabel();
        region = new javax.swing.JLabel();
        botonComentario = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("titulo");
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 30, 420, -1));

        descripcion.setText("descripcion");
        descripcion.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 510, 130));

        alonsoCoin.setText("alonsoCoin");
        getContentPane().add(alonsoCoin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));

        precio.setText("precio");
        getContentPane().add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, -1, -1));

        region.setText("region");
        getContentPane().add(region, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, -1, -1));

        botonComentario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mercadotrueque/imgDefault.png"))); // NOI18N
        botonComentario.setText("Comentario y valoracion");
        botonComentario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonComentarioMouseClicked(evt);
            }
        });
        getContentPane().add(botonComentario, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, -1, -1));
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Accion para generar ventana que muestra lso comentarios del aviso
     *
     * @since mercadotrueque 0.2
     */
    private void botonComentarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonComentarioMouseClicked
        //abro ventana comentarios
        //le paso info avisoActual
        JFComentarioAviso ventana = new JFComentarioAviso();
        ventana.ingresoInfo(avisoActual);
    }//GEN-LAST:event_botonComentarioMouseClicked

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
            java.util.logging.Logger.getLogger(JFVEntanaAvisoVistaPublicador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFVEntanaAvisoVistaPublicador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFVEntanaAvisoVistaPublicador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFVEntanaAvisoVistaPublicador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFVEntanaAvisoVistaPublicador().setVisible(true);
            }
        });
    }

    /**
     * Asigna datos necesarios para el fincionamiento de la ventana
     *
     * @param aviso aviso actual que se desea ver informacion
     * @since mercadotrueque 0.2
     */
    public void setInfo(Aviso aviso) {
        avisoActual = aviso;
        titulo.setText(aviso.getTitulo());
        descripcion.setText("Descripcion : " + aviso.getDescripcion());
        alonsoCoin.setText("AlonsoCoin : " + aviso.getAlonsoCoin());
        precio.setText("Precio : " + aviso.getPrecio());
        region.setText("Region : " + aviso.getRegion());//luego que tenga el nombre de la region(recordar el "cualquier region"
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alonsoCoin;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel botonComentario;
    private javax.swing.JLabel descripcion;
    private javax.swing.JLabel precio;
    private javax.swing.JLabel region;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
