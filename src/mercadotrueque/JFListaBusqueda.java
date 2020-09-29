/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadotrueque;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import static java.awt.Image.SCALE_SMOOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.TOP;
import static mercadotrueque.IModoHistorialPublicacion.VER;

/**
 * Clase JFrame que muestra la lista de avisos que califiquen en la bsuqueda
 *
 * @author Gonzalo Astorga
 * @author Alonso Robledo
 * @since mercadotrueque 0.3
 */
public class JFListaBusqueda extends javax.swing.JFrame implements IVentanaEstatica{

    private boolean salir;
    private int paginaActual;
    private int cantPaginas;
    private static final int CANTIDADPORPAGINA = 6;
    private Aviso[][] avisosPanel;
    private int totalAvisos;
    private Usuario usuarioActual;
    private JFAviso ventanaAviso;

    public JFListaBusqueda() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAvisos = new javax.swing.JPanel();
        botonDer = new javax.swing.JLabel();
        botonAtras = new javax.swing.JLabel();
        botonIz = new javax.swing.JLabel();
        textoPaginas = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelAvisos.setBackground(new java.awt.Color(204, 255, 204));
        panelAvisos.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 15));
        getContentPane().add(panelAvisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 1180, 440));

        botonDer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mercadotrueque/imgDefault.png"))); // NOI18N
        botonDer.setText(">");
        botonDer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonDerMouseClicked(evt);
            }
        });
        getContentPane().add(botonDer, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 630, -1, -1));

        botonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mercadotrueque/imgDefault.png"))); // NOI18N
        botonAtras.setText("Atras");
        botonAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAtrasMouseClicked(evt);
            }
        });
        getContentPane().add(botonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, -1, -1));

        botonIz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mercadotrueque/imgDefault.png"))); // NOI18N
        botonIz.setText("<");
        botonIz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonIzMouseClicked(evt);
            }
        });
        getContentPane().add(botonIz, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 630, -1, -1));

        textoPaginas.setText("jLabel1");
        getContentPane().add(textoPaginas, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 650, -1, -1));
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Accion de realizar click en boton salir, avisa mediante atributo salir
     * que esta listo para volver a menu
     *
     * @since mercadotrueque 0.3
     */
    private void botonAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAtrasMouseClicked
        salir = true;
    }//GEN-LAST:event_botonAtrasMouseClicked
    /**
     * Accion de realizar click en boton retroceder pagina
     *
     * @since mercadotrueque 0.3
     */
    private void botonIzMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonIzMouseClicked
        // verifica que no sea la primera pagina
        if (paginaActual > 0) {
            paginaActual--;
            //limpia la pantalla y luego muestra la informacion actualizada en la nueva pagina
            cleanAvisos();
            mostrar();
        }
    }//GEN-LAST:event_botonIzMouseClicked
    /**
     * Accion de realizar click en boton siguiente pagina
     *
     * @since mercadotrueque 0.3
     */
    private void botonDerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonDerMouseClicked
        //verifica que no sea la ultima pagina
        if (paginaActual < cantPaginas - 1) {
            paginaActual++;
            //limpia pantalla y luego muestra la informacion actualizada en la nueva pagina
            cleanAvisos();
            mostrar();
        }
    }//GEN-LAST:event_botonDerMouseClicked

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
            java.util.logging.Logger.getLogger(JFListaBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFListaBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFListaBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFListaBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFListaBusqueda().setVisible(true);
            }
        });
    }

    /**
     * Inicia la visualizacion y posicion de la ventana, inicia valores de
     * atributos de la clase
     *
     * @since mercadotrueque 0.2
     */
    public void start() {
        if (!this.isVisible()) {
            this.setLocationRelativeTo(null);
        }
        this.setVisible(true);
        salir = false;
        paginaActual = 0;
    }

    /**
     * Retorna variable salir que indica si esta listo para salir
     *
     * @return si esta listo para salir
     * @since mercadotrueque 0.2
     */
    public boolean isSalir() {
        return salir;
    }

    /**
     * Asigna un valor al atributo salir
     *
     * @param valor se asigna al atributo salir
     * @since mercadotrueque 0.3
     */
    public void setSalir(boolean valor) {
        salir = valor;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel botonAtras;
    private javax.swing.JLabel botonDer;
    private javax.swing.JLabel botonIz;
    private javax.swing.JPanel panelAvisos;
    private javax.swing.JLabel textoPaginas;
    // End of variables declaration//GEN-END:variables
    /**
     * Ajusta los valores a los textos visualizados en ventana e asigna valores
     * a atributos
     *
     * @param listaAvisosAcotados lista de acotada (por requerimeintos de
     * busqueda) de avisos
     * @param usuarioActual usaurio actual en la plataforma
     * @since mercadotrueque 0.2
     */
    public void setInfo(ArrayList<Aviso> listaAvisosAcotados, Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
        totalAvisos = listaAvisosAcotados.size();
        cantPaginas = (int) totalAvisos / CANTIDADPORPAGINA + 1;
        if (totalAvisos % CANTIDADPORPAGINA == 0) {
            cantPaginas--;
        }

        avisosPanel = new Aviso[cantPaginas][CANTIDADPORPAGINA];
        int count = 0;
        for (int i = 0; i < cantPaginas; i++) {
            for (int j = 0; j < CANTIDADPORPAGINA && count < totalAvisos; j++) {
                avisosPanel[i][j] = listaAvisosAcotados.get(count);
                count++;
            }
        }
        mostrar();
    }

    /**
     * Muestra/actualzia la informacion de avisos de pagina actual
     *
     * @since mercadotrueque 0.3
     */
    public void mostrar() {
        textoPaginas.setText("Pagina " + (paginaActual + 1) + " / " + cantPaginas);
        int count = 0 + paginaActual * CANTIDADPORPAGINA;
        for (int i = 0; count < totalAvisos && i < CANTIDADPORPAGINA && i < totalAvisos; i++) {
            crearPanelAviso(avisosPanel[paginaActual][i]);
            count++;
        }
        panelAvisos.updateUI();
    }

    /**
     * Cierra ventana
     *
     * @since mercadotrueque 0.3
     */
    public void cerrarVentana() {
        cleanAvisos();
        this.dispose();
    }

    /**
     * Creo panel/boton de aviso
     *
     * @since mercadotrueque 0.3
     */
    private void crearPanelAviso(Aviso aviso) {
        //creo el panel
        JPanel subPanel = new JPanel();
        subPanel.setBackground(Color.orange);
        //creo boton de aviso
        JButton avisoNuevo = crearBotonAviso(aviso);
        //genero interactividad del boton del aviso
        generarInteractividadBoton(aviso, avisoNuevo, subPanel);
        //genero panel con el titulo del aviso
        JLabel titulo = crearPanelTituloAviso(aviso);
        // agrego el boton con imagen y el JLabel con titulo al panel
        subPanel.add(titulo);
        panelAvisos.add(subPanel);
    }

    /**
     * genera panel con titulo del aviso
     *
     * @since mercadotrueque 0.3
     */
    private JLabel crearPanelTituloAviso(Aviso aviso) {
        // creo un JLbael
        JLabel titulo = new JLabel();
        // cambio formato a <html> para los saltos de linea
        titulo.setText("<html>" + aviso.getTitulo());
        // configuro que comence arriba el texto y no al centro que viene por defecto
        titulo.setVerticalAlignment(TOP);
        // lod imensiono
        titulo.setPreferredSize(new Dimension(100, 170));
        titulo.setOpaque(true);
        titulo.setBackground(Color.DARK_GRAY);
        titulo.setForeground(Color.white);
        return titulo;
    }

    /**
     * Agrega interactividad de click al aviso
     *
     * @since mercadotrueque 0.3
     */
    private void generarInteractividadBoton(Aviso aviso, JButton avisoNuevo, JPanel subPanel) {
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                lanzarAviso(aviso);
            }
        };
        avisoNuevo.addActionListener(action);
        subPanel.add(avisoNuevo);
    }

    /**
     * genero el boton del aviso
     *
     * @since mercadotrueque 0.3
     */
    private JButton crearBotonAviso(Aviso aviso) {
        //creo boton
        JButton avisoNuevo = new JButton();
        // lo dimensiono
        avisoNuevo.setPreferredSize(new Dimension(250, 170));
        //le asigno una imagen segun alonsoCoin
        String direccionImagen = "src/img/";
        direccionImagen += imagenAlonsoCoin(aviso.getAlonsoCoin());
        direccionImagen += ".png";
        ImageIcon gato = new ImageIcon(direccionImagen);
        avisoNuevo.setIcon(new ImageIcon(gato.getImage().getScaledInstance(250, 170, SCALE_SMOOTH)));
        // configuro cursor
        avisoNuevo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return avisoNuevo;
    }

    /**
     * genera ventana de aviso especifico que se selecciona
     *
     * @since mercadotrueque 0.3
     */
    private void lanzarAviso(Aviso aviso) {
        ventanaAviso = new JFAviso();
        ventanaAviso.start();
        ventanaAviso.setInfo(aviso, usuarioActual);
    }

    /**
     * Selecciona una imagen para el boton de aviso segun valor de alonsoCoin
     *
     * @return nombre de imagen archivo de alonsoCoin a mostrar
     * @since mercadotrueque 0.3
     */
    private String imagenAlonsoCoin(int alonsoCoin) {
        String opcionRetorno = "";
        switch (alonsoCoin) {
            case 1: {
                opcionRetorno += "uno";
                break;
            }
            case 2: {
                opcionRetorno += "dos";
                break;
            }
            case 3: {
                opcionRetorno += "tres";
                break;
            }
            case 4: {
                opcionRetorno += "cuatro";
                break;
            }
            case 5: {
                opcionRetorno += "cinco";
                break;
            }
            case 6: {
                opcionRetorno += "seis";
                break;
            }
            case 7: {
                opcionRetorno += "siete";
                break;
            }
            case 8: {
                opcionRetorno += "ocho";
                break;
            }
            case 9: {
                opcionRetorno += "nueve";
                break;
            }
            case 10: {
                opcionRetorno += "diez";
                break;
            }
        }
        return opcionRetorno;
    }

    /**
     * Limpia el panel actual de avisos
     *
     * @since mercadotrueque 0.3
     */
    private void cleanAvisos() {
        // remuevo los elementos (avisos) del panel de avisos
        panelAvisos.removeAll();
        // actualizo el panel
        panelAvisos.updateUI();
    }
}
