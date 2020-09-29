/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadotrueque;

import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Clase encargada del flujo del eventos del programa y como medio (interfaz)
 * entre EstructuraDeDatos(logica de datos) y AdminVentana (logica de interfaz
 * grafica) pidiendo y entregando datos desde y a EstructuraDeDatos, y
 * entregando datos a AdminVentana
 *
 * @author Gonzalo Astorga
 * @author Alonso Robledo
 * @since mercadotrueque 0.1
 */
public class Interfaz implements IEstados, ICorreoMaster, IModoMaster {

    private AdminVentana adminVentana;
    private EstructuraDatos datos;
    private int _ESTADO;
    private Usuario userActual;

    /**
     * Constructor de la clase
     *
     * @since mercadotrueque 0.1
     */
    public Interfaz() throws IOException {
        this.adminVentana = new AdminVentana();
        this.datos = new EstructuraDatos();
        datos.cargarDatos();
        userActual = null;

    }

    /**
     * Comienza la ejecucion del programa
     *
     * @since mercadotrueque 0.1
     */
    public void runApp() throws IOException {
        _ESTADO = IEstados.LOGIN;
        //instancia sonido y carga direccion del archivo de audio background en modo loop
        Sonido backgroundMusic = new Sonido();
        backgroundMusic.playSonido("bg", backgroundMusic.LOOP);
        //se va al flujo de la Interfaz
        irAFlujoDeEstados();

    }

    /**
     * Gestiona el flujo de eventos (estados) del programa, administra el flujo
     * de datos de EstructuradeDatos y las llamadas a los distintos eventos de
     * AdminVentana
     *
     * @since mercadotrueque 0.1
     */
    private void irAFlujoDeEstados() throws IOException {

        int flujoLoginRegistro = SIN_RESPUESTA;
        int idEliminarAvisoPublicado = SIN_ID_AVISO_ELIMINAR;
        boolean modificacionAviso = false;
        SolicitudBusqueda mensajeSolicitudBusqueda = null;
        ArrayList<Aviso> listaAvisosAcotados = new <Aviso>ArrayList();

        do {
            switch (_ESTADO) {
                case LOGIN: {
                    loginYRegistro();
                    break;
                }
                case MENU: {
                    menu(modificacionAviso, idEliminarAvisoPublicado);
                    break;
                }
                case FORMULARIO: {
                    formulario();
                    break;
                }
                case HISTORIALPUBLICACIONES: {
                    idEliminarAvisoPublicado = historialPublicacion(idEliminarAvisoPublicado, modificacionAviso);
                    modificacionAviso = flujoModificacionAviso();
                    break;
                }
                case CONFIGURACION: {
                    //TODO
                    adminVentana.runConfiguracion(datos.getCopiaPersona(userActual));
                    break;
                }
                case BUSQUEDA: {
                    mensajeSolicitudBusqueda = busqueda(mensajeSolicitudBusqueda);
                    break;
                }
                case MODO_MASTER: {
                    modoMaster();
                    break;
                }
                case PEDIDOBUSQUEDA: {
                    listaAvisosAcotados = pedirBusqueda(mensajeSolicitudBusqueda);
                    break;
                }
                case LISTABUSQUEDA: {
                    listaBusqueda(listaAvisosAcotados);
                    break;
                }
                case EXIT: {
                    break;
                }
            }
        } while (_ESTADO != EXIT);
        System.exit(0);
    }

    /**
     * Gestiona flujo de menu principal
     *
     * @since mercadotrueque 0.1
     */
    private void menu(boolean modificacionAviso, int idEliminarAvisoPublicado) {
        //obtiene aviso publicdad de cliente empresa
        adminVentana.mostrarBanner(datos.getRandomBanner());
        // vemos si existe alguna solicitud de modificacion 
        if (modificacionAviso) {
            _ESTADO = HISTORIALPUBLICACIONES;
        } else {
            // vemos si existe alguna eliminacion
            if (idEliminarAvisoPublicado != SIN_ID_AVISO_ELIMINAR) {
                _ESTADO = HISTORIALPUBLICACIONES;
            } else {
                _ESTADO = adminVentana.runMenu(userActual);
                adminVentana.cerrarMenu();
            }
        }
        adminVentana.destruirPublicidadClienteMenu();
    }

