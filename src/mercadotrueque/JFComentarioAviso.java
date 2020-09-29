/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadotrueque;

import java.util.ArrayList;

/**
 * Clase JFrame de muestra comentarios,valoracion y quienes comentan tal aviso
 *
 * @author Gonzalo Astorga
 * @author Alonso Robledo
 * @since mercadotrueque 0.2
 */
public class JFComentarioAviso extends javax.swing.JFrame {

    public JFComentarioAviso() {
        initComponents();
        if (!this.isVisible()) {
            this.setLocationRelativeTo(null);
        }
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        c = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("comentario y valoracoin");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        areaTexto.setEditable(false);
        areaTexto.setColumns(20);
        areaTexto.setRows(5);
        c.setViewportView(areaTexto);

        getContentPane().add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 700, 340));
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 841, 484));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(JFComentarioAviso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFComentarioAviso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFComentarioAviso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFComentarioAviso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFComentarioAviso().setVisible(true);
            }
        });
    }

    /**
     * Ingresa datos necesarios para actualizar visualmente la informacion
     *
     * @param avisoActual aviso actual
     * @since mercadotrueque 0.2
     */
    public void ingresoInfo(Aviso avisoActual) {
        //verificamos que existan comentarios
        if (avisoActual.getComentarios() != null) {
            //obtenemos lista de comentarios
            ArrayList<Comentario> comentario = avisoActual.getComentarios();
            //comenzamos a cerar un formato de texto
            String linea = "";
            for (int i = 0; i < comentario.size(); i++) {
                Comentario ComentarioActual = (Comentario) comentario.get(i);
                linea += "";
                linea += "comentario : " + ComentarioActual.getComentarioDescripcion();
                linea += "\n";
                linea += "nickname : " + ComentarioActual.getNombreUsuarioComentante() + "  |  puntuacion : [" + ComentarioActual.getPuntuacion() + "]";
                linea += "\n";
                linea += "\n";
            }
            // finalmente lo agregamos al texto que se mostrara por ventana
            areaTexto.setText(linea);
        } else {
            areaTexto.setText("Sin comentarios.");
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JLabel bg;
    private javax.swing.JScrollPane c;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
