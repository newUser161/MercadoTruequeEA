/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadotrueque;

/**
 * Clase JFrame que muestra campos para modificar la informacion del aviso
 * publicado
 *
 * @author Gonzalo Astorga
 * @author Alonso Robledo
 * @since mercadotrueque 0.4
 */
public class JFMofidicarAviso extends javax.swing.JFrame {

    private Aviso avisoMod;
    private boolean salir;

    public JFMofidicarAviso() {
        initComponents();
        if (!this.isVisible()) {
            this.setLocationRelativeTo(null);
        }
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcionMod = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        tituloMod = new javax.swing.JTextField();
        precioMod = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        alonsoCoinMod = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        categoriaMod = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        regionMod = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("titulo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 50, -1, -1));

        jLabel2.setText("descripcion");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 93, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Aviso Actual");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        jLabel4.setText("precio");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, -1, -1));

        jLabel5.setText("alonsoCoin");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 305, -1, -1));

        jLabel6.setText("categoria");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, -1, -1));

        jLabel7.setText("region");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, -1, -1));

        descripcionMod.setColumns(20);
        descripcionMod.setRows(5);
        jScrollPane1.setViewportView(descripcionMod);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 116, 391, 163));

        jButton1.setText("Modificar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 580, 160, 60));
        jPanel1.add(tituloMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 47, 250, -1));
        jPanel1.add(precioMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 120, -1));

        alonsoCoinMod.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(alonsoCoinMod);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 302, 70, 60));

        categoriaMod.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Computacion", "Moda", "Vehiculo", "Hogar", "Arte" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(categoriaMod);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 120, 60));

        regionMod.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Todas las regiones", "Arica y Parinacota", "Tarapacá", "Antofagasta", "Atacama", "Coquimbo", "Valparaíso", "Metropolitana de Santiago", "Libertador Gral.Bernardo O´Higgins", "Maule", "Ñuble", "Biobío", "La Araucanía", "Los Ríos", "Los Lagos", "Aysen del Gral. Carlos Ibañez del Campo", "Magallanes y la Antártica Chilena" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(regionMod);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 240, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Obtiene los valores de los campos e indica que esta listo para salir y
     * cierra la ventana
     *
     * @since mercadotrueque 0.4
     */
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        avisoMod.setTitulo(tituloMod.getText());
        avisoMod.setDescripcion(descripcionMod.getText());
        avisoMod.setAlonsoCoin(alonsoCoinMod.getSelectedIndex() + 1);
        avisoMod.setPrecio(Integer.parseInt(precioMod.getText()));
        avisoMod.setRegion(regionMod.getSelectedIndex());
        avisoMod.setCategoria(categoriaMod.getSelectedValue());
        salir = true;
        this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(JFMofidicarAviso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFMofidicarAviso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFMofidicarAviso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFMofidicarAviso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFMofidicarAviso().setVisible(true);
            }
        });
    }

    /**
     * Asigna valores a los textos de cada campo la ventana
     *
     * @param aviso aviso actual
     * @since mercadotrueque 0.4
     */
    public void setInfo(Aviso aviso) {//Aviso avisomod
        // obtengo el aviso completo
        this.avisoMod = avisoMod;
        // asigno el texto a cada campo
        tituloMod.setText(aviso.getTitulo());
        descripcionMod.setText(aviso.getDescripcion());
        alonsoCoinMod.setSelectedIndex(aviso.getAlonsoCoin() - 1);
        precioMod.setText(aviso.getPrecio() + "");
        regionMod.setSelectedIndex(aviso.getRegion());
        categoriaMod.setSelectedIndex(categoriaParse(aviso.getCategoria()));
        avisoMod = aviso;
        // indico que al comenzar no estoy listo para salir ya que no he realizado ninguna accion aun
        salir = false;
    }

    /**
     * Retorna estado de salir que indica si esta listo para salir de la ventana
     * o no
     *
     * @return estado de salir que indica si esta listo para salir de la ventana
     * o no
     * @since mercadotrueque 0.4
     */
    public boolean isSalir() {
        return salir;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> alonsoCoinMod;
    private javax.swing.JList<String> categoriaMod;
    private javax.swing.JTextArea descripcionMod;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField precioMod;
    private javax.swing.JList<String> regionMod;
    private javax.swing.JTextField tituloMod;
    // End of variables declaration//GEN-END:variables
    /**
     * Convierte region numerico en una cadena con el onmobre de la region
     *
     * @return nombre de region
     * @since mercadotrueque 0.4
     */
    private int categoriaParse(String categoria) {
        int numero = 0;
        switch (categoria) {
            case "Computacion": {
                numero = 0;
                break;
            }
            case "Moda": {
                numero = 1;
                break;
            }
            case "Vehiculo": {
                numero = 2;
                break;
            }
            case "Hogar": {
                numero = 3;
                break;
            }
            case "Arte": {
                numero = 4;
                break;
            }
        }
        return numero;
    }
}
