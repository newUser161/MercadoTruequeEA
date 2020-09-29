/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadotrueque;

import java.util.ArrayList;

/**
 * Administra el flujo de datos y estados de todas las ventanas hacia y desde
 * clase Interfaz.
 *
 * @author Gonzalo Astorga
 * @author Alonso Robledo
 * @since mercadotrueque 0.1
 */
public class AdminVentana implements IModoMaster {

    private JFAviso aviso;
    private JFBuscar buscar;
    private JFFormulario formulario;
    private JFListaBusqueda listaBusqueda;
    private JFLogin login;
    private JFMenu menu;
    private JFHistorialPublicaciones historialPublicaciones;
    private JFConfiguracion configuracion;
    private JFModoMaster modoMaster;

    public AdminVentana() {
        this.aviso = new JFAviso();
        this.buscar = new JFBuscar();
        this.formulario = new JFFormulario();
        this.listaBusqueda = new JFListaBusqueda();
        this.login = new JFLogin();
        this.menu = new JFMenu();
        this.historialPublicaciones = new JFHistorialPublicaciones();
        this.configuracion = new JFConfiguracion();
        this.modoMaster = new JFModoMaster();
    }

    /**
     * inicializa la ventana de Login
     *
     * @param listaUser lista de usuarios existentes
     * @return si fue acceso por login o registro de nuevo usuario
     * @since mercadotrueque 0.1
     */
    public int runLogin(ArrayList listaUser) {
        final int AUN_NO_ENCONTRADO = 0;
        final int ACCESO_LOGIN = 1;
        final int ACCESO_REGISTRO = 2;
        boolean estado = false;
        int encontrado = AUN_NO_ENCONTRADO;
        //inicializa la visibilidad de la ventana y valores de los atributos
        login.start();
        //flujo de comprobacion de acceso
        do {
            System.out.flush();
            //verifica si se logeo un usuario
            if (login.isCheckLogin() == true) {
                login.setCheckLogin(false);
                for (int i = 0; i < listaUser.size() && encontrado == 0; i++) {
                    Usuario usuarioActual = (Usuario) listaUser.get(i);
                    if (login.getCorreoLoginAcceso() != null && login.getClaveLogin() != null) {
                        System.out.println(usuarioActual.getCorreo() + "  -  " + login.getCorreoLoginAcceso());
                        if (login.getCorreoLoginAcceso().equals(usuarioActual.getCorreo()) && login.getClaveLogin().equals(usuarioActual.getClave())) {
                            encontrado = ACCESO_LOGIN;
                        }
                    }
                }
                //si no es una cuenta existente  limpia la pantalla
                if (encontrado == AUN_NO_ENCONTRADO) {
                    login.limpiarLogin();
                }
            }
            //verifica si se intento registrar un usuario
            if (login.isCheckRegistro() == true) {
                login.setCheckRegistro(false);
                encontrado = ACCESO_REGISTRO;
            }
        } while (estado != false);
        return encontrado;
    }

    /**
     * Cierra la ventana Login.
     *
     * @since mercadotrueque 0.1
     */
    public void cerrarLogin() {
        login.cerrarVentana();
    }

    /**
     * Devuelve el correo del usuario que acceso por Login
     *
     * @return correo de usuario
     * @since mercadotrueque 0.1
     */
    public String getCorreoLoginAcceso() {
        return login.getCorreoLoginAcceso();
    }

    /**
     * Inicializa el menu principal, visibilidad y datos
     *
     * @param userActual cuenta de usuario que se logeo
     * @return estado de menu (si se dirigue a algun lugar y a cual).
     * @since mercadotrueque 0.1
     */
    public int runMenu(Usuario userActual) {
        /*  inicializa la visibilidad de la ventana y valores de los atributos
            y se envia los datos necesarios para su funcionalidad*/
        menu.start();
        menu.setInfo(userActual.getNickname());
        do {
            System.out.flush();
            /*  sigue en menu hasta que haga click en alguna opcion, en ese
                caso pasará a cambiar el check a true*/
        } while (menu.isCheck() == false);
        menu.setCheck(false);
        return menu.getEstado();
    }

    /**
     * Cierra la ventana Menu
     *
     * @since mercadotrueque 0.1
     */
    public void cerrarMenu() {
        menu.cerrarVentana();
    }