    /**
     * Gestiona flujo de modificacion de aviso
     *
     * @since mercadotrueque 0.4
     */
    private boolean flujoModificacionAviso() {
        boolean estadoModificacionAviso;
        // verificamos si existe solicitud de modificacion de aviso
        estadoModificacionAviso = adminVentana.isModificacionAviso();
        _ESTADO = MENU;
        adminVentana.cerrarHistorialPublicaciones();
        return estadoModificacionAviso;
    }

    /**
     * Gestiona flujo de historial publicidad
     *
     * @since mercadotrueque 0.4
     */
    private int historialPublicacion(int idEliminarAvisoPublicado, boolean modificacionAviso) throws HeadlessException {
        // arrancamos historial publicaciones
        adminVentana.runHistorialPublicaciones();
        // enviamos los parametros necesarios para su funcionamiento
        adminVentana.setInfoHistorialPublicaciones(datos.getAvisosUser(userActual));
        //verificamos estados//
        //avisamos que se elimino el aviso y cambiamos estado
        //esto se hace aca por ser un bucle y pensarse como orientacion a eventos
        if (idEliminarAvisoPublicado != SIN_ID_AVISO_ELIMINAR) {
            idEliminarAvisoPublicado = SIN_ID_AVISO_ELIMINAR;
            JOptionPane.showMessageDialog(null, "Aviso Eliminado");
        }
        //avisamos que se modifico el aviso y cmabiamos estado
        //esto se hace aca por ser un bucle y pensarse como orientacion a eventos
        if (modificacionAviso) {
            modificacionAviso = false;
            JOptionPane.showMessageDialog(null, "Aviso Modificado");
        }
        //obtenemos id de aviso que se desea eliminar
        idEliminarAvisoPublicado = adminVentana.getFlujoHistorialPublicaciones();
        // eliminamos aviso
        if (idEliminarAvisoPublicado != SIN_ID_AVISO_ELIMINAR) {
            datos.eliminarPublicacion(userActual, idEliminarAvisoPublicado);
        }
        return idEliminarAvisoPublicado;
    }

    /**
     * Gestiona flujo de lista busqueda
     *
     * @since mercadotrueque 0.2
     */
    private void listaBusqueda(ArrayList<Aviso> listaAvisosAcotados) {
        adminVentana.startListaBusqueda(listaAvisosAcotados, userActual);
        adminVentana.cerrarListaBusqueda();
        _ESTADO = MENU;
    }

    /**
     * Envia solicitud de busqueda y obtiene una lista acotada por tales
     * requerimeintos
     *
     * @since mercadotrueque 0.2
     */
    private ArrayList<Aviso> pedirBusqueda(SolicitudBusqueda mensajeSolicitudBusqueda) {
        ArrayList<Aviso> listaAvisosAcotados;
        // pedimos una lista acotada por requerimeinto de busqueda a estructuraDeDatos,
        // enviando la solicitud
        listaAvisosAcotados = datos.getAvisosAcotados(mensajeSolicitudBusqueda);
        _ESTADO = LISTABUSQUEDA;
        return listaAvisosAcotados;
    }

    /**
     * Gestiona flujo de login y registro
     *
     * @since mercadotrueque 0.3
     */
    private void loginYRegistro() throws IOException, HeadlessException {
        int flujoLoginRegistro;
        flujoLoginRegistro = SIN_RESPUESTA;
        do {
            flujoLoginRegistro = adminVentana.runLogin(datos.getUsuarios());
        } while (flujoLoginRegistro == SIN_RESPUESTA);
        //por login
        if (flujoLoginRegistro == LOGIN_ACEPTADA) {
            // obtenemos nuestro usuario actual
            userActual = datos.getUsuario(adminVentana.getCorreoLoginAcceso());
            flujoLoginRegistro = LOGINAMENU;
        }
        //por registro
        if (flujoLoginRegistro == REGISTRO) {
            //verificamos si no existe anteriormente
            String correoNuevoUser = adminVentana.getCorreoRegistroAcceso();
            if (correoNuevoUser.equals(CORREOMASTER) || datos.isUsuario(correoNuevoUser) == true) {
                JOptionPane.showMessageDialog(null, "Correo ya registrado.");
            } else {
                //pedimos los datos y creamos al nuevo usuario
                datos.addUsuario(new Usuario(adminVentana.getNicknameRegistro(), correoNuevoUser, adminVentana.getClaveRegistro()));
                // obtenemos nuestro usuario actual
                userActual = datos.getUsuario(correoNuevoUser);
                System.out.println(userActual.getNickname());
                _ESTADO = MENU;
            }
        }
        // verificamos si se esta accediendo a modo Master
        if (flujoLoginRegistro == LOGINAMENU) {
            if (userActual.getCorreo().equals(ICorreoMaster.CORREOMASTER)) {
                _ESTADO = MODO_MASTER;
            } else {
                _ESTADO = MENU;
            }
        }
        adminVentana.cerrarLogin();
    }

