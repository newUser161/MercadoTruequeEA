/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadotrueque;

/**
 * Clase JFrame encargada en login y registro de usuario, ademas de usaurio
 * Master en login
 *
 * @author Gonzalo Astorga
 * @author Alonso Robledo
 * @since mercadotrueque 0.1
 */
public class JFLogin extends javax.swing.JFrame implements IVentanaEstatica{

    private String correoIngresadoLogin;
    private String claveIngresadoLogin;
    private boolean checkLogin; // señala si se ingreso por login
    private boolean checkRegistro;// señala si se ingreso por registro
    private String correoIngresadoRegistro;
    private String claveIngresadoRegistro;
    private String nicknameIngresadoRegistro;

    public JFLogin() {
        initComponents();
        checkLogin = false;
        checkRegistro = false;
    }

    /**
     * Obtiene correo de login
     *
     * @return correo de login
     * @since mercadotrueque 0.1
     */
    public String getCorreoLoginAcceso() {
        return correoIngresadoLogin;
    }

    /**
     * Obtiene correo de registro
     *
     * @return correo de registro
     * @since mercadotrueque 0.1
     */
    public String getCorreoRegistroAcceso() {
        return correoIngresadoRegistro;
    }

    /**
     * Obtiene clave de login
     *
     * @return clave de login
     * @since mercadotrueque 0.1
     */
    public String getClaveLogin() {
        return claveIngresadoLogin;
    }

    /**
     * retorna estado de checkLogin que indica si se accedio por login
     *
     * @return estado de checkLogin
     * @since mercadotrueque 0.1
     */
    public boolean isCheckLogin() {
        return checkLogin;
    }

    /**
     * Asigna/resetea valor al atributo checkLogin
     *
     * @param valor se asigna a atributo checkLogin
     * @since mercadotrueque 0.1
     */
    public void setCheckLogin(boolean valor) {
        checkLogin = valor;
    }

    /**
     * Inicia posicion y visualizacion de ventana
     *
     * @since mercadotrueque 0.1
     */
    public void start() {
        if (!this.isVisible()) {
            this.setLocationRelativeTo(null);
        }
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        avisoAlerta = new javax.swing.JLabel();
        PanelLogin1 = new javax.swing.JPanel();
        passwordRegistrarse = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        emailRegistro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        botonRegistrar = new javax.swing.JLabel();
        nicknameRegistro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        bgLogin1 = new javax.swing.JLabel();
        PanelLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        passwordLogin = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        emailLogin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        botonEntrar = new javax.swing.JLabel();
        bgLogin = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        avisoAlerta.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        avisoAlerta.setForeground(new java.awt.Color(255, 0, 51));
        avisoAlerta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(avisoAlerta, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 560, 370, 50));

        PanelLogin1.setBackground(new java.awt.Color(204, 255, 204));
        PanelLogin1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PanelLogin1.add(passwordRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 240, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Registrarse");
        PanelLogin1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jLabel5.setText("email");
        PanelLogin1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, -1, -1));
        PanelLogin1.add(emailRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 230, 240, 32));

        jLabel6.setText("clave");
        PanelLogin1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, -1));

        botonRegistrar.setText("- Registrar  -");
        botonRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonRegistrarMouseClicked(evt);
            }
        });
        PanelLogin1.add(botonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 75, 63));
        PanelLogin1.add(nicknameRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 239, 32));

        jLabel7.setText("nickname");
        PanelLogin1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        bgLogin1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mercadotrueque/imgDefault2.png"))); // NOI18N
        PanelLogin1.add(bgLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 490));

        getContentPane().add(PanelLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 100, 340, 490));

        PanelLogin.setBackground(new java.awt.Color(204, 255, 204));
        PanelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Login");
        PanelLogin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));
        PanelLogin.add(passwordLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 240, 30));

        jLabel2.setText("email");
        PanelLogin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, -1, -1));
        PanelLogin.add(emailLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 239, 32));

        jLabel3.setText("clave");
        PanelLogin.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, -1, -1));

        botonEntrar.setText("- ENTRAR -");
        botonEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEntrarMouseClicked(evt);
            }
        });
        PanelLogin.add(botonEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 75, 63));

        bgLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mercadotrueque/imgDefault2.png"))); // NOI18N
        PanelLogin.add(bgLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 490));

        getContentPane().add(PanelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 340, 490));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mercadotrueque/imgDefault.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Accede usuario por login
     *
     * @since mercadotrueque 0.1
     */
    private void botonEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEntrarMouseClicked
        correoIngresadoLogin = emailLogin.getText();
        claveIngresadoLogin = String.valueOf(passwordLogin.getPassword());
        checkLogin = true;
    }//GEN-LAST:event_botonEntrarMouseClicked
    /**
     * Registra usuario nuevo
     *
     * @since mercadotrueque 0.3
     */
    private void botonRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRegistrarMouseClicked

        correoIngresadoRegistro = emailRegistro.getText();
        claveIngresadoRegistro = String.valueOf(passwordRegistrarse.getPassword());
        nicknameIngresadoRegistro = nicknameRegistro.getText();
        checkRegistro = true;
    }//GEN-LAST:event_botonRegistrarMouseClicked

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
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelLogin;
    private javax.swing.JPanel PanelLogin1;
    private javax.swing.JLabel avisoAlerta;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bgLogin;
    private javax.swing.JLabel bgLogin1;
    private javax.swing.JLabel botonEntrar;
    private javax.swing.JLabel botonRegistrar;
    private javax.swing.JTextField emailLogin;
    private javax.swing.JTextField emailRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField nicknameRegistro;
    private javax.swing.JPasswordField passwordLogin;
    private javax.swing.JPasswordField passwordRegistrarse;
    // End of variables declaration//GEN-END:variables
    /**
     * Retorna estado de checkregistro que indica si se accede por registro
     *
     * @return estado de checkregistro que indica si se accede por registro
     * @since mercadotrueque 0.3
     */
    public boolean isCheckRegistro() {
        return checkRegistro;
    }

    /**
     * Asigna valor a checkregistro
     *
     * @param valor se asigna a atributo checkRegistro
     * @since mercadotrueque 0.3
     */
    public void setCheckRegistro(boolean valor) {
        checkRegistro = valor;
    }

    /**
     * Retorna clave del campo de registro
     *
     * @return clave del campo de registro
     * @since mercadotrueque 0.3
     */
    public String getClaveRegistro() {
        return claveIngresadoRegistro;
    }

    /**
     * Retorna nickname del campo de registro
     *
     * @return nickname del campo de registro
     * @since mercadotrueque 0.3
     */
    public String getNicknameRegistro() {
        return nicknameIngresadoRegistro;
    }

    /**
     * Cierra la ventana
     *
     * @since mercadotrueque 0.1
     */
    public void cerrarVentana() {
        this.dispose();
    }

    /**
     * limpia los campos de login
     *
     * @since mercadotrueque 0.1
     */
    public void limpiarLogin() {
        emailLogin.setText("");
        passwordLogin.setText("");
        avisoAlerta.setText("Correo o clave incorrecta.");
    }

}