    /**
     * Inicializa Formulario, visibilidad y datos.
     *
     * @return retorna Aviso parcial a Interfaz en caso de formulario exitoso
     * @since mercadotrueque 0.1
     */
    public Aviso runFormulario() {
        //inicializa la visibilidad de la ventana y valores de los atributos
        formulario.start();
        do {
            System.out.flush();
        } while (formulario.isSalir() == false);//&& formulario.isFormularioExitoso()==false
        if (formulario.isFormularioExitoso() == true) {
            return formulario.getAviso();
        } else {
            return null;
        }
    }

    /**
     * Cierra el Formulario
     *
     * @since mercadotrueque 0.1
     */
    public void cerrarFormulario() {
        formulario.cerrarVentana();
    }

    /**
     * Inicializa HistorialPublicaciones, visibilidad y datos
     *
     * @since mercadotrueque 0.1
     */
    public void runHistorialPublicaciones() {
        //inicializa la visibilidad de la ventana y valores de los atributos
        historialPublicaciones.start();
    }

    /**
     * Entrega los datos necesarios a HistorialPublicidad para funcionar
     *
     * @param avisosUser es una lista de solo los avisos especificos del usuario
     * @since mercadotrueque 0.2
     */
    public void setInfoHistorialPublicaciones(ArrayList avisosUser) {
        historialPublicaciones.setInfoHistorialPublicaciones(avisosUser);
    }

    /**
     * Atraves de estados de HistorialPublicidad busca si existe un aviso que se
     * opto por eliminar
     *
     * @return retorna hash del aviso a eliminar
     * @since mercadotrueque 0.2
     */
    public int getListaEliminar() {
        do {
            System.out.flush();
            //termina al confirmarse la eliminacion de una publicacion
        } while (historialPublicaciones.isSalir() != true);
        return historialPublicaciones.getHashEliminar();
    }

    /**
     * Cierra HistorialPublicaciones, tanto visibilidad como datos de la ventana
     *
     * @since mercadotrueque 0.2
     */
    public void cerrarHistorialPublicaciones() {
        historialPublicaciones.cerrarVentana();
    }

    /**
     * Inicializa Configuracion
     *
     * @param personaCopia es una copia de Persona del usuario actual.
     * @since mercadotrueque 0.3
     */
    public void runConfiguracion(Persona personaCopia) {
        //inicializa la visibilidad de la ventana y valores de los atributos
        configuracion.start();

    }

    /**
     * Mediante estados busca un estado de salida de HistorialPublicidad
     *
     * @return estado de la publicacion
     * @since mercadotrueque 0.2
     */
    public int getFlujoHistorialPublicaciones() {
        do {
            System.out.flush();
            /*  termina si se hace click en boton salir (cambiando salir=true)
                o al crear una solicitud de modificacion de aviso 
             */
        } while (historialPublicaciones.isSalir() != true && historialPublicaciones.isSolicitudUpdateHistorial() == false);
        return historialPublicaciones.getIdEliminar();

    }

    /**
     * Inicializa la ventana de Busqueda, visualizacion
     *
     * @return retorna a Interfaz una solicitud de busqueda en caso de generarla
     * @since mercadotrueque 0.3
     */
    public SolicitudBusqueda runBusqueda() {
        SolicitudBusqueda nuevaSolicitudBusqueda;
        //inicializa la visibilidad de la ventana y valores de los atributos
        buscar.start();
        do {
            System.out.flush();
            /*  Solo si se hace click en salir (salir = true)
                o al crear una solicitud de busqueda, en tal caso
                retornará esa solicitud instanciada a Interfaz*/
        } while (buscar.isSalir() != true);
        nuevaSolicitudBusqueda = buscar.getSolicitud();
        return nuevaSolicitudBusqueda;
    }

    /**
     * Cierra Busqueda.
     *
     * @since mercadotrueque 0.3
     */
    public void cerrarBusqueda() {
        buscar.cerrarVentana();
    }

