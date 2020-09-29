/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadotrueque;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Clase JFrame que muestra la informacion total de usuarios, avisos y
 * comentarios
 *
 * @author Gonzalo Astorga
 * @author Alonso Robledo
 * @since mercadotrueque 0.3
 */
public class JFInformeUsuarioPublicacion extends javax.swing.JFrame {

    public int nivelDeVision;
    private int totalComentarios;
    private ArrayList<Aviso> coleccionAvisos;
    private ArrayList<Usuario> coleccionUsuarios;
    private ArrayList<String> listaHashUsuario;
    private static final int NINGUNO = 0;
    private static final int USUARIO = 1;
    private static final int USUARIO_AVISO = 2;
    private static final int USUARIO_AVISO_COMENTARIO = 3;

    public JFInformeUsuarioPublicacion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        botonUAP = new javax.swing.JButton();
        botonUA = new javax.swing.JButton();
        botonU = new javax.swing.JButton();
        campoDeVision = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        texto.setEditable(false);
        texto.setColumns(20);
        texto.setRows(5);
        jScrollPane1.setViewportView(texto);

        jLabel1.setText("Informe MercadoTrueque");

        botonUAP.setText("Usuario-Aviso-Comentario");
        botonUAP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonUAPMouseClicked(evt);
            }
        });
        botonUAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonUAPActionPerformed(evt);
            }
        });

        botonUA.setText("Usuario -Aviso");
        botonUA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonUAMouseClicked(evt);
            }
        });

        botonU.setText("Usuario");
        botonU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonUMouseClicked(evt);
            }
        });

        campoDeVision.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        campoDeVision.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(botonU, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(botonUA, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(botonUAP, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(419, 419, 419)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
                            .addComponent(campoDeVision, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(campoDeVision)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonU, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(botonUAP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonUA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonUAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonUAPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonUAPActionPerformed
    /**
     * Accion para mostrar los 3 niveles (usuario,avisos,comentarios)
     *
     * @since mercadotrueque 0.3
     */
    private void botonUAPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonUAPMouseClicked
        nivelDeVision = USUARIO_AVISO_COMENTARIO;
        mostrarInfo();
        campoDeVision.setText("Nivel completo : Usuario->Aviso->Comentario     |   Total Usuarios [ " + (coleccionUsuarios.size() - 1) + " ] ---- Total Avisos [ " + coleccionAvisos.size() + " ] ---- Total Comentarios [ " + totalComentarios + " ]");
    }//GEN-LAST:event_botonUAPMouseClicked
    /**
     * Accion para mostrar los 2 niveles (usuario,avisos)
     *
     * @since mercadotrueque 0.3
     */
    private void botonUAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonUAMouseClicked
        nivelDeVision = USUARIO_AVISO;
        mostrarInfo();
        campoDeVision.setText("Nivel medio : Usuario->Aviso     |   Total Usuarios [ " + (coleccionUsuarios.size() - 1) + " ] ---- Total Avisos [ " + coleccionAvisos.size() + " ]");
    }//GEN-LAST:event_botonUAMouseClicked
    /**
     * Accion para mostrar primer nivel (usuarios)
     *
     * @since mercadotrueque 0.3
     */
    private void botonUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonUMouseClicked
        nivelDeVision = USUARIO;
        mostrarInfo();
        campoDeVision.setText("Nivel bajo : Usuario     |   Total Usuarios [ " + (coleccionUsuarios.size() - 1) + " ]");
    }//GEN-LAST:event_botonUMouseClicked

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
            java.util.logging.Logger.getLogger(JFInformeUsuarioPublicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFInformeUsuarioPublicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFInformeUsuarioPublicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFInformeUsuarioPublicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFInformeUsuarioPublicacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonU;
    private javax.swing.JButton botonUA;
    private javax.swing.JButton botonUAP;
    private javax.swing.JLabel campoDeVision;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea texto;
    // End of variables declaration//GEN-END:variables

    /**
     * asigna los datos que le llegan necesarios para funcionar
     *
     * @param coleccionAvisos coleccion de los avisos de la plataforma
     * @param coleccionUsuarios coleccion de los usuarios de la plataforma
     * @param listaHashUsuario lista de las claves hash/correos de los usuarios
     * @since mercadotrueque 0.3
     */
    public void addInfo(ArrayList<Aviso> coleccionAvisos, ArrayList<Usuario> coleccionUsuarios, ArrayList<String> listaHashUsuario) {
        this.coleccionAvisos = coleccionAvisos;
        this.coleccionUsuarios = coleccionUsuarios;
        this.listaHashUsuario = listaHashUsuario;
    }

    /**
     * Inicia la visualizacion y los valores de atributos de la clase
     *
     * @since mercadotrueque 0.3
     */
    public void start() {
        if (!this.isVisible()) {
            this.setLocationRelativeTo(null);
        }
        this.setVisible(true);
        nivelDeVision = NINGUNO;
        campoDeVision.setText("Selecciona tu campo de vision");
    }

    /**
     * Muestra la informacion por usuario y verifica si es necesario profundizar
     * en los niveles si fue solicitado
     *
     * @since mercadotrueque 0.3
     */
    public void mostrarInfo() {
        totalComentarios = 0;
        String textoFull = "";
        // se recorre lista hash de usuarios
        for (int i = 0; i < listaHashUsuario.size(); i++) {
            // se obtiene cada usuario
            Usuario userActual = (Usuario) coleccionUsuarios.get(i);
            // se verifica saltar el Master
            if (userActual.getCorreo().equals("mercadotrueque@gmail.com")) {
                continue;
            }
            // se genera lisya de los avisos de usuario
            ArrayList<Integer> listaHashAvisosUserActual = userActual.getAvisos();
            //imprimir info user
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
            textoFull += "------------------------------------------------------------------------------------------------------------------------\n||";
            System.out.println("<|°|>_Nickname : " + userActual.getNickname() + " | ID/correo : " + userActual.getCorreo());
            System.out.println("||");
            textoFull += "<|°|>_Nickname : " + userActual.getNickname() + " | ID/correo : " + userActual.getCorreo() + "\n||\n";
            // se verifica si se sigue a nivel mas profundo (avisos y comentarios)
            if (nivelDeVision == USUARIO_AVISO_COMENTARIO || nivelDeVision == USUARIO_AVISO) {
                textoFull += nivelPublicidad(listaHashAvisosUserActual, userActual);
            }
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
            System.out.println("");
            textoFull += "------------------------------------------------------------------------------------------------------------------------\n\n";
        }
        // se asigna el texto generado
        texto.setText(textoFull);
        // se actualiza la informacion asignada para ser visualizada en la ventana
        texto.updateUI();
    }

    /**
     * Genera texto del segundo nivel de vision (avisos)
     *
     * @since mercadotrueque 0.3
     */
    private String nivelPublicidad(ArrayList<Integer> listaHashAvisosUserActual, Usuario user) {
        String textoFull = "";
        // se verifica que la lista exista y no este vacia
        if (listaHashAvisosUserActual == null || listaHashAvisosUserActual.isEmpty()) {
            textoFull += "-Sin publicaciones actuales-\n";
            System.out.println("-Sin publicaciones actuales-");
        } else {
            System.out.println("---------Publicaciones-------___total : " + listaHashAvisosUserActual.size());
            textoFull += "---------Publicaciones-------___total : " + listaHashAvisosUserActual.size() + "\n";
            // se recorre la lista de avisos
            for (int j = 0; j < listaHashAvisosUserActual.size(); j++) {
                // se obtiene cada aviso
                Aviso avisoActual = (Aviso) coleccionAvisos.get(listaHashAvisosUserActual.get(j));
                // se verifica que pertenersca a dicho usuario, aunque no es estrictamente necesario
                if (avisoActual == null || !avisoActual.getIdPublicador().equals(user.getCorreo())) {
                    continue;
                }
                // se genera el texto
                System.out.println("_______Titulo :" + avisoActual.getTitulo() + " | ID :" + avisoActual.getIdAviso() + " | categoria : " + avisoActual.getCategoria() + " | Alonsocoin:" + avisoActual.getAlonsoCoin());
                textoFull += "_______Titulo :" + avisoActual.getTitulo() + " | ID :" + avisoActual.getIdAviso() + " | categoria : " + avisoActual.getCategoria() + " | Alonsocoin:" + avisoActual.getAlonsoCoin() + "\n";
                // se verifica si es necesario seguir profundizando a nivel de comentario
                if (nivelDeVision == USUARIO_AVISO_COMENTARIO) {
                    textoFull += nivelComentario(avisoActual);
                }
            }
        }
        return textoFull;
    }

    /**
     * Genera texto del tercer nivel de vision (comentarios)
     *
     * @since mercadotrueque 0.3
     */
    private String nivelComentario(Aviso avisoActual) {
        String textoFull = "";
        // se obtiene lista de comentarios del aviso
        ArrayList<Comentario> comentariosAvisoActual = avisoActual.getComentarios();
        // se verifica que la lista no se nula ni este vacia
        if (comentariosAvisoActual != null && !comentariosAvisoActual.isEmpty()) {
            // se genera cabecera
            System.out.println("____________________________Comentarios aviso : ");
            textoFull += "____________________________Comentarios aviso : \n";
            // se recorre lsita de comentario
            for (int k = 0; k < comentariosAvisoActual.size(); k++) {
                // se obtiene cada comentario
                Comentario comentarioActual = (Comentario) comentariosAvisoActual.get(k);
                // se genera texto
                System.out.println("______________ #" + (k + 1) + " Comentario : " + comentarioActual.getComentarioDescripcion() + " | Puntaje [ " + comentarioActual.getPuntuacion() + " ]---ID : [ " + comentarioActual.getIdComentario() + " ].");
                textoFull += "______________ #" + (k + 1) + " Comentario : " + comentarioActual.getComentarioDescripcion() + " | Puntaje [ " + comentarioActual.getPuntuacion() + " ]---ID : [ " + comentarioActual.getIdComentario() + " ].\n";
                totalComentarios++;
            }
            System.out.println("______________");
            textoFull += "______________\n";
        } else {
            System.out.println("------Aviso Sin comentario----");
            textoFull += "------Aviso Sin comentario----\n";
        }
        return textoFull;
    }

}
