/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadotrueque;

import java.awt.HeadlessException;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase JFrame de informacion de Aviso desde lisat de avisos
 *
 * @author Gonzalo Astorga
 * @author Alonso Robledo
 * @since mercadotrueque 0.1
 */
public class JFAviso extends javax.swing.JFrame {

    private Aviso avisoActual;
    private Usuario usuarioActual;
    private String nuevoDescripcionComentario;
    private Integer notaComentario;

    public JFAviso() {
        initComponents();
    }

    /**
     * Retorna descripcion de Comentario creado en el aviso
     *
     * @return descripcion de Comentario creado en el aviso
     * @since mercadotrueque 0.4
     */
    public String getDescripcionComentario() {
        return nuevoDescripcionComentario;
    }

    /**
     * Retorna nota de Comentario creado en el aviso
     *
     * @return nota de Comentario creado en el aviso
     * @since mercadotrueque 0.4
     */
    public int getNotaComentario() {
        return notaComentario;
    }

    /**
     * Inicializa posicion y visualizacion de ventana
     *
     * @since mercadotrueque 0.1
     */
    public void start() {
        if (!this.isVisible()) {
            this.setLocationRelativeTo(null);
        }
        this.setVisible(true);
    }

    /**
     * Asigna valores de los datos traspasados necesarios para el funcionamiento
     *
     * @param aviso aviso actual
     * @param usuarioActual suaurio actual
     * @since mercadotrueque 0.4
     */
    public void setInfo(Aviso aviso, Usuario usuarioActual) {
        //obtenemos el usuario actual
        this.usuarioActual = usuarioActual;
        avisoActual = aviso;
        //actualizamos el texto que se mostrara en la ventana
        textTitulo.setText(avisoActual.getTitulo());
        textDescripcion.setText("<html>" + avisoActual.getDescripcion());
        textPublicador.setText("Publicador :   " + avisoActual.getNicknamePublicador());
        textAlonsoCoin.setText("Alonso Coin   < " + avisoActual.getAlonsoCoin() + " >");
        textPrecio.setText("Precio :   $ " + avisoActual.getPrecio());
        textRegion.setText("Region : " + conversionRegion(avisoActual.getRegion()));
        // obtenemos comentarios del aviso y lo asignamos
        if (avisoActual.getComentarios() != null) {
            textComentarios.setText(getTextoComentarios(avisoActual.getComentarios()));
        }
        //vemos la visibilidad del moton MOD (modificar comentario)
        if (puedeUserActualComentarAviso()) {
            botonModComentario.setVisible(false);
        } else {
            botonModComentario.setVisible(true);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelComentarios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textComentarios = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        botonComentar = new javax.swing.JLabel();
        botonModComentario = new javax.swing.JLabel();
        botonTrueque = new javax.swing.JLabel();
        botonCompra = new javax.swing.JLabel();
        textTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        textDescripcion = new javax.swing.JLabel();
        bgDescripcion = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        textPublicador = new javax.swing.JLabel();
        textAlonsoCoin = new javax.swing.JLabel();
        textPrecio = new javax.swing.JLabel();
        textRegion = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelComentarios.setBackground(new java.awt.Color(51, 0, 153));

        textComentarios.setEditable(false);
        textComentarios.setColumns(20);
        textComentarios.setRows(5);
        jScrollPane1.setViewportView(textComentarios);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Comentarios");

        botonComentar.setForeground(new java.awt.Color(255, 255, 255));
        botonComentar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mas.png"))); // NOI18N
        botonComentar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonComentarMouseClicked(evt);
            }
        });

        botonModComentario.setForeground(new java.awt.Color(255, 255, 0));
        botonModComentario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mercadotrueque/imgDefault2.png"))); // NOI18N
        botonModComentario.setText("MOD");
        botonModComentario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonModComentarioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelComentariosLayout = new javax.swing.GroupLayout(panelComentarios);
        panelComentarios.setLayout(panelComentariosLayout);
        panelComentariosLayout.setHorizontalGroup(
            panelComentariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComentariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelComentariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelComentariosLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelComentariosLayout.createSequentialGroup()
                        .addComponent(botonModComentario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(74, 74, 74)
                        .addComponent(botonComentar)
                        .addGap(23, 23, 23))))
        );
        panelComentariosLayout.setVerticalGroup(
            panelComentariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelComentariosLayout.createSequentialGroup()
                .addGroup(panelComentariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelComentariosLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2))
                    .addGroup(panelComentariosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelComentariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonModComentario)
                            .addComponent(botonComentar))))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(panelComentarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 380, 460));

        botonTrueque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mercadotrueque/imgDefault.png"))); // NOI18N
        botonTrueque.setText("Trueque");
        getContentPane().add(botonTrueque, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, -1, -1));

        botonCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mercadotrueque/imgDefault.png"))); // NOI18N
        botonCompra.setText("Compra");
        getContentPane().add(botonCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 610, -1, -1));

        textTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textTitulo.setText("tituloAviso");
        getContentPane().add(textTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 340, -1));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textDescripcion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        textDescripcion.setText("asdf");
        textDescripcion.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(textDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 260, 228));

        bgDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        bgDescripcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mercadotrueque/imgDefault2.png"))); // NOI18N
        jPanel1.add(bgDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 290));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 310, 290));

        jPanel2.setBackground(new java.awt.Color(153, 255, 204));

        textPublicador.setText("publicador=");

        textAlonsoCoin.setText("alonsoCoin=");

        textPrecio.setText("precio=");

        textRegion.setText("region = Aysen del Gral.C.Ibañez del Campo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textRegion, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                    .addComponent(textPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textAlonsoCoin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textPublicador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(textPublicador)
                .addGap(30, 30, 30)
                .addComponent(textAlonsoCoin)
                .addGap(34, 34, 34)
                .addComponent(textPrecio)
                .addGap(28, 28, 28)
                .addComponent(textRegion)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, 380, 230));
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Verifica si ya existe algun comentario en el aviso actual
     *
     * @return si ya a comentario el suaurio actual en este aviso
     * @since mercadotrueque 0.4
     */
    private boolean puedeUserActualComentarAviso() {
        ArrayList<Comentario> listaComentarios = avisoActual.getComentarios();
        boolean puedeComentar = true;
        //recorremos los comentarios del aviso
        for (int i = 0; puedeComentar == true && i < listaComentarios.size(); i++) {
            // si concuerda el nickname de algun comentario con el nickname del usuario actual significara que no puede comentar
            if (listaComentarios.get(i).getNombreUsuarioComentante().equals(usuarioActual.getNickname())) {
                puedeComentar = false;
            }
        }
        return puedeComentar;
    }

    /**
     * Accion al pulsar boton de comentar
     *
     * @since mercadotrueque 0.4
     */
    private void botonComentarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonComentarMouseClicked
        comentarAviso();
    }//GEN-LAST:event_botonComentarMouseClicked
    /**
     * Acciones al accionar boton comentar, puede agregar comentario en caso de
     * no haber comentado en el aviso
     *
     * @since mercadotrueque 0.4
     */
    private void comentarAviso() throws NumberFormatException, HeadlessException {
        if (!avisoActual.getNicknamePublicador().equals(usuarioActual.getNickname())) {
            //verificamos si ya comento para poder o no comentar
            if (puedeUserActualComentarAviso()) {
                nuevoDescripcionComentario = JOptionPane.showInputDialog(null, "Ingrese su comentario.");
                if (nuevoDescripcionComentario != null) {
                    //obtenemos nota de comentario
                    notaComentario = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su puntuacion."));
                    if (notaComentario != null && notaComentario <= 10 && notaComentario >= 1) {///////////////////////////////////////////////////exception
                        Comentario nuevoComentario = avisoActual.addComentario(nuevoDescripcionComentario, notaComentario, usuarioActual.getNickname());
                        setInfo(avisoActual, usuarioActual);
                        //JSONObject jComentario = HandlerJson.encode(nuevoComentario);
                        //HandlerJson.push(jComentario, avisoActual,HandlerJson.init("src\\mercadotrueque\\datos.json"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Numero invalido rango [1,10]");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "ya has comentario en esta publicacion");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No puedes comentar en tu propio aviso");
        }
    }

    /**
     * Accion de pulsar Modificar comentario
     *
     * @since mercadotrueque 0.4
     */
    private void botonModComentarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonModComentarioMouseClicked
        modificarComentario();
    }//GEN-LAST:event_botonModComentarioMouseClicked
    /**
     * Acciones al hacer click en boton modificar, visible solo si ya ah
     * comentado modificará descrpcion y nota de comentario
     *
     * @since mercadotrueque 0.4
     */
    private void modificarComentario() throws HeadlessException, NumberFormatException {
        String descripcionModidicada = null;
        Integer puntuacionModificada = null;
        // obtenemos nueva descripcion del comentario
        do {
            descripcionModidicada = JOptionPane.showInputDialog(null, "Ingrese su comentario.");
        } while (descripcionModidicada == null);
        //obtenemos nueva puntuacion a la publicacion
        do {
            puntuacionModificada = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su puntuacion."));
        } while (puntuacionModificada == null);
        //actualizamos estos datos y lo refrescamos visualmente en la ventana
        actualizarModificacionComentario(descripcionModidicada, puntuacionModificada);
    }

    /**
     * Actualiza la informacion de comentarios que se mostrará visualmente en la
     * ventana
     *
     * @since mercadotrueque 0.4
     */
    private void actualizarModificacionComentario(String descripcionModidicada, Integer puntuacionModificada) {
        ArrayList<Comentario> listaComentarios = avisoActual.getComentarios();
        Comentario comentarioModificar = null;
        //recorremos la lista de comentarios
        for (int i = 0; comentarioModificar == null && i < listaComentarios.size(); i++) {
            if (listaComentarios.get(i).getNombreUsuarioComentante().equals(usuarioActual.getNickname())) {
                comentarioModificar = listaComentarios.get(i);
            }
        }
        // agregamos los datos modificandolo
        comentarioModificar.setComentarioDescripcion(descripcionModidicada);
        comentarioModificar.setPuntuacion(puntuacionModificada);
        //  actualizamos el texto de la ventana
        textComentarios.setText(getTextoComentarios(avisoActual.getComentarios()));
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
            java.util.logging.Logger.getLogger(JFAviso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFAviso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFAviso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFAviso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFAviso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bgDescripcion;
    private javax.swing.JLabel botonComentar;
    private javax.swing.JLabel botonCompra;
    private javax.swing.JLabel botonModComentario;
    private javax.swing.JLabel botonTrueque;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelComentarios;
    private javax.swing.JLabel textAlonsoCoin;
    private javax.swing.JTextArea textComentarios;
    private javax.swing.JLabel textDescripcion;
    private javax.swing.JLabel textPrecio;
    private javax.swing.JLabel textPublicador;
    private javax.swing.JLabel textRegion;
    private javax.swing.JLabel textTitulo;
    // End of variables declaration//GEN-END:variables
    /**
     * Retorna texto de comentarios del aviso
     *
     * @return texto de comentarios del aviso
     * @since mercadotrueque 0.3
     */
    private String getTextoComentarios(ArrayList<Comentario> comentarios) {
        String textoFull = "";
        // recorremos los comentarios
        for (int i = 0; i < comentarios.size(); i++) {
            //obtenemos Comentario
            Comentario cActual = comentarios.get(i);
            // creamos un formato de informacion y agregamos al texto a retornar
            textoFull += "-#" + (i + 1) + " " + cActual.getComentarioDescripcion() + "\n---Puntaje [ " + cActual.getPuntuacion() + " ]_________________Usuario: " + cActual.getNombreUsuarioComentante() + ".\n\n";
        }
        return textoFull;
    }

    /**
     * Realiza una conversion entre region numerica y nombre de region (String)
     *
     * @return nombre de region
     * @since mercadotrueque 0.2
     */
    private String conversionRegion(int region) {
        String nombreRegion = null;
        switch (region) {
            case 0: {
                nombreRegion = "Todo chile";
                break;
            }
            case 1: {
                nombreRegion = "Arica y Parinacota";
                break;
            }
            case 2: {
                nombreRegion = "Tarapacá";
                break;
            }
            case 3: {
                nombreRegion = "Antofagasta";
                break;
            }
            case 4: {
                nombreRegion = "Atacama";
                break;
            }
            case 5: {
                nombreRegion = "Coquimbo";
                break;
            }
            case 6: {
                nombreRegion = "Valparaíso";
                break;
            }
            case 7: {
                nombreRegion = "M. de Santiago";
                break;
            }
            case 8: {
                nombreRegion = "Lib.Gral.B.O´Higgins";
                break;
            }
            case 9: {
                nombreRegion = "Maule";
                break;
            }
            case 10: {
                nombreRegion = "Ñuble";
                break;
            }
            case 11: {
                nombreRegion = "Biobío";
                break;
            }
            case 12: {
                nombreRegion = "La Araucanía";
                break;
            }
            case 13: {
                nombreRegion = "Los Ríos";
                break;
            }
            case 14: {
                nombreRegion = "Los Lagos";
                break;
            }
            case 15: {
                nombreRegion = "Aysen del Gral.C.Ibañez del Campo";
                break;
            }
            case 16: {
                nombreRegion = "Magallanes y la Antártica Chilena";
                break;
            }
        }
        return nombreRegion;
    }
}