    /**
     * Gestiona flujo de formulario
     *
     * @since mercadotrueque 0.3
     */
    private void formulario() throws IOException {
        Aviso nuevoAviso = null;
        // pedimos formulario
        nuevoAviso = adminVentana.runFormulario();
        // verificamos si se creo tal formulario
        if (nuevoAviso != null) {
            datos.addPublicacion(userActual.getCorreo(), nuevoAviso);
        }
        adminVentana.cerrarFormulario();
        _ESTADO = MENU;
    }

    /**
     * Gestiona flujo de busqueda
     *
     * @since mercadotrueque 0.3
     */
    private SolicitudBusqueda busqueda(SolicitudBusqueda mensajeSolicitudBusqueda) {
        mensajeSolicitudBusqueda = null;
        // obtenemos solicitud
        mensajeSolicitudBusqueda = adminVentana.runBusqueda();
        // verificamos que se haya pedido/creado tal solicitud
        if (mensajeSolicitudBusqueda != null) {
            _ESTADO = PEDIDOBUSQUEDA;
        } else {
            _ESTADO = MENU;
        }
        adminVentana.cerrarBusqueda();
        return mensajeSolicitudBusqueda;
    }

    /**
     * Gestiona flujo de modoMaster
     *
     * @since mercadotrueque 0.3
     */
    private void modoMaster() throws HeadlessException {
        String correoUsuario;
        int opcionMaster, idAviso;
        // arrancamos modo master
        opcionMaster = adminVentana.startModoMaster(datos.getAvisoColeccion(), datos.getUsuarios(), datos.getListaHashUsuario());
        switch (opcionMaster) {
            case SIN_ACCION:
                break;
            case ELIMINAR_USUARIO: {
                // obtenemos correo del usuario a eliminar
                correoUsuario = adminVentana.getCorreoUsuarioEliminar();
                // verificamos si existe, en tal caso lo eliminamos
                if (datos.eliminarUsuario(correoUsuario)) {
                    JOptionPane.showMessageDialog(null, "Usuario Eliminado");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encuentra usuario con ese correo.");
                }
                break;
            }
            case ELIMINAR_AVISO: {
                // obtenemos id de aviso a eliminar
                idAviso = adminVentana.getIdAvisoEliminar();
                // verificamos si existe, ,en tal caso lo eliminamos
                if (datos.eliminarPublicacion(idAviso) == true) {
                    JOptionPane.showMessageDialog(null, "Aviso Eliminado");
                } else {
                    JOptionPane.showMessageDialog(null, "No se logro eliminar aviso");
                }
                break;
            }
            case ELIMINAR_COMENTARIO: {
                // obtenemos id de aviso
                idAviso = adminVentana.getIdAvisoEliminar();
                // obtenemos id de comentario a eliminar
                Integer idComentario = adminVentana.getComentarioEliminar();
                // obtenemos aviso que deberia contener el comentario a eliminar
                Aviso avisoActual = datos.getAviso(idAviso);
                // verificamos si los datos nos llevan a un dato existente, en tal caso lo eliminamos
                if (avisoActual != null && avisoActual.eliminarComentario(idComentario) == true) {
                    JOptionPane.showMessageDialog(null, "Comentario Eliminado");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro comentario para ser eliminado");
                }
                break;
            }
        }
        adminVentana.cerrarModoMaster();
    }

}
