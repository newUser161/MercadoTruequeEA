/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadotrueque;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 * Clase JFrame de formulario donde se puede crear una publicacion
 *
 * @author Gonzalo Astorga
 * @author Alonso Robledo
 * @since mercadotrueque 0.2
 */
public class JFFormulario extends javax.swing.JFrame implements IVentanaEstatica{

    private String tituloIngresado;
    private String descripcionIngresado;
    private int AlonsoCoinIngresado;
    private int precioIngresado;
    private int regionIngresado;
    private String categoriaIngresado;
    private boolean salir;
    private boolean formularioExitoso;
    private Aviso avisoCreado;

    public JFFormulario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonPublicar = new javax.swing.JLabel();
        botonAtras = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textTitulo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaAlonsoCoin = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaCategoria = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaRegion = new javax.swing.JList<>();
        textPrecio = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        textDescripcion = new javax.swing.JTextArea();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonPublicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mercadotrueque/imgDefault.png"))); // NOI18N
        botonPublicar.setText("Publicar");
        botonPublicar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonPublicarMouseClicked(evt);
            }
        });
        getContentPane().add(botonPublicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 620, -1, -1));

        botonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mercadotrueque/imgDefault.png"))); // NOI18N
        botonAtras.setText("Atras");
        botonAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAtrasMouseClicked(evt);
            }
        });
        getContentPane().add(botonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel3.setText("Formulario de publicacion");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        jLabel4.setText("titulo");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, -1));

        jLabel5.setText("descripcion");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        jLabel6.setText("precio");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        jLabel7.setText("AlonsoCoin");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, -1, -1));

        jLabel8.setText("categoria");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, -1, -1));

        jLabel9.setText("region");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, -1, -1));
        getContentPane().add(textTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 280, 30));

        listaAlonsoCoin.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaAlonsoCoin);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 50, -1));

        listaCategoria.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Computacion", "Moda", "Vehiculo", "Hogar", "Arte" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listaCategoria);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 90, -1));

        listaRegion.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Todas las regiones", "Arica y Parinacota", "Tarapacá", "Antofagasta", "Atacama", "Coquimbo", "Valparaíso", "Metropolitana de Santiago", "Libertador Gral.Bernardo O´Higgins", "Maule", "Ñuble", "Biobío", "La Araucanía", "Los Ríos", "Los Lagos", "Aysen del Gral. Carlos Ibañez del Campo", "Magallanes y la Antártica Chilena" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listaRegion);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, 280, -1));
        getContentPane().add(textPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 130, 30));

        textDescripcion.setColumns(20);
        textDescripcion.setRows(5);
        jScrollPane4.setViewportView(textDescripcion);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 460, 160));
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 694));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Accion al hacer click en boton volver, esto habilita la salida volviendo
     * al Menu
     *
     * @since mercadotrueque 0.2
     */
    private void botonAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAtrasMouseClicked
        salir = true;
    }//GEN-LAST:event_botonAtrasMouseClicked
    /**
     * Accion al hacer click en boton publicar, llama a metodo publicar
     *
     * @since mercadotrueque 0.2
     */
    private void botonPublicarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonPublicarMouseClicked
        publicar();
    }//GEN-LAST:event_botonPublicarMouseClicked
    /**
     * Verifica y crea Publicacion
     *
     * @since mercadotrueque 0.2
     */
    private void publicar() throws HeadlessException, NumberFormatException {
        //verifica todos los campos del formulario
        if (textTitulo.getText() != null && textDescripcion.getText() != null && textPrecio.getText() != null
                && listaAlonsoCoin.getSelectedValue() != null && listaRegion.getSelectedValue() != null
                && listaCategoria.getSelectedValue() != null) {
            // extrae los datos del formulario que se completo
            tituloIngresado = textTitulo.getText();
            descripcionIngresado = textDescripcion.getText();
            precioIngresado = Integer.parseInt(textPrecio.getText());
            AlonsoCoinIngresado = listaAlonsoCoin.getSelectedIndex() + 1;
            regionIngresado = listaRegion.getSelectedIndex();
            categoriaIngresado = listaCategoria.getSelectedValue();
            //se crea formualrio
            Aviso nuevoAviso = new Aviso(tituloIngresado, descripcionIngresado, precioIngresado, AlonsoCoinIngresado, categoriaIngresado, regionIngresado);
            avisoCreado = nuevoAviso;
            formularioExitoso = true;
            JOptionPane.showMessageDialog(null, "Publicacion exitosa");
            salir = true;
        } else {
            JOptionPane.showMessageDialog(null, "Falta informacion para generar la publicacion");
        }
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
            java.util.logging.Logger.getLogger(JFFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFFormulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel botonAtras;
    private javax.swing.JLabel botonPublicar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> listaAlonsoCoin;
    private javax.swing.JList<String> listaCategoria;
    private javax.swing.JList<String> listaRegion;
    private javax.swing.JTextArea textDescripcion;
    private javax.swing.JTextField textPrecio;
    private javax.swing.JTextField textTitulo;
    // End of variables declaration//GEN-END:variables
    /**
     * Inicializa visualmente la ventana e inicia valores necesarios en
     * atributos
     *
     * @since mercadotrueque 0.2
     */
    public void start() {
        if (!this.isVisible()) {
            this.setLocationRelativeTo(null);
        }
        this.setVisible(true);
        salir = false;
        formularioExitoso = false;
    }

    /**
     * retorna atributo que indica si esta listo para salir
     *
     * @return si esta listo para salir
     * @since mercadotrueque 0.2
     */
    public boolean isSalir() {
        return salir;
    }

    /**
     * Retorna si formulario ha sido creado, si no lo creo retornara false
     *
     * @return si formulario ha sido creado, si no lo creo retornara false
     * @since mercadotrueque 0.2
     */
    boolean isFormularioExitoso() {
        return formularioExitoso;
    }

    /**
     * Retorna aviso creado, si no lo creo retornara null
     *
     * @return formulario creado, si no lo creo retornara null
     * @since mercadotrueque 0.2
     */
    public Aviso getAviso() {
        return avisoCreado;
    }

    /**
     * Asigna/resetea valor a atributo salir
     *
     * @param valor se asigna a atributo salir
     * @since mercadotrueque 0.2
     */
    public void setSalir(boolean valor) {
        salir = valor;
    }

    /**
     * Limpia los campos del formulario
     *
     * @since mercadotrueque 0.2
     */
    public void clean() {
        textTitulo.setText(null);
        textDescripcion.setText(null);
        textPrecio.setText(null);
        listaAlonsoCoin.setSelectedIndex(0);
        listaRegion.setSelectedIndex(0);
        listaCategoria.setSelectedIndex(0);
    }

    /**
     * Cierra la ventana y antes limpia los campos
     *
     * @since mercadotrueque 0.2
     */
    public void cerrarVentana() {
        //reseteo salir
        this.setSalir(false);
        // limpio los campos del formulario
        this.clean();
        // cierro ventana
        this.dispose();
    }

}