    /**
     * Inicializa la interfaz del modo master
     *
     * @param coleccionAvisos recibe una copia de los avisos
     * @param coleccionUsuarios recibe una copia de lista de usuarios
     * @param listaHashUsuario lista con las claves hash de los usuarios
     * @return estado de la salida de flujo(eliminacion usuario,eliminacion
     * publicacion, eliminacion comentario)
     * @since mercadotrueque 0.3
     */
    public int startModoMaster(ArrayList<Aviso> coleccionAvisos, ArrayList<Usuario> coleccionUsuarios, ArrayList<String> listaHashUsuario) {
        String idUsuarioEliminar = null;
        //inicializa la visibilidad de la ventana y valores de los atributos
        modoMaster.start();//
        //envia los datos necesarios para su funcionalidad
        modoMaster.setInfo(coleccionAvisos, coleccionUsuarios, listaHashUsuario);
        do {
            System.out.flush();
            /*  sale del flujo si se accede a eliminar un usario, eliminar publicacion
                o eliminar comentario
             */
        } while (modoMaster.isSalir() != true);
        return modoMaster.getEstado();
    }

    /**
     * obtiene correo del usuario que accede por registro
     *
     * @return correo de usuario que se esta registrando
     * @since mercadotrueque 0.3
     */
    public String getCorreoRegistroAcceso() {
        return login.getCorreoRegistroAcceso();
    }

    /**
     * obtiene clave del usuario que accede por registro
     *
     * @return clave de usuario que se esta registrando
     * @since mercadotrueque 0.3
     */
    public String getClaveRegistro() {
        return login.getClaveRegistro();
    }

    /**
     * obtiene nickname del usuario que accede por registro
     *
     * @return nickname de usuario que se esta registrando
     * @since mercadotrueque 0.3
     */
    public String getNicknameRegistro() {
        return login.getNicknameRegistro();
    }

    /**
     * Inicializa la ventana de lista busqueda
     *
     * @param listaAvisosAcotados lista de los avisos retornados por Interfaz
     * desde EstructuraDeDatos con los avisos seleccionados por la
     * SolicitudDeBusqueda
     * @param usuario usuario que se encuentra actualmente en la plataforma
     * @return Comentario que se pueda crear al comentar cualquier aviso de la
     * lista
     * @since mercadotrueque 0.3
     */
    public Comentario startListaBusqueda(ArrayList<Aviso> listaAvisosAcotados, Usuario usuario) {
        Comentario nuevoComentario = null;
        //inicializa la visibilidad de la ventana y valores de los atributos
        listaBusqueda.start();
        //envia los datos necesarios para su funcionalidad
        listaBusqueda.setInfo(listaAvisosAcotados, usuario);
        do {
            System.out.flush();
            /*  sale en caso de hacer click en salir(salir=true)
                o si se instancia un comentario en alguna publicacion
             */
        } while (listaBusqueda.isSalir() != true && nuevoComentario == null);
        return nuevoComentario;
    }

    /**
     * Cierra la ventana de busqueda
     *
     * @since mercadotrueque 0.2
     */
    public void cerrarListaBusqueda() {
        listaBusqueda.cerrarVentana();
    }

    /**
     * Obtiene el correo del usuario que se eliminará, esto en modo Master
     *
     * @return correo de usuario que se desea eliminar
     * @since mercadotrueque 0.4
     */
    public String getCorreoUsuarioEliminar() {
        return modoMaster.getCorreoUsuarioEliminado();
    }

    /**
     * Obtiene el id del aviso que se eliminará, esto en modo Master
     *
     * @return id de aviso que se desea eliminar
     * @since mercadotrueque 0.4
     */
    public int getIdAvisoEliminar() {
        return modoMaster.getIdAvisoEliminar();
    }

    /**
     * Cierra el modo Master
     *
     * @since mercadotrueque 0.3
     */
    public void cerrarModoMaster() {
        modoMaster.cerrarVentana();
    }

    /**
     * Obtiene el id del Comentario que se eliminará, esto en modo Master
     *
     * @return comentario de aviso que se desea eliminar
     * @since mercadotrueque 0.4
     */
    public Integer getComentarioEliminar() {
        return modoMaster.getComentarioEliminar();
    }

    /**
     * Optiene aviso de solicitud de modificacion de publicidad
     *
     * @return aviso de solicitud de modificacion de publicidad
     * @since mercadotrueque 0.4
     */
    public boolean isModificacionAviso() {
        return (historialPublicaciones.isSolicitudUpdateHistorial() == true);
    }

    public void mostrarBanner(BannerPublicitario randomBanner) {
        menu.crearBanner(randomBanner);
    }

    public void destruirPublicidadClienteMenu() {
        menu.destruirPublicidadCliente();
    }

}
